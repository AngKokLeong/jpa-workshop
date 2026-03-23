package sg.nus.edu.empdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.edu.empdemo.model.Course;
import java.time.LocalDate;


public interface CourseRepository extends JpaRepository<Course, Long> {
    
    // Find courses where the name contains a specific string, ignoring case
    public List<Course> findByNameContainingAllIgnoringCase(String name);
    
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    //Find course starting after a specific date
    public List<Course> findByStartsGreaterThan(LocalDate starts);

    //Find courses by maximum duration
    //public List<Course> findBydurationInMonthsOrderByDesc();

    //Find courses by employeeId
    public Optional<Course> findByEmployeeEquals(Long id);

    //Fetch a course and its associated Employee in a single query by the Course ID 
    //public Course findByIdWithEmployee(Long courseId);

    // Find courses by employeeId that start after a specific date
    //@Query("select u.employees from courses where u.starts = ?1")
    //public List<Course> findBy();


}
