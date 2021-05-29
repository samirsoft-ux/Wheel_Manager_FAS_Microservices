package pe.edu.upc.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detalle_ventas")
@Data
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Cantidad",nullable = false)
    private Integer cantidad;
    @Column(name = "Precio_unitario",nullable = false)
    private Double precioUnitario;
    @Column(name = "Precio_venta",nullable = false)
    private Double precioVenta;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(length = 1,nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Venta venta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;
}
