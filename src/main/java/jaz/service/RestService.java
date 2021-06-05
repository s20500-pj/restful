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

    public void changeavailable(Long id){
        restTemplate.getForEntity("http://localhost:8080/movies/"+ id,Void.TYPE);
    }

}
