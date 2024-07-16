package com.izabellavm.apiforum.generator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senha = "admin123";
        String senhaCriptografada = passwordEncoder.encode(senha);
        System.out.println("Senha Criptografada: " + senhaCriptografada);
    }
}
