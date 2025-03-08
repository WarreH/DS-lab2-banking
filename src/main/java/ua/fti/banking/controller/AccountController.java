package ua.fti.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.fti.banking.dto.BalanceDto;
import ua.fti.banking.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/balance/{id}")
    public BalanceDto get(@PathVariable Integer id) {
        double balance = this.accountService.getBalance(id);
        return new BalanceDto(balance);
    }

    @PutMapping("/balance/increase/{id}")
    void increaseBalance(@PathVariable Integer id,@RequestBody BalanceDto balanceDto) {
        this.accountService.updateBalance(id,balanceDto.balance);
    }

    @PutMapping("/balance/decrease/{id}")
    void decreaseBalance(@PathVariable Integer id,@RequestBody BalanceDto balanceDto) {
        this.accountService.updateBalance(id,-balanceDto.balance);
    }

    @PutMapping("/balance/reset/{id}")
    void resetBalance(@PathVariable Integer id) {
        this.accountService.putBalance(id,0);
    }
}