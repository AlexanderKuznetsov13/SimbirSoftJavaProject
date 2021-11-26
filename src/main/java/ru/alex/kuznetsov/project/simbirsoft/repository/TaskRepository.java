package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskEntity;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer>, JpaSpecificationExecutor<TaskEntity> {

    /**
     * find all tasks said release
     * @param releaseId id release
     * @return list tasks
     */
    @Query(value = "SELECT count(*) FROM task t  join taskstatus ts on ts.id = t.taskstatus_id WHERE t.release_id = :releaseId and ts.name != 'DONE'", nativeQuery = true)
    Integer getQtyUncompletedTasksByReleaseId(@Param("releaseId") Integer releaseId);


    @Query(value ="SELECT t FROM task t join release r on r.id = t.release_id join project p on p.id = r.project_id WHERE t.taskstatus_id != 'DONE' and p.id = :projectId", nativeQuery = true)
    List<TaskEntity> findUnfinishedTasksByProject(@Param("projectId") int projectId);

    @Query(value ="SELECT t FROM task t join release r on r.id = t.release_id join project p on p.id = r.project_id WHERE p.id = :projectId", nativeQuery = true)
    List<TaskEntity> getAllTaskByProject(@Param("projectId") int projectId);

}
