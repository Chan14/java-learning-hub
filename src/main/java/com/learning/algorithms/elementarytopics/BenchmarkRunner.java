package com.learning.algorithms.elementarytopics;

public class BenchmarkRunner {

    public static void main(String[] args) {
        final int start = 100_000;
        final int end = 200_000;

        Runnable task0 = () -> {
            for (int i = start; i <= end; i++) {
                PrimeChecker.isPrime(i);
            }
        };

        Runnable task1 = () -> {
            for (int i = start; i <= end; i++) {
                PrimeChecker.isPrimeOptimizedDiv(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = start; i <= end; i++) {
                PrimeChecker.isPrimeOptimizedMul(i);
            }
        };

        Runnable[] tasks = { task0, task1, task2 };
        String[] labels = { "Basic", "Div-Based Opt", "Mul-Based Opt" };
        double[] results = new double[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            results[i] = Benchmark.run(tasks[i]);
            System.out.printf("%s average time: %.3f ms%n", labels[i], results[i]);
        }

        //Plotter.plot(labels, results);

    }

}
