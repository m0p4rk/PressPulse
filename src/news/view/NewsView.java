package news.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import news.controller.NewsController;

public class NewsView {

    private static void printMenu() {
        System.out.println("\n=== PressPulse ===");
        System.out.println("1 - Scrape news and store in database");
        System.out.println("2 - Display all news from database");
        System.out.println("3 - Get title by URL");
        System.out.println("4 - Get URL by title");
        System.out.println("5 - Display news after a specific date");
        System.out.println("6 - Display the latest N news");
        System.out.println("7 - Display news by keyword");
        System.out.println("0 - Exit");
        System.out.print("Enter your choice: ");
    }

    private static String readInput(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            printMenu();
            try {
                int input = Integer.parseInt(readInput(br));

                switch (input) {
                case 1:
                    NewsController.scrapeAndStoreNews();
                    break;

                case 2:
                    NewsController.getAll();
                    break;

                case 3:
                    System.out.print("Enter URL: ");
                    String url = readInput(br);
                    NewsController.urltogettitle(url);
                    break;

                case 4:
                    System.out.print("Enter Title: ");
                    String title = readInput(br);
                    NewsController.titletogeturl(title);
                    break;

                case 5:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(readInput(br));
                    NewsController.getNewsAfterDate(date);
                    break;

                case 6:
                    System.out.print("Enter number of latest news to display: ");
                    int limit = Integer.parseInt(readInput(br));
                    NewsController.getLatestNews(limit);
                    break;

                case 7:
                    System.out.print("Enter keyword: ");
                    String keyword = readInput(br);
                    NewsController.getNewsByKeyword(keyword);
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid input, please enter a number between 0 and 7.");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("An error occurred while reading the input.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
