<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerar Relat�rio</title>
</head>
<body>

	<form action="RelatorioServlet" method="post">
		<input type="hidden" name="acao" value="gerarRelatorio">
		<input type="submit" value="Gerar Relat�rio">
	</form>

	<br/>

	<form action="RelatorioServlet" method="post">
		<input type="hidden" name="acao" value="imprimirRelatorios">
		<input type="submit" value="Imprimir Relat�rios">
	</form>


</body>
</html>