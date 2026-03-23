package sg.nus.edu.empdemo.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Employees")
@Data
public class Employee {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length=100)
    private String name;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    //https://docs.hibernate.org/orm/7.3/userguide/html_single/#associations-one-to-one-bidirectional-lazy
    public void assignDepartment(Department dept){
        this.department = dept;
        this.department.getEmployee().setDepartment(dept);
    }

    @OneToMany(
        mappedBy = "employees",
        cascade = {
            CascadeType.ALL
        },
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    private List<Course> courses = new ArrayList<Course>();
    
    public void addCourse(Course course){
        course.getEmployees().add(this);
        this.courses.add(course);
    }

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
        }
    )
    @JoinTable(
        name="employee_projects",
        joinColumns = @JoinColumn(name="employee_id"),
        inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private Set<Project> projects = new HashSet<Project>();

    public void addProject(Project project){
        project.getEmployees().add(this);
        this.projects.add(project);
    }

}