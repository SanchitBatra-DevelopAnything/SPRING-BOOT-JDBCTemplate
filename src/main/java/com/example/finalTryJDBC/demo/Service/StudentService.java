package com.example.finalTryJDBC.demo.Service;


import com.example.finalTryJDBC.demo.DAO.StudentDAO;
import com.example.finalTryJDBC.demo.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public ArrayList<Student> getStudents()
    {
        Student s1 = Student.builder().firstName("Sanchit").lastName("Batra").
                email("batrasanchit96@gmail.com").mobile("8585988825").build();

        Student s2 = Student.builder().firstName("Anish").lastName("Monga").
                email("anishMonga@gmail.com").mobile("8459916018").build();

        ArrayList<Student> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);

        return arr;
    }

    //add a student to table.
    public Student addStudent(Student student) throws Exception
    {
        try
        {
            this.studentDAO.createStudent(student);
            return student;
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public int deleteStudent(int id) throws Exception
    {
        try{
            return this.studentDAO.deleteStudent(id);
        }catch(Exception e)
        {
            throw e;
        }
    }

    public ArrayList<Student> getStudentsOnDB()
    {
        return null;
    }
}
