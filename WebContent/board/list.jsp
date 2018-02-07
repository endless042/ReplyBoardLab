<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.*,java.text.*"%>
<% 
	int curpage=1;
	String strPage=request.getParameter("page");
	if(strPage==null)
		strPage="1";
	
	curpage=Integer.parseInt(strPage);
	
	BoardDAO dao=BoardDAO.newInstance();
	ArrayList<BoardVO> list=dao.boardListData(curpage);
	int totalpage=dao.boardTotalPage();
	
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String today=sdf.format(date);
	
	
	
	
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<style type="text/css">
		th,td{
			font-family:맑은 고딕, 휴먼매직체;
			font-size: 9pt;
			
		}
		a{
			text-decoration:none;
			color:black;
		}
		a:hover{
			text-decoration:underline;
			color:green;
		}
	</style>
	<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>

	<center>
	
	
	<img src="image/board.jpg" alt="" width="350" height="75">
	<p></p>
	
	<table border="0" width="600">
		<tr>
			<td align="left">
				<a href="insert.jsp">
				<img src="image/bt_write.jpg"></a>
			</td>
		</tr>
	</table>
	
	<table id="table_content" width="600">
		<tr bgcolor="#ccccff" height="30">
			<th width="10%">
				번호
			</th>
			<th width="45%">
				제목
			</th>
			<th width="15%">
				이름
			</th>
			<th width="20%">
				작성일
			</th>
			<th width="10%">
				조회수
			</th>
		</tr>
		<%
			
		for(BoardVO vo:list){
			
			%>
			<tr height="30" class="dataTr">
			<td width="10%" align="center">
			<%=vo.getNo() %></td>
			<td width="45%">
				<%
					if(vo.getGroup_tab()>0){
						for(int i=0;i<vo.getGroup_tab();i++){
							out.write("&nbsp;&nbsp;");						
						}
					%>
							<img alt="" src="image/icon_reply.gif">					
					<% 
					
					}
					String msg="관리자가 삭제한 게시물입니다.";
					if(msg.equals(vo.getSubject())){
						
						%>
					<span style="color : gray;"><%= vo.getSubject()%></span>
					
					<%
						}else{
					%>
						<a href="content.jsp?no=<%=vo.getNo()%>"><%=vo.getSubject() %></a>					
					<%
					
						}
					if(today.equals(vo.getRegdate().toString())){
						
						%> <sup><img alt="" src="image/new.gif"></sup>
						
						<% 
					}
					%>	
					
			</td>
			<td width="15%" align="center">
			<%=vo.getName() %></td>
			<td width="20%" align="center">
			<%=vo.getRegdate().toString() %></td>
			<td width="10%" align="center">
			<%=vo.getHit() %></td>
			
			</tr>
			<%
			
			
		}
		
		
		%>
		
	</table>
	
	<table id="table_content" width="600">
		<tr>
			<td align="left">
				<form action="find.jsp" method="post">
				Search: 
				<select name="fs">
				<option value="name">이름</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				
				</select>
				<input type="text" name="ss" size="12">
				<input type="submit" value="검색">
				</form>
			</td>
			<td align="right">
			<a href="list.jsp?page=<%=curpage>1?curpage-1:curpage%>">
				<img alt="" src="image/btn_pagePrev.gif" ></a>
			<%
				 for(int i=1;i<=totalpage;i++){
				%>
					[<a href="list.jsp?page=<%=i%>"><%=i %></a>]
				<%
				 }
			%>
			<a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage%>">
			<img src="image/btn_pageNext.gif">
			</a>&nbsp;&nbsp;
			<%=curpage %> page / <%=totalpage %> pages
				
			 </td>
		</tr>
		
		
	
	
	</table>
	</center>






</body>
</html>