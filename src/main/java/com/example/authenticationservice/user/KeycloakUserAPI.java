package com.example.authenticationservice.user;

import com.example.authenticationservice.util.Peggy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/users")
@Log4j2
public class KeycloakUserAPI {

    @Autowired
    KeycloakService keycloakService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Peggy<KeycloakUser>> index() throws IOException {
        return new ResponseEntity<Peggy<KeycloakUser>>(
                keycloakService.findAll(null, null),
                HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "addRealmRole/{id}")
    public ResponseEntity<RoleRepresentation> addRoleRealm(@PathVariable String id, @RequestBody RoleRepresentation[] roleRepresentations) throws IOException {
        return new ResponseEntity(
                keycloakService.addRealmRoleById(id, roleRepresentations),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "addClientRole/{id}/{client}")
    public ResponseEntity<?> addClientRoleById(@PathVariable String id, @PathVariable String client, @RequestBody ClientRoleRepresentation[] clientRoleRepresentations) throws IOException {
        return new ResponseEntity(
                keycloakService.addClientRoleById(id, client, clientRoleRepresentations),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<RoleRepresentation> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) throws IOException {
        log.info("Có chạy vào login");
        return new ResponseEntity(
                keycloakService.login(username, password),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "register")
    public ResponseEntity<KeycloakUser> register(@RequestBody KeycloakUser keycloakUser) throws IOException {
        if (keycloakService.save(keycloakUser)) {
            return new ResponseEntity<KeycloakUser>(keycloakUser, HttpStatus.CREATED);
        } else {
            throw new IOException();
        }
    }
}
