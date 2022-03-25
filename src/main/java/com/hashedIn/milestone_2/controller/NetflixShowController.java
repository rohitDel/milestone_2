package com.hashedIn.milestone_2.controller;

import com.hashedIn.milestone_2.service.NetflixMap;
import com.hashedIn.milestone_2.service.NetflixShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tvshows")
public class NetflixShowController {

    @Autowired
    NetflixShowService netflixShowService;

    @GetMapping(params = "count") //controller to get data by count
    public ResponseEntity<List<NetflixMap>> getTvShowsByType(@RequestParam Integer count) throws FileNotFoundException {
        return new ResponseEntity<>(netflixShowService.parseCsv(count), HttpStatus.OK);
    }

    @GetMapping(params = "country") //controller to get data by country
    public ResponseEntity<List<NetflixMap>> getTvShowByCountry(@RequestParam String country) throws FileNotFoundException {
        return new ResponseEntity<>(netflixShowService.getShowsByCountry(country), HttpStatus.OK);
    }

    @GetMapping(params = "movieType") //controller to get data by movietype
    public ResponseEntity<List<NetflixMap>> getTvShowByMovieType(@RequestParam String movieType) throws FileNotFoundException {
        return new ResponseEntity<>(netflixShowService.getShowsByMovieType(movieType), HttpStatus.OK);
    }
}
