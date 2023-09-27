package com.centralized.logging.aop;

import com.centralized.logging.aop.model.Instructor;
import com.centralized.logging.aop.model.InstructorDetail;
import com.centralized.logging.aop.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCentralizedLoggingAopApplication {

	private InstructorService instructorService;

	@Autowired
	public SpringBootCentralizedLoggingAopApplication(InstructorService instructorService) {
		this.instructorService = instructorService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootCentralizedLoggingAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialInstructor(String[] args){
		return r -> {createInstructorObject();};
	}

	private void createInstructorObject() {
		InstructorDetail instructorDetailA = new InstructorDetail("https://youtube.com/somsak.s", "Cycling");
		Instructor instructorA = new Instructor("SOMSAK", "SANDEE", "SOMSAK.S@gmail.com", instructorDetailA);

		InstructorDetail instructorDetailB = new InstructorDetail("https://youtube.com/somchai", "Singing");
		Instructor instructorB = new Instructor("SOMCHAI", "RIT", "SOMCHAI.R@gmail.com", instructorDetailB);

		InstructorDetail instructorDetailC = new InstructorDetail("https://youtube.com/jirapon", "Tiktoker");
		Instructor instructorC = new Instructor("JIRAPON", "KIM", "JIRAPON.K@gmail.com", instructorDetailC);

		instructorService.save(instructorA);
		instructorService.save(instructorB);
		instructorService.save(instructorC);
	};


}
