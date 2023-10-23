package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
public class Sucursal {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer pk_SucursalID;

    @Column
    private String nomSucursal;
@Column
    private String paisSucursal;


}
