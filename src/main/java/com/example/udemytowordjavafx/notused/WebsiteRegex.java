package com.example.udemytowordjavafx.notused;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebsiteRegex {
    public WebsiteRegex(String htmlContent) {
        String regex = "ud-accordion-panel-title";
        regexSearch(htmlContent, regex);
    }

    private static void regexSearch(String htmlContent, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
