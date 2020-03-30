package uzh.ase.pokemate.exceptions;

public class AseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AseException() {
	}

	public AseException(Long objId) {
		super("Object: " + objId + " not found.");
	}
}