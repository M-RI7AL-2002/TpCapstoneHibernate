package com.example.repository;

import com.example.model.Reservation;
import com.example.model.Salle;

import javax.persistence.EntityManager;

import java.util.List;


public class ReservationRepositoryImpl implements ReservationRepository {

    private EntityManager entityManager;

    public ReservationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Reservation> findAllPaginated(int page, int size) {
        // Pagination avec JPA
        return entityManager.createQuery("SELECT s FROM Reservation s ORDER BY s.id", Reservation.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(s) FROM Reservation s", Long.class)
                .getSingleResult();
    }

    @Override
    public Reservation findById(Long id) {
        return entityManager.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> findAll() {
        return entityManager.createQuery("SELECT s FROM Reservation s", Reservation.class)
                .getResultList();
    }

    @Override
    public void save(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        entityManager.merge(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        entityManager.remove(reservation);
    }
}
