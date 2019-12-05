package dao;

import models.Inventory;

import java.util.List;

public interface InventoryDao {
    public Inventory getItemById(int id);
    public void addItem(Inventory item);
    public List<Inventory> showInventory();
    public List<Inventory> showAge();
    public List<Inventory> search(int size, String type);
}
