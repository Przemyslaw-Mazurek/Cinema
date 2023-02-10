package com.example.Cinema.controllers;

import com.example.Cinema.model.Showing;
import com.example.Cinema.services.ShowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/showings")
public class ShowingController {

    private final ShowingService showingService;

    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @GetMapping
    public ResponseEntity<List<Showing>> getAllShowings() {
        return ResponseEntity.ok(showingService.getAllShowings());
    }

    @GetMapping("{id}")
    public ResponseEntity<Showing> getShowing(@PathVariable Long id) {
        return ResponseEntity.ok(showingService.getShowing(id));
    }

    @PostMapping
    public ResponseEntity<Showing> addShowing(@Valid @RequestBody Showing movie) {
        return ResponseEntity.ok(showingService.addShowing(movie));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeShowing(Long id) {
        showingService.removeShowing(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Showing> updateShowing(@PathVariable Long id, @Valid @RequestBody Showing showing) {
        return ResponseEntity.ok(showingService.updateShowing(id, showing));
    }
}
