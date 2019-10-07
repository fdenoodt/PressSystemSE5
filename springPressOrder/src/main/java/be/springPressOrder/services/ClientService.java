package be.springPressOrder.services;

import be.springPressOrder.domain.Client;

public interface ClientService {
        Client getClientByUsername(String username);

        Client saveClient(Client client);

        void deleteClient(String username);
}