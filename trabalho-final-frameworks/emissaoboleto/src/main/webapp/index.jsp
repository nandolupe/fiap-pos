<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emissão de Boleto de Aluguéis</title>
<style>
#resultado tbody td {
	border-bottom: 1px solid black;
}

#resultado {
	width: 600px;
}
</style>
<script>
	function gerarRelatorio() {
		document.BoletoForm.action = "EmitirRelatorioCompletoServlet";
		document.BoletoForm.submit();
	}

	function salvar() {
		if (document.getElementById("nomeCliente").value != "" 
				&& document.getElementById("valorDocumento").value != ""  
				&& document.getElementById("descricaoDetalhe").value != "") {
			document.BoletoForm.action = "AdicionarBoletoServlet";
			document.BoletoForm.submit();
		} else {
			alert("Todos os campos são obrigatórios, favor preenchê-los!");
		}
	}

	function moeda(z) {
		v = z.value;
		v = v.replace(/\D/g, "") // permite digitar apenas numero 
		v = v.replace(/(\d{1})(\d{1,2})$/, "$1.$2") // coloca virgula antes dos ultimos 2 digitos 
		z.value = v;
	}
</script>
</head>
<body>
	<form action="AdicionarBoleto" method="POST" name="BoletoForm">
		<h1>Emissão de Boleto de Aluguéis</h1>
		<table>
			<tr>
				<td align="right">Cliente:</td>
				<td><input name="nomeCliente" id="nomeCliente" style="width: 300px;" maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right">Valor Cobrado:</td>
				<td><input name="valorDocumento" id="valorDocumento" onkeyup="moeda(this);" maxlength="10" /></td>
			</tr>
			<tr>
				<td align="right">Descrição:</td>
				<td><textarea id="descricaoDetalhe" name="descricaoDetalhe" style="width: 300px;" rows="3"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="Salvar" onclick="salvar()" />
				</td>
			</tr>
		</table>
	</form>
	<h1>Boletos</h1>
	<table id="resultado">
		<thead>
			<tr>
				<td>Nome Pessoa</td>
				<td>Valor Documento</td>
				<td>Detalhe</td>
				<td></td>
			</tr>
		</thead>
		<c:if test="${lista eq null}">
			<tr>
				<td colspan="4">Não há boletos inseridos</td>
			</tr>
		</c:if>
		<c:if test="${lista ne null}">
			<c:forEach items="${lista}" var="boleto">
				<tr>
					<td>${boleto.nomeCliente}</td>
					<td>${boleto.valorDocumento}</td>
					<td>${boleto.descricaoDetalhe}</td>
					<td>
						<a href="EmitirBoletoServlet?nome=${boleto.nomeCliente}&valor=${boleto.valorDocumento}&descricao=${boleto.descricaoDetalhe}">Emitir Boleto</a>
					</td>
				</tr>
			</c:forEach>
			<tfoot>
				<tr>
					<td colspan="4" align="right"><input type="button"
						value="Gerar Relatório" onclick="gerarRelatorio()" /></td>
				</tr>
			</tfoot>
		</c:if>
	</table>
</body>
</html>