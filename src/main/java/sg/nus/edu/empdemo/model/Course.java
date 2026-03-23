package sg.nus.edu.empdemo.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Courses")
@Data
public class Course {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="durationInMonths")
    private Double durationInMonths;
    
    @Column(name="starts")
    private LocalDate starts;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(
        name="employee_id",
        referencedColumnName="id"
    )
    private Employee employee;
    


    public String getName(){
        return this.name;
    }

}