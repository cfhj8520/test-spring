package test.testspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.testspring.repository.JdbcMemberRepository;
import test.testspring.repository.JdbcTemplateMemberRepository;
import test.testspring.repository.MemberRepository;
import test.testspring.repository.MemoryMemberRepository;
import test.testspring.service.MemberService;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
