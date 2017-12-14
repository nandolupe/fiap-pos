<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="funcionarioForm" action="FuncionarioServlet" >
<h2>Pesquisa de Funcionários</h2><br />
Nome: <input type="text" name="nome" id="nome" /><br />
<input type="submit" value="Pesquisar" />
<br />
Resultado Pesquisa:
<br />
<c:if test="${funcionarioList != null}" >
<c:forEach items="${funcionarioList}" var="funcionarioTO" >
Codigo: ${funcionarioTO.codFuncionario}
<br />
Nome: ${funcionarioTO.nome}
<br />
<br />
</c:forEach>
</c:if>

</form>
</body>
</html>