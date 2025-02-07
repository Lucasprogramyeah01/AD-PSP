package com.example.ejemploSecurity.service;

import com.example.ejemploSecurity.model.Task;
import com.example.ejemploSecurity.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    //FIND ALL.
    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    //FIND BY ID.
    public Task getByID(Long id){

        Optional<Task> result = taskRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }else{
            throw new EntityNotFoundException("No hsay task con id: "+id);
        }
    }

    //SAVE.
    public Task save(Task task){
        return taskRepository.save(task);
    }

}
