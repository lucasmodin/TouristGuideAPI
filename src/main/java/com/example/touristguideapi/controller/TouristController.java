package com.example.touristguideapi.controller;


import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;


    public TouristController(TouristService touristService) {

        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttraction(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getTouristAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

    //Her ville det give mening at bruge annotationen "PUT", da PUT er en HTTP-metode til at at opdaterer/erstatte en eksisterende ressource på serveren.
    //Men siden opgaven direkte siger, at vi skal bruge POST, så bruger vi den.

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction updatedTouristAttraction = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.OK);
    }


    //Det samme gør sig gældende her. Her ville dog bare skulle bruge DELETE annotationen. Men siden opgaven igen siger vi skal bruge post, så bruger vi den.

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }




}
