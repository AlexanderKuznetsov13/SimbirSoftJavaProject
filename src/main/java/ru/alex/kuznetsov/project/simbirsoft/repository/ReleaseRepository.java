package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.ProjectEntity;
import ru.alex.kuznetsov.project.simbirsoft.entity.ReleaseEntity;

import java.util.List;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Integer> {

    /**
     * find all releases said project
     * @param project project
     * @return list releases
     */
    List<ReleaseEntity> findByProjectRelease(ProjectEntity project);
}
