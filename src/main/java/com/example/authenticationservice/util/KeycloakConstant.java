package com.example.authenticationservice.util;

public class KeycloakConstant {
    public static String KEYCLOAK_BASEURL = "http://localhost:8282";
    public static String KEYCLOAK_REALM = "KeyCloakService";
    public static String KEYCLOAK_CLIENT_ID = "login-app";
//    public static String KEYCLOAK_CLIENT_SECRET = "a9187633-c82c-4fa4-8261-ac265ed89b35";
    public static String KEYCLOAK_ADMIN_USERNAME = "user001";
    public static String KEYCLOAK_ADMIN_PASSWORD = "123";
    public static String KEYCLOAK_USERS_BASEURL = String.format("%s/auth/admin/realms/%s/users", KEYCLOAK_BASEURL, KEYCLOAK_REALM);
    public static String KEYCLOAK_TOKEN_BASEURL = String.format("%s/auth/realms/%s/protocol/openid-connect/token", KEYCLOAK_BASEURL, KEYCLOAK_REALM);
    public static String KEYCLOAK_AUTHENTICATION_HEADER = "Authorization";
    public static String KEYCLOAK_AUTHENTICATION_BEARER = "Bearer";
    public static String KEYCLOAK_CREDENTIAL_GRANT_TYPE = "password";
}
