package ai.demo.langchain4j.spring.demo;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
interface Assistant {

    @SystemMessage(fromResource = "system-message.txt")
    String chat(String userMessage);

}