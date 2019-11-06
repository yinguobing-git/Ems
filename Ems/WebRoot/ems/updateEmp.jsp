<%@page contentType="text/html; charset=GBK" import="java.text.*"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>update Emp</title>
		
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/ems/css/style.css" />
		
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
						修改联系人：
					</h1>
					<form action="${pageContext.request.contextPath }/ems/UpdateEmsAction" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.id" value="${sessionScope.ems.id}" readonly="readonly"/>
									${requestScope.message}
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.name" value="${sessionScope.ems.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.salary" value="${sessionScope.ems.salary }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.age" value="${sessionScope.ems.age }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									sex:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.sex" value="${sessionScope.ems.sex }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									birthday:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ems.birthday" value="${sessionScope.ems.birthday }"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定&raquo;" />
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
