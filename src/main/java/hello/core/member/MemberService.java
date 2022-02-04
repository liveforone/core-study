package hello.core.member;

public interface MemberService {

    void join(Member member);  //회원 가입

    Member findMember(Long MemberId);  //회원 조회
}
