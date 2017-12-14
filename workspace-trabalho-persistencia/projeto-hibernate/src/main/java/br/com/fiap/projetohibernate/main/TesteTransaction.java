package br.com.fiap.projetohibernate.main;

import br.com.fiap.projetohibernate.cache.TipoItemDAOImpl;
import br.com.fiap.projetohibernate.datatypes.TipoItem;

public class TesteTransaction {
	public static void main(String[] args) {		
		TipoItemDAOImpl itemDAOImpl = new TipoItemDAOImpl();
		
		
		TipoItem tipoItem = new TipoItem();
		tipoItem.setDscTipoItem("Brinquedos");
		itemDAOImpl.findAll();
		
	}
}
