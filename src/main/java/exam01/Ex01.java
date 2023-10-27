package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 동적 로딩 (패키지명을 포함한 클래스명을 매개변수에 입력)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "scott";
        String password = "tiger";

        try (Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stmt = conn.createStatement()){ // 자원 해제
            int deptNo = 50;
            String dName = "DEPT1";
            String loc = "LOC1";

            String sql = "INSERT INTO DEPT2 VALUES(" + deptNo + ", '" + dName + "', '" + loc + "')"; // 생성할 쿼리문 실행
            int affectedRows = stmt.executeUpdate(sql);

            System.out.println(affectedRows);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
