package jaz.controller;

import jaz.model.Movie;
import jaz.service.RestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RentalController {

    private final RestService restService;

    public RentalController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("movieId") Long movieId) {
        return ResponseEntity.ok(restService.getMovie(movieId));
    }

    @PutMapping("/movies/back/{movieId}")
    public ResponseEntity<Void> backMovie(@PathVariable("movieId") Long movieId) {
        restService.backMovie(movieId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/rent/{movieId}")
    public ResponseEntity<Void> rentMovie(@PathVariable("movieId") Long movieId) {
        restService.rentMovie(movieId);
        return ResponseEntity.ok().build();
    }


}
