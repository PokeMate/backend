package uzh.ase.pokemate.service.imagegen;

public interface IImageService {

	byte[] createImage(Long pokeDexId1, Long pokeDexId2, Long newId);
	
	byte[] getImage(Long pokeDexId);
}
