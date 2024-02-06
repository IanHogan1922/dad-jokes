package edu.greenriver.sdev.dad_jokes.controller;

import edu.greenriver.sdev.dad_jokes.domain.DadJoke;
import edu.greenriver.sdev.dad_jokes.service.DadJokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dadjoke")
public class DadJokeApi
{
    private DadJokeService service;

    public DadJokeApi(DadJokeService service)
    {
        this.service = service;
    }

    @GetMapping("all")
    public ResponseEntity<List<DadJoke>> all()
    {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addJoke(@RequestBody DadJoke newJoke)
    {
        return new ResponseEntity(service.addJoke(newJoke), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<DadJoke> updateDadJoke(@PathVariable int id,@RequestBody DadJoke newJokeText)
    {
        DadJoke joke = service.byId(id);
        if (joke == null)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity(service.updateJoke(id, newJokeText),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteJoke(@PathVariable int id)
    {
        DadJoke joke = service.byId(id);
        if (joke == null)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
            service.deleteJoke(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
