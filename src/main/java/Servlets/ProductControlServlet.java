/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Bottom;
import Database.Cupcake;
import Database.Topping;
import JavaCode.LineItems;
import JavaCode.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ezl
 */
public class ProductControlServlet extends HttpServlet {

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
        ShoppingCart shoppingCart;
        
        if(session.getAttribute("ShoppingCart") == null)
        {
            shoppingCart = new ShoppingCart();
        }
        else 
        {
            shoppingCart = (ShoppingCart)session.getAttribute("ShoppingCart");
        }
        
        int bottomIndexInt = Integer.parseInt(request.getParameter("Bottom"));
        int toppingIndexInt = Integer.parseInt(request.getParameter("Topping"));
        List<Bottom> bottomList = (List<Bottom>)session.getAttribute("BottomList");
        List<Topping> toppingList = (List<Topping>)session.getAttribute("ToppingList");
        Cupcake cupcake = new Cupcake(bottomList.get(bottomIndexInt), toppingList.get(toppingIndexInt));
        LineItems lineItem = new LineItems(cupcake, Integer.parseInt(request.getParameter("qty")));
        shoppingCart.addLineItem(lineItem);
        session.setAttribute("ShoppingCart", shoppingCart);
        response.sendRedirect("shop.jsp");
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
