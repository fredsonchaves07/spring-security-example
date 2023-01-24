package com.fredson.springsecutiryexample.modules.user.services;

import com.fredson.springsecutiryexample.modules.user.dtos.CreateUserRoleDTO;
import com.fredson.springsecutiryexample.modules.user.entities.Role;
import com.fredson.springsecutiryexample.modules.user.entities.User;
import com.fredson.springsecutiryexample.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateUserRoleService {

    @Autowired
    UserRepository userRepository;

    public User execute(CreateUserRoleDTO createUserRoleDTO) {
        Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
        List<Role> roles;
        if(userExists.isEmpty()) throw new Error("User does not exists!");
        roles = createUserRoleDTO.getIdsRoles().stream().map(Role::new).collect(Collectors.toList());
        User user = userExists.get();
//        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }
}
