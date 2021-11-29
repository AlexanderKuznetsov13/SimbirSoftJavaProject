package ru.alex.kuznetsov.project.simbirsoft.config;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersEntity;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserService;
import ru.alex.kuznetsov.project.simbirsoft.service.impl.UserServiceImpl;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    public CustomUserDetailsService( @Lazy UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity userEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
