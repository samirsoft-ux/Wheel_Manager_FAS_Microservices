package pe.edu.resource;

import lombok.Data;

import java.util.Date;
@Data
public class SaveUserResource {
    private String userName;
    private String password;
    private String email;
    private String name;
    private String  lastName;
    private String dni;
    private String gender;
    private Date birthDay;
}
