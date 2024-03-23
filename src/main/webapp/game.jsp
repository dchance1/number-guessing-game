<%--
  Created by IntelliJ IDEA.
  User: darrenchance
  Date: 3/19/24
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number Guessing Game</title>
    <script type="text/javascript">
        function take_values() {
            const n = document.forms["myform"]["param1"].value;
            // Checking for errors, alert if not a number or blank
            if (n == null || n == "" || isNaN(n)) {
                alert("Please enter a number");
                return false;
            } else {
                // Posting (post) to server (java servlet)
                const http = new XMLHttpRequest();
                http.open("POST", "input-servlet", true);
                http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                const parameters = "param1=" + n;
                http.send(parameters);
                http.onload = function () {
                    // Creating text from page response
                    const node = document.createTextNode(http.responseText);
                    const paraElement = document.getElementById("resultPara");
                    // Adding text to resultPara html paragraph
                    paraElement.innerHTML = node.textContent;
                    document.getElementById("myForm").reset();

                }
            }


        }
    </script>
</head>

<body id="body1">
<div>
    <h1>Welcome to the number guessing game</h1>
    <h2>Rules:</h2>
    <ul>
        <li>Guess a number from 1 to 5</li>
    </ul>
</div>
<div>
    <form name="myform" id="myForm">
        <label>
            Enter a number: <input type="text" name="param1">
        </label>
        <input type="button" value="Submit" onclick="return take_values()">
    </form>
    <p id="resultPara"><%--- Display results of user guess ---%> </p>
</div>

</body>
</html>
