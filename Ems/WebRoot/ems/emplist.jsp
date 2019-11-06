<%@page contentType="text/html; charset=GBK" import="java.text.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>emplist</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ems/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<fmt:formatDate value="${ems.birthday}" pattern="yyyy-MM-dd"/>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">通讯录</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!${sessionScope.username }
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								序号
							</td>
							<td>
								名字
							</td>
							<td>
								工资
							</td>
							<td>
								年龄
							</td>
							<td>
								性别
							</td>
							<td>
								生日
							</td>
							<td>
								操作
							</td>
						</tr>
						<form action="${pageContext.request.contextPath }/ems/DeleteMoreEmsAction" method="post">
						<c:forEach var="ems" items="${requestScope.list}" varStatus="stu">
							<tr class='row1'>
								<td>
									<input type="checkbox" value="${ems.getId()}" name="ids"/>${stu.index+1}
								</td>
								<td>
									${ems.getName()}
								</td>
								<td>
									${ems.getSalary()}
								</td>
								<td>
									${ems.getAge()}
								</td>
								<td>
									${ems.getSex()}
								</td>
								<td>
									${ems.getBirthday()}
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/ems/DeleteEmsAction?id=${ems.getId()}">删除联系人</a>&nbsp;<a href="${pageContext.request.contextPath}/ems/QuerryEmsByIdAction?id=${ems.getId()}">修改联系人</a>
								</td>
							</tr>
						</c:forEach>
						
						
					</table>
					<input type="submit" class="button" value="批量删除&raquo;" />
					</p>
					</form>
					<p>
						<input type="button" class="button" value="添加&raquo;" onclick="location='${pageContext.request.contextPath }/ems/addEmp.jsp'"/>
						
						<input type="button" class="button" value="退出&raquo;" onclick="location='${pageContext.request.contextPath }/ExitAction'"/>
						
						
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
