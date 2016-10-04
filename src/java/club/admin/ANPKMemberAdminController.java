/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package club.admin;

import club.business.Book;
import static club.business.ELoan.findItem;
import static club.business.ELoan.subtractFromQOH;
import club.business.Member;
import club.data.BookIO;
import static club.data.MemberDB.emailExists;
import static club.data.MemberDB.insert;
import static club.data.MemberDB.selectMember;
import static club.data.MemberDB.selectMembers;
import static club.data.MemberDB.update;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
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
public class ANPKMemberAdminController extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        String action = request.getParameter("action");
        
        ArrayList<String> programs=new ArrayList<String>();
        programs.add("CPA");
        programs.add("CP");
        programs.add("ITID");
        programs.add("CAD");
        programs.add("ITSS");
        programs.add("Others");
        session.setAttribute("programs", programs);
        
        ArrayList<Integer> years=new ArrayList<Integer>();
        years.add(1);
        years.add(2);
        years.add(3);
        years.add(4);
        
        session.setAttribute("years", years);
        
        if (action == null) {
            action = "displayMembers";
        }
        
        String code=request.getParameter("code");
        
        if (action.equals("displayMembers")) {
            ArrayList<Member> members =  selectMembers();
            request.setAttribute("members", members);
        
            String url="/ANPKDisplayMembers.jsp";
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
                
            response.setContentType("text/html;charset=UTF-8");
        } else if (action.equals("addMember")) {
            String url="/ANPKMember.jsp";
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
                
            response.setContentType("text/html;charset=UTF-8");
        }
         else if (action.equals("displayMember")) {
           String email=request.getParameter("email");
            Member member=selectMember(email);

            request.setAttribute("fullName", member.getFullName());
            request.setAttribute("email", member.getEmailAddress());
            request.setAttribute("phone", member.getPhoneNumber());
            request.setAttribute("program", member.getProgramName());
            request.setAttribute("year", member.getYearLevel());

           String url = "/ANPKMember.jsp";
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
        
        //fullName, email, phone, program, year
        String action = request.getParameter("action");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String program = request.getParameter("program");
        Integer year = parseInt(request.getParameter("year"));
        String errorMessage="";
        Boolean error=false;
        
        
        if (fullName == "") {
            errorMessage+="Full name is required."+"<br/>";
            error = true;
        }
        if (email == "") {
            errorMessage+="Email is required."+"<br/>";
            error=true;
        }
        if (phone == "") {
            errorMessage+="Phone is required."+"<br/>";
            error=true;
        }
        
        if (error == false){
            
            Member member = new Member();
                member.setFullName(fullName);
                member.setEmailAddress(email);
                member.setPhoneNumber(phone);
                member.setProgramName(program);
                member.setYearLevel(year);
            
            if (member.isValid()) {
                if (emailExists(email)) {
                    update(member);
                } else {
                    insert(member);
                }
                 processRequest(request, response);
                String url="/ANPKMemberAdmin?action=displayMembers";
                getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
            }
        }
        
        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("fullName", fullName);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("program", program);
        request.setAttribute("year", year);
        
        String url = "/ANPKMember.jsp";
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
