package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.service.imageGen.IImageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/image")
public class ImageController {
	@Autowired
	@Qualifier("imageService")
	private IImageService imageService;
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> get(@PathVariable("id") Long id) {
		byte[] pokeImage= this.imageService.getImage(id);
		return ok(pokeImage);
	}
}
