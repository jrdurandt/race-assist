package io.jrdurandt.raceassist.api;

import io.jrdurandt.raceassist.domain.Game;
import io.jrdurandt.raceassist.services.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameRestController {
	private final GameService gameService;

	public GameRestController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping
	public ResponseEntity<Page<Game>> getAll(Pageable pageable) {
		return ResponseEntity.ok(gameService.getAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Game> getById(@PathVariable long id) {
		return ResponseEntity.of(gameService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Game> create(@RequestBody Game game) {
		return ResponseEntity.ok(gameService.create(game));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Game> update(@PathVariable long id, @RequestBody Game game) {
		return ResponseEntity.of(gameService.update(id, game));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		gameService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
