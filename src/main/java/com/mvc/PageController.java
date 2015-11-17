package com.mvc;

import com.filler.RandomCellValueFiller;
import com.game.Direction;
import com.game.GameField;
import com.generator.RandomCellValueGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    public static final String GAME_FIELD = "gameField";
    public static final String KEY_LEFT = "37";
    public static final String KEY_UP = "38";
    public static final String KEY_RIGHT = "39";
    public static final String KEY_DOWN = "40";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(){
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String game(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        GameField gameField = new GameField(new RandomCellValueFiller(new RandomCellValueGenerator()), 4);

        gameField.fillEmptyCell();
        gameField.fillEmptyCell();

        session.setAttribute(GAME_FIELD, gameField);

        model.addAttribute("hello", "INIT");

        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public @ResponseBody String makeMove(@RequestParam("key") String key, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        GameField gameField = (GameField) session.getAttribute(GAME_FIELD);

        movedField(key, gameField);

        model.addAttribute("hello", "AJAX");

        String field = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field += gameField.getCell(i,j).getValue() + " ";
            }
        }
        return field + gameField.getScore();
    }

    public void movedField(String key, GameField gameField) {
        switch (key) {
            case KEY_LEFT: controllerField(gameField, Direction.LEFT); break;
            case KEY_UP: controllerField(gameField, Direction.UP); break;
            case KEY_RIGHT: controllerField(gameField, Direction.RIGHT); break;
            case KEY_DOWN: controllerField(gameField, Direction.DOWN);  break;
        }
    }

    public void controllerField(GameField gameField, Direction left) {
        gameField.move(left);
        gameField.fillEmptyCell();
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

}
