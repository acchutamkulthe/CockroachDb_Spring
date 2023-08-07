package com.CockroachDbIntegration.services;

import com.CockroachDbIntegration.entities.ClientData;
import com.CockroachDbIntegration.exceptions.ResourceNotFoundException;
import com.CockroachDbIntegration.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private ClientRepository repository;
    @Override
    public List<ClientData> getAccounts() {
        return repository.findAll();
    }

    @Override
    public Optional<ClientData> getAccountById(long id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found for given id:" + id)));
    }

    @Override
    public ClientData create(ClientData clientData) {
        return repository.save(clientData);
    }

    @Override
    public String delete(ClientData clientData) {
        repository.delete(clientData);
        return "Successfully removed the record ";
    }
    @Override    public String update(long id , ClientData clientData){
      repository.update(clientData.getUsername(),clientData.getSurname(),clientData.getFirstname(),id);
      return "Updated successfully";
    }
}
