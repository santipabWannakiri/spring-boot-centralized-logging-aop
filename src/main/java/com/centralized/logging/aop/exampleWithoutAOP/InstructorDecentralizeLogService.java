package com.centralized.logging.aop.exampleWithoutAOP;

import com.centralized.logging.aop.model.Instructor;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface InstructorDecentralizeLogService {

    public void save(Instructor instructor) throws JsonProcessingException;
    public Optional<Instructor> findById(int id) throws JsonProcessingException;
    public List<Instructor> findAll() throws JsonProcessingException;
    public void deleteById(int id);
}
