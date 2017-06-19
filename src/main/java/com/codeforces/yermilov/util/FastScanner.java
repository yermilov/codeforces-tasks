package com.codeforces.yermilov.util;
// tag::imports[]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// end::imports[]

/**
 * Done via http://codeforces.com/blog/entry/7018?locale=ru
 */
public
// tag::submit[]
 class FastScanner {

    private final BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public FastScanner() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException("Can't read next value", e);
            }
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine(){
        String str = "";
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
// end::submit[]
