package com.skryl.backend.utils;

import com.skryl.backend.models.ERole;
import com.skryl.backend.models.Role;
import com.skryl.backend.models.User;
import com.skryl.backend.repository.RoleRepository;
import com.skryl.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Skryl D.V. on 2022-05-18
 * Copyright © 2022 Perenio. All rights reserved.
 */
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Role> adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
        if (adminRole.isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }

        Optional<Role> moderatorRole = roleRepository.findByName(ERole.ROLE_MODERATOR);
        if (moderatorRole.isEmpty()) {
            roleRepository.saveAndFlush(new Role(ERole.ROLE_MODERATOR));
        }

        Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_USER);
        if (userRole.isEmpty()) {
            roleRepository.saveAndFlush(new Role(ERole.ROLE_USER));
        }

        if(!userRepository.existsByUsername("admin")) {
            User user = new User("admin", "admin@skryl.com", encoder.encode("12345678"));
            Set<Role> roles = new HashSet<>();
            Role modRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);
            user.setRoles(roles);
            userRepository.save(user);
        }

        if(!userRepository.existsByUsername("mod")) {
            User user = new User("mod", "mod@skryl.com", encoder.encode("12345678"));
            Set<Role> roles = new HashSet<>();
            Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);
            user.setRoles(roles);
            userRepository.save(user);
        }

        if(!userRepository.existsByUsername("user")) {
            User user = new User("user", "user@skryl.com", encoder.encode("12345678"));
            Set<Role> roles = new HashSet<>();
            Role modRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);
            user.setRoles(roles);
            userRepository.save(user);
        }





    }
}
