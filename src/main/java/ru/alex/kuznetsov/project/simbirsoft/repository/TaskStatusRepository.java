package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskStatusEntity;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatusEntity, Integer> {
}
