<%@page contentType="text/html; charset=GBK" import="java.text.*" %>
<%@page isELIgnored="false" %>

<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/ems/css/style.css" />
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
								2019-08-07
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加联系人
					</h1>
					<form action="${pageContext.request.contextPath }/ems/AddEmsAction" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.name" />
									${requestScope.message}
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									sex:
								</td>
								<td valign="middle" align="left">
									<input type="radio" class="inputgri" name="ems.sex" value="man"/>男
									<input type="radio" class="inputgri" name="ems.sex" value="woman"/>女
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									birthday:
								</td>
								<td valign="middle" align="left">
									<input type="date" class="inputgri" name="ems.birthday" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定 &raquo;" />
							<input type="reset" class="button" value="重置&raquo;" />
							<input type="button" class="button" value="退出&raquo;" onclick="location='${pageContext.request.contextPath }/ExitAction'"/>
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
