package uzh.ase.pokemate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "pokeDexId")
	private PokeDexEntity pokeMon1;
	
	@Column
	@ManyToOne
	@JoinColumn(name = "pokeDexId")
	private PokeDexEntity pokeMon2;
	

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

	public PokeDexEntity getPokeMon1() {
		return pokeMon1;
	}

	public void setPokeMon1(PokeDexEntity pokeMon1) {
		this.pokeMon1 = pokeMon1;
	}

	public PokeDexEntity getPokeMon2() {
		return pokeMon2;
	}

	public void setPokeMon2(PokeDexEntity pokeMon2) {
		this.pokeMon2 = pokeMon2;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
