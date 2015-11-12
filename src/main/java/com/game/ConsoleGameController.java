package com.game;

public class ConsoleGameController {

    public static final String NEW_LINE = "\n";
    public static final String YOU_WIN = "YOU WIN!!!" + NEW_LINE;
    public static final String CONTINUE_PLAYING = "Continue playing? (y/n)" + NEW_LINE;
    public static final String GAME_OVER = "GAME OVER!!!" + NEW_LINE;

    private GameFieldInterface field;
    private GameFieldPrinterInterface printer;
    private GameFieldScannerInterface scanner;

    public ConsoleGameController(GameFieldInterface field, GameFieldPrinterInterface printer, GameFieldScannerInterface scanner) {
        this.field = field;
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run(){
        field.fillEmptyCell();
        field.fillEmptyCell();
        printer.printToStream(field);
        boolean isRun = true;
        while (isRun){
            isRun = scanner.scanCommand(field);

            printer.indent();

            printer.printToStream(field);

            if (field.hasCellWith2048()){
                printer.printToStream(YOU_WIN + CONTINUE_PLAYING);
                isRun = scanner.continueGame();
            }
            if (!field.hasAvailableMoves()){
                printer.printToStream(GAME_OVER);
                isRun = false;
            }
        }
    }
}