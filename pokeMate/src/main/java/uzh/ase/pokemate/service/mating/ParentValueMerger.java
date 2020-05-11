package uzh.ase.pokemate.service.mating;

import java.security.SecureRandom;
import java.util.Random;

import uzh.ase.pokemate.domain.PokeDexDomain;

public final class ParentValueMerger {

	private static Random rnd = new SecureRandom();
	private ParentValueMerger() {
	}

	public static PokeDexDomain merge(PokeDexDomain poke1, PokeDexDomain poke2) {
		PokeDexDomain baby = new PokeDexDomain();
		baby.setAttack(getAvg(poke1.getAttack(), poke2.getAttack()));
		baby.setDefense(getAvg(poke1.getDefense(), poke2.getDefense()));
		baby.setHp(getAvg(poke1.getHp(), poke2.getHp()));
		baby.setSpAtk(getAvg(poke1.getSpAtk(), poke2.getSpAtk()));
		baby.setSpDef(getAvg(poke1.getSpDef(), poke2.getSpDef()));
		baby.setSpeed(getAvg(poke1.getSpeed(), poke2.getSpeed()));
		baby.setTotal(getAvg(poke1.getTotal(), poke2.getTotal()));
		baby.setAttractivity(getAvg(poke1.getAttractivity(), poke2.getAttractivity()));
		baby.setFertility(getAvg(poke1.getFertility(), poke2.getFertility()));
		baby.setFitness(getAvg(poke1.getFitness(), poke2.getFitness()));
		baby.setLegendary(calculateLegendary(poke1.isLegendary(), poke2.isLegendary()));
		baby.setType1(getRandomValue(poke1.getType1(), poke2.getType1()));
		baby.setType2(getRandomValue(poke1.getType2(), poke2.getType2()));
		return baby;
	}

	private static String getAvg(String val1, String val2) {
		return String.valueOf(Integer.valueOf(val1) + Integer.valueOf(val2) / 2);
	}

	private static double getAvg(double val1, double val2) {
		return (val1 + val2) / 2;
	}

	private static boolean calculateLegendary(boolean legendary, boolean legendary2) {
		double nextGaussian = rnd.nextGaussian();
		double bonus = 0;
		bonus += legendary ? 0.1 : 0.0;
		bonus += legendary2 ? 0.1 : 0.0;
		return (nextGaussian + bonus) >= 0.8;
	}

	private static String getRandomValue(String val1, String val2) {
		if (rnd.nextBoolean()) {
			return val1;
		} else {
			return val2;
		}

	}

}
