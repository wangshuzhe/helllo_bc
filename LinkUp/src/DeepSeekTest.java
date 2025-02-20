import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencentcloudapi.common.AbstractModel;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.SSEResponseModel;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.lkeap.v20240522.LkeapClient;
import com.tencentcloudapi.lkeap.v20240522.models.*;

import java.util.Scanner;
      
public class DeepSeekTest {
    public static void main(String[] args) {
        // 初始化账号Credential，入参需要传入腾讯云账户密钥对。
        Credential cred = new Credential("secretId", "secretKey");
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("lkeap.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        LkeapClient client = new LkeapClient(cred, "ap-guangzhou", clientProfile);
        ChatCompletionsRequest request = new ChatCompletionsRequest();
        request.setModel("deepseek-r1");
        Message[] messages1 = new Message[1];
        System.out.println("请输入问题：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        getRespone(client, request, messages1, s);

    }

    public static void getRespone(LkeapClient client, ChatCompletionsRequest request, Message[] mes, String content) {
        Message message = new Message();
        message.setRole("user");
        message.setContent(content);
        mes[0] = message;
        request.setMessages(mes);
        request.setStream(true);
        request.setTemperature(0.6F);
        request.setMaxTokens(500L);
        try {
            ChatCompletionsResponse response = client.ChatCompletions(request);
            if (response.isStream()) {
                for (SSEResponseModel.SSE e : response) {
                    if ("[DONE]".equalsIgnoreCase(e.Data)){
                        System.out.println("\n回答结束");
                        break;
                    }
                    JSONObject jsonObject = JSON.parseObject(e.Data);
                    ResponseDTO responseDTO = jsonObject.toJavaObject(ResponseDTO.class);
                    if (null != responseDTO.getChoices()) {
                        responseDTO.getChoices().forEach(choices -> {
                            if (choices.getDelta().getReasoningContent() != null) {
                                System.out.print(choices.getDelta().getReasoningContent());
                            }
                        });
                    }
                }
            } else {
                System.out.println(AbstractModel.toJsonString(response));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
