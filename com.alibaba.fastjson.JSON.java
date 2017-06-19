package demo.fastjson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * fastjson
 * Maven:
 *     <dependency>
 *         <groupId>com.alibaba</groupId>
 *         <artifactId>fastjson</artifactId>
 *         <version>1.2.33</version>
 *     </dependency>
 *
 * github:
 *    https://github.com/alibaba/fastjson
 *
 */
public class App{
    /**
     * 纯json解码,不涉及重构对象
     * {
     *     "one": "1",
     *     "two": "2",
     *     "three": 3,
     * }
     * @return 返回一个Map<String, Object>对象
     */
    private static Map<String, Object> map_decode(){
        String jsonStr = "{\"one\":\"1\",\"two\":\"2\",\"three\":3}";
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        @SuppressWarnings("unchecked")
        Map<String, Object> map = JSONObject.toJavaObject(jsonObj, Map.class);
        return map;
    }

    /**
     * json数组解码, 数组元素对应一个对象 User(User类遵循JavaBean规范)
     * [
     *     {
     *         "uid": 1,
     *         "user_name":"foo"
     *     },
     *     {
     *         "uid":2,
     *         "user_name":"bar"
     *     }
     * ]     
     */
    private static List<User> array_decode(){
        String jsonStr = "[{\"uid\":1,\"user_name\":\"foo\"},{\"uid\":2,\"user_name\":\"bar\"}]";
        List<User> lst = JSONObject.parseArray(jsonStr, User.class);
        return lst;
    }

    /**
     * json解码, 对象解码(Group类是标准的JavaBean,其中users类型为List<User> 
     * {
     *     "groupId":1,
     *     "groupName": "Lin's",
     *     "users":[
     *        {"uid":10086,"user_name":"cm"},
     *        {"uid":10000,"user_name":"ct"}
     *     ]
     * }
     */
    private static Group object_decode(){
        String jsonStr = "....."; //注释的json字符串
        Group grp = JSON.parseObject(jsonStr, Group.class);
        return grp;
    }

    /*
     * json编码
     */
    private static void json_encode(){
        Group grp = object_decode();
        String jsonStr = JSON.toJSONString(grp);
        System.out.println(jsonStr);
    }

}
