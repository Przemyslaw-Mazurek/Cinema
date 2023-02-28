package com.example.Cinema.controllers;

import com.example.Cinema.model.Repertoire;
import com.example.Cinema.services.RepertoireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/repertoire")
public class RepertoireController {

    private final RepertoireService repertoireService;

    public RepertoireController(RepertoireService repertoireService) {
        this.repertoireService = repertoireService;
    }

    @GetMapping
    public Repertoire getRepertoireByDate(LocalDate repertoireDate){
        Repertoire repertoireByRepertoireDate = repertoireService.getRepertoireByDate(repertoireDate);
        return repertoireByRepertoireDate;
    }

    @PostMapping
    public Repertoire addRepertoire(Repertoire repertoire){
        return repertoireService.addRepertoire(repertoire);
    }
}
