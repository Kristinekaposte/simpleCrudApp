package com.simpleCrudApp.repository;

import com.simpleCrudApp.entity.Cats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CatsRepository extends CrudRepository<Cats,Long> {

   // @Override
    ArrayList<Cats>findAll();
    Cats findCatsById(Long catsId);

    public Cats findCatsByName(String name);



}
