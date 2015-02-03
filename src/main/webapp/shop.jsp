<!DOCTYPE html>
<jsp:useBean id="shopDataBeanId" class="barra.Shop" scope="application" />
<jsp:setProperty name="shopDataBeanId" property="*" />
<% Integer stockA=shopDataBeanId.getQtyA();
   Integer stockB=shopDataBeanId.getQtyB(); %>
<html>
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootswatch/3.3.0/journal/bootstrap.min.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            Currently available in our shop:
        </div>
            <div class="col-xm-2">
                Item A : <%= stockA %> available<br>
                Item B : <%= stockB %> available
            </div>

            <div class="col-xm-2">
               <div class="page-header">
                          Your shopping
                       </div>
                <form method="post" action="shop">
                Quantity A: <input type="number" size="7" min="0" required="true" max=<%= shopDataBeanId.getQtyA() %> name=orderQtyA><br>
                Quantity B: <input type="number" size="7" min="0" required="true" max=<%= shopDataBeanId.getQtyB() %> name=orderQtyB><br>
                <br>
                <input type="submit" value="Place your order">
                <hr>
                </form>

</div>
</div>
</div>
</body>
</html>