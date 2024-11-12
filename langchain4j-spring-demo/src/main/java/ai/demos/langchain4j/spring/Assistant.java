package ai.demos.langchain4j.spring;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
interface Assistant {

    @SystemMessage(fromResource = "system-message.txt")
    String chat(String userMessage);

}