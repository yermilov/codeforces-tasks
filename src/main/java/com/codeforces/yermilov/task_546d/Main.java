package com.codeforces.yermilov.task_546d;

import com.codeforces.yermilov.util.FastScanner;
// tag::imports[]
import java.io.*;
// end::imports[]
// tag::submit[]

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        FastScanner fastScanner = new FastScanner();
        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(System.out));

        int t = fastScanner.nextInt();

        for (int i = 0; i < t; i++) {
            int a = fastScanner.nextInt();
            int b = fastScanner.nextInt();

            int result = main.solve(a, b);

            printWriter.println(result);
        }

        printWriter.close();
    }

    private static final int MAX_AB = 5_010_000;

    private final int[] dt;
    private final int[] dtf;

    Main() {
        dt = new int[MAX_AB];
        for (int i = 2; i < MAX_AB; i++) {
            if (dt[i] == 0) {
                dt[i] = 1;
                for (int j = 2 * i; j < MAX_AB; j += i) {
                    dt[j] = dt[j / i] + 1;
                }
            }
        }

        dtf = new int[MAX_AB];
        dtf[1] = dt[1];
        for (int i = 2; i < MAX_AB; i++) {
            dtf[i] = dtf[i - 1] + dt[i];
        }
    }

    int solve(int a, int b) {
        return dtf[a] - dtf[b];
    }
}
// end::submit[]
