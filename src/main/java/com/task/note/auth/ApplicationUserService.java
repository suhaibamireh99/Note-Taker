package com.task.note.auth;

import com.task.note.Entity.User;
import com.task.note.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.task.note.Security.ApplicationUserRole.USER;

@Service
public class ApplicationUserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("Username %s nnot found", username)));

        return new ApplicationUser(
                user.getId(),
                user.getName(),
                user.getSurName(),
                user.getPassword(),
                USER.getGrantedAuthorities()
        );
    }

}
