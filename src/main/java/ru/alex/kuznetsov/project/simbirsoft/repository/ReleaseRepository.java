package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.ReleaseEntity;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Integer> {
}
