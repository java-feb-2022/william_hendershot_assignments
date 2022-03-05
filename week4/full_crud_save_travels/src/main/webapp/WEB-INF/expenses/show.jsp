<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/general/taglibs.jspf" %>
<%@ page isErrorPage="true" %>
<general:layout>
    <expenses:list></expenses:list>
    <expenses:create></expenses:create>
</general:layout>