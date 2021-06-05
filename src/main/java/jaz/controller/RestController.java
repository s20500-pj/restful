package jaz.controller;

import jaz.model.Movie;
import jaz.service.RestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final RestService restService;

    public RestController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("movieId") Long movieId) {
        return ResponseEntity.ok(restService.getMovie(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<Void> changeavailable(@PathVariable("movieId") Long movieId) {
        restService.changeavailable(movieId);
        return ResponseEntity.ok().build();
    }


}
