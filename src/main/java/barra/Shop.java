package barra;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String;

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

        if (orderQA <= Shop.qtyA){
            Shop.qtyA-=orderQA;
            statusMsg += "You have bought "+ orderQA + " of A<br>";
        }
        else {
            statusMsg+="Order of A exceeds current stock.<br>";
        }

        if (orderQB <= Shop.qtyB){
            Shop.qtyB-=orderQB;
            statusMsg += "You have bought "+ orderQB + " of B<br>";
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
        // some logging
        System.out.println("processing POST");
        System.out.println("stock A before " + Shop.qtyA + " | stock B before " + Shop.qtyB );
        // grab form values
        int orderQA = Integer.valueOf(request.getParameter("orderQtyA"));
        int orderQB = Integer.valueOf(request.getParameter("orderQtyB"));
        // process the order
        statusMsg = processOrder(orderQA,orderQB);
        // logging
        System.out.println("stock A after " + Shop.qtyA + " | stock B after " + Shop.qtyB );
        // prepare to send the outcome of order processing
        request.setAttribute("msg",statusMsg);
        // redirect to checkout page
        request.getRequestDispatcher("/checkout.jsp").forward(request,response);
    }

}
