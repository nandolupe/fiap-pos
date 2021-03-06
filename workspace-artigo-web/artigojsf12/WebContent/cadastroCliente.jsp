<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h:form>
		<h1>Cadastro de Clientes</h1>
		<table>
			<tr>
				<td>Nome: </td>
				<td><h:inputText value="#{clienteMB.cliente.nameCliente}" /></td>
			</tr>
			<tr>
				<td>SobreNome: </td>
				<td> <h:inputText value="#{clienteMB.cliente.sobrenome}" /></td>
			</tr>
			<tr>
				<td>Data Nascimento:</td>
				<td><h:inputText value="#{clienteMB.dtNasc}" /></td>
			</tr>
		</table><br />
		<h:commandButton value="Cadastrar" action="#{clienteMB.inserirCliente}" /><br />
		<h:dataTable value="#{clienteMB.clienteList}" var="bean" style="width:700px;" >
			<h:column id="ID" >
				<f:facet name="header" >
					<h:outputText value="ID" />
				</f:facet>
				<h:outputText value="#{bean.idCliente}" />
			</h:column>
			<h:column>
				<f:facet name="header" >
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{bean.nameCliente}" />
			</h:column>
			<h:column>
				<f:facet name="header" >
					<h:outputText value="Sobrenome" />
				</f:facet>
				<h:outputText value="#{bean.sobrenome}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Data Nascimento" />
				</f:facet>
				<h:outputText value="#{bean.dtNasc}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header" >
					<h:outputText value="Remover" />
				</f:facet>
				<h:commandLink action="#{clienteMB.removerCliente}" value="X" >
					<f:setPropertyActionListener target="#{clienteMB.cliente}" value="#{bean}" />
				</h:commandLink>
			</h:column>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>