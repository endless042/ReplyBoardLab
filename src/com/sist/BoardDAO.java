package com.sist;

import java.util.*;
import java.sql.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static BoardDAO dao;
	/*
	 * 	1) �������/Ŭ��������
	 * 		���� : �Ϲݺ���(int,double..),Ŭ����,�迭
	 * 		���(final) 
	 * 	2) ����������
	 * 		private < default < protected < public
	 * 	3) ���� : ����(has-a), ���(is-a)
	 * 	4) ����,�߰� : ������
	 * 	5) ������
	 * 	6) �������̽�
	 * 	7) ����ó��
	 * 	8) �÷���(ArrayList,Map), ���׸�
	 *  
	 * 
	 */
	
	private BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Ŭ���� ���� �б�
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	//�̱���
	public static BoardDAO newInstance() {
		if(dao==null) {
			dao=new BoardDAO();
		}
		return dao;
	}
	
	//����
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"scott","tiger");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//����
	public void disConnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//����߰�
	//1.���	ArrayList<BoardVO> : int 
	public ArrayList<BoardVO> boardListData(int page){
		
		ArrayList<BoardVO> list=new ArrayList<>();
		
		try {
			getConnection();
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			//1,11,21... rownum BETWEEN 1 AND 10
			int end=rowSize*page;
			String sql="SELECT no,subject,name,regdate,hit,group_tab,num "
			+"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit,group_tab "
			+"FROM replyboard ORDER BY group_id DESC,group_step ASC)) "
			+"WHERE num BETWEEN "+start+" AND "+end;
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
				vo.setRownum(rs.getInt(7));
				
				list.add(vo);
				
			}
			
			rs.close();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disConnection();
		}
		
		
		return list;
	}
	
	
		//2.�������� �б�
	public int boardTotalPage() {
		int total=0;
		
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10) FROM replyboard";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
				
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disConnection();
		}
		
		
		return total;
		
	}
	
	//3.�����ϱ�
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck=false;
			
		return bCheck;
	}
	
	
	//4.���뺸��
	//5.�߰��ϱ�
	//6.�亯�ϱ�
	//7.�����ϱ�
	//8.ã��
	

	
}
