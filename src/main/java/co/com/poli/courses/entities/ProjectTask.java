package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projectTask")
public class ProjectTask extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String name;

    @Column(name = "summary")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String summary;

    @Column(name = "acceptance_critery")
    private String acceptanceCritery;

    //falta agregar el status

    @Column(name = "priority")
    @Length(min = 1, max = 5)
    private int priority;

    @Column(name = "hours")
    @Length(min = 1,max = 8)
    @Positive
    private Double hours;

    //Falta las dates

    @Column(name = "project_identifier", updatable = false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Backlog_id")
    private Backlog backlog;


}
