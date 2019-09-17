package testSql;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	public static void main(String[] args) {
		//声明connection对象；
		Connection con = null;//连接MySQL数据库
		
		Statement statement = null;// 2.创建statement对象，用来执行SQL语句
		ResultSet rs = null;// 3.ResultSet类，用来存放获取到的结果集
		//驱动程序名；
		String driver = "com.mysql.cj.jdbc.Driver";
		//URL指定要访问的数据库名；
		String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT&useSSL=false";
         //serverTimezone=GMT&useSSL=false
		//MySql用户名和密码；
		String user = "root";
		String password = "zxx123321";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed()) {
				System.out.println("Succeeded connection to the database!");
			}
			// 2.创建statement对象，用来执行SQL语句
			 statement = con.createStatement();
			//要执行的SQL语句
			String sql = "select * from test";
			// 3. ResultSet类，用来存放获取到的结果集
		    rs = statement.executeQuery(sql);
			System.out.println("输出结果如下：");
			System.out.println("ID"+"\t"+"姓名"+"\t"+"电话");	
			//rs.close();
			String id = null;
			String name = null;
			String phone = null;
			while(rs.next()) {
				//获取列数据
				id = rs.getString("id");
				name = rs.getString("name");
				phone = rs.getString("phone");
				System.out.println(id+"\t"+name+"\t"+phone);
			}
			rs.close();
			con.close();
		}catch(ClassNotFoundException e) {
			//数据库异常处理
			System.out.println("sorry,can't find the driver");
			    e.printStackTrace();
		        }catch(SQLException e) {
		        	//数据库链接异常处理
		        	e.printStackTrace();
		        }catch(Exception e) {
		        	e.printStackTrace();
		        }finally {
		        //	6.关闭资源
		        //一个数据库连接对象可以创建多个数据库操作对象
		        //多个数据库操作对象就有多个查询结果集--倒关
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


