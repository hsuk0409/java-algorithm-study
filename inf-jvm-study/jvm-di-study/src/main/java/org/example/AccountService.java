package org.example;

import com.jvm.study.di.Inject;

public class AccountService {
    @Inject AccountRepository accountRepository;

    public void join() {
        System.out.println("Service.join!!");
        accountRepository.save();
    }
}
