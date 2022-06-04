package io.jrdurandt.raceassist.services;

import io.jrdurandt.raceassist.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GameService {
	Page<Game> getAll(Pageable pageable);

	Optional<Game> getById(long id);

	Game create(Game game);

	Optional<Game> update(long id, Game game);

	void delete(long id);
}
