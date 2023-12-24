package news.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import news.dao.NewsDAO;
import news.model.NewsScraper;

public class NewsService {

    // 모든 뉴스 데이터를 가져옵니다.
    public static Map<String, String> getAllData() throws ClassNotFoundException, SQLException {
        return NewsDAO.getTitleToUrlMap();
    }

    // 제목을 기반으로 URL을 찾습니다.
    public static String getUrlByTitle(String title) throws ClassNotFoundException, SQLException {
        return NewsDAO.getTitleToUrlMap().get(title);
    }

    // URL을 기반으로 제목을 찾습니다.
    public static String getTitleByUrl(String url) throws ClassNotFoundException, SQLException {
        return NewsDAO.getUrlToTitleMap().get(url);
    }
    
    // Jsoup을 사용해 뉴스 데이터를 스크랩하고 데이터베이스에 저장합니다.
    public static void storeNewsInDatabase() throws ClassNotFoundException, SQLException, IOException {
        storeScrapedNews(NewsScraper.getNews());
    }
    
    // 주어진 뉴스 데이터를 데이터베이스에 저장합니다.
    public static void storeScrapedNews(Map<String, String> newsData) throws ClassNotFoundException, SQLException {
        NewsDAO.saveNews(newsData);
    }

    // 특정 날짜 이후의 뉴스 데이터를 가져옵니다.
    public static Map<String, String> getNewsAfterDate(Date date) throws ClassNotFoundException, SQLException {
        return NewsDAO.getNewsAfterDate(date);
    }

    // 최근 N개의 뉴스를 가져옵니다.
    public static Map<String, String> getLatestNews(int limit) throws ClassNotFoundException, SQLException {
        return NewsDAO.getLatestNews(limit);
    }

    // 특정 키워드를 포함하는 뉴스를 가져옵니다.
    public static Map<String, String> getNewsByKeyword(String keyword) throws ClassNotFoundException, SQLException {
        return NewsDAO.getNewsByKeyword(keyword);
    }
}
