/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
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
public class ANPKClearCartServlet extends HttpServlet {

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
        
        ServletContext context=getServletContext();
        HttpSession session=request.getSession();
        
        ECart cart=(ECart)session.getAttribute("cart");
        
        String action=request.getParameter("action");
        String code = request.getParameter("code");
        String description=request.getParameter("description");
        
        ArrayList<Book> cartItems = new ArrayList<Book>();
        ArrayList<Book> newCartItems=new ArrayList<Book>();
        
        cartItems=(ArrayList<Book>)context.getAttribute("loanItems");
        
        if (action.equals("clear")) {
            for (Book cartItem: cart.getItems()) {
                newCartItems.add(cartItem);
            }
            for (Book cartItem: newCartItems) {
                cart.removeItem(cartItem);
                ELoan.addToQOH(cartItems, cartItem.getCode(), cartItem.getQuantity());
            }
        }
        
        session.setAttribute("cart", cart);
        context.setAttribute("loanItems", cartItems);
        
        context.getRequestDispatcher("/ANPKECart.jsp")
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
