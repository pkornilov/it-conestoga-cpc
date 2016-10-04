/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pkornilov
 */
public class ANPKAddBookServlet extends HttpServlet {


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
        doPost(request, response);
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
        String code=request.getParameter("code");
        String description=request.getParameter("description");
        String quantity=request.getParameter("quantity");
        Integer quantityInt=0;
        String errorMessage="";
        Boolean error=false;
        

        
        
        if (code=="") {
            errorMessage+="Book code is required." +"<br>";
            error=true;
        }
        if (description.length()<2) {
            errorMessage+="Description must have at least 2 characters."+"<br>";
            error=true;
        }
        if (quantity=="") {
            errorMessage+="Quantity must be a posistive number."+"<br>";
            error=true;
        }
        else{
            quantityInt=parseInt(quantity);
            if (quantityInt<1) {
            errorMessage+="Quantity must be a posistive number."+"<br>";
            error=true;
            }
        }

        if(error==false){
            Book book=new Book();
            book.setCode(code);
            book.setDescription(description);
            book.setQuantity(quantityInt);
            ServletContext context=getServletContext();
            String path=context.getRealPath("/WEB-INF/books.txt");
            BookIO.insert(book, path);
            ArrayList<Book> books=BookIO.getBooks(path);
            request.setAttribute("books", books);
            String url="/ANPKDisplayBooks.jsp";
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            
        }
        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("code", code);
        request.setAttribute("description", description);
        request.setAttribute("quantity", quantity);
                String url="/ANPKAddBook.jsp";
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
