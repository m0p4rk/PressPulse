package news.service;

import java.sql.SQLException;
import java.util.Map;

import news.dao.NewsDAO;

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
}
