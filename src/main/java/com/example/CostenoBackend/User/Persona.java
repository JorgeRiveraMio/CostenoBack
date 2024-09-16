
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"dni"})})
public class Persona {

    @Id
    private Integer dni;

    private String nombres;
    private String apellidos;
    private java.util.Date nacimiento;

}