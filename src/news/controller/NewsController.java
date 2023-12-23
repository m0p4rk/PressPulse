package news.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import news.model.NewsScraper;
import news.service.NewsService;

public class NewsController {

    public static void urltogettitle(String url) {
        try {
            String title = NewsService.getTitleByUrl(url);
            if(title != null && !title.isEmpty()) {
                System.out.println("Title: " + title);
            } else {
                System.out.println("No title found for the given URL.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching the title.");
        }
    }

    public static void titletogeturl(String title) {
        try {
            String url = NewsService.getUrlByTitle(title);
            if(url != null && !url.isEmpty()) {
                System.out.println("URL: " + url);
            } else {
                System.out.println("No URL found for the given title.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching the URL.");
        }
    }
    
    public static void scrapeAndStoreNews() {
        try {
            // 스크랩한 뉴스 데이터를 가져옵니다.
            Map<String, String> newsData = NewsScraper.getNews();
            
            // 뉴스 데이터를 데이터베이스에 저장합니다.
            NewsService.storeScrapedNews(newsData);
            
            System.out.println("News data has been scraped and stored in the database.");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred during scraping or storing the news.");
        }
    }
}
