package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO;

import lombok.Getter;
import lombok.Setter;

public class SucursalDTO {

    @Getter
    @Setter
    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;
}
