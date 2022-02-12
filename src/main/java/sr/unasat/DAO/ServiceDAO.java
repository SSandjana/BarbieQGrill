package sr.unasat.DAO;

import sr.unasat.entities.Meals;
import sr.unasat.entities.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ServiceDAO {

    private EntityManager entityManager;

    public ServiceDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Service insert(Service service) {
        entityManager.getTransaction().begin();
        entityManager.persist(service);
        entityManager.getTransaction().commit();
        return service;
    }

    public Service findService(String service) {
        entityManager.getTransaction().begin();
        String jpql = "select s from Service s  where s.type = :service";
        TypedQuery<Service> query = entityManager.createQuery(jpql, Service.class);
        Service serviceResult = query.setParameter("service", service).getSingleResult();
        entityManager.getTransaction().commit();
        return serviceResult;
    }

}
