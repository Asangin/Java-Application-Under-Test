package com.skryl.backend.repository;

import com.skryl.backend.models.ERole;
import com.skryl.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Skryl D.V. on 2022-04-22
 * Copyright © 2022 Perenio. All rights reserved.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
