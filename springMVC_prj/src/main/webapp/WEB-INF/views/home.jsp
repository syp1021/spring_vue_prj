<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. 가나</P>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<div id="app">{{message}}</div>
<script>
	var app = new Vue({
	  el: '#app',
	  data: {
	    message: '안녕하세요 Vue!'
	  }
	})
</script>
</body>
</html>
