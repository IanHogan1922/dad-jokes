
package edu.greenriver.sdev.dad_jokes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadJokes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
