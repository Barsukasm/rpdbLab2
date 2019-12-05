package dao;

import models.Rents;

import java.util.List;

public interface RentsDao {
    public List<Rents> showAllRecords();
    public Rents getRentById(int id);
    public void addRent(int id_client, String firstName, String lastName, int id_item);
    public void closeRent(int id_rent);
    public void removeRecord(int id_rent);
}
