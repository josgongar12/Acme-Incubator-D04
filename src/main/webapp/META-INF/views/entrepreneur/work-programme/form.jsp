<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="entrepreneur.workProgramme.form.label.title" path="title"/>
	<acme:form-url code="entrepreneur.workProgramme.form.label.moment" path="moment"/>
	<acme:form-url code="entrepreneur.workProgramme.form.label.deadline" path="deadline"/>
	<acme:form-url code="entrepreneur.workProgramme.form.label.budget" path="budget"/>
	
	<acme:form-return code="entrepreneur.workProgramme.form.button.return"/>
</acme:form>