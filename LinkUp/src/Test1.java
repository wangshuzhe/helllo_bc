import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    @Test
    public void test1(){
        System.out.println("test1");
    }

    public static void main(String[] args) {
        try {
            // 创建 HttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // 创建 GET 请求
            HttpPost request = new HttpPost("https://wkbrs1.tingyun.com/action?url=https%3A%2F%2Fwenku.csdn.net%2Fanswer%2F1vch76ak9n&pvid=2c81d6a713df435fb2970feacf7c4ee1&ref=https%3A%2F%2Fwenku.csdn.net%2Fanswer%2F1vch76ak9n&referrer=https%3A%2F%2Fcn.bing.com%2F&v=3.3.1-saas.2&av=3.3.1-saas.2&did=10_35240375840-1736999603320-549393&uid=weixin_45170594&sid=8bc7f347326b49f5b100ced39eae2310&__s=1737191443664&id=oxCR3HG3rnM&key=jcyC7WVM7Ho&token=8399f6662a2747fc872cacd390930886&sh=982&sw=1512&ps=1&__r=1737191450281");
            Map<String, Object> map  = new HashMap<>();
            request.setHeader("Content-Type", "application/json");
            map.put("id", "1");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(map);
            System.out.println(json);
            request.setEntity(new StringEntity(json));
            // 发送请求并获取响应
            HttpResponse response = httpClient.execute(request);
            // 解析响应
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + jsonResponse);

            // 关闭 HttpClient
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
