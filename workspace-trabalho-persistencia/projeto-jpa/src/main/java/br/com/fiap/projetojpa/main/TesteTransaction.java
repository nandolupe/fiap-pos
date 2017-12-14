package br.com.fiap.projetojpa.main;

import br.com.fiap.projetojpa.cache.TipoItemDAOImpl;
import br.com.fiap.projetojpa.datatypes.TipoItem;

public class TesteTransaction {
	public static void main(String[] args) {		
		TipoItemDAOImpl itemDAOImpl = new TipoItemDAOImpl();
		
		
		TipoItem tipoItem = new TipoItem();
		tipoItem.setDscTipoItem("Brinquedos");
		itemDAOImpl.findAll();
		
	}
}
