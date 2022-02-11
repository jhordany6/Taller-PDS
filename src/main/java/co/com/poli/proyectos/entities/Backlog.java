package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "backlog")
public class Backlog extends EntityBase{

    @Column(name="project_identifier")
    @NotEmpty(message = "Name may not be blank")
    private String projectIdentifier;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_id")
    private Project project;

    ////

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTasks;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(projectIdentifier, backlog.projectIdentifier);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), projectIdentifier);
    }
}
