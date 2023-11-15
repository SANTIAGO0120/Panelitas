package com.example.demo.Java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(LoginForm loginForm) {
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginForm(LoginForm loginForm, Model model) {
        // Aquí puedes manejar la lógica de autenticación
        // Por ejemplo, puedes verificar el nombre de usuario y la contraseña con tu base de datos

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // Supongamos que este es un método que verifica las credenciales del usuario
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            model.addAttribute("message", "Inicio de sesión exitoso!");
            return "home";
        } else {
            model.addAttribute("message", "Nombre de usuario o contraseña incorrectos");
            return "login";
        }
    }

    private boolean authenticate(String username, String password) {
        // Aquí debes implementar la lógica de autenticación
        // Este es solo un ejemplo y siempre devuelve true
        return true;
    }
}