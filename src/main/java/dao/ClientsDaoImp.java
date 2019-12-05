package dao;

import models.Clients;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ClientsDaoImp implements ClientsDao {

    public void addClient(Clients client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(client);
        tx1.commit();
        session.close();
    }


    public Clients findClientById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Clients.class, id);
    }


    public List<Clients> showAllClients() {
        List<Clients> clients = (List<Clients>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Clients").list();
        return clients;
    }
}
