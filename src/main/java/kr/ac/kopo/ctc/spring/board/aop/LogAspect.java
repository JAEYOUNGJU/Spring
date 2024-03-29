package kr.ac.kopo.ctc.spring.board.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Before("execution(* kr.ac.kopo.ctc.spring.board.service.*.*AopBefore(..))")
	public void onBeforeHandler() {
		System.out.println("LogAspect.onBeforeHandler() 핸들러 호출");
	}

	@After("execution(* kr.ac.kopo.ctc.spring.board.service.*.*AopAfter(..))")
	public void onAfterHandler() {
		System.out.println("LogAspect.onAfterHandler() 핸들러 호출");
	}

	@AfterReturning(value = "execution(* kr.ac.kopo.ctc.spring.board.service.*.*AopAfterReturning(..))", returning = "returnValue")
	public void onAfterReturningHandler(Object returnValue) {
		System.out.println("LogAspect.onAfterReturningHandler() 핸들러 호출");
		System.out.println("ReturnValue: " + returnValue);
	}

	@AfterThrowing(value = "execution(* kr.ac.kopo.ctc.spring.board.service.*.*AopAfterThrowing(..))", throwing = "exception")
	public void onAfterThrowingHandler(Exception exception) {
		System.out.println("LogAspect.onAfterThrowingHandler() 핸들러 호출");
		System.out.println("Exception: " + exception.getMessage());
	}

	@Around("execution(* kr.ac.kopo.ctc.spring.board.service.*.*AopAround(..))")
	public void onAroundHandler(ProceedingJoinPoint pjp) {
		System.out.println("LogAspect.onAroundHandler() 핸들러 호출, 시작점");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("LogAspect.onAroundHandler() 핸들러 호출, 끝점");
	}

}
