package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="project")
public class Project extends EntityBase{
    @Column(name="project_name",unique=true)
    @NotEmpty(message = "No puede estar vacio")
    private String projectName;

    @Column(name="project_identifier",unique=true, updatable=false)
    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 5, max = 7, message = "Debe ser minimo 7 caracteres y como maximo 7")
    private String ProjectIdentifier;

    @Column(name="description")
    @NotEmpty(message = "No puede estar vacio")
    private String description;

    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;


    @JsonManagedReference
    @OneToOne(mappedBy = "project",cascade = CascadeType.ALL)
    @JoinColumn(name="backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
