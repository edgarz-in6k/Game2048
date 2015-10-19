package com.game;

public class ConsoleGameController {

    public static final String NEW_LINE = "\n";
    public static final String YOU_WIN = "YOU WIN!!!" + NEW_LINE;
    public static final String CONTINUE_PLAYING = "Continue playing? (y/n)" + NEW_LINE;
    public static final String GAME_OVER = "GAME OVER!!!" + NEW_LINE;

    private GameField field;
    private GameFieldPrinter printer;
    private GameFieldScanner scanner;

    public ConsoleGameController(GameField field) {
        this.field = field;
        printer = new GameFieldPrinter(System.out);
        scanner = new GameFieldScanner(System.in);
    }

    public void run(){
        printer.printToStream(field);
        boolean isRun = true;
        while (isRun){
            isRun = scanner.waitCheck(field);

            printer.indent();

            printer.printToStream(field);

            if (field.hasCellWith2048()){
                printer.printToStream(YOU_WIN + CONTINUE_PLAYING);
                isRun = scanner.waitPlaying();
            }
            if (!field.hasAvailableMoves()){
                printer.printToStream(GAME_OVER);
                isRun = false;
            }
        }
    }
}