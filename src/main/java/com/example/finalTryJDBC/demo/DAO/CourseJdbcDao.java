package com.example.finalTryJDBC.demo.DAO;

import com.example.finalTryJDBC.demo.Domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

//JDCB TEMPLATE METHODS => 1.) update -> for insert , delete , update. ,, 2.) query(returns a list) -> Turns query to prepared statement , and RowMapper se values ORM. , 3.) Execute can also be used for DDL commands.

@Repository
public class CourseJdbcDao implements DAO<Course>{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    //RowMapper duplicate mat karo. Thats how you prevent it.
    private RowMapper<Course> rowMapper = (rs,rowNum)->{
        Course course = Course.builder().courseId(rs.getInt("course_id")).link(rs.getString("link")).
                description(rs.getString("description")).title(rs.getString("title")).build();
        return course;
    };

    public CourseJdbcDao()
    {

    }

    @Override
    public List<Course> list() {
        //press 2 times shift to search everywhere and look for a RowMapper class! , it has a functional mapRow and as its a functionalInterface , we can lamba that fn implementation.
        //4.)queryForObject-> RETURNS A SINGLE OBJECT.
        String sql = "select course_id , title , description , link from course";
        return jdbcTemplate.query(sql ,rowMapper);
    }

    @Override
    public void create(Course course) {
        String sql = "insert into course(course_id,title , description , link) values(? , ? , ?,?)";
        jdbcTemplate.update(sql , new Object[]{course.getCourseId(),course.getTitle() , course.getDescription() , course.getLink()});
    }

    @Override
    public Optional<Course> get(int id){
        String sql = "select course_id , title , description , link from course where course_id = ?";
        Course c = null;
        try{
            c=jdbcTemplate.queryForObject(sql , new Object[]{id} , rowMapper);
        }catch (Exception e)
        {
            System.out.println("COURSE NOT FOUND ID = "+id);
        }
        return Optional.ofNullable(c);
    }

    @Override
    public void update(Course course, int id) {
        //student jaise karlo.
    }

    @Override
    public void delete(int id) {
        //student jaise karlo.
    }

    @Override
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS COURSE(COURSE_ID INT PRIMARY KEY, TITLE VARCHAR(200) , " +
                "LINK VARCHAR(200), DESCRIPTION VARCHAR(200))";

        this.jdbcTemplate.update(query);
    }
}
