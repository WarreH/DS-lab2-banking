package ua.fti.banking.repository;

import java.util.HashMap;

public class AccountRepository {
    private static AccountRepository single_instance = null;

    public HashMap<Integer,Double> balances;

    private AccountRepository()
    {

        balances = new HashMap<>();
    }

    private static synchronized AccountRepository getInstance()
    {
        if (single_instance == null)
            single_instance = new AccountRepository();

        return single_instance;
    }

    public static synchronized Double getBalance(Integer id){
        return getInstance().balances.getOrDefault(id,0.0);
    }

    public static synchronized Double putBalance(Integer id,Double balance){
        return getInstance().balances.put(id,balance);
    }
}