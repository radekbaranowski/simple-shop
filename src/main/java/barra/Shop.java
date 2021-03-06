package barra;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

import barra.ShopItem;

public class Shop extends HttpServlet {

    // static fields to hold current stock
    private static int qtyA;
    private static int qtyB;


    public static int getQtyA() {
        return qtyA;
    }

    public static int getQtyB() {
        return qtyB;
    }

    public static void setQtyB(int qtyB) {
        Shop.qtyB = qtyB;
    }

    public static void setQtyA(int qtyA) {
        Shop.qtyA = qtyA;
    }

    // initiate the shop
    public Shop() {
        super();
        qtyA=20;
        qtyB=10;
    }

    /* method to process order sent from the frontend*/
    private String processOrder(int orderQA, int orderQB){
        // temp order processing status result
        String statusMsg = "";

        /*if ordered amount of A or B is less or equal,
        confirm order, otherwise let user know ordered amount exceeds stock */

        if (orderQA <= this.qtyA){
            this.qtyA-=orderQA;
            statusMsg += "You have bought "+ orderQA + " Goblins<br>";
        }
        else {
            statusMsg+="Order of A exceeds current stock.<br>";
        }

        if (orderQB <= this.qtyB){
            this.qtyB-=orderQB;
            statusMsg += "You have bought "+ orderQB + " Imps<br>";
        }
        else {
            statusMsg+="Order of B exceeds current stock.<br> ";
        }

        return statusMsg;


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
        System.out.println("stock A before " + this.qtyA + " | stock B before " + this.qtyB );

        // grab form values, validation is made on client side however sending empty POST request
        // from outside of the browser would cause nasty exceptions
        if (StringUtils.isNumeric(request.getParameter("orderQtyA")) && StringUtils.isNumeric(request.getParameter("orderQtyB"))) {
            // grab order quantity values
            int orderQA = Integer.valueOf(request.getParameter("orderQtyA"));
            int orderQB = Integer.valueOf(request.getParameter("orderQtyB"));
            // process the order
            statusMsg = processOrder(orderQA, orderQB);
        } else {
            statusMsg = "Invalid data supplied for either of the products";
            System.out.println(statusMsg);
        }
        // logging
        System.out.println("stock A after " + this.qtyA + " | stock B after " + this.qtyB );
        // prepare to send the outcome of order processing
        request.setAttribute("msg",statusMsg);
        // redirect to checkout page
        request.getRequestDispatcher("/checkout.jsp").forward(request,response);
    }

}
