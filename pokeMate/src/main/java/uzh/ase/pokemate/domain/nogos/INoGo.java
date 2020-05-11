package uzh.ase.pokemate.domain.nogos;

import uzh.ase.pokemate.domain.PokeDexDomain;

public interface INoGo {

	public NoGoEnum getNoGoEnum();
	public String getDescription();
	public boolean isNoGo(PokeDexDomain mate);
}
