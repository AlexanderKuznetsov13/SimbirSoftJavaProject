package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.ProjectStatusEntity;

@Repository
public interface ProjectStatusRepository extends JpaRepository<ProjectStatusEntity, Integer> {
    /**
     * find all projects is DONE
     * @return projectId DONE
     */
    @Query(value = "SELECT id FROM projectstatus ps WHERE ps.name == 'DONE'", nativeQuery = true)
    Integer getDoneId();

    /**
     * find all projects is IN_PROGRESS
     * @return projectId IN_PROGRESS
     */
    @Query(value = "SELECT id FROM projectstatus ps WHERE ps.name == 'IN_PROGRESS'", nativeQuery = true)
    Integer getInProgressId();

}
