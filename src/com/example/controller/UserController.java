package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;

public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void createUser(String name, String email) {
        // 1. El Muro: Si los datos vienen vacíos, lanzamos un mensaje y cortamos
        if (name.trim().isEmpty() || email.trim().isEmpty()) {
            System.out.println(">>> ERROR: No se puede crear un usuario con campos vacíos.");
            return; // IMPORTANTE: Este return impide que se ejecute la línea de abajo
        }

        // 2. Solo si hay datos, llegamos a esta línea
        userService.addUser(new User(name, email));
    }

}