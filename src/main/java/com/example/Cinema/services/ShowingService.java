package com.example.Cinema.services;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Showing;
import com.example.Cinema.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ShowingService {

    private final ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    private final String showingNotFound = "Showing with id = {0} not found.";



    public Showing addShowing(Showing showing) {
        return showingRepository.save(showing);
    }

    public List<Showing> getAllShowings() {
        return showingRepository.findAll();
    }

    public Showing getShowing(Long id) {
        Showing showingFromDB = showingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(showingNotFound, id)));

        return showingFromDB;
    }

    public Showing updateShowing(Long id, Showing showing) {
        Showing showingFromDB = showingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(showingNotFound, id)));

        showingFromDB.setMovie(showing.getMovie());
        showingFromDB.setTimeSlots(showing.getTimeSlots());
        showingFromDB.setMovie(showing.getMovie());
        showingFromDB.setRepertoire(showing.getRepertoire());

        return showingFromDB;
    }

    public void removeShowing(Long id) {
        Showing showing = showingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(showingNotFound, id)));
        showingRepository.delete(showing);
    }
}
