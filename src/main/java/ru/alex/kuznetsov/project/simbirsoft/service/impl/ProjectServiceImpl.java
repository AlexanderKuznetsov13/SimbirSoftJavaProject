package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.config.CustomUserDetails;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.ProjectEntity;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskEntity;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.InsufficientMoneyException;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.exception.UnfinishedTaskException;
import ru.alex.kuznetsov.project.simbirsoft.feign.IAccountClient;
import ru.alex.kuznetsov.project.simbirsoft.feign.dto.OperationRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.repository.*;
import ru.alex.kuznetsov.project.simbirsoft.repository.filter.Condition;
import ru.alex.kuznetsov.project.simbirsoft.repository.filter.TaskFilter;
import ru.alex.kuznetsov.project.simbirsoft.service.IProjectService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;
    private final ProjectStatusRepository projectStatusRepository;
    private final ReleaseRepository releaseRepository;
    private final TaskRepository taskRepository;
    private final UsersRepository usersRepository;
    private final IAccountClient accountClient;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectStatusRepository projectStatusRepository, ReleaseRepository releaseRepository, TaskRepository taskRepository, UsersRepository usersRepository, IAccountClient accountClient) {
        this.projectRepository = projectRepository;
        this.projectStatusRepository = projectStatusRepository;
        this.releaseRepository = releaseRepository;
        this.taskRepository = taskRepository;
        this.usersRepository = usersRepository;
        this.accountClient = accountClient;
    }

    @Override
    public ProjectResponseDto getById(Integer id) {
        logger.debug(String.format("getById - Project with ID = %d not found", id));
        ProjectEntity project = projectRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Project with ID = %d not found", id)));
        return CommonMapper.fromProjectEntityToProjectResponseDto(project);
    }

    @Override
    public ProjectResponseDto create(ProjectRequestDto requestDto) {
        logger.debug(String.format("create - create project"));
        ProjectEntity project = CommonMapper.fromProjectRequestDtoToProjectEntity(requestDto);
        return CommonMapper.fromProjectEntityToProjectResponseDto(projectRepository.save(project));
    }

    @Override
    public ProjectResponseDto update(ProjectRequestDto requestDto) {
        int statusId = requestDto.getProjectStatusId();
        int projectId = requestDto.getId();

        int idDoneProject = projectStatusRepository.getDoneId();
        if (statusId == idDoneProject) {
            List<TaskEntity> list = taskRepository.findUnfinishedTasksByProject(projectId);
            if (list.size() > 0) {
                logger.error("update - cannot completed project with unfinished tasks");
                throw new UnfinishedTaskException("update - cannot completed project with unfinished tasks");
            }
        }

        int idInProgressProject = projectStatusRepository.getInProgressId();

        if (statusId == idInProgressProject) {

            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            CustomUserDetails principal = (CustomUserDetails) token.getPrincipal();
            String login = principal.getUsername();
            UsersEntity user = usersRepository.findUsersEntitiesByLogin(login);

            Integer idProject = requestDto.getId();
            ProjectEntity project = projectRepository.findById(idProject).orElseThrow(() -> new NoEntityException(String.format("Project with ID = %d not found", idProject)));
            if (project.getPrice() > accountClient.getBalance(user.getAccountId()).getBalance()) {
                logger.error("update - there is no money to start project");
                throw new InsufficientMoneyException("Insufficient money to start project");
            }
            Long diffPrice = (-1) * project.getPrice();
            accountClient.makeOperation(user.getAccountId(), new OperationRequestDto(diffPrice));
        }

        ProjectEntity project = CommonMapper.fromProjectRequestDtoToProjectEntity(requestDto);
        logger.debug(String.format("update - update project with %id", project.getId()));
        return CommonMapper.fromProjectEntityToProjectResponseDto(projectRepository.save(project));
    }

    @Override
    public List<ProjectResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all projects"));
        return projectRepository.findAll().stream().map(CommonMapper::fromProjectEntityToProjectResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<ReleaseResponseDto> getReleasesProject(Integer id) {
        ProjectEntity project = projectRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("getReleasesProject - Project with ID = %d not found", id));
            return new NoEntityException(String.format("getReleasesProject - Project with ID = %d not found", id));
        });
        return releaseRepository.findByProjectRelease(project).stream().map(CommonMapper::fromReleaseEntityToReleaseResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<BoardTaskResponseDto> getTasksProject(Integer id) {
        ProjectEntity project = projectRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("getTasksProject - Project with ID = %d not found", id));
            return new NoEntityException(String.format("Resource with id: %d not found", id));
        });
        return taskRepository.getAllTaskByProject(project.getId()).stream().map(CommonMapper::fromTaskEntityToBoardTaskResponseDto).collect(Collectors.toList());
    }


    @Override
    public void deleteById(Integer id) {
        projectRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - Project with ID = %d not found", id));
            return new NoEntityException(String.format("Project with ID = %d not found", id));
        });
        projectRepository.deleteById(id);
    }

    @Override
    public List<BoardTaskResponseDto> getFilteredTasksProject(Integer id, List<Condition> conditions) {
        TaskFilter filter = new TaskFilter(conditions);
        return taskRepository.findAll(filter).stream().map(CommonMapper::fromTaskEntityToBoardTaskResponseDto).collect(Collectors.toList());
    }
}

