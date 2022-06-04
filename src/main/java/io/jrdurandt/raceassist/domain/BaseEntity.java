package io.jrdurandt.raceassist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EqualsAndHashCode(of = {"id"})
public abstract class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private final LocalDateTime createdDateTime = LocalDateTime.now();

	private LocalDateTime updatedDateTime;

	@PrePersist
	public void prePersist() {
		this.updatedDateTime = LocalDateTime.now();
	}
}
