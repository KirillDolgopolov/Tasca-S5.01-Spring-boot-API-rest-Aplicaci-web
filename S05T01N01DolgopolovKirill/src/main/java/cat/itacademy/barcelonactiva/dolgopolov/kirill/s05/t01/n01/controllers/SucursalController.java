package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;


    @GetMapping("/add")
    public String addSucursal(Model model) {
        model.addAttribute("sucursalDTO", new SucursalDTO());
        return "formularioSucursal";
    }


    @PostMapping("/saveSucursal")
    public String saveSucursal(Model model, SucursalDTO sucursalDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formularioSucursal";
        }
        sucursalService.addSucursal(sucursalDto);
        return "saved";
    }

    @GetMapping("/getAll")
    public String getAllSucursal (Model model){
        model.addAttribute("listSucursal", sucursalService.getAllDTO());
        return "allSucursal";
    }


    @GetMapping("/getByID")
    public String getByID(Model model) {
        return "findByID";
    }

    @GetMapping("resultByID")
    public String resultByID (@RequestParam(name = "sucursalId") Long sucursalId, Model model){
    SucursalDTO sucursalDTO = sucursalService.getByID(sucursalId);
        model.addAttribute("sucursalDTO", sucursalDTO);
        return "resultByID";
    }



//    @PutMapping("/update/")
//    public ResponseEntity<Sucursal> updateSucursal(@RequestBody SucursalDTO request) {
//        Sucursal sucursal = sucursalService.updateSucursal(request, request.getPk_SucursalID());
//        if (sucursal==null){
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        } else return new ResponseEntity<>(sucursal, HttpStatus.OK);
//    }


}
