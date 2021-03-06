package br.com.fiap.projetojpa.concurrency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import br.com.fiap.projetojpa.datatypes.Item;

public class ItemDAOImpl {
	
	EntityManagerFactory entityManagerFactory = null;
	EntityManager em = null;
	
	public ItemDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-pu");
		em = entityManagerFactory.createEntityManager();
	}
	
	public Item alterarItemLock(Item item) {
		
		Item listResult = null;
		
		try{
			
			listResult = em.find(Item.class, item.getIdItem());
			listResult.setValorItem(item.getValorItem());
			em.lock(listResult, LockModeType.WRITE);
			
		} catch (Exception e){
			System.out.println("Ocorreu um erro: " + e);
		}
		
		return listResult;
	}
}
