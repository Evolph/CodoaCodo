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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evolph
 */
@WebServlet(urlPatterns = {"/checkorder"})
public class checkorder extends HttpServlet {

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
            
          Persistencia base = new Persistencia();
          ResultSet rs =base.consultaSQL("SELECT * from pedidos WHERE idpedido = '" + request.getParameter("idpedido")+"'");
          
          while(rs.next()){
            
                out.println("Nro pedido: "+rs.getString("idpedido")+"<BR>");                
                out.println("Nombre: "+rs.getString("nombre")+"<BR>");
                out.println("Apellido: "+rs.getString("apellido")+"<BR>");
                out.println("Usuario: "+rs.getString("usuario")+"<BR>");
                out.println("Email: "+rs.getString("mail")+"<BR>");
                out.println("Dirección de entrega: "+rs.getString("lugarentrega")+"<BR>");
                out.println("Localidad: "+rs.getString("localidad")+"<BR>");
                out.println("Provincia: "+rs.getString("provincia")+"<BR>");
                out.println("Código Postal: "+rs.getString("codpostal")+"<BR>");
                out.println("Forma de pago: "+rs.getString("formadepago")+"<BR>");
                out.println("Titular Tarjeta: "+rs.getString("tarjtitular")+"<BR>");
                out.println("Número Tarjeta: "+rs.getString("tarjnumero")+"<BR>");
                out.println("Vencimiento Tarjeta: "+rs.getString("tarjvto")+"<BR>");
                //out.println("Clave Tarjeta: "+rs.getString("tarjclave")+"<BR>");
            }
          
          if(rs.first()==false){
                out.println("No hay pedidos que coincidan con la busqueda");
                       
                   
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(checkorder.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(checkorder.class.getName()).log(Level.SEVERE, null, ex);
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
