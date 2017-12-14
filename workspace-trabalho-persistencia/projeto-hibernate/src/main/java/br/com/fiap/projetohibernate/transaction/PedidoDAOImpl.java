package br.com.fiap.projetohibernate.transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.projetohibernate.datatypes.Pedido;
import br.com.fiap.projetohibernate.datatypes.PedidoItem;
import br.com.fiap.projetohibernate.util.HibernateUtil;

public class PedidoDAOImpl {

	private Session session = null;
	private Transaction transaction = null;

	public String inserirPedido(Pedido pedido) {
		
		try{
			
			// Obtemos a sessão conectando-se ao banco de dados
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			// Abre a transação, após isso várias operações poderão ser executadas
			// e em caso de falhas a operação como inteiro é retornada ao seu estado inicial.
			transaction = session.beginTransaction();
			
			// salvamos o Pedido primeiramente.
			session.save(pedido);
			
			// Aqui percorre toda a lista de Pedido Item e a salva no banco de dados.
			for (PedidoItem pedidoItem : pedido.getPedidoItems()) {
				pedidoItem.setPedido(pedido);
				session.save(pedidoItem);
			}
			// Após todas operações serem executadas o banco de dados 
			// é avisado que a transação foi terminada e é realizado o commit.
			transaction.commit();
			return "Usuario salvo";
			
		} catch (Exception e){
			return e.getMessage();
		}
	}
}
