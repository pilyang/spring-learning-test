package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
Some example patterns:

- "/resources/ima?e.png" - match one character in a path segment
- "/resources/*.png" - match zero or more characters in a path segment
- "/resources/**" - match multiple path segments
- "/projects/{project}/versions" - match a path segment and capture it as a variable
- "/projects/{project:[a-z]+}/versions" - match and capture a variable with a regex
 */

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> pathVariable(@PathVariable Long id) {
        User user = new User(id, "이름", "email");
        return ResponseEntity.ok().body(user);
    }

    // ?에 해당하는 문자에 접근하는등은 가능한가?
    @GetMapping(value = "/patterns/?")
    public ResponseEntity<String> pattern() {
        return ResponseEntity.ok().body("pattern");
    }

    // 마찬가지로 **에 해당하는 uri값을 받는 방법? 값을 받으려면 @PathParam만 가능?
    @GetMapping(value = "patterns/**")
    public ResponseEntity<String> patternStars() {
        return ResponseEntity.ok().body("pattern-multi");
    }
}
