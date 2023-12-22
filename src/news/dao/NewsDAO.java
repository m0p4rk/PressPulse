package news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import news.util.DBUtil;

public class NewsDAO {
	
    public static Map<String, String> getAllNews() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        Map<String, String> newsMap = new HashMap<>();

        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM summary");
            rset = stmt.executeQuery();

            while (rset.next()) {
                newsMap.put(rset.getString("title"), rset.getString("url"));
            }
        } finally {
            DBUtil.close(conn, stmt, rset);
        }

        return newsMap;
    }
}
