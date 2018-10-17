<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
    import="my.demo.eshop.Offer"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Active Offers</title>

</head>
<body>

<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2><b>List of the Active Offers</h2></div>
                </div>
            </div>
            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/CancelOffer">
            <table class="table table-bordered" border="1"  align="center">
            	<thead>
            		<tr>
      					<th>Offer ID</th>
      					<th>Offer name</th>
      					<th>Description</th>
      					<th>Offer price</th>
    				</tr>
            	</thead>
                <tbody>
                <% 
                    ArrayList<Offer> list = (ArrayList<Offer>) request.getAttribute("offersList");
                	Iterator<Offer> offerIterator = list.iterator();
                	while (offerIterator.hasNext()) {
                		Offer curr = offerIterator.next();
                	
                %>
                    <tr>
                        <td width="25%"   align="center">
                            <label class="radio"><%out.print(curr.getOfferId()); %>
                                <input type="radio" checked="checked" name="clientIdName" value="<%out.print(curr.getOfferId());%>">
                                <span class="checkround"></span>
                            </label>
                        </td> 
                        <td width="25%"   align="center">
                            <label class="radio"><%out.print(curr.getName()); %>
                                <span class="checkround"></span>
                            </label>
                        </td>
                        <td width="30%"   align="center">
                            <label class="radio"><%out.print(curr.getDescription()); %>
                                <span class="checkround"></span>
                            </label>
                        </td>
                        <td width="25%"   align="center">
                            <label class="radio"><%out.print(curr.getPrice()); %>
                                <span class="checkround"></span>
                            </label>
                        </td> 
                    </tr> 
					
                    <%} %>
                  
                </tbody>
            </table>
            
            <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/DemoEshop/home.jsp'">Home</button>
            <button type="submit" class="btn btn-success">Cancel Offer</button>
			</form>
		</div>
    </div> 

</body>
</html>                            