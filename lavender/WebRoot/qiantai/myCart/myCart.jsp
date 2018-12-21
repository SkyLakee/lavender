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
    
    <script type='text/javascript' src='<%=path %>/dwr/interface/cartService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    
    <script language="javascript">
            function modiNum(goodsId,quantity)
	        {
	            var r1= /^[0-9]*[1-9][0-9]*$/　　//正整数 
	            var val=r1.test(quantity); //str为你要判断的字符 执行返回结果 true 或 false
	            if(val==false)
	            {
	                alert("数量必须是数字,请重新输入");
	            }
	            else
	            {
	                document.getElementById("indicator1").style.display="block";
	                cartService.modiNum(goodsId,quantity,callback);
	            }
	        }
	        
	        function callback(data)
	        {
	            document.getElementById("indicator1").style.display="none";
	            if(data=="kucunbuzu")
			    {
			        alert("鲜花库存不足");
			    }
			    
	            document.location.reload(true);
	        }
	        
	        
	        function delGoodsFromCart(goodsId)
	        {
	            document.getElementById("indicator1").style.display="block";
	            cartService.delGoodsFromCart(goodsId,callback);
	        }
	        
	        function clearCart()
	        {
	            document.getElementById("indicator1").style.display="block";
	            cartService.clearCart(callback);
	        }
	        
	        
	        function orderQueren()
	        {
	            var ss=${sessionScope.cart.totalPrice};
	            if(ss==0)
	            {
	                alert("购物车中无商品");
	                return false;
	            }
	            
	            var url="<%=path %>/qiantai/order/orderQueren.jsp";
	            window.location.href=url;
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
				<!-- <h1>购物车</h1> -->
				<br/>
	            <p>
	                <s:set name="items" value="#session.cart.items"/>
	                        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align="center" bgcolor="#FAFAF1" height="22">
					                  <td>名称</td>
					                  <td>购买价格</td>
					                  <td>数量</td>
					                  <td>总金额</td>
					                  <td>删除</td>
				                  </tr>
								  <s:iterator value="#items">
								  <tr align='center' bgcolor="#FFFFFF" height="22">
									  <td><s:property value="value.goods.mingcheng"/></td>
									  <td>￥<s:property value="value.goods.tejia"/><br/></td>
									  <td>
									      <form>
									         <input type="text" name="shuliang" value="<s:property value="value.goodsShuliang"/>" size="4"/>
									         <input type="button" value="更新" onclick="modiNum(<s:property value="value.goods.id"/>,this.form.shuliang.value)"/>
									      </form>
									  </td>
									  <td>￥<s:property value="value.goodsShuliang * value.goods.tejia"/></td>
									  <td><input onClick="delGoodsFromCart(<s:property value="value.goods.id"/>)" type="button" value="删除"/></td>
								  </tr>
								  </s:iterator>
					              <tr style="height: 100px;" align="center" >
					                 <td colspan="6" class="Order_Total">
									    总金额：￥<span id="totalMoney"><s:property value="#session.cart.totalPrice"/></span>
									    &nbsp;&nbsp;&nbsp;&nbsp;
									    <img id="indicator1" src="<%=path %>/images/loading.gif" style="display:none"/>
									 </td>
					              </tr>				
	        				</table>
	        				<table>
	        				   <tr height="7"><td></td></tr>
			                   <tr>
			                       <td width="120"></td>
			                       <td width="110"><a href="#" onclick="clearCart()" style="font-family: 微软雅黑;font-size: 15px;">清空购物车</a></td>
			                       <td width="110"><a href="<%=path %>/qiantai/default.jsp" style="font-family: 微软雅黑;font-size: 15px;">继续购买</a></td>
			                       <td width="110"><a href="#" onclick="orderQueren()" style="font-family: 微软雅黑;font-size: 15px;">去收银台</a></td>
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
