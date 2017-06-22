package com.codeforces.yermilov.task_543a;

import com.codeforces.yermilov.util.FastScanner;
// tag::imports[]
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.copyOf;
// end::imports[]
// tag::submit[]

public class Main {

    int solve(int n, int m, int b, int mod, int[] a) {
        return new TaskSolver(mod, a).solve(n, m, b);
    }

    class TaskSolver {

        final Map<TaskRequest, Integer> cache;

        final int mod;
        final int[] a;

        public TaskSolver(int mod, int[] a) {
            this.mod = mod;
            this.a = copyOf(a, a.length);
            this.cache = new HashMap<>();
        }

        int solve(int n, int m, int b) {
            if (b < 0) {
                return 0;
            }

            if (m == 0) {
                if (b >= 0) {
                    return 1;
                } else {
                    return 0;
                }
            }

            if (n == 0) {
                return 0;
            }

            TaskRequest taskRequest = new TaskRequest(n, m, b);

            if (!cache.containsKey(taskRequest)) {
                int result = solve(n - 1, m, b);
                for (int i = 1; i <= m; i++) {
                    result = (result + solve(n - 1, m - i, b - i * a[n-1])) % mod;
                }
                cache.put(taskRequest, result);
            }

            return cache.get(taskRequest);
        }

    }

    class TaskRequest {
        int n, m, b;

        TaskRequest(int n, int m, int b) {
            this.n = n;
            this.m = m;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TaskRequest that = (TaskRequest) o;

            if (n != that.n) return false;
            if (m != that.m) return false;
            return b == that.b;
        }

        @Override
        public int hashCode() {
            int result = n;
            result = 31 * result + m;
            result = 31 * result + b;
            return result;
        }
    }
}
// end::submit[]
