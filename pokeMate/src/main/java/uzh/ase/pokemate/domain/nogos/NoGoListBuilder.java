package uzh.ase.pokemate.domain.nogos;

import java.util.ArrayList;
import java.util.List;

import uzh.ase.pokemate.domain.PokeDexDomain;

public final class NoGoListBuilder {

	private NoGoListBuilder() {
	}

	public static List<INoGo> build(PokeDexDomain pokemon) {
		List<INoGo> nogos = new ArrayList<INoGo>();
//		for (String nogo : pokemon.getNogos()) {
//			nogos.add(NoGoFactory.create(NoGoEnum.valueOf(nogo)));
//		}
		return nogos;
	}

}
