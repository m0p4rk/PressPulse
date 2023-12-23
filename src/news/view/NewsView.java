package news.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import news.controller.NewsController;

public class NewsView {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter 1 to scrape and store news, 2 to fetch title by URL, 3 to fetch URL by title: ");
            try {
                int input = Integer.parseInt(br.readLine());

                switch (input) {
                case 1:
                    // 스크랩하고 데이터베이스에 저장하는 기능을 실행합니다.
                    NewsController.scrapeAndStoreNews();
                    break;

                case 2:
                    System.out.print("Enter URL: ");
                    String url = br.readLine();
                    NewsController.urltogettitle(url);
                    break;

                case 3:
                    System.out.print("Enter Title: ");
                    String title = br.readLine();
                    NewsController.titletogeturl(title);
                    break;

                default:
                    System.out.println("Invalid input, please enter a number between 1 and 3.");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("An error occurred while reading the input.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
