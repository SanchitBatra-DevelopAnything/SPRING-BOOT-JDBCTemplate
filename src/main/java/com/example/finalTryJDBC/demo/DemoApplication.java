package com.example.finalTryJDBC.demo;

import com.example.finalTryJDBC.demo.DAO.CourseJdbcDao;
import com.example.finalTryJDBC.demo.DAO.StudentDAO;
import com.example.finalTryJDBC.demo.Domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private CourseJdbcDao courseJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//we used command line runner cuz studentDAO was non static and cant be used in static.
		//run methods allows to run non static.
		this.courseJdbcDao.createTable();
		this.studentDAO.createTable(); //initialize all tables.

		//start working & testing (in prod apps , you'll be doing through controller & service layer.)
//		Course c = Course.builder().courseId(22).title("FrontEnd - SB").description("Learn spring boot , best framework").link("https://www.sanchitBatra.com").build();
//		this.courseJdbcDao.create(c);

		Optional<Course> c = this.courseJdbcDao.get(27);
		if(c.isPresent())
		{
			System.out.println("FOUND COURSE -> "+c.get().getTitle());
		}
		else
		{
			//NOT FOUND.
		}
	}
}
