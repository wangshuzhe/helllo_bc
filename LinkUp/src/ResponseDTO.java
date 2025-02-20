import lombok.Data;

import java.util.List;
@Data
public class ResponseDTO {
    @Data
    static class Choices {
        private Delta Delta;
        private String Index;
    }
    @Data
    static class Delta {
        private String ReasoningContent;
        private String Role;
    }
    @Data
    static class Usage {
        private String CompletionTokens;
        private String PromptTokens;
        private String TotalTokens;
    }
    private List<Choices> Choices;
    private String Created;
    private String Id;
    private String Model;
    private String Object;
    private Usage Usage;

}


