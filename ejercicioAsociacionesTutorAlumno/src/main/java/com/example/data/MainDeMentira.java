package com.example.data;

import com.example.data.repository.AlumnoRepository;
import com.example.data.repository.TutorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final TutorRepository repoTutor;
    private final AlumnoRepository repoAlumno;

    @PostConstruct
    public void run() {



    }



}
