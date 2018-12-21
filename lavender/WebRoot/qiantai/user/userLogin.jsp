<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <style type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
	
	<script type="text/javascript">
	        function login()
	        {
	           if(document.userLogin.loginname.value=="")
	           {
	               alert("请输入用户名");
	               return;
	           }
	           if(document.userLogin.loginpw.value=="")
	           {
	               alert("请输入密码");
	               return;
	           }
	           
	           document.getElementById("indicator").style.display="block";
			   loginService.login(document.userLogin.loginname.value,document.userLogin.loginpw.value,1,callback);
	        }
	        
	        
	        function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("用户名或密码错误");
			    }
			    if(data=="yes")
			    {
			        alert("通过验证,系统登录成功");
			        var url="<%=path %>/index.action";
			        window.location.href=url;
			    }
			    
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
				<!-- <h1>用户登陆</h1> -->
	            <p>
	                 <form action="" name="userLogin" method="post">
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                                                                                                  账号：<input style="width: 200px;" name="loginname" type="text" />
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                          	密码：<input type="password" name="loginpw" style="width: 200px;"/>
	                                          	<input type="button" value="登陆" onclick="login()" style="width: 100px;height: 24px;"/>
	                                          	<img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
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
