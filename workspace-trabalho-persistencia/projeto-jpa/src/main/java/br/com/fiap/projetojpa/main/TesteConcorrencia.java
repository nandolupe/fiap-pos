package br.com.fiap.projetojpa.main;

import br.com.fiap.projetojpa.concurrency.ItemDAOImpl;
import br.com.fiap.projetojpa.datatypes.Item;

public class TesteConcorrencia {
	public static void main(String[] args) {		
		ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
		
		
		itemDAOImpl.alterarItemLock(new Item());
		
	}
}
