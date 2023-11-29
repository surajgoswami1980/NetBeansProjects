/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*; 

/**
 *
 * @author HP
 */
public class studentdetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet studentdetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet studentdetails at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                 PrintWriter out = response.getWriter();  
         response.setContentType("text/html");  
         out.println("<html>");
out.println("<head>");
out.println("<style>");
out.println(".container {");
out.println("    text-align: center;");
out.println("    display:block;");
out.println("    margin-bottom: 30px;");
out.println("}");
out.println("</style>");
out.println("</head>");
out.println("<body>");
out.println("<div class='container'>");
out.println("<h1>Student Details</h1>");
out.println("</div>");
out.println("</body>");
out.println("</html>");
         try 
         {  
              Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/first_form","root","");
             // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select name,ID_Number,phone from student_college");  
           out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<style>");
out.println("table {");
out.println("    font-family: Arial, sans-serif;");
out.println("    border-collapse: collapse;");
out.println("    width: 100%;");
out.println("}");
out.println("td, th {");
out.println("    border: 1px solid #dddddd;");
out.println("    text-align: left;");
out.println("    padding: 8px;");
out.println("}");
out.println("tr:nth-child(even) {");
out.println("    background-color: #f2f2f2;");
out.println("}");
out.println("th {");
out.println("    background-color: #4CAF50;");
out.println("    color: white;");
out.println("}");
out.println("h1 {");
out.println("    text-align: center;");
out.println("}");
//out.println(".container h1{");
//out.println("    text-align: center;");
//out.println("    margin-top: 30px;");
//out.println("    margin-bottom: 30px;");
//out.println("}");
out.println("</style>");
out.println("<title>Servlet studentdetails</title>");
out.println("</head>");
out.println("<body>");
//out.println("<div class='container'>");
//out.println("<h1>Student Details</h1>");
//out.println("</div>");
out.println("<table>");
out.println("<tr><th>Name</th><th>Roll Number</th><th>Phone No.</th></tr>");

             while (rs.next()) 
             {  
                 String n = rs.getString("name");  
                 String nm = rs.getString("ID_Number");  
                   String p = rs.getString("phone");  
//                 int s = rs.getInt("sal");   
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + p + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
               e.printStackTrace();
        out.println("Error: " + e.getMessage()); 
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
