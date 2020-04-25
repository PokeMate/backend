package uzh.ase.pokemate.domain.nogos;

import uzh.ase.pokemate.domain.PokeDexDomain;

public class NoGoLegendary  implements INoGo{
	private static final String DESCRIPTION = "Arrogant legendary Pokemons";
	private static final NoGoEnum NOGOENUM = NoGoEnum.LEGENDARY;

	@Override
	public boolean isNoGo(PokeDexDomain mate) {
		return mate.isLegendary();
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	@Override
	public NoGoEnum getNoGoEnum() {
		return NOGOENUM;
	}
}
