package ua.samoplavskaya.module_products;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\module_products\\input.txt");
            File outputFile = new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\module_products\\output.txt");
            outputFile.createNewFile();
            List<Products> products = readFromFile(inputFile);
            writeToFile(products, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Products> readFromFile(File file) {
        List<Products> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split("\\|");
                String name = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                Products product = new Products(name, quantity, price);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static List<Products> filterProducts(List<Products> products, int value) {
        return products.stream()
                .filter(product -> product.getQuantity() > value)
                .collect(Collectors.toList());
    }

    private static int totalQuantity(List<Products> products) {
        return products.stream()
                .mapToInt(Products::getQuantity)
                .sum();
    }

    private static double averagePriceOfProduct(List<Products> products) {
        return totalCost(products) / totalQuantity(products);
    }

    private static List<Products> sortByPriceInDescendingOrder(List<Products> products) {
        Comparator<Products> comparator = Comparator.comparingDouble(Products::getPrice).reversed();
        return products.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private static double totalCost(List<Products> products) {
        return products.stream()
                .flatMapToDouble(product -> DoubleStream.of(product.getPrice() * product.getQuantity()))
                .sum();
    }

    private static void writeToFile(List<Products> products, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("1.Filter products with quantities greater than 4:\n");
            for (Products product : filterProducts(products, 4)) {
                fileWriter.write(product.getName() + "|" + product.getQuantity() + "|" + product.getPrice() + "\n");
            }
            fileWriter.write("2.The total amount of food in the refrigerator: " + totalQuantity(products));
            DecimalFormat df = new DecimalFormat("#.##");
            fileWriter.write("\n3.Average price of products: " + df.format(averagePriceOfProduct(products)));
            fileWriter.write("\n4.Sorted products by price in descending order:\n");
            for (Products product : sortByPriceInDescendingOrder(products)) {
                fileWriter.write(product.getName() + "|" + product.getQuantity() + "|" + product.getPrice() + "\n");
            }
            fileWriter.write("5.Total cost of products (price * quantity): " + totalCost(products));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
