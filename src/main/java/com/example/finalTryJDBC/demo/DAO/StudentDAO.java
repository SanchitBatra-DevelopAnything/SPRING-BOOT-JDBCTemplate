package com.example.finalTryJDBC.demo.DAO;

import com.example.finalTryJDBC.demo.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate JdbcTemplate; // by autoconfiguration spring gives us bean of it.

    public StudentDAO()
    {


    }

    public int createTable()
    {
        String query = "CREATE TABLE IF NOT EXISTS STUDENT(ID INT PRIMARY KEY, FIRST_NAME VARCHAR(200) , " +
                "LAST_NAME VARCHAR(200), EMAIL VARCHAR(200) , MOBILE VARCHAR(200))";

        return this.JdbcTemplate.update(query);
    }

    public int createStudent(Student student)
    {
        String query = "insert into student(student_id , first_name , last_name , email,mobile) values" +
                "(?,?,?,?,?)";

        //update method returns number of rows affected.
        return this.JdbcTemplate.update(query , new Object[]{student.getId(),student.getFirstName() ,
        student.getLastName() , student.getEmail() , student.getMobile()});
    }

    public int deleteStudent(int id)
    {
        String query = "DELETE FROM STUDENT WHERE ID = ?";
        return this.JdbcTemplate.update(query , new Object[]{id});
    }


}
