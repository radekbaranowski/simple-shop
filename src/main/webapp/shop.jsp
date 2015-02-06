<!DOCTYPE html>
<jsp:useBean id="shopDataBeanId" class="barra.ShopServlet" scope="application" />
<jsp:setProperty name="shopDataBeanId" property="*" />
<% Integer stockA=shopDataBeanId.getShop().getStockA();
   Integer stockB=shopDataBeanId.getShop().getStockB(); %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:html5="http://www.w3.org/1999/xhtml">
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootswatch/3.3.0/journal/bootstrap.min.css">

</head>
<body>
 <html5:section>
<div class="container">
    <div class="row">
        <div class="page-header">
            Currently available in our shop:
        </div>
    </div>
    <div class="row">
            <div class="col-md-6">
                <b>Goblins</b>:<br>
                <%= stockA %> available<br>

            </div>

            <div class="col-md-6">
                <b>Imps:</b><br>
                <%= stockB %> available
            </div>
    </div>
            <div class="col-md-6">
               <div class="page-header">
                          Your shopping
                       </div>
                <form method="post" action="shop">
                Order <input type="number" size="2" min="0" required="true" max=<%= stockA %> name="orderQtyA"> Goblins<br>
                Order <input type="number" size="2" min="0" required="true" max=<%= stockB %> name="orderQtyB"> Imps<br>
                <br><input type="submit" class="btn btn-default" value="Place your order">
                <hr>
                </form>


</div>
</div>
</div>


</html5:section>
</body>
</html>