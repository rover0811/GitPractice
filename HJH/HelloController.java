package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 웹에서 /hello 라고 들어오면 이 메소드가 호출된다
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");   // key:data , value:hello
        return "hello"; // 기본적으로 스프링이, resources 의 templates폴도 밑의 hello 파일를 찾아서 랜더링 하게 된다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // http 에서의 바디부에 return의 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;    // hello spring (name을 spring으로 하면)
    }
    // API가 위의 MVC와 다른점은 소스코드를 웹에 내려가는게 아니라, 그냥 그대로 내려간다

    // 지금부터 API 진짜 - 데이터를 내놓으라고 할 때
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // 문자가 아니라 객체를 반환할 때 - 디폴트가 json 방식으로 데이터를 만들어서 http 응답에 반환하겠다는게 기본임
    }
    // 결과가 json 방식으로 나온
    // {"name":"spring!!"}
    // json 방식 - 키 벨류로 이루어진 데이터 구조 ( 최근에 이걸로 자리잡음, 과거에는 xml과 경쟁 )
    static class Hello{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

