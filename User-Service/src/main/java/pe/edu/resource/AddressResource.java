package pe.edu.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pe.edu.domain.model.User;

import javax.persistence.*;
@Data
public class AddressResource {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String description;

}
