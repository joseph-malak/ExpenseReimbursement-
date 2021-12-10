import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FinancialManagerDao implements DAO<FinancialManager> {

    Configuration cfg;
    SessionFactory sessionFactory;

    FinancialManagerDao () {

        // Create Configuration Object
        cfg = new Configuration();

        // read the configuration and load the
        cfg.configure("hibernate.cfg.xml");

        // create the factory
        sessionFactory = cfg.buildSessionFactory();

    }

    @Override
    public void insert(FinancialManager financialManager) {
        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        // hibernate save to the database
        session.save(financialManager);

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

    }

    @Override
    public FinancialManager readById(int financialManagerId) {
        return null;
    }

    @Override
    public List<FinancialManager> readAll() {

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM FinancialManager";
        Query query = session.createQuery(hql);
        List<FinancialManager> results = query.list();

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return results;
    }

    @Override
    public void update(FinancialManager financialManager) {

    }

    @Override
    public void delete(FinancialManager financialManager) {

    }

    public boolean login(FinancialManager financialManager) {

        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM FinancialManager WHERE username=:currusername AND password=:currpassword";
        Query query = session.createQuery(hql);
        query.setParameter("currusername", financialManager.getUsername());
        query.setParameter("currpassword", financialManager.getPassword());
        FinancialManager result = (FinancialManager)query.uniqueResult();

        boolean flag = false;
        if (result == null) {
            flag = false;
        }
        else if(financialManager.getUsername().equals(result.getUsername()) && financialManager.getPassword().equals(result.getPassword())) {
            flag = true;
        }

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return flag;
    }

    public void logout(FinancialManager financialManager) {

    }

    public FinancialManager getFinancialManagerByUsernamePassword(String username, String password) {
        // open the session
        Session session = sessionFactory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM FinancialManager WHERE username=:currusername AND password=:currpassword";
        Query query = session.createQuery(hql);
        query.setParameter("currusername", username);
        query.setParameter("currpassword", password);
        FinancialManager financialManager = (FinancialManager) query.uniqueResult();

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return financialManager;
    }


}
