package io.jrdurandt.raceassist.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "games")
@Data
@EqualsAndHashCode(callSuper = true, of = {"title"})
public class Game extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String title;
}
