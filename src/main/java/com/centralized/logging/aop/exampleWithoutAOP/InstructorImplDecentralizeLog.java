package com.centralized.logging.aop.exampleWithoutAOP;

import com.centralized.logging.aop.model.Instructor;
import com.centralized.logging.aop.repository.InstructorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InstructorImplDecentralizeLog implements InstructorDecentralizeLogService {

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorImplDecentralizeLog(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void save(Instructor instructor) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String className = this.getClass().getName();
        String methodName = "save";

        log.info("Entering {}.{} ==> Request payload {}", className, methodName, mapper.writeValueAsString(instructor));
        Instructor result = instructorRepository.save(instructor);
        log.info("Exiting {}.{} ==> Response payload {}", className, methodName, mapper.writeValueAsString(result));
    }

    @Override
    public Optional<Instructor> findById(int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String className = this.getClass().getName();
        String methodName = "findById";

        log.info("Entering {}.{} ==> Request payload {}", className, methodName, mapper.writeValueAsString(id));
        Optional<Instructor> result = instructorRepository.findById(id);
        log.info("Exiting {}.{} ==> Response payload {}", className, methodName, mapper.writeValueAsString(result));
        return result;
    }

    @Override
    public List<Instructor> findAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String className = this.getClass().getName();
        String methodName = "findAll";

        log.info("Entering {}.{} ==> Request payload {}", className, methodName, "[]");
        List<Instructor> listResult = (List<Instructor>) instructorRepository.findAll();
        log.info("Exiting {}.{} ==> Response payload {}", className, methodName, mapper.writeValueAsString(listResult));
        return listResult;
    }

    @Override
    public void deleteById(int id) {

    }
}
