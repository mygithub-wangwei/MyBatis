package com.dqsy.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 基于xml的配置切面
 * @author lenovo
 *
 */
public class MyAspect {
	//定义前置通知
	public void beforAdvice(){
		System.out.println("前置通知----在方法执行前运行");
	}
	//后置通知
	public void afterAdvice(){
		System.out.println("后置通知----在方法执行后运行");
	}
	//后置通知,含返回值
	public void afterAdvice(Object result){
		System.out.println("后置通知----在方法执行后运行,带返回值:"+result);
	}
	//环绕通知
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕通知,在方法执行的前运行");
		/**
		 * 这个表示目标方法的运行
		 */
		pjp.proceed();
		System.out.println("环绕通知,在方法执行之后运行");
	}
	//异常通知
	public void afterThrowingAdvice(Exception ex){
		System.out.println("异常通知"+ex.toString());
	}
	//最终通知
	public void finalAdvice(){
		System.out.println("最终通知");
	}
}
