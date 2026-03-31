package _01_Fundamentals.BJ10870_피보나치_수_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println(fibonachi(number));
    }

    static int fibonachi(int number) {
        if(number == 0) return 0;
        if(number == 1) return 1;

        return fibonachi(number - 1) + fibonachi(number - 2) ;
    }

}
