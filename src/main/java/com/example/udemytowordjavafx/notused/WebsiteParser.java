package com.example.udemytowordjavafx.notused;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WebsiteParser {
    public WebsiteParser(String html) {

        Document doc = Jsoup.parse(html);
        //doc.select("p").forEach(System.out::println);

        // /html/body/div[1]/div[1]/div/div[1]/main/div/div[2]/section/div[2]/div/div/div[1]/div[1]/div/div/h3/div/button/span/span
//        Elements elements = doc.selectXpath("/html/body/div[1]/div[1]/div/div[1]/main/div/div[2]/section/div[2]/div/div/div[1]/div[1]/div/div/h3/div/button/span/span");
//        //System.out.println("0: " + elements.eachText().get(0));
//        //System.out.println("1: " + elements.eachText().get(1));
//        System.out.println("toString: " + elements.toString());
//
//        String textNodes = doc.selectXpath("/html/body/div[1]/div[1]/div/div[1]/main/div/div[2]/section/div[2]/div/div/div[1]/div[1]/div/div/h3/div/button/span/span");

    }
}
