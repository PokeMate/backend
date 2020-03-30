package uzh.ase.pokemate.dto;

import uzh.ase.pokemate.domain.PokeMon;

public class PokeMonDtoMapper {

	public static PokeMon dtoToEntity(PokeMonDto dto) {
		return new PokeMon();
	}

	public static PokeMonDto entityToDto(PokeMon entity) {
		return new PokeMonDto();
	}
}
