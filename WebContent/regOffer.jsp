<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Offer Details</title>
</head>
<body>

<div class="container">
    <div class="table-wrapper">
      <div class="row">
          <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterOffer">
            <fieldset>

              <legend>Demo E-shop</legend>
              <div class="panel panel-default">
                <div class="panel-body">
                    New Offer
                </div>
              </div>
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Name</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Name" class="form-control" name="name">
                </div>
              </div>
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Description</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Description" class="form-control" name="description">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Price</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Price" class="form-control" name="price">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Time of offer validity(in minutes)</label>
                <div class="col-sm-4">
                  <input type="text" placeholder="Time" class="form-control" name="time">
                </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="pull-right">
                    <button type="button" class="btn btn-default"  onclick="window.location.href='http://localhost:8080/DemoEshop/home.jsp'">Cancel</button>
                    <button type="submit" class="btn btn-success">Save</button>
                  </div>
                </div>
              </div>

            </fieldset>
          </form>
        </div>
    </div>
    </div>
</body>
</html>