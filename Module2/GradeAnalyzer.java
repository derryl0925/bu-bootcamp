import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    static int invalidLineCount = 0;
    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);
        if (scores.isEmpty()) {
            System.out.println("No valid scores found.");
            return;    
        }
        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }
        // Step 3: write and print report
        writeReport(scores, avg, highest, lowest, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();

                if (trimmed.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(trimmed);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    invalidLineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: ");
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            writer.write(String.format("Invalid lines skipped:  %d%n", invalidLineCount));
            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score:  %d%n", low));
            writer.newLine();
            writer.write("Grade distribution:");
            writer.newLine();
            writer.write(String.format("  A (90-100):   %d%n", countA));
            writer.write(String.format("  B (80-89):    %d%n", countB));
            writer.write(String.format("  C (70-79):    %d%n", countC));
            writer.write(String.format("  D (60-69):    %d%n", countD));
            writer.write(String.format("  F (below 60): %d%n", countF));
        } catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
            return;
        }

        // Print the same info to the terminal
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read back report: " + e.getMessage());
        }
    }
} 