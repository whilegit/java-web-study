/**
 * 每个Web应用(.war文件)对应一个ServletContext对象,此类主要用于跟容器打交道
 * 对同应用下的所有Servlet开放
 * ServletContext对象存放于SerletConfig对象中
 * 获取ServletContext方法:　
 *    servlet.getServletContext()
 *    servlet.getSerletConfig().getServletContext()
 *    httpServletRequest.getServletContext()
 * 来源: http://tomcat.apache.org/tomcat-8.5-doc/servletapi/javax/servlet/ServletContext.html
 */
public interface ServletContext{
  /**
  * 获取相对于站点的应用根路径
  * @expamle /app_name
  */
  String getContextPath(); 
  
  /**
  * 获取某个地址所在的ServletContext对象
  * @param uripath 必须以/开头
  */
  ServletContext getContext(String uripath);  

  /**
  * getMajorVersion(): 获取Java Serlet API的大版本号,如3.1就返回3
  * getMinorVersion(): 获取小版本号,如3.1就返回1
  */
  int getMajorVersion();
  int getMinorVersion();

  /**
   * 获取指定资源目录下的所有子目录和子文件
   * @param path 必须以/开头,如果是目录,最好也以/结尾
   */
  Set<String> getResourcePaths(String path);

  /**
   * 根据path,返回一个URL对象
   * @param path 传入的参数必须以/开头
   */
  URL getResource(String path);
  
  /**
   * 获取资源所对应的输入流
   * 使用org.apache.commons.io.IOUtils包下的IOUtils.toString(inputStream, "encoding")可以转化为String
   */
  InputStream getResourceAsStream(String path);
  
   /**
    * 获取指定路径资源的RequestDispatcher对象,从而可以使用该对象的forward()和include()方法
    * @param path 必须以/开头
    */
   RequestDispatcher getRequestDispatcher(String path);

   /**
    * 写入系统日志中
    */
   void log(String msg);
   void log(String msg, Throwable throwable);

   /**
    * 获取资源在相对于文件系统的实际地址
    * 注意:如果应用是从.war文件创建的,可能无法返回null
    */
   String getRealPath(String path)
   
   /**
    * 获取初始化参数
    */
    String getInitParameter(String name);
}
