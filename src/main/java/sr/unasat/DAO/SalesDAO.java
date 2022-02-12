package sr.unasat.DAO;

import sr.unasat.entities.Meals;
import sr.unasat.entities.Sales;
import sr.unasat.entities.Service;
import sr.unasat.entities.Users;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class SalesDAO {

    private final EntityManager entityManager;

    public SalesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Sales insert(Sales sales) {
        entityManager.getTransaction().begin();
        entityManager.persist(sales);
        entityManager.getTransaction().commit();
        return sales;
    }

    public List<Meals> findByType(Service service) {
        entityManager.getTransaction().begin();
        String jpql = "select distinct(s.meal) from Sales s  where s.service = :service";
        TypedQuery<Meals> query = entityManager.createQuery(jpql, Meals.class);
        List<Meals> dish = query.setParameter("service", service).getResultList();
        entityManager.getTransaction().commit();
        return dish;
    }

    public List<Long> findTotalByType(Service service) {
        entityManager.getTransaction().begin();
        String jpql = "select count(s.meal) from Sales s  where s.service = :service group by s.meal";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        List<Long> total = query.setParameter("service", service).getResultList();
        entityManager.getTransaction().commit();
        return total;
    }

    public List<Meals> findByDate(LocalDate fromDate, LocalDate toDate) {
        entityManager.getTransaction().begin();
        String jpql = "select distinct(s.meal) from Sales s  where s.date >= :fromdate and s.date <= :to";
        TypedQuery<Meals> query = entityManager.createQuery(jpql, Meals.class);
        List<Meals> dish = query.setParameter("fromdate", fromDate)
                .setParameter("to", toDate).getResultList();
        entityManager.getTransaction().commit();
        return dish;
    }

    public List<Long> findTotalByDate(LocalDate from, LocalDate to) {
        entityManager.getTransaction().begin();
        String jpql = "select count(s.meal) from Sales s  where s.date >= :fromDate and s.date <= :toDate group by s.meal";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        List<Long> total = query.setParameter("fromDate", from)
                .setParameter("toDate", to).getResultList();
        entityManager.getTransaction().commit();
        return total;
    }

    public List<Users> findCustomers() {
        entityManager.getTransaction().begin();
        String jpql = "select distinct(s.user) from Sales s group by s.user";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        List<Users> dish = query.getResultList();
        entityManager.getTransaction().commit();
        return dish;
    }

    public List<Long> findFrequency() {
        entityManager.getTransaction().begin();
        String jpql = "select count(s.user) from Sales s group by s.user";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        List<Long> total = query.getResultList();
        entityManager.getTransaction().commit();
        return total;
    }

}
