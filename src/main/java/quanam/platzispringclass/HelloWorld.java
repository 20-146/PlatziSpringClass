package quanam.platzispringclass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorld {

    @GetMapping("/pintar")
    public String pintar(){
        return "Hello World of JAVA!!!";
    }
}
