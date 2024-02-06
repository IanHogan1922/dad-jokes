package edu.greenriver.sdev.dad_jokes.service;

import edu.greenriver.sdev.dad_jokes.db.DadJokeRepository;
import edu.greenriver.sdev.dad_jokes.domain.DadJoke;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DadJokeService
{
    private DadJokeRepository repository;

    public DadJokeService (DadJokeRepository repository)
    {
        this.repository = repository;
    }

    public List<DadJoke> getAll()
    {
        List<DadJoke> dadJokes = repository.findAll();
        return Collections.unmodifiableList(dadJokes);
    }

    public DadJoke addJoke(DadJoke joke)
    {
        return repository.save(joke);
    }

    public DadJoke updateJoke(int id,DadJoke newJokeText)
    {
        DadJoke currentJoke = repository.findById(id).orElseThrow();

        currentJoke.setJokeText(newJokeText.getJokeText());

        return repository.save(currentJoke);
    }

    public void deleteJoke(int id)
    {
        repository.deleteById(id);
    }

    public DadJoke byId(int id)
    {
        return repository.findById(id).orElse(null);
    }

}
