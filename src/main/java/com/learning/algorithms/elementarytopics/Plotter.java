package com.learning.algorithms.elementarytopics;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Plotter {

    public static void plot(String[] labels, double[] results) {
        // Create a dataset for the chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < labels.length; i++) {
            dataset.addValue(results[i], "Time (ms)", labels[i]);
        }

        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Benchmarking Results", // Chart title
                "Method", // X-axis label
                "Time (ms)", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Include legend
                true, // Tooltips
                false // URLs
        );

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        // Display the chart in a JFrame
        JFrame frame = new JFrame("Benchmarking Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
