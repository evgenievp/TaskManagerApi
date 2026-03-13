package com.TaskManagerApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @NonNull
    @Column(unique = true)
    @Size(min = 3)
    private String username;
    @NonNull
    @NotBlank
    @Size(min = 6)
    @Column(unique = true)
    private String email;
    @Size(min = 8, max = 40)
    @NonNull
    @NotBlank
    private String password;

    public User(@NonNull String username, @NonNull String email, @NonNull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
