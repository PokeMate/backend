package uzh.ase.pokemate.service.imageGen;

public interface IImageService {

	byte[] createImage(Long pokeDexId1, Long pokeDexId2);
	
	byte[] getImage(Long pokeDexId);
}
