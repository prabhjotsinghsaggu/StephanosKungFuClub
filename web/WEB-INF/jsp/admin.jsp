<%-- 
    Document   : myhome
    Created on : Apr 7, 2017, 10:15:22 PM
    Author     : chonzom_rapgay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Admin Login </title>
  
  
  <link rel='stylesheet prefetch' href='https://www.google.com/fonts#UsePlace:use/Collection:Roboto:400,300,100,500'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://www.google.com/fonts#UsePlace:use/Collection:Roboto+Slab:400,700,300,100'>

      <link rel="stylesheet" href="css/mylog.css">

  
</head>

<body>
  <div id="successful_login" class="fix-middle">
  <div class="container text-center">
    <h1>Welcome !!!</h1>
  </div>
</div>
<div id="successful_registration" class="fix-middle">
  <div class="container text-center">
   </div>
</div>

<div id="dialog" class="dialog dialog-effect-in">
  <div class="dialog-front">
    <div class="dialog-content">
      <form id="login_form" class="dialog-form" action="myhome.com" >
        <fieldset>
          <legend>Log in</legend>
          <div class="form-group">
            <label for="user_username" class="control-label">Username:</label>
            <input type="text" id="user_username" class="form-control" name="name" autofocus/>
          </div>
          <div class="form-group">
            <label for="user_password" class="control-label">Password:</label>
            <input type="password" id="user_password" class="form-control" name="password"/>
          </div>
          
          <div class="pad-top-20 pad-btm-20">
            <input type="submit" class="btn btn-default btn-block btn-lg" value="Continue">
          </div>
          <!--<div class="text-center">-->
            <!--<p>Do you wish to register<br> for <a href="#" class="link user-actions"><strong>a new account</strong></a>?</p>-->
          <!--</div>-->
        </fieldset>
      </form>
    </div>
  </div>
</div>
  </body>
</html>
