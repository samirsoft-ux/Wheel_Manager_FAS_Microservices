package pe.edu.upc.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_cliente",nullable = false)
    private Long clienteId;
    @Column(name = "fecha_venta",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Column(nullable = false)
    private Double precioTotal;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(length = 1,nullable = false)
    private String status;

    @OneToMany(mappedBy = "ventas")
    private List<Detalle> detalleVentas;
    public Venta(){
        detalleVentas=new ArrayList<>();
    }
}
