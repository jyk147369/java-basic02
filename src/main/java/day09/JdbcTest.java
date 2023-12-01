package day09;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;     // DB 서버와 연결하는 객체
        Statement stmt = null;      // SQL 실행하는 객체
        ResultSet rs = null;        // 실행 결과를 받아오는 객체

        try {
            String url = "jdbc:mysql://10.10.10.111:3306/test";
            String id = "kjy";
            String pw = "qwer1234";
            conn = DriverManager.getConnection(url, id, pw);
            // Do something with the Connection
            // 내가 만든 mysql DB 서버와 연결함
            stmt = conn.createStatement();
            String sql = "SELECT * FROM student";
            stmt.execute(sql);
            rs = stmt.executeQuery(sql);

            while(rs.next())        // while 반복문에서  next가 있으면 반복
            {
                String sname = rs.getString("sname");
                System.out.println(sname);
                Integer sage =  rs.getInt("sage");
                System.out.println(sage);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
