package com.gdu.app08.config;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;



/*
  @@EnableTransactionManagement
  
  안녕 난 트랜잭션매니저를 허용하는 애너테이션이야!
  
 */

@EnableTransactionManagement
@Configuration
public class DBConfig {

	
	// SpringJDbc 처리를 위한 DriverMAnagerDataSource와 JdbcTemplate을 Bean으로 등록한다.
	
	@Bean
	public DriverManagerDataSource dataSource() {
		   DriverManagerDataSource dataSource = new DriverManagerDataSource();
		      dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		      dataSource.setUsername("SCOTT");
		      dataSource.setPassword("TIGER");
		      return dataSource;
		   }
		   
		   @Bean
		   public JdbcTemplate jdbcTemplate() {
			   return new JdbcTemplate(dataSource()); //dataSource()의존 관계 처리

	}
		   
	// 트랜잭션 처리를 위한 TransactionManager를 Bean으로 등록한다
	@Bean
	public TransactionManager transactionManamger() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	// 트랜잭션 인터셉터를 Bean으로 등록한다
	
	@Bean
	public TransactionInterceptor transactionInterceptor() {
		
		// 모든 Exception이 발생하면 Rollback을 수행하시오
		RuleBasedTransactionAttribute attribute= new RuleBasedTransactionAttribute();
		attribute.setName("*");
		attribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		
		
		MatchAlwaysTransactionAttributeSource source=new MatchAlwaysTransactionAttributeSource();
		source.setTransactionAttribute(attribute);
		
		return new TransactionInterceptor(transactionManamger(), source);
		
	}
	
	// 트랜잭션 인터셉터를 Advice로 등록하는 Advisor를 Bean으로 등록한다.
	
	@Bean
	public Advisor advisor() {
		
		/*
        AOP 기본 용어
        1. 조인포인트 : AOP를 동작시킬 수 있는 메소드 전체       (목록, 상세, 삽입, 수정, 삭제 메소드)
        2. 포인트컷   : 조인포인트 중에서 AOP를 동작시킬 메소드 (삽입, 수정, 삭제 메소드)
        3. 어드바이스 : 포인트컷에 동작시킬 AOP 동작 자체       (로그, 트랜잭션 등)
		 */
		
		
		// 언제 Advice를 동작시킬 것인가?
		// 포인트컷(Point)컷을 결정해야 한다.
		
		// 포인트컷 표현식
		/*
		 
		 	1. 기본형식
		 		executoin(리턴타입 패키지.클래스.메소드(매개변수))
		 		
		 	2. 의미
		 		1) 리턴타입
		 			(1) * (모든 반환타입)
		 			(2) void
		 			(3) !void
		 			
		 		2) 매개변수
		 			(1) .. (모든 매개변수)
		 			(2)	* ( 1개의 모든 매개변수)
		 			(3)
		  
		 */
		
		AspectJExpressionPointcut pointCut =new AspectJExpressionPointcut();
		pointCut.setExpression("executoin(* com.gdu.app08.service.*Impl.*Transaction(..))");
		
		
		return new DefaultPointcutAdvisor(pointCut, transactionInterceptor());
		
		
	}
	
	
}
