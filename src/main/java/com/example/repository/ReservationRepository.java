package com.example.repository;

import com.example.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ReservationRepository {

    List<Reservation> findAllPaginated(int page, int size);

    // Méthode pour compter le nombre total de salles (pour la pagination)
    long count();

    // Autres méthodes CRUD de base
    Reservation findById(Long id);
    List<Reservation> findAll();
    void save(Reservation salle);
    void update(Reservation salle);
    void delete(Reservation salle);

}
