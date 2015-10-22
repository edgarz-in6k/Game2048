package com.factory;

import java.io.InputStream;
import java.io.PrintStream;

public class StreamFactory {
    public static PrintStream getSystemOut() {
        return System.out;
    }

    public static InputStream getSystemIn() {
        return System.in;
    }
}