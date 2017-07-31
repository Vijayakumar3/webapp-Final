import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/logout")
public class Log_Out extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
               //String username = request.getParameter("username");
          RequestDispatcher rs = request.getRequestDispatcher("admin.jsp");
                          out.println("You are logout successfully");
           rs.include(request, response);
           
        }
    }  