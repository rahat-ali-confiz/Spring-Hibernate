package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all our related advices for logging

    // let's start with a @Before advice

    @Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    // create pointCut for getter methods
    @Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create pointCut for setter methods
    @Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}



    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

}
