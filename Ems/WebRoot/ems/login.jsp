<%@page contentType="text/html; charset=GBK" import="java.text.*" pageEncoding="GBK"%>


<html>
	<head>
		<title>login</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css" />
			<% java.util.Date date=new java.util.Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(date);
			request.setAttribute("time",time);%>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								${time}
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						π‹¿Ì‘±µ«¬º
					</h1>
					<form action="${pageContext.request.contextPath}/manager/LoginManagerAction" method="get">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									Í«≥∆:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="manager.username"/>${requestScope.message}
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									√‹¬Î:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="manager.password" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="µ«¬º &raquo;" />
							<input type="reset" class="button" value="÷ÿ÷√&raquo;" />
							<a href="${pageContext.request.contextPath }/ems/regist.jsp"><input type="button" class="button" value="◊¢≤· &raquo;" /></a>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
