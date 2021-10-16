package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {
    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("api/lombok")
    public String lombokTest(){

//        Member m = new Member(1,"ssar","1234","david@netsbridge.com");
        Member m = Member.builder().username("ssar").password("1234").email("kk@naver.com").build();
        System.out.println(TAG + "getter : " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "getter : " + m.getUsername());
        return "lombok test 완료";
    }

    @GetMapping("api/get")
   /* public String getTest(@RequestParam int id, @RequestParam String username){
        return "get 요청 " + id + " " + username;
    }*/
    public String getTest(Member m){

        return "get 요청 " + m.getId() + " " + m.getUsername();
    }

    @PostMapping("api/post")
    public String postTest(@RequestBody Member member){ // MessageConverter에 의해 HTTP Body 를 통해 전달된 값들을 정의된 class (model이라고 부른다)에 자동으로 할당
        return "post 요청: " + member.getId() + ", " + member.getUsername() + ", " + member.getEmail();
    }

    @PutMapping("api/put")
    public String putTest(@RequestBody Member member){
        return "put 요청" + member.getId() + ", " + member.getPassword();
    }

    @DeleteMapping("api/delete")
    public String deleteTest(){
        return "delete 요청";
    }

}
