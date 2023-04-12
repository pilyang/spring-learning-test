package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/method-argument")
public class MethodArgumentController {

    /**
     * @ModelAttribute 도 동일하게 사용가능해보이기는 함
     * @ModelAttribute
     * - setter를 통해서 mapping을 하고, 그 과정에서 type에 대한 vlidation이 진행된다함
     * - parameter가 여러개일경우 하나의 객체에 한번에 맵핑 가능
     * @RequestParam
     * - 파라미터와 1:1 맵핑
     *
     * ex)
     * 요청이 "/method-argument/users?name=test&email=testmail"과 같은 경우
     * requestParam(@ModelAttribute User user)와 같이 받기 가능 (단 User에 getter가 있어야함)
     */

    @GetMapping("/users")
    public ResponseEntity<List<User>> requestParam(@RequestParam("name") String userName) {
        List<User> users = Arrays.asList(
                new User(userName, "email"),
                new User(userName, "email")
        );
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users/body")
    public ResponseEntity requestBody(@RequestBody User user) {
        User newUser = new User(1L, user.getName(), user.getEmail());
        return ResponseEntity.created(URI.create("/users/" + newUser.getId())).body(newUser);
    }

}
