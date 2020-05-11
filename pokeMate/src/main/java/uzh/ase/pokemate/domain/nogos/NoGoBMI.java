package uzh.ase.pokemate.domain.nogos;

import uzh.ase.pokemate.domain.PokeDexDomain;

public class NoGoBMI implements INoGo {
	private static final String DESCRIPTION = "BMI > %s";
	private static final NoGoEnum NOGOENUM = NoGoEnum.BMI;
	
	@Override
	public boolean isNoGo(PokeDexDomain mate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return DESCRIPTION;
	}

	@Override
	public NoGoEnum getNoGoEnum() {
		return NOGOENUM;
	}

}
