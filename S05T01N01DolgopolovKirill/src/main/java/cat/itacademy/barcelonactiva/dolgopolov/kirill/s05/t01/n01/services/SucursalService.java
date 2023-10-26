package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;


    public Sucursal addSucursal(SucursalDTO sucursalDto) {
        Sucursal sucursal = Sucursal.toEntity(sucursalDto);
        return sucursalRepository.save(sucursal);
    }

    public List<SucursalDTO> getAllDTO() {

        List<Sucursal> list = sucursalRepository.findAll();
        List <SucursalDTO> listDTO = new ArrayList<>();
        list.forEach(s->listDTO.add(SucursalDTO.toDTO(s)));
        return listDTO;
    }

    public SucursalDTO getByID(Long id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if (sucursal.isPresent()){
            Sucursal sucursalReal=sucursal.get();
            return SucursalDTO.toDTO(sucursalReal);
        }
        return null;
    }

//    public Sucursal updateSucursal(Sucursal request) {
//        Sucursal sucursal = sucursalRepository.findById(request.getPk_SucursalID()).get();
//        sucursal.setNomSucursal(request.getNomSucursal());
//        sucursal.setPaisSucursal(request.getPaisSucursal());
//        return sucursal;
//    }



}
