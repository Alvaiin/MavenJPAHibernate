package edu.epidata;


//Cuantas paginas reviso cada persona en un año dado
public class Reporte2DTO {
	
	private int personaId;
	private long cantPaginasRevisadas;
	
	public Reporte2DTO(int personaId, long cantPagniasRevisadas) {
		super();
		this.personaId = personaId;
		this.cantPaginasRevisadas = cantPagniasRevisadas;
		
	}

	@Override
	public String toString() {
		return "Reporte2DTO [personaId=" + personaId + ", cantPaginasRevisadas=" + cantPaginasRevisadas + "]";
	}
	
	

}
