package com.learning.algorithms.elementarytopics;

public class Benchmark {
    private static final int warmupIterationCount = 3;
    private static final int benchmarkIterationCount = 5;

    private static void warmup(Runnable task) {
        for (int i = 0; i < warmupIterationCount; i++) {
            task.run();
        }
    }

    public static double run(Runnable task) {
        warmup(task);
        long total = 0;
        for (int j = 0; j < benchmarkIterationCount; j++) {
            long startTime = System.nanoTime();
            task.run();
            long endTime = System.nanoTime();
            total += (endTime - startTime);
        }
        return total / (benchmarkIterationCount * 1e6); // convert to ms
    }
}
