package com;

//import com.box.Field2048;

import com.test.TestJUnit;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Result result = JUnitCore.runClasses(TestJUnit.class);
        for (Failure failure : result.getFailures())
            System.err.println(failure.getMessage());
        System.err.println(result.wasSuccessful());


        int sizeField = 4;

    }
}