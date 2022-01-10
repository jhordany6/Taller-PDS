package dominio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Project")
public class Project extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false,unique = true)
    private Long id;

    @Column(name = "project_name", nullable = false, unique = false)
    private String projectName;

    @Column(name = "project_identifier", nullable = false, unique = false, updatable = false)
    @Size(min = 5, max = 7, message = "Debe contar entre 5 y 7 caracteres")
    private String projectIdentifier;

    @Column(name = "description", nullable = false)
    private String description;

//Tener pendiente la fecha
 /*   @Column(name = "start_date")
    private String starDate;

    @Column(name = "end_date")
    private String endDate;
*/
    @OneToOne()
    @JoinColumn(name = "backlog_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
