package com.zeus.LoginAndRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.LoginAndRegistration.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role ,Long> {
    List<Role> findAll();
    List<Role> findByName(String name);
}
