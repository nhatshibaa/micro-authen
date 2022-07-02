package com.example.authenticationservice.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClientRoleRepresentation {
    private String id;
    private String name;
}
