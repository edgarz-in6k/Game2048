package com.mvc;

import com.filler.RandomCellValueFiller;
import com.game.Direction;
import com.game.GameField;
import com.generator.RandomCellValueGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class PageController {

    public static final String GAME_FIELD = "gameField";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String game(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        GameField gameField = new GameField(new RandomCellValueFiller(new RandomCellValueGenerator()), 4);
        gameField.fillEmptyCell();
        gameField.fillEmptyCell();
        session.setAttribute(GAME_FIELD, gameField);

        model.addAttribute("hello", "INIT");

        return "game";
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.POST)
    public String move(Model model, HttpServletRequest request, @PathVariable("key") String key){

        HttpSession session = request.getSession();
        GameField gameField = (GameField) session.getAttribute(GAME_FIELD);

        System.out.println("!!!!!" + key);

        switch (key) {
            case "37":
                gameField.move(Direction.LEFT);
                gameField.fillEmptyCell();
                break;
            case "38":
                gameField.move(Direction.UP);
                gameField.fillEmptyCell();
                break;
            case "39":
                gameField.move(Direction.RIGHT);
                gameField.fillEmptyCell();
                break;
            case "40":
                gameField.move(Direction.DOWN);
                gameField.fillEmptyCell();
                break;
        }

        model.addAttribute("hello", "GAME");

        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public @ResponseBody String makeMove(@RequestParam("key") String key, HttpServletRequest request) {
        HttpSession session = request.getSession();
        GameField gameField = (GameField) session.getAttribute(GAME_FIELD);
        switch (key) {
            case "37":
                gameField.move(Direction.LEFT);
                gameField.fillEmptyCell();
                break;
            case "38":
                gameField.move(Direction.UP);
                gameField.fillEmptyCell();
                break;
            case "39":
                gameField.move(Direction.RIGHT);
                gameField.fillEmptyCell();
                break;
            case "40":
                gameField.move(Direction.DOWN);
                gameField.fillEmptyCell();
                break;
        }
        String field = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field += gameField.getCell(i,j).getValue() + " ";
            }
        }
        return field + gameField.getScore();
    }

}
