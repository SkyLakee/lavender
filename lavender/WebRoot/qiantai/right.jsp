<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page isELIgnored="false" %> 
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
				<div style="width:200px;margin-top: 10px;padding-bottom:10px;">
				      <div style="height:26px;background:url(/xhw/images/guangguang.PNG);font-size: 14px;color:#de3237;">
				          <span style="float:left;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;margin-left: 10px;">鲜花类别</span>
						  <span style="float:right;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;">&nbsp;</span>
				      </div>
				      <div style="height: 100px;border:1px solid red;">
				          <c:forEach items="${sessionScope.leibieList }" var="leibie" varStatus="ss">
				          <div style="margin-left: 10px;margin-top: 10px;">
				             <a href="<%=path %>/goodsByLeibie.action?leibieId=${leibie.id }">
				                <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/>${leibie.mingcheng }
				             </a>
				          </div>
				          </c:forEach>
				      </div>
				 </div>
				 <br/><br/><br/><br/><br/><br/><br/><br/><br/>
				 <br/><br/><br/><br/><br/><br/><br/><br/><br/>
  </body>
</html>
