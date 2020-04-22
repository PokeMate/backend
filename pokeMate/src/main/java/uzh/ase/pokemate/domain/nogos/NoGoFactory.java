package uzh.ase.pokemate.domain.nogos;

public final class NoGoFactory {

	private NoGoFactory() {

	}

	public static INoGo create(NoGoEnum nogoEnum) {
		INoGo nogo = null;
		switch (nogoEnum) {
		case BMI:
			nogo = new NoGoBMI();
			break;
		case LEGENDARY:
			nogo = new NoGoLegendary();
			break;
		case UGLY:
			nogo = new NoGoUgly();
			break;
		default:
			break;
		}
		return nogo;
	}
}
