<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 id="hola">HolaMundo</h1>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script>
	
		$.ajax({
	        type: 'POST',
	        url: './AuthServlet?accion=singnIn',
	        dataType: "json",
	        data: {
	            json: JSON.stringify({})
	        }, success: function (data, textStatus, jqXHR) {
	            resolve(data)
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            reject('Error en la petición')
	        }
	    });
	
	</script>
</body>
</html>