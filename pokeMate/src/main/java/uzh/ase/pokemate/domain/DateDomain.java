package uzh.ase.pokemate.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "pokeDate")
public class DateDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id;
	boolean successful;
	boolean finished;
	@DBRef
	private PokeDexDomain pokemon1;
	@DBRef
	private PokeDexDomain pokemon2;
	@DBRef
	private PokeDexDomain pokeBaby;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public PokeDexDomain getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(PokeDexDomain pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public PokeDexDomain getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(PokeDexDomain pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public PokeDexDomain getPokeBaby() {
		return pokeBaby;
	}

	public void setPokeBaby(PokeDexDomain pokeBaby) {
		this.pokeBaby = pokeBaby;
	}

}
