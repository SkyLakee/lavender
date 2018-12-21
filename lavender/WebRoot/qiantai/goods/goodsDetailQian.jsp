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
        function buy1(kucun)
        {
            <s:if test="#session.userType !=1">
                  alert("请先登录");
            </s:if>
            <s:if test="#session.userType ==1">
                if(document.buy.shuliang.value=="")
	            {
	                alert("请输入购买数量");
	                return false;
	            }
	            
	            document.buy.submit();
            </s:if>
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
	            <p>
	                 <form action="<%=path %>/addToCart.action" method="post" name="buy">
				                         <table width="100%" border="0" cellpadding="6" cellspacing="6">
											    <tr>
											       <td align="left"><img width="400" height="200" src="<%=path %>/${requestScope.goods.fujian }" style="border:1px solid  #CCCCCC; padding:5px;"/></td>
											    </tr>
											    <tr>
											       <td align="left">名称：${requestScope.goods.mingcheng }</td>
											    </tr>
											    <tr>
											       <td align="left"><c:out value="${requestScope.goods.jieshao }" escapeXml="false"></c:out></td>
											    </tr>
											    <tr>
											       <td align="left">
											          <c:if test="${requestScope.goods.shifoutejia=='yes' }">
												                              原价：${requestScope.goods.jiage }
												          &nbsp;&nbsp;&nbsp;
												                              特价：${requestScope.goods.tejia }
											          </c:if>
											          <c:if test="${requestScope.goods.shifoutejia=='no' }">
												                              价格：${requestScope.goods.jiage }
											          </c:if>
											          
											       </td>
											    </tr>
											    <tr>
											       <td align="left">
											                                  数量：
											           <input type="text" name="shuliang" value="1" size="8" 
											                onkeyup="this.value=this.value.replace(/\D/g,'')" 
											                onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
											           <input type="hidden" name="goodsId" value="${requestScope.goods.id }"/>
											           <input type="button" value="购买" style="width: 80px;height: 30px;" onclick="buy1()"/>
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
