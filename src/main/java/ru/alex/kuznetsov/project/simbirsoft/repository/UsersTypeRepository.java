package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersTypeEntity;

@Repository
public interface UsersTypeRepository extends JpaRepository<UsersTypeEntity, Integer> {

    UsersTypeEntity findByName(String name);
}