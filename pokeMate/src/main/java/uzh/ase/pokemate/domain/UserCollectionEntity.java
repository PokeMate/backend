package uzh.ase.pokemate.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usercollection")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	
	@Column
	@ManyToMany
	@JoinColumn(name = "id")
	private List<PokeDexEntity> pokeCollection;
}
