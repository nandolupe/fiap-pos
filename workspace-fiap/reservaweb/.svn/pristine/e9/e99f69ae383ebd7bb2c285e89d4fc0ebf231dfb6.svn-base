package br.com.fiap.reservaweb.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.reservaweb.entity.Reserva;

public class ReservaDao {
	
	static final Logger log = Logger.getLogger(ReservaDao.class);
	
	Session session = null;
	Transaction transaction = null;

	public String salvar(Reserva reserva){
		log.info("salvar + " + reserva);
		
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.merge(reserva);
			transaction.commit();
			return "Reserva salva";
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public Reserva buscar(int id){
		return (Reserva) session.load(Reserva.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarTodasReservas(Reserva reserva) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
		
		StringBuffer queryStr = new StringBuffer();
		queryStr.append(" from Reserva r where r.estabelecimento.cnpjCpf = :cnpjCpf ");
		
		if (reserva.getCodMesa() != null && !reserva.getCodMesa().equals("")) {
			queryStr.append("and r.codMesa = :codMesa ");
		}
		
		if (reserva.getNomeCliente() != null && !reserva.getNomeCliente().equals("")) {
			queryStr.append("and upper(r.nomeCliente) like upper(:nomeCliente) ");
		}
		
		if (reserva.getContato() != null && !reserva.getContato().equals("")) {
			queryStr.append("and r.contato = :contato ");
		}
		
		if (reserva.getDtReserva() != null) {
			queryStr.append("and r.dtReserva = :dtReserva ");
		}
		
		Query query = session.createQuery(queryStr.toString());
		query.setParameter("cnpjCpf", reserva.getEstabelecimento().getCnpjCpf());
		
		
		if (reserva.getCodMesa() != null && !reserva.getCodMesa().equals("")) {
			query.setParameter("codMesa", reserva.getCodMesa());
		}
		
		if (reserva.getNomeCliente() != null && !reserva.getNomeCliente().equals("")) {
			query.setParameter("nomeCliente", "%" + reserva.getNomeCliente() + "%");
		}
		
		if (reserva.getContato() != null && !reserva.getContato().equals("")) {
			query.setParameter("contato", reserva.getContato());
		}
		
		if (reserva.getDtReserva() != null) {
			query.setParameter("dtReserva", reserva.getDtReserva());
		}
		
		return query.list();
	}
	
	public void remover(Reserva reserva) {
		log.info("remover " + reserva);
		
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.load(Reserva.class, reserva.getIdReserva());
			session.delete(reserva);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
