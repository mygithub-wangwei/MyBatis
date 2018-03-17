package com.dqsy.spring.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
/**
 * 定义通知，基于XML配置的方式
 * @author Administrator
 *
 */
public class MyAspect {
	 //定义前置通知
	public void beforeAdvice(){
		System.out.println("前置通知，方法之前运行");
	}
	 // 后置通知
	public void afterAdvice(){
		System.out.println("后置通知，方法之后运行");
	}
	 //定义后置通知，含返回值
	public void afterAdvice(Object result){
		System.out.println("后置通知，方法之后运行，带返回值  ： " + result);
	}
	 // 定义环绕通知
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕通知，方法之前运行");
		 //这个表示目标对象的方法的运行
		pjp.proceed();
		System.out.println("环绕通知，方法之后运行");
	}
	 //定义异常通知
	public void afterThrowingAdvice(){
		System.out.println("异常通知");
	}
	 //定义异常通知
	public void afterThrowingAdvice(Exception ex){
		System.out.println("异常通知 " + ex.toString());
	}
	 // 最终通知
	public void lastAdvice(){
		System.out.println("最终通知");
	}
}
