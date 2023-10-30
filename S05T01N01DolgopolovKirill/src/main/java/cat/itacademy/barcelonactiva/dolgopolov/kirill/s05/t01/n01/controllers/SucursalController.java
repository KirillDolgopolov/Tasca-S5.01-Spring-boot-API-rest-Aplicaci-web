package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models.Sucursal;
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


    @PostMapping("/saveNewSucursal")
    public String saveSucursal(Model model, SucursalDTO sucursalDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formularioSucursal";
        }
        sucursalService.addSucursal(sucursalDto);
        return "saved";
    }

    @GetMapping("/getAll")
    public String getAllSucursal(Model model) {
        model.addAttribute("listSucursal", sucursalService.getAllDTO());
        return "allSucursal";
    }


    @GetMapping("/getByID")
    public String getByID(Model model) {
        return "findByID";
    }

    @GetMapping("/resultByID")
    public String resultByID(@RequestParam(name = "sucursalId") Long sucursalId, Model model) {
        SucursalDTO sucursalDTO = sucursalService.getByID(sucursalId);
        if (sucursalDTO == null) {
            return "notFound";
        }
        model.addAttribute("sucursalDTO", sucursalDTO);
        return "resultByID";
    }

    @GetMapping("/updateByID")
    public String updateByID(Model model) {
        model.addAttribute("sucursalDTO", new SucursalDTO());
        return "updateByID";
    }


    @PostMapping("/update")
    public String updateSucursal(Model model, SucursalDTO sucursalDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateByID";
        }
        if (sucursalService.updateSucursal(sucursalDto)!=null){
            return "updated";
        } else return "sucursalNotFound";

    }
}