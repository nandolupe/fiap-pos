<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes</title>
<script>
function cadastrar() {
	document.clienteForm.action = "clienteinserir.do";
	document.clienteForm.submit();
}

function remover(idCliente) {
	document.clienteForm.idCliente.value = idCliente;
	document.clienteForm.action = "clienteremover.do";
	document.clienteForm.submit();
}
</script>
</head>
<body>
	<html:form action="cliente.do" >
		<html:hidden property="idCliente" />
		<h1>Cadastro de Clientes</h1><br />
		<table>
			<tr>
				<td>Nome:</td>
				<td><html:text property="nameCliente" /></td>
			</tr>
		 	<tr>
				<td>Sobrenome:</td>
				<td><html:text property="sobrenome" /></td>
			</tr>
			<tr>
				<td>Data Nasc:</td>
				<td><html:text property="dtNasc" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Cadastrar" onclick="cadastrar()" /></td>
			</tr>
		</table>
		<br />
		<c:choose>
			<c:when test="${clienteList != null}">
				<table style="width: 700px;">
					<tr>
						<td>ID</td>
						<td>Nome</td>
						<td>Sobrenome</td>
						<td>Data Nascimento</td>
						<td>Remover</td>
					</tr>
					<c:forEach items="${clienteList}" var="cliente">
						<tr>
							<td>${cliente.idCliente}</td>
							<td>${cliente.nameCliente}</td>
							<td>${cliente.sobrenome}</td>
							<td><fmt:formatDate value="${cliente.dtNasc}" pattern="dd/MM/yyyy" /></td>
							<td><a href="javascript:remover(${cliente.idCliente})" >X</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise> 
				N�o h� clientes registrados!
			</c:otherwise>
		</c:choose>
	</html:form>
</body>
</html>