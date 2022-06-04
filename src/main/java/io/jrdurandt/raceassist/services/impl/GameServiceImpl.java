package io.jrdurandt.raceassist.services.impl;

import io.jrdurandt.raceassist.domain.Game;
import io.jrdurandt.raceassist.persistence.GameRepository;
import io.jrdurandt.raceassist.services.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
	private final GameRepository repository;

	public GameServiceImpl(GameRepository repository) {
		this.repository = repository;
	}

	@Override
	public Page<Game> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Game> getById(long id) {
		return repository.findById(id);
	}

	@Override
	public Game create(Game game) {
		return repository.save(game);
	}

	@Override
	public Optional<Game> update(long id, Game game) {
		return repository.findById(id)
				.map(entity -> {
					entity.setTitle(game.getTitle());
					return repository.save(entity);
				});
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}
}
