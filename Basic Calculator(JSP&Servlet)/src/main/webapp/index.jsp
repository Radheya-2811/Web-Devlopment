<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basic calci</title>
</head>
<style>
    .heading{
        text-align: center;
    }
    body{
        background-color: azure;
    }
    .inp form{
        display: flex;
        gap: 2rem;
        width: 50%;
        margin-left: 25%;
    }
   input{
    width: 300px; 
    height: 20px; 
    font-size: 16px;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #ccc;
   }
   .answer{
    text-align: center;
   }
</style>
<body>
    <div class="bd">
        <h1 class="heading">
            Basic calculator
        </h1>
        
    </div>
    <div class="inp">
        <form action="MyServlet">
            <input type="number" placeholder="Enter the number" name="num1">
            <button name="bt1" value="1">+</button>
            <button name="bt1" value="2">-</button>
            <button name="bt1" value="3">*</button>
            <button name="bt1" value="4">/</button>
            <input type="number" placeholder="Enter the number" name="num2">
        </form>
    </div>
    <div class="answer">
        <h2>Answer=<%=request.getParameter("answer") %></h2>
    </div>
</body>
</html>