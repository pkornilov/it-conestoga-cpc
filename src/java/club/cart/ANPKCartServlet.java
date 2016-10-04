/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package club.cart;

import club.business.Book;
import club.business.ECart;
import static club.business.ELoan.findItem;
import static club.business.ELoan.subtractFromQOH;
import club.data.BookIO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pkornilov
 */
public class ANPKCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session=request.getSession();
        ServletContext context=getServletContext();
        
        ArrayList<Book> loanItems=(ArrayList<Book>)context
                .getAttribute("loanItems");
          
        String action=request.getParameter("action");
      
        
        ECart cart=(ECart)session.getAttribute("cart");
        
        if (cart==null) {
            
            cart=new ECart();
        }
        if (action==null) {
            action="reserve";
        }

        String code=request.getParameter("code");
        String quantityString=request.getParameter("quantity");
        
        if (quantityString==null) {
                quantityString="1";
        }
        if (action.equals("reserve")) {
         
            cart.addItem(findItem(loanItems, code));  
            subtractFromQOH(loanItems, code, Integer.parseInt(quantityString));
           
        }
        session.setAttribute("cart", cart);
        String url="/ANPKECart.jsp";
        getServletContext().getRequestDispatcher(url)
                    .forward(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
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
        processRequest(request, response);
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
