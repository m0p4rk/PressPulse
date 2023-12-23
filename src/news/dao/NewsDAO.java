package news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import news.util.DBUtil;

public class NewsDAO {

	// Double map
	private static void loadNewsData(Map<String, String> titleToUrlMap, Map<String, String> urlToTitleMap)
			throws SQLException, ClassNotFoundException {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM summary");
				ResultSet rset = stmt.executeQuery()) {

			while (rset.next()) {
				String title = rset.getString("title");
				String url = rset.getString("url");
				titleToUrlMap.put(title, url);
				urlToTitleMap.put(url, title);
			}
		}
	}

	public static Map<String, String> getTitleToUrlMap() throws SQLException, ClassNotFoundException {
		Map<String, String> titleToUrlMap = new HashMap<>();
		Map<String, String> urlToTitleMap = new HashMap<>(); // not used
		loadNewsData(titleToUrlMap, urlToTitleMap);
		return titleToUrlMap;
	}

	public static Map<String, String> getUrlToTitleMap() throws SQLException, ClassNotFoundException {
		Map<String, String> titleToUrlMap = new HashMap<>(); // not used
		Map<String, String> urlToTitleMap = new HashMap<>();
		loadNewsData(titleToUrlMap, urlToTitleMap);
		return urlToTitleMap;
	}
	
	public static void saveNews(Map<String, String> newsMap) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBUtil.getConnection();
             // title이 이미 존재하면 아무것도 하지 않음 (MySQL/MariaDB 경우)
             PreparedStatement pstmt = conn.prepareStatement(
               "INSERT INTO summary (title, url) VALUES (?, ?) ON DUPLICATE KEY UPDATE title=title")) {

            for (Map.Entry<String, String> entry : newsMap.entrySet()) {
                pstmt.setString(1, entry.getKey()); // title
                pstmt.setString(2, entry.getValue()); // url
                pstmt.executeUpdate();
            }
        }
    }
}
