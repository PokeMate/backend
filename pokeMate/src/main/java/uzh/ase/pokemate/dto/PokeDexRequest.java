package uzh.ase.pokemate.dto;

import java.util.List;

public class PokeDexRequest {
	List<String> types;
	List<String> generations;

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getGenerations() {
		return generations;
	}

	public void setGenerations(List<String> generations) {
		this.generations = generations;
	}

}
