package uzh.ase.pokemate.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pokeFetish")
public class FetishDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id;
	private Long fetishId;
	private String fetish;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getFetishId() {
		return fetishId;
	}

	public void setFetishId(Long fetishId) {
		this.fetishId = fetishId;
	}

	public String getFetish() {
		return fetish;
	}

	public void setFetish(String fetish) {
		this.fetish = fetish;
	}

}
