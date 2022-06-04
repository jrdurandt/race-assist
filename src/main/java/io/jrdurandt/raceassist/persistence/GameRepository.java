package io.jrdurandt.raceassist.persistence;

import io.jrdurandt.raceassist.domain.Game;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {
	Optional<Game> findByTitle(String title);
}
