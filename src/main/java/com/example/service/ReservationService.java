package com.example.service;

import com.example.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAllPaginated(int page, int size);


    long count();

    // Autres méthodes CRUD de base
    Reservation findById(Long id);
    List<Reservation> findAll();
    void save(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
}
