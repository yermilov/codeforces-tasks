package com.codeforces.yermilov.task_553a;

import com.codeforces.yermilov.util.FastScanner;
// tag::imports[]
import java.io.*;

import static java.util.Arrays.stream;
// end::imports[]
// tag::submit[]

public class Main {

    private static final int MAGIC_MOD = 1_000_000_007;

    private static final Long[] MOD_INVERSE_CACHE = new Long[2000];

    public static void main(String[] args) {
        Main main = new Main();

        FastScanner fastScanner = new FastScanner();
        PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

        int k = fastScanner.nextInt();

        int[] c = new int[k];

        for (int index = 0; index < k; index++) {
            c[index] = fastScanner.nextInt();
        }

        long result = main.solve(k, c);

        output.println(result);

        output.close();
    }

    long solve(int k, int[] c) {
        if (k == 0 || k == 1) {
            return 1;
        }
        return combinations(c[k - 1] - 1, stream(c).limit(k).sum() - 1) * solve(k - 1, c) % MAGIC_MOD;
    }

    long combinations(long k, long n) {
        long result = 1;

        for (long i = n - k + 1; i <= n; i++) {
            result = (result * i) % MAGIC_MOD;
        }

        for (int i = 1; i <= k; i++) {
            result = (result * modInverse(i)) % MAGIC_MOD;
        }

        return result;
    }

    long modInverse(int n) {
        if (MOD_INVERSE_CACHE[n] == null) {
            if (n == 1) {
                MOD_INVERSE_CACHE[1] = 1L;
            } else {
                MOD_INVERSE_CACHE[n] = (-modInverse(MAGIC_MOD % n) * (MAGIC_MOD / n)) % MAGIC_MOD;
                if (MOD_INVERSE_CACHE[n] < MAGIC_MOD) {
                    MOD_INVERSE_CACHE[n] += MAGIC_MOD;
                }
            }
        }

        return MOD_INVERSE_CACHE[n];
    }
}
// end::submit[]
