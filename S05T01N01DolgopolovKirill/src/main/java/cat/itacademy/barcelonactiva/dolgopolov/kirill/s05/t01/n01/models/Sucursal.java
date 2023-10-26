package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models;


import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO.SucursalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Sucursal {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer pk_SucursalID;

    @Column
    private String nomSucursal;
    @Column
    private String paisSucursal;

    public static Sucursal toEntity(SucursalDTO sucursalDto) {
        Sucursal sucursal = Sucursal.builder()
                .pk_SucursalID(sucursalDto.getPk_SucursalID())
                .nomSucursal(sucursalDto.getNomSucursal())
                .paisSucursal(sucursalDto.getPaisSucursal())
                .build();
        return sucursal;
    }

}
