<%-- 
    Document   : header
    Created on : May 23, 2019, 4:45:19 PM
    Author     : Mnzit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM</title>
        <link rel="stylesheet" href="${SITE_URL}/static/css/style.css"/>
        <link rel="stylesheet" href="${SITE_URL}/webjars/bootstrap/4.3.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${SITE_URL}/webjars/datatables/1.10.19/media/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="${SITE_URL}/webjars/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${SITE_URL}/webjars/toastr/2.1.3/toastr.min.css">
        <script src="${SITE_URL}/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
        <script src="${SITE_URL}/webjars/datatables/1.10.19/media/js/jquery.dataTables.min.js"></script>
        <script src="${SITE_URL}/webjars/bootstrap/4.3.1/dist/js/bootstrap.min.js"></script>
        <script src="${SITE_URL}/webjars/toastr/2.1.3/toastr.min.js"></script>
        <script src="${SITE_URL}/static/js/app.js"></script>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container">