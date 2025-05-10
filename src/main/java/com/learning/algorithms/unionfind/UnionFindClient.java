package com.learning.algorithms.unionfind;

import java.util.Scanner;

public class UnionFindClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = scanner.nextInt();
        scanner.nextLine();

        var uf = new QuickFindUF(n);
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("exit")) break;

            else if (line.startsWith("union")) {
                String[] parts = line.substring(6).split(",");
                int p = Integer.parseInt(parts[0].trim());
                int q = Integer.parseInt(parts[1].trim());
                uf.union(p, q);
                System.out.println("Union performed.");
            }

            else if (line.startsWith("connected")) {
                String[] parts = line.substring(10).split(",");
                int p = Integer.parseInt(parts[0].trim());
                int q = Integer.parseInt(parts[1].trim());
                boolean result = uf.connected(p, q);
                System.out.println(result ? "yes" : "no");
            }

            else if (line.startsWith("count"))
                System.out.println("Connected components: " + uf.getConnectedComponentsCount());
            else
                System.out.println("Invalid command. Try: union, connected, count, exit");
        }
        scanner.close();

    }
}