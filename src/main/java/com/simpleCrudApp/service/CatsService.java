package com.simpleCrudApp.service;

import com.simpleCrudApp.entity.Cats;
import com.simpleCrudApp.repository.CatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CatsService {
   private final CatsRepository catsRepository;

    @Autowired
    public CatsService(CatsRepository catsRepository) {
        this.catsRepository = catsRepository;
    }
    //getting all cats records from sql
    public ArrayList<Cats> findAllCats(){
        return this.catsRepository.findAll();
    }
    public void createOrUpdateCat(Cats cat) {
        this.catsRepository.save(cat);
    }

    // getting record by specific id
    public Cats findCatById(Long catId) throws Exception{
       return catsRepository.findCatsById(catId);
    }

    public Cats findCatsByName(String catName) throws Exception{
       return catsRepository.findCatsByName(catName);
    }

    public void deleteCatById(Long catId) throws Exception{
        catsRepository.deleteById(catId);
    }


}
