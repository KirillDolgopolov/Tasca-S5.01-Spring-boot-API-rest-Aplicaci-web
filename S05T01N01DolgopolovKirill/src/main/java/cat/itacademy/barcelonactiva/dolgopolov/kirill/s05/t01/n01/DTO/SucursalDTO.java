package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {


    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    private static final List<String> countries = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic",
            "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia",
            "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain", "Sweden");


    private void setTipeSucursal() {
        if (countries.contains(this.paisSucursal)) {
            this.tipusSucursal = "UE";
        } else this.tipusSucursal = "Not UE";
    }

    public static SucursalDTO toDTO(Sucursal sucursal) {
        SucursalDTO sucursalDto = SucursalDTO.builder()
                .pk_SucursalID(sucursal.getPk_SucursalID())
                .nomSucursal(sucursal.getNomSucursal())
                .paisSucursal(sucursal.getPaisSucursal())
                .build();
        sucursalDto.setTipeSucursal();
        return sucursalDto;
    }

}
