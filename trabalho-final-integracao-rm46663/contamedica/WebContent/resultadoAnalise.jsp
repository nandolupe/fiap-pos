<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de An�lise</title>
</head>
<body>
<form action="ContaMedica" >
<h1>Resultado de An�lise</h1>
<table>
	<tr>
		<td align="right" style="font-weight: bold;">Protocolo:</td>
		<td>${numProtocolo}</td>
	</tr>
	<tr>
		<td align="right" style="font-weight: bold;">Resultado da An�lise:</td>
		<td>${resultadoAnalise}</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/contamedica/">Voltar</a></td>
	</tr>
</table>
</form>
</body>
</html>