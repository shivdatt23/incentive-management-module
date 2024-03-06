<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    
</head>

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

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 8px;
}

input {
    padding: 8px;
    margin-bottom: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    background-color: #4caf50;
    color: #fff;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}


</style>


<body>
    <div class="container">
        <form action="userupdate_details" method="post">
            <h2>UPDATE EMPLOYEE DETAILS</h2>
            <label for="name">Username:</label>
            <input type="text" id="name" name="name" required value="${updatedEmployee.getName() }">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required value="${updatedEmployee.getEmail() }">

            <label for="totalSales">Total Sales</label>
            <input type="number" id=""totalSales" name="totalSales" required value="${updatedEmployee.getTotalSales() }">
            
            
           <input type="hidden" id="id" name="id" value="${updatedEmployee.getId() }" required>
    
            

            <button type="submit">Update</button>
            
        </form>
        
    </div>
 
</body>
</html>
