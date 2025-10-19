package com.example.service;

import com.example.model.Reservation;
import com.example.repository.ReservationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private EntityManager entityManager;
    private ReservationRepository reservationRepository;
    public ReservationServiceImpl(EntityManager entityManager, ReservationRepository reservationRepository) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Reservation> findAllPaginated(int page, int size) {
        return reservationRepository.findAllPaginated(page, size);
    }

    @Override
    public long count() {
        return reservationRepository.count();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void save(Reservation salle) {
        reservationRepository.save(salle);

    }

    @Override
    public void update(Reservation reservation) {
        reservationRepository.update(reservation);

    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);

    }
}
