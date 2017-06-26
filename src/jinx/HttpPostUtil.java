package jinx;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by jinx on 12/13/16.
 */
public class HttpPostUtil {

    public static void main(String[] args) throws IOException {
        String menuStr = "id3=0004a8f3e8bf&devid=020000fffe0002f0&tick=1498023165565&event=0&eventtime=1498022969000";
        String url = "http://carstop.jmwyw.com/event";
        menuStr += "&sign="+get(MD5Test.MD5(menuStr).toLowerCase());
        System.out.println(menuStr);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url+"?"+menuStr);
        post.addHeader("Content-type","application/json; charset=utf-8");
        post.setHeader("Accept", "application/json");
        post.setEntity(new StringEntity("", Charset.forName("UTF-8")));
        HttpResponse response = httpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(jsonStr);


    }

    public static String get(String s){
        System.out.println(s);
        String str = "";
        for(int i = 0;i<s.length();i++){
            String ss = String.valueOf(s.charAt(i));
            if("0".equals(ss)||"9".equals(ss)||"a".equals(ss)){
                str += "b";
            }else{
                str += s.charAt(i);
            }
        }
        System.out.println(str);
        return str;
    }

}
