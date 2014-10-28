<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Hello AWS Web World!</title>
    <link rel="stylesheet" href="styles/styles.css" type="text/css" media="screen">
</head>
<body>
    <div id="content" class="container">
        <div class="section grid grid5 s3">
            <h2>About Us:</h2>
            <ul>
            	<li>one</li>
            </ul>
        </div>

        <div class="section grid grid5 sdb">
            <h2>Services:</h2>
            <ul>
				<li>two</li>
            </ul>
        </div>

        <div class="section grid grid5 gridlast ec2">
            <h2>Sign in:</h2>
            <form method = "post" action = "UserLogin()">
            	<input type = "text" name = "username" id = "username" placeholder = "User Name"/>
            	<br/>
            	<input type = "password" name = "password" id = "password" placeholder = "Password"/>
            	<br/>
            	<input type = "submit" name = "submit" id = "submit" value = "Sign In"/>
            </form>
        </div>
    </div>
</body>
</html>