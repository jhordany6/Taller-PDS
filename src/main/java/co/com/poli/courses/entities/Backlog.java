package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Backlog")
public class Backlog extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "project_Identifier")
    @NotEmpty(message = "no puede estar vacio")
    private String projectIdentifier;

    /*
    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @NotEmpty(message = "El campo no puede estar vacio")
    @JoinColumn(name = "project_id")
    private Project project;

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.ALL)
    private List<ProjectTask> projectTasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(id, backlog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(id, backlog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
