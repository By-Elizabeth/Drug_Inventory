package com.dswii.inventario.config;

import com.dswii.inventario.entity.Usuario;
import com.dswii.inventario.repository.UsuarioRepository;
import com.dswii.inventario.security.RoleName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UsuarioRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (!repo.existsByUsername("admin")) {
                repo.save(Usuario.builder()
                        .username("admin")
                        .password(encoder.encode("admin123"))
                        .role(RoleName.ROLE_ADMIN)
                        .build());
            }
            if (!repo.existsByUsername("user")) {
                repo.save(Usuario.builder()
                        .username("user")
                        .password(encoder.encode("user123"))
                        .role(RoleName.ROLE_USER)
                        .build());
            }
        };
    }
}
