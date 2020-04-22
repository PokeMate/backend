package uzh.ase.pokemate.domain;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "pokeUser")
public class UserDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id;
	private String userName;
	private String password;
	@DBRef
	private List<PokeDexDomain> pokemonCollection;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PokeDexDomain> getPokemonCollection() {
		return pokemonCollection;
	}

	public void setPokemonCollection(List<PokeDexDomain> pokemonCollection) {
		this.pokemonCollection = pokemonCollection;
	}

}
