package com.example.Cinema.services;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.exceptions.RepertoireDateHasBeenAlready;
import com.example.Cinema.model.Movie;
import com.example.Cinema.model.Repertoire;
import com.example.Cinema.repositories.RepertoireRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;

@Service
public class RepertoireService {

    private final RepertoireRepository repertoireRepository;


    private final String repertoireNotFound = "Repertoire with id = {0} not found.";

    public RepertoireService(RepertoireRepository repertoireRepository) {
        this.repertoireRepository = repertoireRepository;
    }

    public Repertoire addRepertoire(Repertoire repertoire){
       return repertoireRepository.save(repertoire);
    }

    public Repertoire getRepertoire(Long id){
        Repertoire repertoire = repertoireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(repertoireNotFound, id)));
        return repertoire;
    }

    public Repertoire getRepertoireByDate(LocalDate repertoireDate){
        if (repertoireDate.isBefore(LocalDate.now())){
            throw new RepertoireDateHasBeenAlready("The date of repertoire is before now!");
        }
        Repertoire repertoireByRepertoireDate = repertoireRepository.findRepertoireByRepertoireDate(repertoireDate);
        return repertoireByRepertoireDate;
    }

    public Repertoire updateRepertoire(Long id, Repertoire repertoire) {
        Repertoire repertoireFromDB = repertoireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(repertoireNotFound, id)));

        repertoireFromDB.setShowings(repertoire.getShowings());

        return repertoireRepository.save(repertoireFromDB);
    }

    public void removeRepertoire(Long id){
        Repertoire repertoire = repertoireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(repertoireNotFound, id)));
        repertoireRepository.deleteById(id);
    }




}
