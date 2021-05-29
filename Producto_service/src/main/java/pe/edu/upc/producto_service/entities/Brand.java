package pe.edu.upc.producto_service.entities;

import javax.persistence.*;

@Entity
@Table(name = "brands")

public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String brandName;

    public Brand setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public Brand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
