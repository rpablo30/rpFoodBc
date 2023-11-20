package com.api.rpfood.controllers;

import com.api.rpfood.models.Pastel;
import com.api.rpfood.services.PastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pasteis")
public class PastelController {

    private final PastelService pastelService;

    @Autowired
    public PastelController(PastelService pastelService) {
        this.pastelService = pastelService;
    }

    @GetMapping
    public List<Pastel> obterTodosPasteis() {
        return pastelService.obterTodosPasteis();
    }
}
