package testSql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestDML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;//���ݿ����Ӷ���
		Statement statement = null;//���ݿ��������
		//ResultSet rs = null;
		int count = 0;
        try {
        	//1ע������(��һ�ַ�ʽע������)
			//Driver driver = new com.mysql.cj.jdbc.Driver();//��ȡ���ݿ���������
			//DriverManager.registerDriver(driver);//ע������
        	
        	//�ڶ��ַ�ʽע��������ͨ��Java�ķ�����ƴ���ע��������
        	//Class.forName("com.first.jdbc.RegisterDriver");
        	//�����ַ�ʽע������
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
			//2��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT&useSSL=false";
			String user = "root";
			String password = "zxx123321";
			//�������ݿ����Ӷ���
			con=DriverManager.getConnection(url,user,password);
			//3��ȡ���ݿ��������
			statement=con.createStatement();//ͨ�����ݿ����Ӷ����ṩ�ķ�����ȡ���ݿ��������
			//4ִ��SQL���->DML��䣨insert update delete��
			String sql_insert = "insert into test(id,name,phone) values(3,'mmm',156)";
		 	count = statement.executeUpdate(sql_insert);//ִ�У������ݿ��������
			
			String sql_update = "update test set name ='jjj' where id =2";
			count=statement.executeUpdate(sql_update);
			
			String sql_delete = "delete from test where id =3";
			count = statement.executeUpdate(sql_delete);
			System.out.println(count);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
