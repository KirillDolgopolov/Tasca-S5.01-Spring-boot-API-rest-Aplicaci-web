package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;


    public Sucursal addSucursal(SucursalDTO sucursalDto) {
        Sucursal sucursal = Sucursal.toEntity(sucursalDto);
        return sucursalRepository.save(sucursal);
    }

    public Sucursal updateSucursal(Sucursal request) {
        Sucursal sucursal = sucursalRepository.findById(request.getPk_SucursalID()).get();
        sucursal.setNomSucursal(request.getNomSucursal());
        sucursal.setPaisSucursal(request.getPaisSucursal());
        return sucursal;
    }


}
