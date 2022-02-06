package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach  //이 구문이 먼저 실행되고 아래 테스트가 돌아감
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();  //AppConfig를 만듦
        memberService = appConfig.memberService();  //멤버 서비스를 위의 객체에 할당해준 후에 아래 테스트가 실행
    }

    @Test
    void join() {
        //given -> ~가 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when -> ~게 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then -> ~게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
