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

    @Bean //메서드이름이 스프링 컨테이너에 등록됨
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }  //서비스 구현

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }  //저장소 구현

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }  //오더서비스는 멤버저장소를 가져오고 할인정책불러오기

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }  //할인 정책은 원하는 할인 정책으로 고치만 하면됨

}
