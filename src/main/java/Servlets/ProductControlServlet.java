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
import Database.User;
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
 * Handles all requests from the shop.
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
        HttpSession session = request.getSession();
        DataMapper dataMapper = new DataMapper();
        if(request.getParameter("index") != null)
        {
            int index =  Integer.parseInt(request.getParameter("index"));
            ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("ShoppingCart");
            dataMapper.removeProduct(shoppingCart.getLineItem(index), (int)session.getAttribute("Invoice_id"));
            shoppingCart.removeLineItem(index);
            session.setAttribute("ShoppingCart", shoppingCart);
            response.sendRedirect("shop.jsp");
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
        processRequest(request, response);

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart;
        DataMapper dataMapper = new DataMapper();
        User user = (User)session.getAttribute("user");
        if (session.getAttribute("ShoppingCart") == null) {
            shoppingCart = new ShoppingCart();
        } else {
            shoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
        }
        
        
        switch (request.getParameter("submit")) {
            case "Checkout":
                if(user.getBalance() < shoppingCart.getTotalPrice() || shoppingCart.getTotalPrice() <= 0){
                    dataMapper.deleteInvoicedProducts((int)session.getAttribute("Invoice_id"));
                    shoppingCart.emptyCart();
                    session.removeAttribute("ShoppingCart");
                    session.setAttribute("ShoppingCart", shoppingCart);
                    response.sendRedirect("shop.jsp");
                }else {
                int checkOutInvoice = (int)session.getAttribute("Invoice_id");
                dataMapper.makePurchase(user, shoppingCart.getTotalPrice());
                shoppingCart.emptyCart();
                    session.removeAttribute("ShoppingCart");
                    session.setAttribute("ShoppingCart", shoppingCart);
                session.removeAttribute("Invoice_id");
                session.setAttribute("Invoice_id", dataMapper.checkInvoice(dataMapper.getUser(user.getUsername())));
                response.sendRedirect("confirmation.jsp?checkOutInvoice="+checkOutInvoice);
                }
                break;
                
            case "Add Cupcake":
                
                int Invoice_id = (int)session.getAttribute("Invoice_id");
                int bottomIndexInt = Integer.parseInt(request.getParameter("Bottom"));
                int toppingIndexInt = Integer.parseInt(request.getParameter("Topping"));
                List<Bottom> bottomList = (List<Bottom>) session.getAttribute("BottomList");
                List<Topping> toppingList = (List<Topping>) session.getAttribute("ToppingList");
                Cupcake cupcake = new Cupcake(bottomList.get(bottomIndexInt), toppingList.get(toppingIndexInt));
                LineItems lineItem = new LineItems(cupcake, Integer.parseInt(request.getParameter("qty")));
                shoppingCart.addLineItem(lineItem);
                session.setAttribute("ShoppingCart", shoppingCart);
                dataMapper.addProduct(lineItem, Invoice_id);
                
                
                
                
                response.sendRedirect("shop.jsp");
                break;
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
