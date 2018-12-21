<%@ page language="java" pageEncoding="UTF-8"%>
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
	                  <form action="<%=path %>/goodsRes.action" name="fd" method="post">
						<table align="left" border="0" cellpadding="1" cellspacing="1">
							<tr align='right'>
								<td style="width: 80px;vertical-align: middle;" align="right">
									关键字：
						        </td>
								<td align="left">
								<input name="mingcheng" type="text" style="width: 200px;"/>
								<input type="submit" value="查询"/>&nbsp; 
								</td>
							</tr>
						</table>
					  </form>                            
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
