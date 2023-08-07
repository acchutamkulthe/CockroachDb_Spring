package com.CockroachDbIntegration.services;



import com.CockroachDbIntegration.entities.ClientData;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    List<ClientData> getAccounts();

    Optional<ClientData> getAccountById(long id);

    ClientData create(ClientData clientData);

    String delete(ClientData clientData);

    String  update(long id , ClientData clientData );
}
