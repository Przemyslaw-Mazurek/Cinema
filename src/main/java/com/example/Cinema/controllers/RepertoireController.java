package com.example.Cinema.controllers;

import com.example.Cinema.services.RepertoireService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/repertoire/")
public class RepertoireController {

    private final RepertoireService repertoireService;

    public RepertoireController(RepertoireService repertoireService) {
        this.repertoireService = repertoireService;
    }
}
