package ru.alex.kuznetsov.project.simbirsoft.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersEntity;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    /**
     * find user with login
     * @param login user login
     * @return user
     */
    UsersEntity findUsersEntitiesByLogin(String login);

}
