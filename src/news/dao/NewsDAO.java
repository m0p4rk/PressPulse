package news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import news.dto.News;
import news.util.DBUtil;

public class NewsDAO {
	
	public static ArrayList<News> getAllNews() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        ArrayList<News> deptList = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM summary");
            rset = stmt.executeQuery();

            while (rset.next()) {
                deptList.add(new News(rset.getString("title"), rset.getString("url")));
            }
        } finally {
            DBUtil.close(conn, stmt, rset);
        }

        return deptList;
    }
}
