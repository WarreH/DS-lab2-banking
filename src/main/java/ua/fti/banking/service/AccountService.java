package ua.fti.banking.service;

import org.springframework.stereotype.Service;
import ua.fti.banking.repository.AccountRepository;

@Service
public class AccountService {
    public Double getBalance(int id){
        return AccountRepository.getBalance(id);
    }

    public void updateBalance(int id, double amount){
        double oldAmount = AccountRepository.getBalance(id);
        double newAmount = oldAmount + amount;
        AccountRepository.putBalance(id,newAmount);
    }

    public void putBalance(int id, double amount){
        AccountRepository.putBalance(id,amount);
    }



}
