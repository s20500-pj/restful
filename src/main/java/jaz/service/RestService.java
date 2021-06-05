package jaz.service;

import jaz.model.Movie;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id){
        return restTemplate.getForObject("http://localhost:8080/" + id,Movie.class);
    }

    public void backMovie(Long id){
        restTemplate.put("http://localhost:8080/movies/back/"+ id,Void.TYPE);
    }

    public void rentMovie(Long id){
        restTemplate.put("http://localhost:8080/movies/rent/"+ id,Void.TYPE);
    }

}
