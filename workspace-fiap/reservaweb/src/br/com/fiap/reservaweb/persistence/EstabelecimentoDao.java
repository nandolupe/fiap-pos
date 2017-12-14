package br.com.fiap.reservaweb.persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.reservaweb.entity.Estabelecimento;

public class EstabelecimentoDao {
	Session session = null;
	Transaction transaction = null;

	public String salvar(Estabelecimento estabelecimento){
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(estabelecimento);
			transaction.commit();
			return "Estabelecimento salvo";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	public String atualizar(Estabelecimento estabelecimento){
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.merge(estabelecimento);
			transaction.commit();
			return "Estabelecimento atualizado";
		}catch(Exception e){
			return e.getMessage();
		}
	}

	public Estabelecimento buscar(String id){
		return (Estabelecimento) session.load(Estabelecimento.class, id);
	}

	public Estabelecimento validar(String nome, String senha){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();

		Query q = session.createQuery("FROM Estabelecimento WHERE login= :login AND senha=:senha ");
		q.setParameter("login", nome);
		q.setParameter("senha", senha);

		try {
			return ((Estabelecimento)q.uniqueResult());
		} catch(Exception e) {
			return null;
		}
	}
}
