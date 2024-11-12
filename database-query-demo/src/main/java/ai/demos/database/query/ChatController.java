package ai.demos.database.query;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    private final Assistant assistant;
    private final Parser parser;
    private final HtmlRenderer renderer;
    private final DatabaseService databaseService;
    private final QueryAssistant queryAssistant;

    ChatController(Assistant assistant, QueryAssistant queryAssistant, DatabaseService databaseService) {
        this.assistant = assistant;
        this.queryAssistant = queryAssistant;
        this.databaseService = databaseService;
        this.parser = Parser.builder().build();
        this.renderer = HtmlRenderer.builder()
                .escapeHtml(false)
                .build();
    }

    @GetMapping("")
    public String home() {
        return "index";
    }

    @HxRequest
    @PostMapping("/api/chat")
    public HtmxResponse generate(@RequestParam String message, Model model) {
        log.info("User Message: {}", message);
        String sqlQuery = queryAssistant.chat(message);
        log.info("sql = {}", sqlQuery);

        String queryResult = databaseService.executeQuery(sqlQuery);
        String response = assistant.chat(message, queryResult);

        return createHtmxResponse(message, model, response);
    }

    private HtmxResponse createHtmxResponse(String message, Model model, String response) {
        Node document = parser.parse(response);
        String htmlResponse = renderer.render(document);
        log.info("htmlResponse = {}", htmlResponse);

        model.addAttribute("response", htmlResponse);
        model.addAttribute("message", message);

        return HtmxResponse.builder()
                .view("response :: responseFragment")
                .view("recent-message-list :: messageFragment")
                .build();
    }

}
