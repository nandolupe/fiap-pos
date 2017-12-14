package br.com.fiap.projetohibernate.cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.projetohibernate.datatypes.TipoItem;
import br.com.fiap.projetohibernate.util.HibernateUtil;

public class TipoItemDAOImpl {

	private Session session = null;
	private Transaction transaction = null;

	public List<TipoItem> findAll() {
		
		List<TipoItem> tipoItems = null;
		
		try{
			
			// CRIA UM CONEX�O COM O BANCO DE DADOS
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// ABRE UMA TRANSA��O COM O BANCO DE DADOS
			transaction = session.beginTransaction();
		
			// EXECUTA A QUERY QUE BUSCA TODOS OS TIPO ITEMS DA BASE
			Query query = session.createQuery("from TipoItem ");
			
			// MARCA A QUERY COMO CACHE
			query.setCacheable(true);
			
			// OBTEM O RESULTADO DA LISTA
			tipoItems = query.list();
			
		} catch (Exception e){
			System.out.println("Ocorreu um erro ao fazer a lista de Tipo Item.");
		} finally {
			session.close();
			transaction.rollback();
		}
		
		return tipoItems;
	}
}
