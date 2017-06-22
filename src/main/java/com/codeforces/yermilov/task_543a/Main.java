package com.codeforces.yermilov.task_543a;

import com.codeforces.yermilov.util.FastScanner;
// tag::imports[]
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.Math.min;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.function.IntUnaryOperator.identity;
import static java.util.stream.Collectors.toList;
// end::imports[]
// tag::submit[]

public class Main {

    int solve(int n, int m, int b, int mod, int[] a) {
        return new TaskSolver(mod, a).solve(n, m, b);
    }

    class TaskSolver {

        final int[][][] cache;
        final boolean[][][] calcualted;

        final int mod;
        final int[] a;

        final int[] minas;

        public TaskSolver(int mod, int[] a) {
            this.mod = mod;
            this.a = Arrays.stream(a).map(x -> -x).sorted().map(x -> -x).toArray();
            this.cache = new int [501][501][501];
            this.calcualted = new boolean[501][501][501];

            minas = new int[a.length];
            minas[0] = this.a[0];
            for (int i = 1; i < a.length; i++) {
                minas[i] = min(minas[i-1], this.a[i]);
            }
        }

        int solve(int n, int m, int b) {
            if (b < 0) {
                return 0;
            }

            if (m == 0) {
                return 1;
            }

            if (n == 0) {
                return 0;
            }

            if (minas[n-1] * m > b) {
                return 0;
            }

            if (n == 1) {
                return 1;
            }

            if (!calcualted[n][m][b]) {
                int result = 0;
                for (int i = 0; i <= m; i++) {
                    result = (result + solve(n - 1, m - i, b - i * a[n-1])) % mod;
                }

                cache[n][m][b] = result;
                calcualted[n][m][b] = true;
            }

            return cache[n][m][b];
        }
    }
}
// end::submit[]
