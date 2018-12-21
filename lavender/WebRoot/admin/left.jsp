<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	-->
	</style>
	</head>

	<body>
	<body bgcolor="D6EBBD">
		<table width="173" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout:fixed;">
			<tr>
				<td
					style="width:4px; background-image:url(<%=path%>/img/main_16.gif)">
					&nbsp;
				</td>
				<td width="169" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" background="<%=path%>/img/main_11.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/admin/userinfo/userPw.jsp" target="I2" style="text-decoration:none">修改登陆密码</a>
									</td>
								</table>
							</td>
						</tr> 
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/leibieMana.action" target="I2" style="text-decoration:none">类别信息管理</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/goodsMana.action" target="I2" style="text-decoration:none">鲜花信息管理</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/huiyuanMana.action" target="I2" style="text-decoration:none">会员信息管理</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/orderMana.action" target="I2" style="text-decoration:none">订单信息管理</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/admin/tongji/tongjiPre.jsp" target="I2" style="text-decoration:none">销售统计模块</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/liuyanMana.action" target="I2" style="text-decoration:none">留言信息管理</a>
									</td>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
