package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> saveSucursal(@RequestBody SucursalDTO sucursalDto) {
        sucursalService.addSucursal(sucursalDto);
        return new ResponseEntity<>(sucursalDto, HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<Sucursal> updateSucursal(@RequestBody Sucursal request) {
        Sucursal sucursal = sucursalService.updateSucursal(request, id);
        if (sucursal==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(sucursal, HttpStatus.OK);
    }


}
