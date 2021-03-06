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
            <table class="table table-bordered" border="1">
            	<thead>
            		<tr>
            			<th>Selection</th>
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
                    	<td width="10%"  align="center">
                            <input type="radio" checked="checked" name="offerId" value="<%out.print(curr.getOfferId());%>">
                        </td>
                        <td width="25%"  align="center">
                            <label><%out.print(curr.getOfferId()); %>
                            </label>
                        </td> 
                        <td width="25%"  align="center">
                            <label><%out.print(curr.getName()); %>
                            </label>
                        </td>
                        <td width="30%"  align="center">
                            <label><%out.print(curr.getDescription()); %>
                            </label>
                        </td>
                        <td width="25%"  align="center">
                            <label><%out.print(curr.getPrice()); %>
                            </label>
                        </td> 
                    </tr> 
					
                    <%} %>
                  
                </tbody>
            </table>
            
            <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/DemoEshop/home.jsp'">OK</button>
            <button type="submit" class="btn btn-success">Cancel the selected Offer</button>
			</form>
		</div>
    </div> 

</body>
</html>                            