package sg.nus.edu.empdemo.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import lombok.Data;
import sg.nus.edu.empdemo.model.Course;

@DataJpaTest
@Data
//@Sql("/data.sql")
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void testfindByNameContainingAllIgnoringCase(){
        List<Course> courses = courseRepository.findByNameContainingAllIgnoringCase("Fr");

        assertThat(courses).element(1).extracting(Course::getName).isEqualTo("French");
    }

}
