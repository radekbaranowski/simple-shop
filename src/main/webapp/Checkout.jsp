<jsp:useBean id="shopDataBeanId" class="barra.ShopData" scope="session" />
<jsp:setProperty name="shopDataBeanId" property="*" />



hi! <%= shopDataBeanId.getUsername() %> <br>
your email <%= shopDataBeanId.getEmail() %> <br>
and your age is <%= shopDataBeanId.getAge() %> <br>
</p>
<p>
<a href="/simple-webapp/shop.jsp">back to the roots</a>
</p>
