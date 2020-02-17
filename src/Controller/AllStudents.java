package Controller;

import Bean.Students;
import Util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AllStudents")
public class AllStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utils utils = new Utils();
        Connection conn = utils.getConnection();
        String sql = "select name, number,w from zongshu";
        List<Students> studentsList = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                Students students = new Students();
                //System.out.println(rs.getString(1)+rs.getString(2)+rs.getInt(3)+";");
                students.setName(rs.getString(1));
                students.setNumber(rs.getInt(2));
                studentsList.add(students);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("students",studentsList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
