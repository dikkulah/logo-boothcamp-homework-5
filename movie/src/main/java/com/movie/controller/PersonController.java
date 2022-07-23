package com.movie.controller;

import com.movie.dto.PersonDto;
import com.movie.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto request){
        return ResponseEntity.ok().body(personService.addPerson(request));
    }



    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonsByName(@PathVariable Long id){
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        return ResponseEntity.ok().body(personService.deleteById(id));
    }



}
