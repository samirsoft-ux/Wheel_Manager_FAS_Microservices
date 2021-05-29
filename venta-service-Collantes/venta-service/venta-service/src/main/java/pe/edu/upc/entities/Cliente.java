package pe.edu.upc.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40,nullable = false)
    private String nombres;
    @Column(length = 40,nullable = false)
    private String apellidos;
    @Column(name="numero_doc",length = 8,nullable = false)
    private String nDoc;
    @Column(length = 9,nullable = false)
    private String celular;
    @Column(length = 40,nullable = false)
    private String direccion;
    @Column(length = 40,nullable = false)
    private String correo;
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(length = 1,nullable = false)
    private String status;
}
