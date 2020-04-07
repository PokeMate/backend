package uzh.ase.pokemate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokedate")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	boolean successful;

	@Column
	boolean finished;

	@Column
	private Long pokemonId1;

	@Column
	private Long pokemonId2;

	public Long getId() {
		return id;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Long getPokemonId1() {
		return pokemonId1;
	}

	public void setPokemonId1(Long pokemonId1) {
		this.pokemonId1 = pokemonId1;
	}

	public Long getPokemonId2() {
		return pokemonId2;
	}

	public void setPokemonId2(Long pokemonId2) {
		this.pokemonId2 = pokemonId2;
	}

}
