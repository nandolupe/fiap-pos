<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Contas</title>
</head>
<body>
<form action="ContaMedica" method="post">
<h1>Cadastro de Contas Médicas</h1>
<table>
	<tr>
		<td align="right">Prestador:</td>
		<td><input type="text" name="dscPrestador" id="dscPrestador"/></td>
	</tr>
	<tr>
		<td align="right">E-mail:</td>
		<td><input type="text" name="emailPrestador" id="emailPrestador"/></td>
	</tr>
	<tr>
		<td align="right">Descrição da Conta:</td>
		<td><input type="text" name="descricaoContaMedica" id="descricaoContaMedica"/></td>
	</tr>
	<tr>
		<td align="right">Tipo:</td>
		<td>
			<select id="tipoConta" name="tipoConta" style="width: 145px;" >
				<option value="">Selecione</option>
				<option value="M">Mat/Med</option>
				<option value="P">Procedimento</option>
			</select>
		</td>
	</tr>
	<tr>
		<td align="right">Valor Informado:</td>
		<td><input type="text" name="valorInformado" id="valorInformado"/></td>
	</tr>
	<tr>
		<td align="right">Valor Acatado:</td>
		<td><input type="text" name="valorAcatado" id="valorAcatado"/></td>
	</tr>
	<tr>
		<td align="right" colspan="2"><input type="submit" value="Enviar" /></td>
	</tr>
</table>
</form>
</body>
</html>