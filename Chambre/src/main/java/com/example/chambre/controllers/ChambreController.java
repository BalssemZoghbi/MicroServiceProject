package com.example.chambre.controllers;


import com.example.chambre.dto.ChambreDto;
import com.example.chambre.entity.Chambre;
import com.example.chambre.services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class ChambreController {


    @Autowired
    IChambreService iChambreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChambreDto> AllChambres() {
        return iChambreService.AllChambres();
    }

    @GetMapping("/{id}")
    public ChambreDto getChambreById(@PathVariable("id") Long id) {return iChambreService.getChambreById(id);}

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ChambreDto addChambre(@RequestBody ChambreDto chambreDto) {return iChambreService.saveChambre(chambreDto);}

    @PutMapping("/{id}")
    public ChambreDto updateChambre(@PathVariable Long id, @RequestBody ChambreDto chambreDto) {return iChambreService.updateChambre(
            chambreDto);}
    @GetMapping("/display/{idchambre}")
    Chambre retrieveChambre(@PathVariable("idchambre") long idChambre) {
        return iChambreService.getChambre(idChambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        iChambreService.deleteChambreById(id);
    }


}
