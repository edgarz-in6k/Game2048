package com.game;

import java.io.InputStream;
import java.util.Scanner;

public class GameFieldScanner {
    public Scanner scannerWithInput(InputStream scan){
        return new Scanner(scan);
    }
}
