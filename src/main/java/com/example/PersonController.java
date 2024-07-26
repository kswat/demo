package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping
    ResponseEntity<Void> createNewMessage(@RequestBody Person itemDto, UriComponentsBuilder uriComponentsBuilder){
        System.out.println(itemDto);
        final Person itemInfo = personService.createPerson(itemDto)
                .orElseThrow(()-> new DuplicateException("ALREADY_EXISTS"));
        //NOTE: assume there will be a get end point
        UriComponents uriComponents = uriComponentsBuilder.path("/person/find/{id}").buildAndExpand(itemInfo.getId());

        return ResponseEntity.created(uriComponents.toUri()).build();
    }
}
