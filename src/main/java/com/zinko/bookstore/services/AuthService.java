package com.zinko.bookstore.services;

public interface AuthService {
    String findLoggedInUsername();
    void loginProcess(String email,String password);
    boolean isLogged();
}
