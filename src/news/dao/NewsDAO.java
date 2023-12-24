package news.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import news.util.DBUtil;

public class NewsDAO {

    // 데이터베이스에서 뉴스 데이터를 로드하는 메서드
    private static void loadNewsData(Map<String, String> titleToUrlMap, Map<String, String> urlToTitleMap)
            throws SQLException, ClassNotFoundException {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM news");
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                String title = rset.getString("Title");
                String url = rset.getString("URL");
                titleToUrlMap.put(title, url);
                urlToTitleMap.put(url, title);
            }
        }
    }

    // 제목으로 URL 검색
    public static Map<String, String> getTitleToUrlMap() throws SQLException, ClassNotFoundException {
        Map<String, String> titleToUrlMap = new HashMap<>();
        Map<String, String> urlToTitleMap = new HashMap<>();
        loadNewsData(titleToUrlMap, urlToTitleMap);
        return titleToUrlMap;
    }

    // URL로 제목 검색
    public static Map<String, String> getUrlToTitleMap() throws SQLException, ClassNotFoundException {
        Map<String, String> titleToUrlMap = new HashMap<>();
        Map<String, String> urlToTitleMap = new HashMap<>();
        loadNewsData(titleToUrlMap, urlToTitleMap);
        return urlToTitleMap;
    }

    // 뉴스 데이터 저장
    public static void saveNews(Map<String, String> newsMap) throws SQLException, ClassNotFoundException {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO news (Title, URL) VALUES (?, ?) ON DUPLICATE KEY UPDATE Title=Title")) {
            for (Map.Entry<String, String> entry : newsMap.entrySet()) {
                pstmt.setString(1, entry.getKey());
                pstmt.setString(2, entry.getValue());
                pstmt.executeUpdate();
            }
        }
    }

    // 특정 날짜 이후의 뉴스 추출
    public static Map<String, String> getNewsAfterDate(Date date) throws SQLException, ClassNotFoundException {
        Map<String, String> newsMap = new HashMap<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT Title, URL FROM news WHERE ScrapedAt > ?")) {
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            try (ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    newsMap.put(rset.getString("Title"), rset.getString("URL"));
                }
            }
        }
        return newsMap;
    }

    // 최근 N개의 뉴스 추출
    public static Map<String, String> getLatestNews(int limit) throws SQLException, ClassNotFoundException {
        Map<String, String> newsMap = new HashMap<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT Title, URL FROM news ORDER BY ScrapedAt DESC LIMIT ?")) {
            stmt.setInt(1, limit);
            try (ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    newsMap.put(rset.getString("Title"), rset.getString("URL"));
                }
            }
        }
        return newsMap;
    }

    // 키워드를 포함하는 뉴스 추출
    public static Map<String, String> getNewsByKeyword(String keyword) throws SQLException, ClassNotFoundException {
        Map<String, String> newsMap = new HashMap<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT Title, URL FROM news WHERE Title LIKE ? OR URL LIKE ?")) {
            String keywordPattern = "%" + keyword + "%";
            stmt.setString(1, keywordPattern);
            stmt.setString(2, keywordPattern);
            try (ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    newsMap.put(rset.getString("Title"), rset.getString("URL"));
                }
            }
        }
        return newsMap;
    }
}
