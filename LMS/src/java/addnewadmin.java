/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mangl
 */
public class addnewadmin extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        String name=request.getParameter("username1");
          String rollnumber=request.getParameter("RollNo1");
          String phone=request.getParameter("phone1");
//          String registration=request.getParameter("registration");
          
          String radio=request.getParameter("radio1");
          String Email=request.getParameter("Email1");
          String password=request.getParameter("password1");
  try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/first_form","root","");
      PreparedStatement pr=(PreparedStatement) con.prepareStatement("INSERT INTO `admins_college`(`Name`,`ID_Number`,`Phone_Number`,`Gender`,`Email`,`Password`) VALUES (?,?,?,?,?,?)");
      pr.setString(1, name);
      pr.setString(2, rollnumber);
      pr.setString(3, phone);
//      pr.setString(4, registration);
      pr.setString(4,radio);
      pr.setString(5, Email);
      pr.setString(6, password);
      int i=pr.executeUpdate();
      if(i>0){
          System.out.println("Recoed inserted");
          
          response.sendRedirect("https://www.google.com"); 
      }
      else{
          System.out.println("Not inserted");
      }
  }catch(Exception e){
        e.printStackTrace();
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