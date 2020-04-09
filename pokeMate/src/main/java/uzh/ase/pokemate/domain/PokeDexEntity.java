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
@Table(name = "pokedex")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokeDexEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Long pokeDexId;
	@Column
	private String name;
	@Column
	private String type1;
	@Column
	private String type2;
	@Column
	private String total;
	@Column
	private String hp;
	@Column
	private String attack;
	@Column
	private String defense;
	@Column
	private String spAtk;
	@Column
	private String spDef;
	@Column
	private String speed;
	@Column
	private String generation;
	@Column
	private boolean legendary;

	public Long getId() {
		return id;
	}

	public Long getPokeDexId() {
		return pokeDexId;
	}

	public void setPokeDexId(Long pokeDexId) {
		this.pokeDexId = pokeDexId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getDefense() {
		return defense;
	}

	public void setDefense(String defense) {
		this.defense = defense;
	}

	public String getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(String spAtk) {
		this.spAtk = spAtk;
	}

	public String getSpDef() {
		return spDef;
	}

	public void setSpDef(String spDef) {
		this.spDef = spDef;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
