<jsp:useBean id="shopDataBeanId" class="barra.ShopData" scope="session" />
<jsp:setProperty name="shopDataBeanId" property="*" />

<form method=post action="Checkout.jsp">
Your name: <input type=text name=username size=20 ><br>
Email: <input type=text name=email size=20><br>
Age: <input type=text name=age size=20><br>
<input type=submit>
</form>

Used names: <%= shopDataBeanId.getUsedNames() %>