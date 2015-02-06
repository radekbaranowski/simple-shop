<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:html5="http://www.w3.org/1999/xhtml">
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootswatch/3.3.0/journal/bootstrap.min.css">
<title> [simple shop] checkout </title>
</head>

 <body>
 <html5:section>
        <div class="container">
            <div class="page-header">Order summary:</div>
            <div class="row">
                <div class="col-xm-2">

                <%= request.getAttribute("msg") %>
                <p>
                    <a href="/simple-shop/shop">back to the shop</a>
                </p>
                </div>
            </div>

        </div>
</html5:section>
</body>
</html>
