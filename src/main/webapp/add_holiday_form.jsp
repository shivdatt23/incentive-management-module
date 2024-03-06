<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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



</style>


</head>
<body>
		
	<div class="container">
        <form id="holiday-form" action="add_hp">
        	<h1>ADD HOLIDAY PACKAGE</h1>
            <label for="holidayName">Holiday Name:</label>
            <input type="text" id="holidayName" name="holidayName" required>

            <label for="duration">Duration (Nights):</label>
            <input type="number" id="duration" name="duration" required>

            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" required>

            <label for="location">Location:</label>
            <input type="text" id="location" name="location" required>

            <label for="amenities">Amenities:</label>
            <textarea id="amenities" rows="3" required name="amenities"></textarea>

            <button type="submit">Add Holiday Package</button>
        </form>
	</div>
</body>
</html>