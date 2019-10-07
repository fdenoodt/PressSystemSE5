package be.springPressOrder.services;

import be.springPressOrder.dao.PersonsRepository;
import be.springPressOrder.domain.Client;
import be.springPressOrder.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private PersonsRepository personsRepository;

    @Autowired
    public void setPersonRepository(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @Override
    public Client getClientByUsername(String username) {
        return (Client)personsRepository.findOne(username);
    }

    @Override
    public Client saveClient(Client client) {
        return personsRepository.save(client);
    }

    @Override
    public void deleteClient(String username) {
        personsRepository.delete(username);
    }
}
