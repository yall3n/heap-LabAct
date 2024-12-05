import java.util.PriorityQueue;
import java.util.Scanner;

public class TopScoresTracker{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of top scores: ");
        int N = scanner.nextInt();

        PriorityQueue<Integer> topScores = new PriorityQueue<>(N);

        int choice;

        do {
            System.out.println("\n=== Top Scores Tracker ===");
            System.out.println("1. Add Score");
            System.out.println("2. View Top Scores");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter score: ");
                    int score = scanner.nextInt();

                    if (topScores.size() < N) {
                        topScores.add(score);
                    } else {
                        if (score > topScores.peek()) {
                            topScores.poll();
                            topScores.add(score);
                        }
                    }
                    System.out.println("Score added successfully!");
                    break;

                case 2:
                    if (topScores.isEmpty()) {
                        System.out.println("No scores available.");
                    } else {
                        System.out.println("Top " + N + " Scores: " + topScores);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
