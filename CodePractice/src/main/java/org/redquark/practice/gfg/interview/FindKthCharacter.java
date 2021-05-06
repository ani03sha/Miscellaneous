package org.redquark.practice.gfg.interview;

public class FindKthCharacter {

    private static char find(String S, String T, int K) {
        // lengths of S and T
        int s = S.length();
        int t = T.length();
        // Counters of S and T
        int sCounter = 1;
        int tCounter = 2;
        // To store final chunks of string
        StringBuilder sb = new StringBuilder();
        // Loop until K is greater than zero
        while (K > 0) {
            if (K > sCounter * s) {
                K -= sCounter * s;
                sCounter += 2;
                if (K > tCounter * t) {
                    K -= tCounter * t;
                    tCounter += 2;
                } else {
                    return sb.append(T.repeat(tCounter)).charAt(K - 1);
                }
            } else {
                return sb.append(S.repeat(sCounter)).charAt(K - 1);
            }
        }
        return '\u0000';
    }

    public static void main(String[] args) {
        String S = "a";
        String T = "bc";
        int K = 3;
        System.out.println(find(S, T, K));
        K = 17;
        System.out.println(find(S, T, K));
    }
}
