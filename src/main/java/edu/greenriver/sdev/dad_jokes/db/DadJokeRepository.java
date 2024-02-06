package edu.greenriver.sdev.dad_jokes.db;

import edu.greenriver.sdev.dad_jokes.domain.DadJoke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadJokeRepository extends JpaRepository<DadJoke, Integer>
{
    // Provides all CRUD capabilities
}
