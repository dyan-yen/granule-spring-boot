<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://granule.com/tags" prefix="g" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>
    <g:compress>
        <link rel="stylesheet" href="/assets/stylesheets/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/stylesheets/normalize.min.css">
    </g:compress>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h3>${message}</h3>
    <p>
        We use <a href="https://code.google.com/p/granule/">Granule</a> here in a
        <a href="http://projects.spring.io/spring-boot/">Spring Boot</a> project.
    </p>
    <p>My CSS and JavaScript files were combined to a single file respectively.</p>
</div>
</body>
<g:compress>
    <script src="/assets/javascripts/vendor/jquery-1.12.0.js"></script>
    <script src="/assets/javascripts/vendor/bootstrap.js"></script>
    <script src="/assets/javascripts/application.js"></script>
</g:compress>
</html>
