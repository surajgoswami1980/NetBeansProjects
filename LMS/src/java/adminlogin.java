/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.*;
//import com.mysql.jdbc.ResultSet;
import java.sql.ResultSet;

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
import javax.swing.JOptionPane;

/**
 *
 * @author mangl
 */
public class adminlogin extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean userFound = false;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/first_form","root","");
//            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Insert into `users`(`User_Name`,`User_Password`) values(?,?)");
            PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM admins_college WHERE Email=? AND Password=?");
            pr.setString(1,username);
            pr.setString(2,password);
             ResultSet rs = (ResultSet) pr.executeQuery();
//            
//            PrepareStatement stmt = (PrepareStatement) con.prepareStatement("Select * from ")
            
//            int i = stmt.executeUpdate();
             
//             int flag=0;
//             while(rs.next()){
//                 
//                 if(username.equals(rs.getString(2))  &&  password.equals(rs.getString(3))){
//                     flag=1;
//                 }
//             }
//             if(flag==1){
//                  response.sendRedirect("admininterface.html"); 
//             }
//             else{
//                  response.sendRedirect("addnewadmin.html"); 
//             }
//            if(rs.next()){
//               System.out.println("Login successful");
//                response.sendRedirect("admininterface.html");
//            }else{
//                response.sendRedirect("addnewadmin.html");   
//            }
//        }catch(Exception e){
//         response.sendRedirect("admininterface.html");   
//        }
//             ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // User exists with the provided username and password
                // Redirect to a success page or perform further actions
                response.sendRedirect("admininterface.html");
                userFound = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database errors or exceptions
            response.sendRedirect("error.html");
        }

        if (!userFound) {
            // User does not exist or credentials are incorrect
            // Display an error message on the same login page
            out.println("<html><body>");
            out.println("<h2>Login Error</h2>");
            out.println("<p>User record not found or credentials are incorrect.</p>");
            out.println("<a href='login.html'>Go back to login</a>");
            out.println("</body></html>");
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