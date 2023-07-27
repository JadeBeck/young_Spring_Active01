package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();  //왜 굳이 아이디만 불러옴? 커맨드랑 쿼리랑 분리하자는 원칙. 저장 후 리턴값 거의 없이 아이디만 조회하게끔.
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }


}
