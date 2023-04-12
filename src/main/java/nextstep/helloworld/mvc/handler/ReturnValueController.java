package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {


    /**
     * @ResponseBody : Return 값이 response body로 포장되도록 함..
     */
    @GetMapping("/message")
    @ResponseBody
    public String string() {
        return "message";
    }


    @GetMapping("/users")
    @ResponseBody
    public User responseBodyForUser() {
        return new User("name", "email");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @GetMapping("/members")
    public ResponseEntity responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }

    /**
     * Model, thymeleaf 작동 관해서 찾아보기
     * @param model
     * @return resources/templates/sample.html
     */
    @GetMapping("thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "필립");
        return "sample";
    }
}
