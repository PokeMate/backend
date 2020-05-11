package uzh.ase.pokemate.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Document(collection = "pokeRating")
public class RatingDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id;
	private Long ratingId;
	@DBRef
	private PokeDexDomain pokemon;
	private int name;
	private int image;
	private int rating;

	public ObjectId getId() {
		return id;
	}
	
	
	public void setId(ObjectId id) {
		this.id = id;
	}



	public PokeDexDomain getPokemon() {
		return pokemon;
	}

	public void setPokemon(PokeDexDomain pokemon) {
		this.pokemon = pokemon;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}
	
	

}
