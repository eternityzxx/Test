package testSql;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	public static void main(String[] args) {
		//����connection����
		Connection con = null;//����MySQL���ݿ�
		
		Statement statement = null;// 2.����statement��������ִ��SQL���
		ResultSet rs = null;// 3.ResultSet�࣬������Ż�ȡ���Ľ����
		//������������
		String driver = "com.mysql.cj.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ�����
		String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT&useSSL=false";
         //serverTimezone=GMT&useSSL=false
		//MySql�û��������룻
		String user = "root";
		String password = "zxx123321";
		//������ѯ�����
		try {
			//������������
			Class.forName(driver);
			// 1.getConnection()����������MySQL���ݿ�
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed()) {
				System.out.println("Succeeded connection to the database!");
			}
			// 2.����statement��������ִ��SQL���
			 statement = con.createStatement();
			//Ҫִ�е�SQL���
			String sql = "select * from test";
			// 3. ResultSet�࣬������Ż�ȡ���Ľ����
		    rs = statement.executeQuery(sql);
			System.out.println("���������£�");
			System.out.println("ID"+"\t"+"����"+"\t"+"�绰");	
			//rs.close();
			String id = null;
			String name = null;
			String phone = null;
			while(rs.next()) {
				//��ȡ������
				id = rs.getString("id");
				name = rs.getString("name");
				phone = rs.getString("phone");
				System.out.println(id+"\t"+name+"\t"+phone);
			}
			rs.close();
			con.close();
		}catch(ClassNotFoundException e) {
			//���ݿ��쳣����
			System.out.println("sorry,can't find the driver");
			    e.printStackTrace();
		        }catch(SQLException e) {
		        	//���ݿ������쳣����
		        	e.printStackTrace();
		        }catch(Exception e) {
		        	e.printStackTrace();
		        }finally {
		        //	6.�ر���Դ
		        //һ�����ݿ����Ӷ�����Դ���������ݿ��������
		        //������ݿ����������ж����ѯ�����--����
		        	if(rs!=null) {
		        		try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	if(statement!=null) {
		        		try {
							statement.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	if(con!= null) {
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


