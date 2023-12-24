package news.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import news.service.NewsService;

public class NewsController {

    // 모든 뉴스 데이터를 콘솔에 출력합니다.
    public static void getAll() {
        try {
            Map<String, String> newsMap = NewsService.getAllData();
            printNewsMap(newsMap);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching all news data.");
        }
    }

    // URL을 기반으로 뉴스 제목을 검색하여 출력합니다.
    public static void urltogettitle(String url) {
        try {
            String title = NewsService.getTitleByUrl(url);
            printTitleOrUrl(title);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching the title.");
        }
    }

    // 제목을 기반으로 뉴스 URL을 검색하여 출력합니다.
    public static void titletogeturl(String title) {
        try {
            String url = NewsService.getUrlByTitle(title);
            printTitleOrUrl(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching the URL.");
        }
    }

    // 스크랩한 뉴스를 데이터베이스에 저장합니다.
    public static void scrapeAndStoreNews() {
        try {
            NewsService.storeNewsInDatabase();
            System.out.println("News data has been scraped and stored in the database.");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred during scraping or storing the news.");
        }
    }

    // 특정 날짜 이후의 뉴스를 콘솔에 출력합니다.
    public static void getNewsAfterDate(Date date) {
        try {
            Map<String, String> newsMap = NewsService.getNewsAfterDate(date);
            printNewsMap(newsMap);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching news after date.");
        }
    }

    // 최근 N개의 뉴스를 콘솔에 출력합니다.
    public static void getLatestNews(int limit) {
        try {
            Map<String, String> newsMap = NewsService.getLatestNews(limit);
            printNewsMap(newsMap);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching the latest news.");
        }
    }

    // 특정 키워드를 포함하는 뉴스를 콘솔에 출력합니다.
    public static void getNewsByKeyword(String keyword) {
        try {
            Map<String, String> newsMap = NewsService.getNewsByKeyword(keyword);
            printNewsMap(newsMap);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while fetching news by keyword.");
        }
    }

    // 도우미 메서드: 뉴스 맵을 콘솔에 출력합니다.
    private static void printNewsMap(Map<String, String> newsMap) {
        if (newsMap != null && !newsMap.isEmpty()) {
            for (Map.Entry<String, String> entry : newsMap.entrySet()) {
                System.out.println("Title: " + entry.getKey());
                System.out.println("URL: " + entry.getValue());
                System.out.println();
            }
        } else {
            System.out.println("No news data found.");
        }
    }

    // 도우미 메서드: 제목 또는 URL을 콘솔에 출력합니다.
    private static void printTitleOrUrl(String text) {
        if (text != null && !text.isEmpty()) {
            System.out.println(text);
        } else {
            System.out.println("No data found.");
        }
    }
}
