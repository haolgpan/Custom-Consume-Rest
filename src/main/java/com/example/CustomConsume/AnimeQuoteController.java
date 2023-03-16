package com.example.CustomConsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AnimeQuoteController.AJOKE)
public class AnimeQuoteController {
    public static final String AJOKE ="/quote";
    @Autowired
    GreetingService greetingService;

    @GetMapping
    public String getAquote(Model model) throws Exception {
        AnimeQuote quote = greetingService.getAnimeQuote();
        model.addAttribute("quote", quote.quote());
        model.addAttribute("anime", quote.anime());
        model.addAttribute("character", quote.character());
        System.out.println("Anime: " + quote.anime());
        System.out.println("Character: " + quote.character());
        System.out.println("Quote: " + quote.quote());
        return "AnimeQuote";
    }
}
