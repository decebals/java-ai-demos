package ai.demos.database.query;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
interface QueryAssistant {

    @SystemMessage(fromResource = "query-message.txt")
    String chat(String userMessage);

}