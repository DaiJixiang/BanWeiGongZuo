package Util;

import java.sql.*;

public class Utils {

    private Connection con = null;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            String password = "root";
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=banji";
            String name = "sa";
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connection is successful......");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public void closeConnection(Connection con) {
        try {
            if (con != null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(Connection conn, Statement stm, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (pstm != null) {
                pstm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
