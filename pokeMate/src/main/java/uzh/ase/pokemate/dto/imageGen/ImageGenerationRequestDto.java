package uzh.ase.pokemate.dto.imageGen;

public class ImageGenerationRequestDto {

	private Long id1;
	private Long id2;
	private Long newId;

	
	public ImageGenerationRequestDto() {
		
	}
	
	public ImageGenerationRequestDto(Long id1, Long id2, Long newId) {
		this.id1=id1;
		this.id2=id2;
		this.newId=newId;
	}
	
	public Long getId1() {
		return id1;
	}
	public void setId1(Long id1) {
		this.id1 = id1;
	}
	public Long getId2() {
		return id2;
	}
	public void setId2(Long id2) {
		this.id2 = id2;
	}

	public Long getNewId() {
		return newId;
	}

	public void setNewId(Long newId) {
		this.newId = newId;
	}
	
	
	
}
