package edu.greenriver.sdev.dad_jokes.db;

import edu.greenriver.sdev.dad_jokes.domain.DadJokes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadJokeRepository extends JpaRepository<DadJokes, Integer>
{

}
