package news.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import news.dao.NewsDAO;
import news.model.NewsScraper;

public class NewsService {

	// Get all data in Map type
	public static Map<String, String> getAllData() throws ClassNotFoundException, SQLException {
		return NewsDAO.getTitleToUrlMap();
	}

	public static String getUrlByTitle(String title) throws ClassNotFoundException, SQLException {
		Map<String, String> titleToUrlMap = NewsDAO.getTitleToUrlMap();
		return titleToUrlMap.get(title);
	}

	public static String getTitleByUrl(String url) throws ClassNotFoundException, SQLException {
		Map<String, String> urlToTitleMap = NewsDAO.getUrlToTitleMap();
		return urlToTitleMap.get(url);
	}
	
	public static void storeNewsInDatabase() throws ClassNotFoundException, SQLException, IOException {
        Map<String, String> newsMap = NewsScraper.getNews(); // Jsoup을 사용해 뉴스 데이터를 가져옴
        NewsDAO.saveNews(newsMap); // 데이터베이스에 저장
    }
	
	public static void storeScrapedNews(Map<String, String> newsData) throws ClassNotFoundException, SQLException {
        // 데이터베이스에 뉴스 데이터를 저장합니다.
        NewsDAO.saveNews(newsData);
    }
}
