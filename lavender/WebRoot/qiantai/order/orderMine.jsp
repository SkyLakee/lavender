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
         function orderDel(id)
        {
            var url="<%=path %>/orderDel.action?id="+id;
            window.location.href=url;
        }
        
        function orderDetail(id)
        {
              var url="<%=path %>/orderDetail.action?orderId="+id;
              var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
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
				<!-- <h1>我的订单</h1> -->
	            <p>
	                 <c:forEach items="${requestScope.orderList}" var="order">
						               <fieldset style="width:95%; margin-left:5px;"><legend class="fieldtitle"></legend>
											<table class="bill" width="97%" cellpadding="4" cellspacing="4">
											    <tr>
											        <td>订单编号：${order.bianhao}</td>
											    </tr>
											    <tr>
											        <td>下单时间：${order.xiadanshi}</td>
											    </tr>
											    <tr>
											        <td> 订单状态：${order.zt}</td>
											    </tr>
											    <tr>
											        <td>送货地址：${order.songhuodizhi}</td>
											    </tr>
											    <tr>
											        <td>
											                                 总金额：${order.zongjia}&nbsp;&nbsp;
											           <a href="#" onclick="orderDetail(${order.id})"/>订单明细</a>
											           &nbsp;&nbsp;
											           <a href="#" onclick="orderDel(${order.id})">删除</a>
											        </td>
											    </tr>
											</table>
									   </fieldset>
									   <br/>
									   </c:forEach>                                
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
