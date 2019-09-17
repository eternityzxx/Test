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
		Connection con = null;//数据库连接对象
		Statement statement = null;//数据库操作对象
		//ResultSet rs = null;
		int count = 0;
        try {
        	//1注册驱动(第一种方式注册驱动)
			//Driver driver = new com.mysql.cj.jdbc.Driver();//获取数据库驱动对象
			//DriverManager.registerDriver(driver);//注册驱动
        	
        	//第二种方式注册驱动：通过Java的反射机制创建注册驱动类
        	//Class.forName("com.first.jdbc.RegisterDriver");
        	//第三种方式注册驱动
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
			//2获取数据库连接
			String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT&useSSL=false";
			String user = "root";
			String password = "zxx123321";
			//返回数据库连接对象
			con=DriverManager.getConnection(url,user,password);
			//3获取数据库操作对象
			statement=con.createStatement();//通过数据库连接对象提供的方法获取数据库操作对象
			//4执行SQL语句->DML语句（insert update delete）
			String sql_insert = "insert into test(id,name,phone) values(3,'mmm',156)";
		 	count = statement.executeUpdate(sql_insert);//执行，用数据库操作对象
			
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
