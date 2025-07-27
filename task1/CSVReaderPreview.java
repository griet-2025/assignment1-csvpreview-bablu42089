package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // Print the current working directory to help locate the CSV file
        System.out.println("Working Directory: " + System.getProperty("user.dir"));

        // Path to the CSV file (use full path or relative path if 'dataset' folder is in the working directory)
        String filePath = "dataset/dataset.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the header line (first line)
            line = br.readLine();
            if (line == null) {
                System.out.println("The file is empty.");
                return;
            }

            // Split the header line by comma to get column names
            String[] columns = line.split(",");

            // Display the column names
            System.out.println("\nColumns:");
            for (String column : columns) {
                System.out.println(column.trim());
            }

            // Display total number of columns
            System.out.println("\nTotal number of columns: " + columns.length);

            // Print first 5 records (excluding header)
            System.out.println("\nFirst 5 records:");
            int count = 0; // counter for number of records printed

            while ((line = br.readLine()) != null && count < 5) {
                System.out.println(line);
                count++;
            }

            // Continue reading to count total records (excluding header)
            while ((line = br.readLine()) != null) {
                count++;
            }

            // Display total number of records (excluding header)
            System.out.println("\nTotal number of records (excluding header): " + count);

        } catch (IOException e) {
            // If file is not found or there's a read error, print the error message
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
