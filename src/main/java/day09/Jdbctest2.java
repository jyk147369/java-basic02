package day09;

import java.sql.*;
import java.util.Scanner;

public class Jdbctest2 {
    public static void main(String[] args) {
        Connection conn = null; // DB 서버와 연결하는 객체
        Statement stmt = null; // SQL을 실행하는 객체
        ResultSet rs = null; // 실행 결과를 받아오는 객체
        try {
            String url = "jdbc:mysql://10.10.10.111:3306/test";
            String id = "kjy";
            String pw = "qwer1234";
            conn = DriverManager.getConnection(url, id, pw);
            stmt = conn.createStatement();

            Scanner sc = new Scanner(System.in);

            String sname = "hong";
            int sage = 28;

            String sql = "INSERT INTO student (sname, sage) VALUES ('" + sname + "', " + sage + ")";
            // UPDATE test.student SET sage = 25 WHERE sname = '이름';
            Integer result = stmt.executeUpdate(sql);       // 0이면 실패, 1이면 성공

            if (result > 0) {
                System.out.println("정상적으로 insert 됐다");
            } else {
                System.out.println("insert 안됨");
            }


        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}

