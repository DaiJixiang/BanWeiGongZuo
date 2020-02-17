package Controller;

import Bean.Students;
import Util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/ChangeName")
public class ChangeName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement preparedStatement = null;
        Utils utils = new Utils();
        Connection conn = utils.getConnection();
        String sql = "select name, number,w from zongshu";
        String sql1 = "update zongshu set w = 0";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql1);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Students> studentsList = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Students students = new Students();
                students.setName(rs.getString(1));
                students.setNumber(rs.getInt(2));
                studentsList.add(students);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String newFileName = "";
        String banji = "17软工二班";
        request.setCharacterEncoding("utf-8");
        String path = request.getParameter("filePath");
        String name = request.getParameter("fileName");
        String type = request.getParameter("type");
        System.out.println("路径是："+path);
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (File file1 : tempList) {
            if (file1.isFile()) {
                System.out.println(file1.getName());
                for (Students s : studentsList) {
                    if (file1.getName().contains(s.getName().trim())){
                        String houzhui = "";
                        String rule = ".*(\\.[a-z]+)";
                        Pattern pattern = Pattern.compile(rule);
                        Matcher matcher = pattern.matcher(file1.getName());
                        while (matcher.find()) {
                            houzhui = matcher.group(1);
                        }
                        newFileName = banji+"-"+s.getNumber()+"-"+s.getName().trim()+"-"+name+houzhui;
                        String sql2 = "update zongshu set w = 1 where number="+s.getNumber();
                        try {
                            preparedStatement = conn.prepareStatement(sql2);
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        file1.renameTo(new File(file1.getParent()+"\\"+newFileName));
                        System.out.println(">>>新的文件名已经修改好："+newFileName+"......");
                    }
                }
            }
        }
        List<Students> unhandStudents = new ArrayList<>();
        List<Students> handedStudents = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (0 == resultSet.getInt(3)) {
                    Students students = new Students();
                    students.setName(resultSet.getString(1));
                    students.setNumber(resultSet.getInt(2));
                    unhandStudents.add(students);
                }
                else {
                    Students students = new Students();
                    students.setName(resultSet.getString(1));
                    students.setNumber(resultSet.getInt(2));
                    handedStudents.add(students);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("unhandStudents",unhandStudents);
        request.setAttribute("handedStudents",handedStudents);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

}
