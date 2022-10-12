package com.spring.aopdemo.aspect;

import com.spring.aopdemo.dto.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,
                                                Throwable theExc) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n======> The Exception is: " + theExc);

    }

    @AfterReturning(
            pointcut = "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,
                                                 List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n======>result is: " + result);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);



    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);

        }
    }


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
