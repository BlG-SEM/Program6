package ru.vsu.cs;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readVariable("x");
        double numberOfMembers = readVariable("numberOfMembers");
        double eps= readVariable("epsilon");

        double sumOfSequence = calculateSumOfSequence(x, numberOfMembers);
        printResult("of N terms", sumOfSequence);

        double sumOfSequenceWithEpsilon = calculateSumOfSequenceWithEpsilon(x, numberOfMembers, eps);
        printResult("of N terms of which the absolute value of more than epsilon", sumOfSequenceWithEpsilon);

        double sumOfSequenceWithEpsilonDividedBy10 = calculateSumOfSequenceWithEpsilon(x, numberOfMembers, eps / 10);
        printResult("of N terms of which the absolute value of more than epsilon divided by 10",
                sumOfSequenceWithEpsilonDividedBy10);

        double sumOfSequenceWithMath = Math.cos(x);
        printResult("using Math", sumOfSequenceWithMath);
    }

    private static double readVariable(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s: ", name);
        return scanner.nextDouble();
    }
    
     private static double pow(double base, int index) {
        double result = 1;
        for (int i = 0; i < index; i++) {
            result *= base;
        }
        return result;
    }
    
    private static int getFactorial(int value) {
        int result = 1
        for (int i = 1; i <=  i++) {
            result = result * i;
        }
        return result;
    }

    private static double getNMemberOfSequence(double x, int n) {
        double numerator = Math.pow(-1, n-1) * Math.pow(x, 2 * n - 2);
        double denominator = getFactorial(2 * n -2);
        return numerator / denominator;
    }

    private static double calculateSumOfSequence(double x, double numberOfMembers) {
        double sum = 0;
        for (int i = 0; i <= numberOfMembers; i++) {
            sum += getNMemberOfSequence(x, i);
        }
        return sum;
    }

    private static double calculateSumOfSequenceWithEpsilon(double x, double numberOfMembers, double eps) {
        double sum = 0;
        for (int i = 0; i <= numberOfMembers; i++) {
            double nMemberOfSequence = getNMemberOfSequence(x, i);
            if (abs(nMemberOfSequence) > eps) {
                sum = sum + getNMemberOfSequence(x, i);
            }
        }
        return sum;
    }
    
    private static void printResult(String text, double sum) {
        System.out.printf("The sum %s: %f\n", text, sum);
    }
}
