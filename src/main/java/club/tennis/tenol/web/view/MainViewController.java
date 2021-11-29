package club.tennis.tenol.web.view;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Hidden
@Slf4j
@RequiredArgsConstructor
@Controller
public class MainViewController {
    private final Environment env;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(HttpServletRequest request) {
        log.info("Server port = {}", request.getServerPort());
        return "Welcome to the tenol service. PORT: " + env.getProperty("server.port");
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }
}
