package com.gdu.app13.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component 
@EnableAspectJAutoProxy
@Aspect 
public class RequiredLoginAspect {

		// aop가 동작하기 위해서는 만들고 @컴포넌트 등록하고 해당 컴포넌트 동작시키는 @EnableAspcetJAutoProxy가 필요하다
		// aspect가 Controller의 메소드들(?) 요청들(?)을 인식해서 자동으로 실행시켜주는애
		// 모든 컨트롤러에 requiredLogin_이 붙어있는 애들을 인식해서 로그인이 안되어있으면 로그인하라고 시킴
		@Pointcut("execution(* com.gdu.app13.controller.*Controller.requiredLogin_*(..))")
		public void requiredLogin() { }
			
		@Before("requiredLogin()")  // 포인트컷 실행 전에 requiredLogin() 메소드 수행
		public void requiredLoginHandler(JoinPoint joinPoint) throws Throwable {
			
			// 로그인이 되어 있는지 확인하기 위해서 session이 필요하므로,request가 필요하다
			// 응답을 만들기 위해서 response도 필요하다
			ServletRequestAttributes servletWebRequest = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = servletWebRequest.getRequest();
			HttpServletResponse response = servletWebRequest.getResponse();

			
			// 세션
			HttpSession session = request.getSession();
			
			// 로그인 여부 확인
			if(session.getAttribute("loginUser") == null) {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("if(confirm('로그인이 필요한 기능입니다. 로그인 하시겠습니까?')){");
				out.println("location.href='" + request.getContextPath() + "/user/login/form';");
				out.println("} else {");
				out.println("history.back();");
				out.println("}");			
				out.println("</script>");
				out.close();
				
			}	
			
		}
		
	}