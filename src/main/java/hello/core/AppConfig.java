package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //구성하는 클래스에는 해당 어노테이션을 붙여주어야한다.
public class AppConfig {

    //@Bean -> memberService -> new MemoryMemberRepository()
    //@Bean -> orderService -> new MemoryMemberRepository()

    //예상한 결과
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //예상과 다르게 결과는 아래와 같다. 즉, 스프링이 싱글톤을 지켰다.
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //memberRepository가 여러번 출력되지 않은 이유는 이미 존재하는 스프링 빈이기 때문에
    //스프링이 한 번만 반환하기 때문이다. 이러한 이유로 싱글톤이 보장된다.

    @Bean //메서드이름이 스프링 컨테이너에 등록됨
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }  //서비스 구현

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }  //저장소 구현

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }  //오더서비스는 멤버저장소를 가져오고 할인정책불러오기

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }  //할인 정책은 원하는 할인 정책으로 고치만 하면됨

}
