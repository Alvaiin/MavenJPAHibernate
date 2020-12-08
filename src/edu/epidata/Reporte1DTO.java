package edu.epidata;

public class Reporte1DTO {
	private int personaId;
	private long cantLibrosEditados;

	public Reporte1DTO(int personaId, long cantLibrosEditados) {
		super();
		this.personaId = personaId;
		this.cantLibrosEditados= cantLibrosEditados;
	}

	// Getters y Setters
	@Override
	public String toString() {
		return "Reporte1DTO [personaId=" + personaId + ", cantLibrosEditados=" + cantLibrosEditados + "]";
	}

}
