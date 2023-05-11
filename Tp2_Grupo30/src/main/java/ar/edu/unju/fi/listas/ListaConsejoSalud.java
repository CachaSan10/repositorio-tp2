package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Consejo;

public class ListaConsejoSalud {
	
	private List<Consejo> consejos;

	
	
	public ListaConsejoSalud() {
		consejos = new ArrayList<Consejo>();
		consejos.add(null);
	}



	public List<Consejo> getConsejos() {
		return consejos;
	}



	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}



	

}
