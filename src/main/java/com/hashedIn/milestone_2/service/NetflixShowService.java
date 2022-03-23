package com.hashedIn.milestone_2.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class NetflixShowService {

    public int count = 0;

    public List<NetflixMap> parseCsv(Integer n) throws FileNotFoundException {
        List<NetflixMap> result = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/main/resources/netflix_titles.csv"));
        while (sc.hasNext() && count != n)  //returns a boolean value
        {
            String data = sc.nextLine();
            String []fields = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            NetflixMap map = new NetflixMap(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10], fields[11]);
            result.add(map);
            count++;
        }
        sc.close();
        count=0;
        return result;
    }

    public List<NetflixMap> getShowsByCountry(String country) throws FileNotFoundException {
        List<NetflixMap> result = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/main/resources/netflix_titles.csv"));
        while (sc.hasNext())  //returns a boolean value
        {
            String data = sc.nextLine();
            String []fields = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            NetflixMap map = new NetflixMap(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10], fields[11]);
            result.add(map);
        }
        sc.close();
        return  result.stream()
                .filter( map -> map.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<NetflixMap> getShowsByMovieType(String movieType) throws FileNotFoundException {
        List<NetflixMap> result = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/main/resources/netflix_titles.csv"));
        while (sc.hasNext())  //returns a boolean value
        {
            String data = sc.nextLine();
            String []fields = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            NetflixMap map = new NetflixMap(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10], fields[11]);
            result.add(map);
        }
        sc.close();
        return  result.stream()
                .filter( map -> map.getListed_in().contains(movieType))
                .collect(Collectors.toList());
    }

}
