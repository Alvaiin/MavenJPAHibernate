package edu.epidata;

//En cuantos libros particip� cada persona como autor de cap�tulo.
public class Reporte3DTO {

	private int personaId;
	private long cantLibros;
	
	public Reporte3DTO(int personaId,long cantLibros) {
		this.personaId = personaId;
		this.cantLibros = cantLibros;
	}

	@Override
	public String toString() {
		return "Reporte3DTO [personaId=" + personaId + ", cantLibros=" + cantLibros + "]";
	}
	
	
}
