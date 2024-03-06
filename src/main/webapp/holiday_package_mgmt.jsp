<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Holiday Package Management</title>
   
    
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

.container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form, table {
    margin-top: 20px;
}

label {
    display: block;
    margin-bottom: 8px;
}

input, textarea {
    width: 100%;
    padding: 8px;
    margin-bottom: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    background-color: #3498db;
    color: #fff;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #2980b9;
}

#holiday-table {
    border-collapse: collapse;
    width: 100%;
}

#holiday-table th, #holiday-table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

#holiday-table th {
    background-color: #3498db;
    color: #fff;
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
    
    
    
    </style>
    
    
    
    
    
</head>
<body>
    <div class="container">
        <h2>Holiday Package Management</h2>

        <table id="holiday-table">
            <thead>
                <tr>
                    <th>Holiday Name</th>
                    <th>Duration (Nights)</th>
                    <th>Destination</th>
                    <th>Location</th>
                    <th>Amenities</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Table rows will be dynamically added using JavaScript -->
                <c:forEach var="i" items="${list}">
              
           <tr>
            
            
            <td>${i.getHolidayName()}</td>
            <td>${i.getDuration()}</td>
            <td>${i.getDestination()}</td>
            <td>${i.getLocation()}</td>
            <td>${i.getAmenities()}</td>
            <td>
            <form>
           
			
            
          
            <button type="submit" class="updatebtn" onClick="form.action='#'">UPDATE</button>
            <button type="submit" class="deletebtn" onClick="form.action='#'">DELETE</button>
            
            </form>
            
                
            </tr>  
            
                </c:forEach>
                
                
           <tr>
           <td>
           <form>
           <button type="submit" class="addbtn" onClick="form.action='addholiday'">ADD</button>
           </form>
           </td>
           </tr>
            </tbody>
        </table>
    </div>

   
</body>
</html>
