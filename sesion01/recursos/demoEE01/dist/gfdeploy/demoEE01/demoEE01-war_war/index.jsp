<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ingreso al sistema</title>
	</head>
	<body>
		<h1>Ingresa tus datos!</h1>
		<form action="validador">
			Usuario:<input name="txtUsuario"/><br/>
			Password: <input type="password" name="txtPassword"/><br/>
			<input type="submit" value="Ingresar"/>
		</form>
		
	</body>
</html>
