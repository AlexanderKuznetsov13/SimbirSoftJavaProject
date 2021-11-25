package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskEntity;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
