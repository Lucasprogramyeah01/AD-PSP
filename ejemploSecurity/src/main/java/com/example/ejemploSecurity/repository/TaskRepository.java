package com.example.ejemploSecurity.repository;

import com.example.ejemploSecurity.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
