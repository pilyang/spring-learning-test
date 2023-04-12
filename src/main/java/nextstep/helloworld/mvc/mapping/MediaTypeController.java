package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/media-type")
public class MediaTypeController {

    // consume과 Header의 Content-Type을 비교
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        Long id = 1L;
        return ResponseEntity.created(URI.create("/users/" + id)).build();
    }

    /*
    Header의 Accept=~~ 에 따라서 이에 해당하는 produce를 가지고 있는 api를 맵핑해준다
     */
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> showUser() {
        List<User> users = Arrays.asList(
                new User("이름", "email"),
                new User("이름", "email")
        );
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/users", produces = MediaType.TEXT_HTML_VALUE)
    public String userPage() {
        return "user page";
    }
}
