/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evolph
 */
@WebServlet(urlPatterns = {"/RealizarPedido"})
public class RealizarPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
                      
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String paymentMethod = request.getParameter("paymentMethod");
            String ccname = request.getParameter("cc-name");
            String ccnumber = request.getParameter("cc-number");
            String ccexpiration = request.getParameter("cc-expiration");
            String cccvv = request.getParameter("cc-cvv");
            
            String sql = "INSERT INTO pedidos(idpedido, nombre, apellido, usuario, mail, lugarentrega, localidad, provincia, codpostal, formapago, tarjtitular, tarjnumero, tarjvto, tarjclave) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            Persistencia base = new Persistencia();
            Connection conexion = base.conectarse();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            
            
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, username);
            stmt.setString(4, email);
            stmt.setString(5, address);
            stmt.setString(6, country);
            stmt.setString(7, state);
            stmt.setString(8, zip);
            stmt.setString(9, paymentMethod);
            stmt.setString(10, ccname);
            stmt.setString(11, ccnumber);
            stmt.setString(12, ccexpiration);            
            stmt.setString(13, cccvv);
            
            
            
            stmt.executeUpdate();
            response.sendRedirect("index.html");
            
            /*Persistencia base = new Persistencia();             
            /*ResultSet rs = base.consultaSQL("insert into `pedidos` (`idpedido`, `nombre`, `apellido`, `usuario`, `mail`, `lugarentrega`, `localidad`, `provincia`, `codpostal`, `formadepago`, `tarjtitular`, `tarjnumero`, `tarjvto`, `tarjclave`) "
                    + "VALUES(NULL, '"+request.getParameter("firstName")+"', '"
                    +request.getParameter("lastName")+"', '"
                    +request.getParameter("username")+"', '"
                    +request.getParameter("email")+"', '"
                    +request.getParameter("address")+"', '"
                    +request.getParameter("country")+"', '"
                    +request.getParameter("state")+"', '"
                    +request.getParameter("zip")+"', '"
                    +request.getParameter("paymentMethod")+"', '"
                    +request.getParameter("cc-name")+"', '"
                    +request.getParameter("cc-number")+"', '"
                    +request.getParameter("cc-expiration")+"', '"
                    +request.getParameter("cc-cvv")+"')");
            Connection conexion = base.conectarse();
            Statement instruccion= conexion.createStatement();
            String sql="INSERT into `pedidos`(`idpedido`, `nombre`, `apellido`, `usuario`, `mail`, `lugarentrega`, `localidad`, `provincia`, `codpostal`, `formadepago`, `tarjtitular`, `tarjnumero`, `tarjvto`, `tarjclave`)"
                        +"VALUES(NULL,'"
                        +request.getParameter("firstName")+"', '"
                        +request.getParameter("lastName")+"', '"
                        +request.getParameter("username")+"', '"
                        +request.getParameter("email")+"', '"
                        +request.getParameter("address")+"', '"
                        +request.getParameter("country")+"', '"
                        +request.getParameter("state")+"', '"
                        +request.getParameter("zip")+"', '"
                        +request.getParameter("paymentMethod")+"', '"
                        +request.getParameter("cc-name")+"', '"
                        +request.getParameter("cc-number")+"', '"
                        +request.getParameter("cc-expiration")+"', '"
                        +request.getParameter("cc-cvv")+"')";
            ResultSet resultado= instruccion.executeQuery(sql);
            resultado.updateRow();*/
        }catch (SQLException ex) {
            Logger.getLogger(RealizarPedido.class.getName()).log(Level.SEVERE, null, ex);           
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarPedido.class.getName()).log(Level.SEVERE, null, ex);
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
