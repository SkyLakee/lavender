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
            function back1()
	        {
	           window.history.go(-1);
	        }
	        
	        /* function dd()
	        {
	            var fukuanfangshi=document.f.fukuanfangshi.value;
	            //alert(odderFukuangfangshi);
	            if(fukuanfangshi=="银行付款")
	            {
	                 document.getElementById("qufukuan").style.display="block";
	            }
	            if(fukuanfangshi=="货到付款")
	            {
	                 document.getElementById("qufukuan").style.display="none";
	            }
	        } */
	        
	        function kahao()
	        {
	            var strUrl = "<%=path %>/site/order/kahao.jsp";
				var ret = window.showModalDialog(strUrl,"","dialogWidth:700px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
	        }      
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
				<br/>
	            <p>
	                 <form action="<%=path %>/orderSubmit.action" name="f" method="post">
		                        <table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align='center' bgcolor="#FFFFFF" height="40">
					                  <td width="20%" align="right">收货人帐号：</td>
					                  <td width="80%" align="left">
					                      <input type="text" readonly="readonly" value="<s:property value="#session.huiyuan.loginname"/>"/>
					                  </td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="40">
					                  <td width="20%" align="right">收货人姓名：</td>
					                  <td width="80%" align="left">
					                      <input type="text" value="<s:property value="#session.huiyuan.xingming"/>"/>
					                  </td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="40">
					                  <td width="20%" align="right">收货人电话：</td>
					                  <td width="80%" align="left">
					                      <input type="text" value="<s:property value="#session.huiyuan.dianhua"/>"/>
					                  </td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="40">
					                  <td width="20%" align="right">收货人地址：</td>
					                  <td width="80%" align="left">
					                      <input type="text" name="songhuodizhi" value="<s:property value="#session.huiyuan.address"/>"/>
					                  </td>
					              </tr>
					              <tr align='center' bgcolor="#FFFFFF" height="40">
					                  <td width="20%" align="right">&nbsp;</td>
					                  <td width="80%" align="left">
		   		                          <input type="button" onclick="kahao()" id="qufukuan" style="display: none" value="查看卡号"/>
		   		                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   		                          <a href="#" onclick="back1()" style="font-family: 微软雅黑;font-size: 15px;">返回修改</a>
		   		                          &nbsp;&nbsp;
		   		                          <a href="#" onclick="javascript:document.f.submit();" style="font-family: 微软雅黑;font-size: 15px;">提交订单</a>
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
