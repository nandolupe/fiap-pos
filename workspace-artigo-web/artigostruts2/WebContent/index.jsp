<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cadastrar Clientes</title>
<script>
	function remover(idCliente) {
		document.all('cliente.idCliente').value = idCliente;
		document.clienteForm.action = "removercliente";
		document.submit();
	}
</script>

</head>

<body>
	<s:form action="inserircliente" id="clienteForm" method="post" name="clienteForm">
		<s:textfield type="hidden" name="cliente.idCliente" />
		<s:textfield name="cliente.nameCliente" label="Nome" size="20" />
		<s:textfield name="cliente.sobrenome" label="Sobrenome" size="20" />
		<s:textfield name="cliente.dtNasc" label="Data Nascimento" size="20" />
		<s:submit name="submit" label="Cadastrar" align="center" value="Cadastrar" />
		<h1>Cadastrar Clientes</h1>
		<br />
		<table style="width: 700px;">
			<tr>
				<td>ID</td>
				<td>Nome</td>
				<td>Sobrenome</td>
				<td>Data Nascimento</td>
				<td>Remover</td>
			</tr>
			<s:iterator value="#session.clienteList" var="bean">
				<tr>
					<td>${bean.idCliente}</td>
					<td>${bean.nameCliente}</td>
					<td>${bean.sobrenome}</td>
					<td>${bean.dtNasc}</td>
					<td><a href="javascript:remover('${bean.idCliente}')">X</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
</body>
</html>