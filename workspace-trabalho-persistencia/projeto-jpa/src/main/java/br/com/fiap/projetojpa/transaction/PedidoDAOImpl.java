package br.com.fiap.projetojpa.transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.projetojpa.datatypes.Pedido;
import br.com.fiap.projetojpa.datatypes.PedidoItem;
import br.com.fiap.projetojpa.util.JPAUtil;

public class PedidoDAOImpl {

	private Session session = null;
	private Transaction transaction = null;

	public void inserirPedido(Pedido pedido) {
		
		try{
			
			session = JPAUtil.getSessionFactory().getCurrentSession();

			// Abre a transa��o, ap�s isso v�rias opera��es poder�o ser executadas
			// e em caso de falhas a opera��o como inteiro � retornada ao seu estado inicial.
			transaction = session.beginTransaction();
			
			// salvamos o Pedido primeiramente.
			session.save(pedido);
			
			// Aqui percorre toda a lista de Pedido Item e a salva no banco de dados.
			for (PedidoItem pedidoItem : pedido.getPedidoItems()) {
				pedidoItem.setPedido(pedido);
				session.save(pedidoItem);
			}
			// Ap�s todas opera��es serem executadas o banco de dados 
			// � avisado que a transa��o foi terminada e � realizado o commit.
			transaction.commit();
			
		} catch (Exception e){
			System.out.println("Ocorreu um erro: " + e);
		}
	}
}
