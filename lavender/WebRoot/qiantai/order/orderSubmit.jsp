<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="<%=path %>/css/qiantai.css" type="text/css" />
    
    <script type="text/javascript">
            
    </script>
  </head>
  
  <body>
	<div id="header-wrap">
		<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
	</div>
				
	<div id="content-wrap">
		<div id="content">	 
		    <div id="main">		
				<!-- 111 -->
				<!-- <h1>鲜花展示</h1> -->
	            <p>
	                 <table width="99%" border="0" cellpadding="5" cellspacing="5" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
				              <tr>
				                  <td align="center" style="color: red">恭喜您，订单提交成功！</td>
				              </tr>
				              <tr>
				                  <td>订单编号：<s:property value="#request.order.bianhao"/></td>
				              </tr>
				              <tr>
				                  <td>下单日期:<s:property value="#request.order.xiadanshi"/></td>
				              </tr>
				              <tr>
				                  <td>送货地址:<s:property value="#request.order.songhuodizhi"/></td>
				              </tr>
				              <tr>
				                  <td>总金额：<s:property value="#request.order.zongjia"/></td>
				              </tr>
				              
		        		</table>                          
	            </p>
	            <!-- 111 -->
	            
			</div>
			<div id="sidebar">	
				<jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
			</div>			
		</div>
	</div>

	<div style="height: 10px;">
	    <br/><a style="color: white;" href="<%=path %>/login.jsp">系统后台</a>
	</div>
</body>
</html>
