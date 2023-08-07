package com.CockroachDbIntegration.controllers;


import com.CockroachDbIntegration.entities.ClientData;
import com.CockroachDbIntegration.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class CockroachDb_AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping()
    public List<ClientData> getAllAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Optional<ClientData> getAccountById(@PathVariable long id){
        return accountService.getAccountById(id);
    }

    @PostMapping()
    public ClientData create(@RequestBody ClientData clientData){
        return accountService.create(clientData);
    }

    @DeleteMapping()
    public String delete(@RequestBody ClientData clientData ){
        return accountService.delete(clientData);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable long id , @RequestBody ClientData data){
        return accountService.update(id,data);
    }
}
