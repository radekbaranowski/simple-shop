package barra;

public class Shop {

    int stockA;
    int stockB;

    public int getStockB() {
        return stockB;
    }

    public void setStockB(int stockB) {
        this.stockB = stockB;
    }

    public int getStockA() {
        return stockA;
    }

    public void setStockA(int stockA) {
        this.stockA = stockA;
    }

    public Shop(int newA, int newB){
        this.stockA = newA;
        this.stockB = newB;
        }

    public Shop(){
        this.stockA = 20;
        this.stockB = 10;
    }

    /* method to process order sent from the frontend*/
    public String processOrder(int orderQA, int orderQB){
        // temp order processing status result
        String statusMsg = "";

        /*if ordered amount of A or B is less or equal,
        confirm order, otherwise let user know ordered amount exceeds stock */

        if (orderQA <= this.stockA){
            this.stockA-=orderQA;
            statusMsg += "You have bought "+ orderQA + " Goblins<br>";
        }
        else {
            statusMsg+="Order of A exceeds current stock.<br>";
        }

        if (orderQB <= this.stockB){
            this.stockB-=orderQB;
            statusMsg += "You have bought "+ orderQB + " Imps<br>";
        }
        else {
            statusMsg+="Order of B exceeds current stock.<br>";
        }

        return statusMsg;


    }

}