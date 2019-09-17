package testSql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/*
 * 1.ע������
 * 2.��ȡ���ݿ�����
 * 3.��ȡ���ݿ��������
 * 4.ִ��SQL���
 *   4.1 DQL��� ->���岽����������
 *   4.2 DML
 * 5.�����ѯ�����
 * 6.�ر���Դ
 */
public class JDBCTest {
        public static void main(String[] args) {
        	//����connection����
    		Connection conn = null;//����MySQL���ݿ�
    		
    		Statement stmt = null;// 2.����statement��������ִ��SQL���
    		ResultSet rs = null;// 3.ResultSet�࣬������Ż�ȡ���Ľ����
        	try {
        		//1.ע������
            	//1.1��ȡ��������
				Driver driver = new com.mysql.cj.jdbc.Driver();
				//1.2ע������
	        	DriverManager.registerDriver(driver);
	        	
	        	//2.��ȡ���ݿ�����
	        	String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT&useSSL=false";
	        	String user = "root";
	        	String password = "zxx123321";
	        	conn = DriverManager.getConnection(url,user,password);
	        	//System.out.println(conn);
	        	
	        	//3.��ȡ���ݿ��������
	        	stmt = conn.createStatement();
	        	//System.out.println(stmt);
	        	
	        	//4ִ��SQL��䣻 DQL���
	        	String sql = "select * from test";
	        	rs = stmt.executeQuery(sql);
	        	//System.out.println(rs);
	        	System.out.println("���������£�");
	        	System.out.println("�û�ID"+"\t"+"����"+"\t"+"�绰");	
	        	//5.��������
	        	while(rs.next()) {
	        		
	        		String id = rs.getString("id");
	        		String name = rs.getString("name");
					String phone = rs.getString("phone");
				
					System.out.println(id+"\t"+name+"\t"+phone);
				
	        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//�ر���Դ
				
			}
        	
        }
}
