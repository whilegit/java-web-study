package demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class App{
    public static void main( String[] args ) throws IOException, TemplateException
    {
        // 生成Freemarker的配置器,指明版本号
        Configuration conf = new Configuration(Configuration.VERSION_2_3_26);
        // 获取模版文件存放的根目录. 一般是存在src/main/resources上,并新建templates目录
        String tplRoot = App.class.getClassLoader().getResource("templates").getPath();
        conf.setDirectoryForTemplateLoading(new File(tplRoot));
        conf.setDefaultEncoding("UTF-8");
        /* 四个异常处理器:HTML_DEBUG_HANDLER(用于HTML调试)  DEBUG_HANDLER(用于非HTML调试) 
                          IGNORE_HANDLER(忽略异常,继续执行)  RETHROW_HANDLER(向上抛出异常,适合生产环境)*/
        conf.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
        // 不在Logger中记录异常信息
        conf.setLogTemplateExceptions(false);

        // 准备数据模型(Date-Model), 必须实现Map接口
        Map<String,Object> root = new HashMap<String,Object>();
        root.put("user","Big Joe");
        // 获得Template实例,准备绑定数据模型和输出
        Template tpl = conf.getTemplate("test.html");
        // 输出到文本
        FileOutputStream fos = new FileOutputStream(new File("path/to/output"));
        Writer out = new OutputStreamWriter(fos);
        /* 输出到System.out
           Writer out = new OutputStreamWriter(System.out);
           输出到浏览器
           PrintWriter pw = response.getWriter();

         */
        tpl.process(root, out);
        out.close();
        fos.close();
    }

}
