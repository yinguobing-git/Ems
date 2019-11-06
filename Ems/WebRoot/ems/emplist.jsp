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
							<a href="#">ͨѶ¼</a>
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
								���
							</td>
							<td>
								����
							</td>
							<td>
								����
							</td>
							<td>
								����
							</td>
							<td>
								�Ա�
							</td>
							<td>
								����
							</td>
							<td>
								����
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
									<a href="${pageContext.request.contextPath}/ems/DeleteEmsAction?id=${ems.getId()}">ɾ����ϵ��</a>&nbsp;<a href="${pageContext.request.contextPath}/ems/QuerryEmsByIdAction?id=${ems.getId()}">�޸���ϵ��</a>
								</td>
							</tr>
						</c:forEach>
						
						
					</table>
					<input type="submit" class="button" value="����ɾ��&raquo;" />
					</p>
					</form>
					<p>
						<input type="button" class="button" value="���&raquo;" onclick="location='${pageContext.request.contextPath }/ems/addEmp.jsp'"/>
						
						<input type="button" class="button" value="�˳�&raquo;" onclick="location='${pageContext.request.contextPath }/ExitAction'"/>
						
						
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
