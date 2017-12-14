<%@ page import="br.com.fiap.persistencia.common.Chamado"%>

<html>
<head>
<title>Consulta de chamados</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<p><font color="#CC0000" size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>
  [Chamado encontrado]</strong></font></p>
<br />
<%
	Chamado chamado = (Chamado) request.getSession().getAttribute("chamado");
	if (chamado != null) {
		out.print("Descrição: " + chamado.getDescricao());
	}
	out.print("<br><br><input type=button value=Voltar onclick=\"history.back();\">");
%>
</body>
</html>
