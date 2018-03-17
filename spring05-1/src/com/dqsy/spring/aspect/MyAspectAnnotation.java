package com.dqsy.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class MyAspectAnnotation {
	//定义前置通知
		@Before(value="execution(* add*(..))")
		public void beforeAdvice(){
			System.out.println("前置通知，方法之前运行");
		}
		 // 后置通知
		@AfterReturning(value="execution(* update*(..))")
		public void afterAdvice(){
			System.out.println("后置通知，方法之后运行");
		}
		 //定义后置通知，含返回值
		@AfterReturning(value="execution(* update*(..))", returning="result")
		public void afterAdvice(Object result){
			System.out.println("后置通知，方法之后运行，带返回值  ： " + result);
		}
		 // 定义环绕通知
		@Around(value="execution(* get*(..))")
		public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
			System.out.println("环绕通知，方法之前运行");
			 //这个表示目标对象的方法的运行
			pjp.proceed();
			System.out.println("环绕通知，方法之后运行");
		}
		 //定义异常通知
		@AfterThrowing(value="execution(* delete*(..))")
		public void afterThrowingAdvice(){
			System.out.println("异常通知");
		}
		 //定义异常通知
		@AfterThrowing(value="execution(* delete*(..))", throwing="ex")
		public void afterThrowingAdvice(Exception ex){
			System.out.println("异常通知 " + ex.toString());
		}
		 // 最终通知
		@After(value="execution(* delete*(..))")
		public void lastAdvice(){
			System.out.println("最终通知");
		}
}
