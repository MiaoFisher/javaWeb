package com.spring01.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
//添加动态代理的注解

/**
 * User类的增强类
 */
@Component
@Aspect
public class UserProxy {
    /**
     * 抽取切入点
     */
    //"executio...n(* com.spring01.aop.anno.User.add(..))"
    @Pointcut(value = "execution(* com.spring01.aop.anno.User.add(..))")
    public void pointCut(){
        
    }
    /**
     * 前置通知
     */
    @Before(value = "pointCut()")
    public void before(){
        System.out.println("in before .....");
    }
    /**
     * 最终通知（最终通知，无论是被增强的方法是否成功执行都会执行）
     */
    @After(value = "pointCut()")
    public void after(){
        System.out.println("in after .....");
    }
    /**
     * 返回通知（后置通知，只有成功执行了方法才会执行）
     */
    @AfterReturning(value = "pointCut()")
    public void afterReturning(){
        System.out.println("in afterReturning .....");
    }
    /**
     * 异常通知（有异常的时候才会通知）
     */
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(){
        System.out.println("in afterThrowing .....");
    }
    /**
     * 环绕通知
     */
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知之前 .....");
        //执行被环绕的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知之后 .....");
    }
}
