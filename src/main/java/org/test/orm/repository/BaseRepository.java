package org.test.orm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.test.orm.config.DatabaseConfiguration;
import org.test.orm.model.BaseEntity;
import org.test.orm.model.User;

import java.util.List;

public abstract class BaseRepository<E extends BaseEntity> {

    SessionFactory sessionFactory = DatabaseConfiguration.getSessionFactory();
    String entityName;
    private Class<E> type;
    public BaseRepository(String entityName,Class<E> cls) {
        this.entityName = entityName;
        this.type = cls;
    }

    public void create(E e) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
    }

    public void update(E e,Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        E result = session.load(type, id);
        result = e;
        result.setId(id);
        session.update(result);
        session.getTransaction().commit();
        session.close();
    }

    public E findById(Long id) {
        Session session = sessionFactory.openSession();
        E result = session.load(type, id);
        session.close();
        return result;
    }


    public List<E> findAll(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from " + entityName + " e");
        List list = query.list();
        session.close();
        return list;
    }

    public void delete(Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        E result = session.load(type, id);
        session.delete(result);
        session.getTransaction().commit();
        session.close();
    }
}
