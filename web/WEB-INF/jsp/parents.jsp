<%-- 
    Document   : parents
    Created on : Apr 8, 2017, 10:16:22 PM
    Author     : chonzom_rapgay
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  
<title>STEPHANOS KUNGFU CLUB</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}


</style>

<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <span class="w3-bar-item w3-right">Logo</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="/w3images/avatar2.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>Chonzom</strong></span><br>
<!--      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>-->
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="viewStudents.com" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-users fa-fw"></i> STUDENT</a>
    <a href="attendance.com" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> ATTENDANCE</a>
    <a href="fees.com" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i> FEES</a>
    <a href="parents.com" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullseye fa-fw"></i> PARENTS</a>
    <a href="rank.com" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i> RANK</a>
    <a href="add_stu.com" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i> ADD STUDENT</a> </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <!--<h5><b><i class="fa fa-dashboard"></i> My Dashboard</b></h5>-->
  </header>


  <div class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      
      <div class="w3-twothird">
        <h5>PARENTS</h5>
        <!--<form action="editStudent.com">-->
        <table>
            <thead><th>Parent Id</th>
            <th>Student Number</th>
            <th>Student Name</th>
            <th>Parent Email</th>
            <th>Parent Address</th>
                            </thead>
        
    <tbody>
     <%--<c:set var="tot" value="0"></c:set>--%>
    <c:forEach items="${ob}" var="ob">   
        
                       
                    <tr>
                        <td>${ob.parent_id}</td>
                       <td>${ob.student.stu_num}</td>
                       <td>${ob.student.stu_name}</td>
                    
                    
                        <td>${ob.email}</td>
                    
                        <td>${ob.address}</td>
                        
                                                                           
                                
                        						
                        
 
       </c:forEach>     
                       
     
    </tbody>
    
          
        </table>
        <!--<a href="add_parents.com">Add parents</a>-->
      </div>
    </div>
  </div>

               <footer class="w3-container w3-padding-16 w3-light-grey">
    </footer>

  <!-- End page content -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}
</script>

</body>
</html>
