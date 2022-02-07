package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        /*AppConfig에 등록된 Bean을 스프링 컨테이너에 넣어 관리 해줌*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        /*Bean을 가져올때(get)는 메서드 이름을 써주고 클래스를 적어준다.*/
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

/*
전통적인 자바 코드만으로 테스트를 작성.. 하지만 너무나도 귀찮고 약간 복잡. 터미널에서 하나하나 내가 다 분석해야하는
문제점이 발생
 */