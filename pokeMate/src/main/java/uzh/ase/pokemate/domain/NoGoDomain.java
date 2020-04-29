package uzh.ase.pokemate.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pokeNogos")
public class NoGoDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id;
	private Long nogoId;
	private String nogo;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getNogoId() {
		return nogoId;
	}

	public void setNogoId(Long nogoId) {
		this.nogoId = nogoId;
	}

	public String getNogo() {
		return nogo;
	}

	public void setNogo(String nogo) {
		this.nogo = nogo;
	}

}
