<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
	
	<script type="text/javascript">
			function userLogout()
	        {
			    loginService.userLogout(callback1);
	        }
	        
	        
	        function callback1(data)
			{
			    alert("退出系统");
			    window.location.reload();
			}
			
			function gerenzhongxin()
			{
			    var targetWinUrl="<%=path %>/auser/index.jsp";
				var targetWinName="newWin";
				var features="width="+screen.width+" ,height="+screen.height+" ,toolbar=yes, top=0, left=0, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes";
				var new_win=window.open(targetWinUrl,targetWinName,features);
			}
			
		   function mycart()
	       {
	            <c:if test="${sessionScope.userType !=1}">
	                  alert("请先登录");
	            </c:if>
	            
	            <c:if test="${sessionScope.userType==1}">
	                var s="<%=path %>/myCart.action";
		            window.location.href=s;
	            </c:if>
	       } 
	         
	       function orderMine()
	       {
	            <c:if test="${sessionScope.userType !=1}">
	                  alert("请先登录");
	            </c:if>
	            
	            <c:if test="${sessionScope.userType==1}">
	                var s="<%=path %>/orderMine.action";
		            window.location.href=s;
	            </c:if>
	       } 
	</script>
  </head>
  
  <body>
        <div id="header-content" style="width: 1025px;">
			<br/><br/><br/>
			<h1 style="color: white;font-size: 30px;">七彩鲜花商城</h1>
			<ul>
				<li><a href="<%=path %>/index.action" style="font-family: 微软雅黑;font-size: 15px;">系统首页</a></li>
				<li><a href="<%=path %>/qiantai/goods/goodsSea.jsp" style="font-family: 微软雅黑;font-size: 15px;">鲜花查询</a></li>
				<li><a href="<%=path %>/qiantai/user/userReg.jsp" style="font-family: 微软雅黑;font-size: 15px;">用户注册</a></li>
				<li><a href="<%=path %>/liuyanAll.action" style="font-family: 微软雅黑;font-size: 15px;">留言板</a></li>
				
				<c:if test="${sessionScope.userType!=1}">
				<li><a href="<%=path %>/qiantai/user/userLogin.jsp" style="font-family: 微软雅黑;font-size: 15px;">用户登录</a></li>
				</c:if>
				
				<c:if test="${sessionScope.userType==1}">
				<li><a href="#">欢迎你：${sessionScope.huiyuan.loginname}</a></li>
				<li><a href="<%=path %>/qiantai/user/userInfo.jsp" style="font-family: 微软雅黑;font-size: 15px;">我的信息</a></li>
				<li><a href="#" onclick="userLogout()" style="font-family: 微软雅黑;font-size: 15px;">注销退出</a></li>
				<li><a href="#" onclick="mycart()" style="font-family: 微软雅黑;font-size: 15px;">我的购物车</a></li>
				<li><a href="#" onclick="orderMine()" style="font-family: 微软雅黑;font-size: 15px;">我的订单</a></li>
				</c:if>
			</ul>					
		</div>
  </body>
</html>
