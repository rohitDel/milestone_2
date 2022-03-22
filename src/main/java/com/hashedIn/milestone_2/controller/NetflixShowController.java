package com.hashedIn.milestone_2.controller;

import com.hashedIn.milestone_2.service.NetflixShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/tvshows")
public class NetflixShowController {

    @Autowired
    NetflixShowService netflixShowService;

    @GetMapping
    public ResponseEntity<List<String>> getTvShowsByType(@RequestParam Integer count) throws FileNotFoundException {
        return new ResponseEntity<>(netflixShowService.parseCsv(count), HttpStatus.OK);
    }
}
