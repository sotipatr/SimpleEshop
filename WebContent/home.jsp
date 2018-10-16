<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>

</head>
<body>
    <div class="productboxOne" style="width:230px; heigh:70px">
        <div class="producttitle"></div>
        <div class="productprice">
          <div class="pull-right">
            <button type="button" class="btn btn-success btn-sm" onclick="location.href='http://localhost:8080/DemoEshop/regOffer.jsp'" style="heigh:100px">
            <b>Register new Offer</b>
            </button>
          </div>
        </div>
    </div>
    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/ViewOffers">
		<div class="productboxOne" style="width:230px; heigh:70px">
		    <div class="producttitle"></div>
		    <div class="productprice">
		       <div class="pull-right">
		          <button type="submit" class="btn btn-success" style="heigh:100px">
		            <b>View all Offers</b>
		          </button>
		       </div>
		    </div>
		 </div>
	</form>
   
</body>
</html>   