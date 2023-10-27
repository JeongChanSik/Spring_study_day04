package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String pass = "tiger";

        String sql = "INSERT INTO DEPT2 VALUES (?, ?, ?)"; // 교체가 되는 부분
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, 50);
                pstmt.setString(2, "DEPT2");
                pstmt.setString(3, "LOC2");

                int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
