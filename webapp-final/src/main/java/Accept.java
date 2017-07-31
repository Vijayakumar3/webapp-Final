import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet("/Accept")
 public class Accept extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from view");

            pw.println("<table border=1>");
            while (rs.next()) {
                pw.println("<tr><td>" + rs.getString(1) + "<td>" + rs.getString(2)+ "<td>" + rs.getString(3)+"<td>"+ rs.getString(4)+ "<td>"+rs.getString(5) + "</tr>");
            }
            pw.println("</table>");
              pw.println("<html>"+"<body>"+"<form action='/logout' method='POST'>"+"<button type='submit'> Logout </button>"+"</form>");
              pw.println("<form action='/search' method='GET'>"+"Search blood group:<input type='text' name='blood'>"+"<input type='submit' vlaue='submit'> "+"</form"+"</body>"+"</html>");

            pw.close();
        }
        

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}