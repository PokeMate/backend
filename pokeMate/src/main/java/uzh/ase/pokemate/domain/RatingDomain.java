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
	@DBRef
	private PokeDexDomain pokemon;
	private Long name;
	private Long image;
	private Long rating;

	public ObjectId getId() {
		return id;
	}
}
