<%@page contentType="text/html; charset=GBK" import="java.text.*"%>
<html>
	<head>
		<title>regist</title>
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
						ע��
					</h1>
					<form action="${pageContext.request.contextPath }/manager/RegistManagerAction" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									�û���:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="manager.username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									��ʵ����:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="manager.name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									����:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="manager.password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									�Ա�:
								</td>
								<td valign="middle" align="left">
									��
									<input type="radio" class="inputgri" name="manager.sex" value="man" checked="checked"/>
									Ů
									<input type="radio" class="inputgri" name="manager.sex" value="woman"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									��֤��:
									<img id="num" src="image" />
									<a href="javascript:;" onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()">��һ��</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="ע�� &raquo;" />
							<input type="reset" class="button" value="����&raquo;" />
							<input type="button" class="button" value="�˳�&raquo;" onclick="location='${pageContext.request.contextPath }/ExitAction'"/>
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
