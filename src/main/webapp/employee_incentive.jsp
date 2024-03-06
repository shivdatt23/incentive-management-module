<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.org.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
   
    
    
    <style>
    body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f4f4f4;
}

#employee-table {
    border-collapse: collapse;
    width: 80%;
    margin-top: 20px;
}

#employee-table th, #employee-table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

#employee-table th {
    background-color: #3498db;
    color: #fff;
}




label {
    margin-bottom: 8px;
}


button {
    background-color: #3498db;
    color: #fff;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin: 1px;
}
.updatebtn{
    background-color: #f5e60e;
}
.deletebtn{
    background-color: #ea1c09;
}
.sendemailbtn{
    background-color: #0958ea;
}

.addbtn{
background-color: #2980b9;
}

button:hover {
    background-color: #2980b9;
}

 
    
    </style>
    
    
    
</head>
<body> 



    <table id="employee-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Total Sales</th>
                <th>Incentive Percentage</th>
                <th>Bonus</th>
                <th>Holiday Package Eligibility</th>
                <th>ACTION</th>
            </tr>
        </thead>
        <tbody>
        
             <c:forEach var="i" items="${list}">
              
           <tr>
            
            <td>${i.getId()}</td>
            <td>${i.getName()}</td>
            <td>${i.getEmail()}</td>
            <td>${i.getTotalSales()}</td>
            <td>${i.getIncentivePercentage()}</td>
            <td>${i.getBonus()}</td>
            <td>${i.getHpe()}</td>
            <td>
            <form>
            <input type="hidden" value="${i.getId()}" name="id">
			<input type="hidden" value="${i.getEmail()}" name="email">
            
          
            <button type="submit" class="updatebtn" onClick="form.action='userupdate'">UPDATE</button>
            <button type="submit" class="deletebtn" onClick="form.action='userdelete'">DELETE</button>
            <button type="submit" class="sendemailbtn" onClick="form.action='sendemail'">SEND EMAIL</button></td>
            </form>
            <!-- ?id=${i.getId()} -->
                
            </tr>  
            
                </c:forEach>
                
                
           <tr>
           <td>
           <form>
           <button type="submit" class="addbtn" onClick="form.action='useradd'">ADD</button>
           </form>
           </td>
           </tr>
        </tbody>
        
    </table>
    
   

</body>
</html>
