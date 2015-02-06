package barra;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

import barra.*;

public class ShopServlet extends HttpServlet {


    private static Shop shop;

    public static Shop getShop() {
        return shop;
    }

    // initiate the shop
    public ShopServlet() {
        super();
        shop=new Shop();
    }



    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("processing GET");

        request.getRequestDispatcher("/shop.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // status message to return to customer
        String statusMsg;

        // some logging
        System.out.println("processing POST");
        System.out.println("stock A before " + shop.getStockA() + " | stock B before " + shop.getStockB());

        // grab form values, validation is made on client side however sending empty POST request
        // from outside of the browser would cause nasty exceptions
        if (StringUtils.isNumeric(request.getParameter("orderQtyA")) && StringUtils.isNumeric(request.getParameter("orderQtyB"))) {
            // grab order quantity values
            int orderQA = Integer.valueOf(request.getParameter("orderQtyA"));
            int orderQB = Integer.valueOf(request.getParameter("orderQtyB"));

            // process the order
            statusMsg = shop.processOrder(orderQA, orderQB);

        } else {
            statusMsg = "Invalid data supplied for either of the products";
            System.out.println(statusMsg);
        }

        // logging
        System.out.println("stock A after " +  shop.getStockA() + " | stock B after " + shop.getStockB() );
        // prepare to send the outcome of order processing
        request.setAttribute("msg",statusMsg);
        // redirect to checkout page
        request.getRequestDispatcher("/checkout.jsp").forward(request,response);
    }

}
