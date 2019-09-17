package testSql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/*
 * 1.注册驱动
 * 2.获取数据库连接
 * 3.获取数据库操作对象
 * 4.执行SQL语句
 *   4.1 DQL语句 ->第五步：处理结果集
 *   4.2 DML
 * 5.处理查询结果集
 * 6.关闭资源
 */
public class JDBCTest {
        public static void main(String[] args) {
        	//声明connection对象；
    		Connection conn = null;//连接MySQL数据库
    		
    		Statement stmt = null;// 2.创建statement对象，用来执行SQL语句
    		ResultSet rs = null;// 3.ResultSet类，用来存放获取到的结果集
        	try {
        		//1.注册驱动
            	//1.1获取驱动对象
				Driver driver = new com.mysql.cj.jdbc.Driver();
				//1.2注册驱动
	        	DriverManager.registerDriver(driver);
	        	
	        	//2.获取数据库连接
	        	String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT&useSSL=false";
	        	String user = "root";
	        	String password = "zxx123321";
	        	conn = DriverManager.getConnection(url,user,password);
	        	//System.out.println(conn);
	        	
	        	//3.获取数据库操作对象
	        	stmt = conn.createStatement();
	        	//System.out.println(stmt);
	        	
	        	//4执行SQL语句； DQL语句
	        	String sql = "select * from test";
	        	rs = stmt.executeQuery(sql);
	        	//System.out.println(rs);
	        	System.out.println("输出结果如下：");
	        	System.out.println("用户ID"+"\t"+"姓名"+"\t"+"电话");	
	        	//5.处理结果集
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
				//关闭资源
				
			}
        	
        }
}
