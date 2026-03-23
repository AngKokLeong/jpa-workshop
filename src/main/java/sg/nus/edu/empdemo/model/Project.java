package sg.nus.edu.empdemo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Projects")
@Data
public class Project {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="name")
    private String name;


    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy="projects"
    )
    private Set<Employee> employees = new HashSet<Employee>();
    

}
