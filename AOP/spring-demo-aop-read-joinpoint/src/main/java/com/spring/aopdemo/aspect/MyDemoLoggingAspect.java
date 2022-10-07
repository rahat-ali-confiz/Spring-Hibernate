package com.spring.aopdemo.aspect;

import com.spring.aopdemo.dto.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.spring.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " +methodSignature);

        // display the arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object tempArg : args){
            System.out.println(tempArg);

            if (tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account account = (Account) tempArg;

                System.out.println("account name: "+ account.getName());
                System.out.println("account level: "+ account.getLevel());
            }
        }

    }


}
