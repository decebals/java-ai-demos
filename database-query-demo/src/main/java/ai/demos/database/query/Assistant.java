package ai.demos.database.query;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
interface Assistant {

    @SystemMessage(fromResource = "system-message.txt")
    String chat(@UserMessage String userMessage, @V("queryResult") String queryResult);

}