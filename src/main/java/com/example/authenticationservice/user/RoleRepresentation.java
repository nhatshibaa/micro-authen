package com.example.authenticationservice.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RoleRepresentation {
    private String id;
    private String name;
}
