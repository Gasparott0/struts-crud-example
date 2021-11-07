<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <s:head />
        <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="label.persons"/></title>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <s:url var="url" action="inputPerson" />
        <a id="add-person" href="<s:property value="#url"/>">Adicionar nova Pessoa</a>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><s:text name="person.firstName"/></th>
                <th><s:text name="person.lastName"/></th>
                <th><s:text name="person.age"/></th>
                <th><s:text name="person.gender"/></th>
                <th><s:text name="person.email"/></th>
                <th><s:text name="person.phoneNumber"/></th>
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="persons" status="status">
                <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
                    <td class="nowrap"><s:property value="firstName"/></td>
                    <td class="nowrap"><s:property value="lastName"/></td>
                    <td class="nowrap"><s:property value="age"/></td>
                    <td class="nowrap"><s:property value="gender"/></td>
                    <td class="nowrap"><s:property value="email"/></td>
                    <td class="nowrap"><s:property value="phoneNumber"/></td>
                    <td class="nowrap">
                        <s:url action="inputPerson" var="url">
                            <s:param name="person.personId" value="personId"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Editar</a>
                        &nbsp;&nbsp;&nbsp;
                        <s:url action="deletePerson" var="url">
                            <s:param name="person.personId" value="personId"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Excluir</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <a id="back" href="<s:url action='index'/>">Voltar</a>
    </body>
</html>