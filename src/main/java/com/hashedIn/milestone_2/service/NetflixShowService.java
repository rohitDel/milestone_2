package com.hashedIn.milestone_2.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class NetflixShowService {

    public static int count = 0;

    public List<String> parseCsv(Integer n) throws FileNotFoundException {
        List<String> result = new ArrayList<>();
        Scanner sc = new Scanner(new File("/Users/rohitgupta3/Downloads/netflix_titles.csv"));
        while (sc.hasNext() && count != n)  //returns a boolean value
        {
            String data = sc.nextLine();
            if(getShowByCategory(data, "TV Show")) {
                result.add(data);
            }
        }
        sc.close();
        return result;
    }

    public boolean getShowByCategory(String input, String category) {
        String []fields = input.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//        String regex = ".*\\bs1\\b*.";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);

        String inputCategory = fields[1];
//        System.out.println(fields.length);
        if(inputCategory.equals(category)) {
            System.out.println(input);
            count++;
            return true;
        }
        return false;
    }

}
