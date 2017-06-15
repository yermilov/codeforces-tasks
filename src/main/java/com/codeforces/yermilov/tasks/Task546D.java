package com.codeforces.yermilov.tasks;

import com.codeforces.yermilov.util.FastScanner;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class Task546D {

    public static void main(String[] args) {
        Task546D task546D = new Task546D();

        FastScanner fastScanner = new FastScanner();
        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(System.out));

        int t = fastScanner.nextInt();

        for (int i = 0; i < t; i++) {
            int a = fastScanner.nextInt();
            int b = fastScanner.nextInt();

            int result = task546D.solve(a, b);

            printWriter.println(result);
        }

        printWriter.close();
    }

    int solve(int a, int b) {
        return 0;
    }
}
