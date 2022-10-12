package com.spring.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create pointCut for getter methods
    @Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create pointCut for setter methods
    @Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
