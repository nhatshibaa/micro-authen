package com.example.authenticationservice.retrofiet;

import com.example.authenticationservice.credential.KeycloakAccessToken;
import com.example.authenticationservice.user.ClientRoleRepresentation;
import com.example.authenticationservice.user.KeycloakUser;
import com.example.authenticationservice.user.RoleRepresentation;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface RetrofietUserService {

    @FormUrlEncoded
    @POST("/auth/realms/KeyCloakService/protocol/openid-connect/token")
    Call<KeycloakAccessToken> login(@FieldMap Map<String,String> params);

    @POST("/auth/admin/realms/KeyCloakService/users")
    Call<Void> save(@Body KeycloakUser keycloakUser);


    @POST("/auth/admin/realms/KeyCloakService/users/{id}/role-mappings/realm")
    Call<RoleRepresentation> saveRealmRole(@Path("id") String id, @Body RoleRepresentation[] roleRepresentation);

    @POST("/auth/admin/realms/KeyCloakService/users/{id}/role-mappings/clients/{client}")
    Call<Void> saveClientRole(@Path("id") String id,@Path("client") String client, @Body ClientRoleRepresentation[] clientRoleRepresentations);

    @GET("/auth/admin/realms/KeyCloakService/users")
    Call<List<KeycloakUser>> findAll();

    @GET("/auth/admin/realms/KeyCloakService/users/{id}")
    Call<KeycloakUser> findById(@Path("id") String id);

    @PUT("/auth/admin/realms/KeyCloakService/users/{id}")
    Call<Void> update(@Path("id") String id, @Body KeycloakUser updateKeycloakUser);

    @DELETE("/auth/admin/realms/KeyCloakService/users/{id}")
    Call<Void> delete(@Path("id") String id);
}
