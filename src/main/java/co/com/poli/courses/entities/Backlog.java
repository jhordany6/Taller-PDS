package co.com.poli.courses.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "backlogs")
public class Backlog extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false,unique = true)
    private Long id;

    @Column(name = "project_identifier", nullable = false)
    private String projectIdentifier;

    @OneToOne()
    @JoinColumn(name = "Project")
    @Column(name = "project")
    //Se debe cambiar la propiedad de Instructor por projectTask
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ProjectTask")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @Column(name = "projec_task")
    private List<Instructor> items;

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
