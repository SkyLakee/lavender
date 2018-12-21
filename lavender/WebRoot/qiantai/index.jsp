<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		    <div id="main" style="border: 2px;color: red">		
				<!-- 111 -->
				<fieldset style="width:99%; margin-left:5px;"><legend style="font-family: 微软雅黑">新品上市</legend>
	                 <TABLE class=main border=0 cellSpacing=8 cellPadding=8>
		                <TR>
			                  <c:forEach items="${requestScope.xinpinList}" var="goods" varStatus="sta">
			                    <c:if test="${sta.index%4==0}">
			                       </tr><tr>
			                    </c:if>
				                <TD>
				                  <TABLE onmouseover="this.style.backgroundColor='#FF6600'" onmouseout="this.style.backgroundColor=''" border=0 cellSpacing=1 cellPadding=2 width=98 bgColor=#e1e1e1 align=center height=100>
				                    <TR>
				                      <TD bgColor=#ffffff  align=left>
				                        <P align="center">
				                           <A href="<%=path %>/goodsDetailQian.action?id=${goods.id }">
				                               <IMG border=0 align=absMiddle src="<%=path %>/${goods.fujian }" width=119 height=140>
				                           </A>
				                           <center>
				                               <A href="<%=path %>/goodsDetailQian.action?id=${goods.id }">
				                                  <FONT color=#ff0000></FONT><c:out value="${fn:substring(goods.mingcheng, 0, 12)}" escapeXml="false"></c:out>
				                               </A>
				                           </center>
				                        </P>
				                      </TD>
				                    </TR>
				                  </TABLE>
				                </TD>
			                  </c:forEach>
			              </TR>  
		             </TABLE>                                
	            </fieldset>
	            <!-- 111 -->
	            
	            
	            
	            
	            
	            
	            <!-- 111 -->
				<fieldset style="width:99%; margin-left:5px;"><legend style="font-family: 微软雅黑">销售排行</legend>
	                 <TABLE class=main border=0 cellSpacing=8 cellPadding=8>
		                <TR>
			                  <c:forEach items="${requestScope.paihangList}" var="goods" varStatus="sta">
			                    <c:if test="${sta.index%4==0}">
			                       </tr><tr>
			                    </c:if>
				                <TD>
				                  <TABLE onmouseover="this.style.backgroundColor='#FF6600'" onmouseout="this.style.backgroundColor=''" border=0 cellSpacing=1 cellPadding=2 width=98 bgColor=#e1e1e1 align=center height=100>
				                    <TR>
				                      <TD bgColor=#ffffff  align=left>
				                        <P align="center">
				                           <A href="<%=path %>/goodsDetailQian.action?id=${goods.id }">
				                               <IMG border=0 align=absMiddle src="<%=path %>/${goods.fujian }" width=119 height=140>
				                           </A>
				                           <center>
				                               <A href="<%=path %>/goodsDetailQian.action?id=${goods.id }">
				                                  <FONT color=#ff0000></FONT><c:out value="${fn:substring(goods.mingcheng, 0, 12)}" escapeXml="false"></c:out>
				                               </A>
				                           </center>
				                        </P>
				                      </TD>
				                    </TR>
				                  </TABLE>
				                </TD>
			                  </c:forEach>
			              </TR>  
		             </TABLE>                                
	            </fieldset>
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
