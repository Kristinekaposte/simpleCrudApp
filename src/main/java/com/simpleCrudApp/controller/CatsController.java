package com.simpleCrudApp.controller;

import com.simpleCrudApp.entity.Cats;
import com.simpleCrudApp.service.CatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatsController {

@Autowired
  private final  CatsService catsService;

    public CatsController(CatsService catsService) {
        this.catsService = catsService;
    }

    @GetMapping("/cat")
    public List<Cats> getAllCats(){
        return catsService.findAllCats();
    }

    @GetMapping("/cat/{catId}")
    public Cats getCatById(@PathVariable("catId") Long catId) throws Exception {
        return catsService.findCatById(catId);
    }

    @PostMapping("/cats")
    public Long saveCat (@RequestBody Cats cats) throws Exception{
        catsService.createOrUpdateCat(cats);
        return cats.getId();
    }

    @PutMapping("/cats")
    public Cats updateCat (@RequestBody Cats cats) throws Exception{

        catsService.createOrUpdateCat(cats);
        return cats;
    }

    @DeleteMapping("/cat/{catId}")
    public void deleteCat(@PathVariable("catId") Long catId) throws Exception{
        catsService.deleteCatById(catId);
    }

}
