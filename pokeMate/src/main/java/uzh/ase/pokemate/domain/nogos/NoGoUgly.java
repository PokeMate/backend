package uzh.ase.pokemate.domain.nogos;

import uzh.ase.pokemate.domain.PokeDexDomain;

public class NoGoUgly implements INoGo {
	private static final String DESCRIPTION = "Superficial Pokemons don't like the ugly ones!";
	private static final NoGoEnum NOGOENUM = NoGoEnum.UGLY;
	
	@Override
	public NoGoEnum getNoGoEnum() {
		return NOGOENUM;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public boolean isNoGo(PokeDexDomain mate) {
		return mate.getAttractivity() > 0.5?false:true;
	}

}
