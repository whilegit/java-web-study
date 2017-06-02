/**
 * 
 */
public interface HttpServletResponse{
   /**
    * 获取输出流
    * getOutputStream(): 获取输出字节流，适用于二进制传输
    * getWriter(): 获取输出字符流，适合于文本
    * ServletOutputStream和PrintWriter可以相互转化，中间媒介是OutputStreamWriterget,并注意编码方式
    */
   ServletOutputStream getOutputStream();
   PrintWriter getWriter();

   /**
    * 设置报头
    */
    void setDateHeader(String name, long date);   //设置GMT标准格式的时间字符串,date使用long型的毫秒数
}
