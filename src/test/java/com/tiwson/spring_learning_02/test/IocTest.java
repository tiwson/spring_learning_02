package com.tiwson.spring_learning_02.test;

import com.tiwson.spring_learning_02.bean.Account;
import com.tiwson.spring_learning_02.service.AccountService;
import com.tiwson.spring_learning_02.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IocTest {

    //传统mvc开发方式
    @Test
    public void run1() {
        AccountService accountservice = new AccountServiceImpl();
        List<Account> list = accountservice.getAccount();
        for (Account account:list
             ) {
            System.out.println("id:" + account.getId());
            System.out.println("name:" + account.getName());
            System.out.println("money:" + account.getMoney());
        }
    }

    //spring的IOC容器开发方式
    @Test
    public void run2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountServiceImpl)ac.getBean("accountService");
        List<Account> list = accountService.getAccount();

        for (Account account:list
        ) {
            System.out.println("id:" + account.getId());
            System.out.println("name:" + account.getName());
            System.out.println("money:" + account.getMoney());
        }
    }
}
