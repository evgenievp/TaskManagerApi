package com.TaskManagerApi.repo;


import com.TaskManagerApi.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(@NonNull @NotBlank @Size(min = 6) String email);
}
