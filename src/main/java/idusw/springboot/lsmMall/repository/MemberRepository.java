package idusw.springboot.lsmMall.repository;

import idusw.springboot.lsmMall.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>
       // JpaRepository<MemberEntity, Long> ,
//        QuerydslPredicateExecutor<MemberEntity> {
//    @Query("select m from MemberEntity  m where m.email = :email and m.pw = :pw")
//    Object getMemberEntityById(@Param("id") String id, @Param("pw") String pw);
{

}
