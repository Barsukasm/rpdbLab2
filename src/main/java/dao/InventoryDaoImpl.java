package dao;

import models.Inventory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class InventoryDaoImpl implements InventoryDao {

    public Inventory getItemById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Inventory.class,id);
    }

    public void addItem(Inventory item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(item);
        tx1.commit();
        session.close();
    }

    public List<Inventory> showAge() {
        List<Inventory> items = (List<Inventory>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Inventory as inv" +
                " order by inv.dateProd asc").list();
        return items;
    }


    public List<Inventory> showInventory() {
        List<Inventory> items = (List<Inventory>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Inventory").list();
        return items;
    }


    public List<Inventory> search(int size, String type) {
        String query;
        if(size>0){
            query = "from Inventory as inv where inv.type like '%" + type + "%' and inv.size="+size;
        } else {
            query = "from Inventory as inv where inv.type like '%" + type + "%'";
        }
        List<Inventory> items = (List<Inventory>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
        return items;
    }
}
