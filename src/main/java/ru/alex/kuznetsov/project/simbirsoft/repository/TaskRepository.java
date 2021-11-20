package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskEntity;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    /**
     * find all tasks said release
     * @param releaseId id release
     * @return list tasks
     */
    @Query(value = "SELECT count(*) FROM task t  join taskstatus ts on ts.id = t.taskstatus_id WHERE t.release_id = :releaseId and ts.name != 'DONE'", nativeQuery = true)
    Integer getQtyUncompletedTasksByReleaseId(@Param("releaseId") Integer releaseId);


}
