package com.example.authenticationservice.retrofiet;

import com.example.authenticationservice.credential.KeycloakAccessToken;
import com.example.authenticationservice.user.KeycloakUser;
import com.example.authenticationservice.util.KeycloakConstant;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RetrofietUserServiceTest {

    private String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJXaklXbjRtclBBcFBfTHUzN1hKa3gtcWxzZUhSYmcwOVYyb3VfZUIyYUdRIn0.eyJleHAiOjE2NTM5MDY1NzQsImlhdCI6MTY1MzkwNjUxNCwianRpIjoiNWNlYjA5ZGItNDM1OC00MDEzLTkxYzktN2ZjNzc2NTExZDU5IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL21hc3RlciIsImF1ZCI6WyJtYXN0ZXItcmVhbG0iLCJhY2NvdW50Il0sInN1YiI6ImRhMGNiOTU3LWFhYmMtNDM1Yy05YWQwLThkNjEzMmI2ZjBkMyIsInR5cCI6IkJlYXJlciIsImF6cCI6InNlcnZpY2UwMSIsInNlc3Npb25fc3RhdGUiOiI0NjFkM2ZkNy1mOThjLTQ0YjgtYmM0NC1hMmM4YTlhZDY0NjYiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImNyZWF0ZS1yZWFsbSIsImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsibWFzdGVyLXJlYWxtIjp7InJvbGVzIjpbInZpZXctaWRlbnRpdHktcHJvdmlkZXJzIiwidmlldy1yZWFsbSIsIm1hbmFnZS1pZGVudGl0eS1wcm92aWRlcnMiLCJpbXBlcnNvbmF0aW9uIiwiY3JlYXRlLWNsaWVudCIsIm1hbmFnZS11c2VycyIsInF1ZXJ5LXJlYWxtcyIsInZpZXctYXV0aG9yaXphdGlvbiIsInF1ZXJ5LWNsaWVudHMiLCJxdWVyeS11c2VycyIsIm1hbmFnZS1ldmVudHMiLCJtYW5hZ2UtcmVhbG0iLCJ2aWV3LWV2ZW50cyIsInZpZXctdXNlcnMiLCJ2aWV3LWNsaWVudHMiLCJtYW5hZ2UtYXV0aG9yaXphdGlvbiIsIm1hbmFnZS1jbGllbnRzIiwicXVlcnktZ3JvdXBzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImFkbWluIn0.Rvaov1DoexAymU9lFuzaCaumWdu24vC3bLgORNbenA2K6vIV8krsCDzg541h75A-m0_7euns2HqaZ_ksaeB9iNXddAGE39WddWKod0vLrH9p9j7Gmxg921UIKFLo2i3ebyXnXTnN4KvktAVaBFyNNAc4Vxc9qvkOnGBUMW1agJgGP2eW48IxTbfkxV4WoDQOZAZuzLdm4UzWdgYBoXwFgCoTHWDizw4lDXcq7kU4bHNVORlL-CeN9omKx_4wVA9zt7h0OMIEBnXHL8mrxekc_BzLlrtFryg9nXDihWrXaOXGYDMYEaPrlI5rdWUN8DmDSbQuSWLYuLY-CLkfkIFnog";
    private String currentId = "ad62911b-61e0-42d6-aea6-7b0a2c0d2a88";
    @Test
    void login() {
        Map<String,String> params = new HashMap<>();
        params.put("client_id", KeycloakConstant.KEYCLOAK_CLIENT_ID);
        params.put("username", KeycloakConstant.KEYCLOAK_ADMIN_USERNAME);
        params.put("password", KeycloakConstant.KEYCLOAK_ADMIN_PASSWORD);
        params.put("grant_type", KeycloakConstant.KEYCLOAK_CREDENTIAL_GRANT_TYPE);
        RetrofietUserService service
                = RetrofietServiceGenerator.createService(RetrofietUserService.class);
        try {
            KeycloakAccessToken accessToken = service.login(params).execute().body();
            System.out.println(accessToken.getAccess_token());
            System.out.println(accessToken.getExpires_in());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void save() throws IOException {
        RetrofietUserService service
                = RetrofietServiceGenerator.createService(RetrofietUserService.class, token);
         Response<Void> response
                 = service.save(KeycloakUser.builder().username("xuanhung01").enabled(true).build()).execute();
         if(response.isSuccessful()){
             System.out.println(response.body());
             System.out.println(response.toString());
         }else{
             System.out.println(response.errorBody().string());;
         }
    }

    @Test
    void findAll() throws IOException {
        RetrofietUserService service
                = RetrofietServiceGenerator.createService(RetrofietUserService.class, token);
        Response<List<KeycloakUser>> response
                = service.findAll().execute();
        if(response.isSuccessful()){
            List<KeycloakUser> list = response.body();
            System.out.println(list.size());
            for (KeycloakUser user : list){
                System.out.println(user.toString());
            }
        }else{
            System.out.println("Error");
            System.out.println(response.errorBody().string());;
        }
    }

    @Test
    void findById() throws IOException {
        RetrofietUserService service
                = RetrofietServiceGenerator.createService(RetrofietUserService.class, token);
        Response<KeycloakUser> response
                = service.findById(currentId).execute();
        if(response.isSuccessful()){
            KeycloakUser obj = response.body();
            System.out.println(obj.toString());
        }else{
            System.out.println(response.errorBody().string());;
        }
    }

    @Test
    void update() throws IOException {
        RetrofietUserService service
                = RetrofietServiceGenerator.createService(RetrofietUserService.class, token);
        HashMap<String, Object> atts = new HashMap<>();
        atts.put("hello", "update here 01");
        Response<Void> response
                = service.update(currentId, KeycloakUser.builder().attributes(atts).enabled(true).build()).execute();
        if(response.isSuccessful()){
            System.out.println("Okie");
        }else{
            System.out.println(response.errorBody().string());;
        }
    }

    @Test
    void delete() throws IOException {
        RetrofietUserService service
                = RetrofietServiceGenerator.createService(RetrofietUserService.class, token);
        Response<Void> response
                = service.delete(currentId).execute();
        if(response.isSuccessful()){
            System.out.println("Okie");
        }else{
            System.out.println(response.errorBody().string());;
        }
    }

}