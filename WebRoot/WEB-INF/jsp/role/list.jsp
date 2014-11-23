<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  
  <body>
    <table>
    	<tr>
    		<td>岗位名称</td>
    		<td>说明</td>
    		<td>操作</td>
    	</tr>
    	<s:iterator value="list">
    		<tr>
    			<td>${name }</td>
    			<td>${description }</td>
    			<td>操作</td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
