package com.fredson.springsecutiryexample.modules.user.dtos;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateUserRoleDTO {

    private UUID idUser;

    private List<UUID> idsRoles;
}
