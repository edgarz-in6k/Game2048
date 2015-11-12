package com;

import com.game.ConsoleGameController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main( String[] args ) {

        ApplicationContext ct = new ClassPathXmlApplicationContext("spring.xml");

        ConsoleGameController controller = ct.getBean(ConsoleGameController.class);
        controller.run();
    }

    static void printColors(){
        int k = 0;
        for (int i = 0; i<=108; i++){
            if (i == 3)
                i = 30;
            else if (i == 51)
                i = 90;
            System.out.print("\u001B[" + i + "m" + "\\u001B[" + i + "m" + "\u001B[0m");
            k++;
            if (k%10 == 0 && k != 0)
                System.out.println();
        }
    }
}
//s a s d w s a d s w a d s a d w