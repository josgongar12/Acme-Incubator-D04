<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.investmentRound.list.label.ticker" path="ticker"/>
	<acme:list-column code="authenticated.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:list-column code="authenticated.investmentRound.form.label.title" path="title"/>
</acme:list>