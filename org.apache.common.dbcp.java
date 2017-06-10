package com.shifangju.dpcpstudy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;

/*
<dependency>
  <groupId>commons-dbcp</groupId>
  <artifactId>commons-dbcp</artifactId>
  <version>1.4</version>
  <scope>compile</scope>
</dependency>
 */
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
# db.properties文件(放在src/main/java目录下)
verClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/DATABASE_NAME
username=USER_NAME
password=PASSWORD

#初始化时连接池中connection数量
initialSize=1

#最大连接数量
maxActive=5

#最大的空闲连接数量
maxIdle=2

#最小的空闲链接数量
minIdle=1

#最大的等待时间，单位是毫秒
maxWait=10000
#建立连接时的附加参数，如果指定的编码不一致数据库中会出现乱码
connectionProperties=useUnicode=true;characterEncoding=utf8

#是否开启自动提交，跟事务的控制有关
defaultAutoCommit=true

#指定由连接池所创建的连接的事务隔离级别（TransactionIsolation）。
defaultTransactionIsolation=REPEATABLE_READ
*/

/**
 * Hello world!
 *
 */
public class App 
{
   static BasicDataSource bs = null;

   public static void main( String[] args ) throws SQLException
   {
      try {
	 init();
      } catch (Exception e) {
	 System.err.println("初始化失败");
	 System.exit(1);
      }
      System.out.println( "Hello World!" );
       
      test();
   }

   private static void test() throws SQLException{

      Connection conn = bs.getConnection();
      // Do something...
      conn.close();
   }
			    
   private static void init() throws Exception{
      InputStream ins = App.class.getClassLoader().getResourceAsStream("dbcp.properties");
      if(ins == null) {
         System.err.println("dbcp.properties not found!");
	 throw new IOException();
      }
      Properties pro = new Properties();
      pro.load(ins);
      ins.close();
      bs = (BasicDataSource) BasicDataSourceFactory.createDataSource(pro);
      if(bs == null){
         System.err.println("cannot create datasource.");
	 throw new IOException();
      }
  }
}

