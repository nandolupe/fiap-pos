package br.com.fiap.projetohibernate.concurrency;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.projetohibernate.datatypes.Item;
import br.com.fiap.projetohibernate.util.HibernateUtil;

public class ItemDAOImpl {

	private Session session = null;
	private Transaction transaction = null;

	public void alterarItemLock(Item item) {
		
		try{
			
			// Obtemos a sess�o conectando-se ao banco de dados
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// Abre a transa��o, ap�s isso v�rias opera��es poder�o ser executadas
			// e em caso de falhas a opera��o como inteiro � retornada ao seu estado inicial.
			transaction = session.beginTransaction();
			
			// Busca o Item na base e bloqueia ele para altera��o
			Item itemResult = (Item) session.load(Item.class, item.getIdItem(), LockMode.READ);
			
			// Altera o valor do item
			itemResult.setValorItem(item.getValorItem());
			
			// Atualiza o item na base
			session.merge(itemResult);
			
			transaction.commit();
			
		} catch (Exception e){
			e.getMessage();
			transaction.rollback();
		}
		
	}
}
