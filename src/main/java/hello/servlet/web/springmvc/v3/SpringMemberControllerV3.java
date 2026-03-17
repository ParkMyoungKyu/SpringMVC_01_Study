package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Model 적용
 * ViewName을 직접 반환
 * @RequestParam 사용
 * -> request.getParameter() 와 동일한 기능
 * @GetMapping , @PostMapping 사용
 * -> @RequestMapping을 메소드와 함께 사용하는 편리한 방법
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "save-result";
    }

    @GetMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
