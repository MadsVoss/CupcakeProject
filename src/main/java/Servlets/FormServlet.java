/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Bottom;
import Database.Cupcake;
import Database.DataMapper;
import Database.Topping;
import JavaCode.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mads Voss
 * Handles all the form requests.
 */
public class FormServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        switch (request.getParameter("submit")) {
            case "Login":
                Validate validate = new Validate();
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (validate.ValidateLogin(username, password)) {
                    DataMapper dataMapper = new DataMapper();
                    
                    session.setAttribute("user", dataMapper.getUser(username));
                    session.setAttribute("BottomList", dataMapper.getBottoms());
                    session.setAttribute("ToppingList", dataMapper.getToppings());
                    session.setAttribute("Invoice_id", dataMapper.checkInvoice(dataMapper.getUser(username)));
                    session.setAttribute("ShoppingCart", dataMapper.fillShoppingCart(dataMapper.checkInvoice(dataMapper.getUser(username))));
                    response.sendRedirect("shop.jsp");
                } else {
                    response.sendRedirect("login.jsp");
                }
                break;
                
            case "Register":
                DataMapper dataMapper = new DataMapper();
                username = request.getParameter("username");
                password = request.getParameter("password");
                String email = request.getParameter("email");
                if(dataMapper.getUser(username) == null){
                dataMapper.addUser(username, password, email);
                response.sendRedirect("login.jsp");
                } else {
                response.sendRedirect("registration.jsp");
                }
                break;
                
            /*case "Add Cupcake":
                List<Cupcake> cupcakeCart;
                if(session.getAttribute("CupcakeCart") == null)
                {
                    cupcakeCart = new ArrayList<>();
                }
                else 
                {
                    cupcakeCart = (List<Cupcake>)session.getAttribute("CupcakeCart");
                }
                int bottomIndexInt = Integer.parseInt(request.getParameter("Bottom"));
                int toppingIndexInt = Integer.parseInt(request.getParameter("Topping"));
                List<Bottom> bottomList = (List<Bottom>)session.getAttribute("BottomList");
                List<Topping> toppingList = (List<Topping>)session.getAttribute("ToppingList");
                Cupcake cupcake = new Cupcake(bottomList.get(bottomIndexInt), toppingList.get(toppingIndexInt), Integer.parseInt(request.getParameter("qty")));
                cupcakeCart.add(cupcake);
                session.setAttribute("CupcakeCart", cupcakeCart);
                response.sendRedirect("shop.jsp");
                break;*/
                
            default:
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
