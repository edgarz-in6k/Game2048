package com.mvc;

import com.filler.RandomCellValueFiller;
import com.game.GameField;
import com.generator.RandomCellValueGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String game(Model model){
        GameField field = new GameField(new RandomCellValueFiller(new RandomCellValueGenerator()), 4);
        model.addAttribute("hello", "Hello game!");
        model.addAttribute("field", field);
        return "game";
    }

}
