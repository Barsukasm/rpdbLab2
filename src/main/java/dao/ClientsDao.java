package dao;

import models.Clients;

import java.util.List;

public interface ClientsDao {
    public void addClient(Clients client);
    public Clients findClientById(int id);
    public List<Clients> showAllClients();
}
