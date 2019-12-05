package dao;

import models.Clients;
import models.Inventory;
import models.Rents;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.time.LocalDate;
import java.util.List;

public class RentsDaoImpl implements RentsDao {

    public List<Rents> showAllRecords() {
        List<Rents> rents = (List<Rents>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Rents").list();
        return rents;
    }



    public Rents getRentById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Rents rent = session.get(Rents.class,id);
        tx.commit();
        session.close();
        return rent;
    }

    public void addRent(int id_client, String firstName, String lastName, int id_item) {
        ClientsDao clientsDAO = new ClientsDaoImp();
        Clients client = clientsDAO.findClientById(id_client);
        if(client == null){
            client = new Clients(firstName, lastName);
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(client);
            tx1.commit();
            session.close();
        }
        InventoryDao inventoryDAO = new InventoryDaoImpl();
        Inventory item = inventoryDAO.getItemById(id_item);
        if(item!=null){
            Rents rent = new Rents(client, item, LocalDate.now());
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(rent);
            tx1.commit();
            session.close();
            System.out.println("Successfully added");
        }else {
            System.out.println("No such item in inventory");
        }
    }

    public void closeRent(int id_rent) {
        Rents rent = getRentById(id_rent);
        if(rent!=null){
            rent.setRentEnd(LocalDate.now());
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(rent);
            tx1.commit();
            session.close();
            System.out.println("Successfully closed");
        }else {
            System.out.println("No such item in inventory");
        }
    }


    public void removeRecord(int id_rent) {
        Rents rent = getRentById(id_rent);
        if(rent!=null){
            rent.setRentEnd(LocalDate.now());
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(rent);
            tx1.commit();
            session.close();
            System.out.println("Record removed");
        }else {
            System.out.println("No such item in inventory");
        }
    }
}
