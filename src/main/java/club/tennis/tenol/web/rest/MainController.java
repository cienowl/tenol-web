package club.tennis.tenol.web.rest;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Hidden
@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {
    private final Environment env;

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        log.info("Server port = {}", request.getServerPort());
        return "Welcome to the tenol service. PORT: " + env.getProperty("server.port");
    }
}
