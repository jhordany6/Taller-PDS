package dominio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ProjecTask")
public class ProjecTask extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Hey nea el campo no puede estar vacio")
    private String name;

    @Column(name = "summary")
    @NotEmpty(message = "Hey nea el campo no puede estar vacio")
    private String summary;

    @Column(name = "acceptance_criterio")
    @NotEmpty(message = "Hey nea el campo no puede estar vacio")
    private String acceptanceCriterio;

    @Column(name = "status")
    //Pendiente las validaciones
    private String status;

    @Column(name = "priority")
    @Length(min = 1, max = 5, message = "El rango debe ser de 1-5 de caracteres")
    private String priority;

    @Column(name = "hours")
    @Length(min = 1, max = 8, message = "El rango debe ser de 1-8 de caracteres")
    @PositiveOrZero(message = "Los valores deben ser positivos")
    private double hours;

    //Tener pendiente la fecha
 /*   @Column(name = "start_date")
    private String starDate;

    @Column(name = "end_date")
    private String endDate;
*/

    @Column(name = "project_identifier",updatable = false)
    private String projectIdentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "backlog_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProjecTask that = (ProjecTask) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
