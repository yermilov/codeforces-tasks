package com.codeforces.yermilov.task_543a;

import com.codeforces.yermilov.util.FastScanner;
// tag::imports[]
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
// end::imports[]
// tag::submit[]

public class Main {

    int[][][] dn;

    public static void main(String[] args) {
        Main main = new Main();

        FastScanner fastScanner = new FastScanner();
        PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

        int n = fastScanner.nextInt();
        int m = fastScanner.nextInt();
        int b = fastScanner.nextInt();
        int mod = fastScanner.nextInt();

        int[] a = new int[n];

        for (int index = 0; index < n; index++) {
            a[index] = fastScanner.nextInt();
        }

        long result = main.solve(n, m, b, mod, a);

        output.println(result);

        output.close();
    }

    int solve(int N, int M, int B, int mod, int[] a) {
        dn = new int [2][M+1][B+1];
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                for (int b = 0; b <= B; b++) {
                    if (m == 0) {
                        dn[n%2][m][b] = 1;
                    } else {
                        if (n == 0) {
                            dn[n%2][m][b] = 0;
                        } else {
                            if (a[n-1] <= b) {
                                dn[n%2][m][b] = (dn[(n + 1)%2][m][b] + dn[n%2][m - 1][b - a[n-1]]) % mod;
                            } else {
                                dn[n%2][m][b] = dn[(n + 1)%2][m][b];
                            }
                        }
                    }
                }
            }
        }

        return dn[N%2][M][B] % mod;
    }
}
// end::submit[]
