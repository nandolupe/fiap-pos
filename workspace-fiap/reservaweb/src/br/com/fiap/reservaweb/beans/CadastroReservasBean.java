package br.com.fiap.reservaweb.beans;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.reservaweb.entity.Reserva;
import br.com.fiap.reservaweb.persistence.ReservaDao;
import br.com.fiap.reservaweb.repository.RepositoryDao;

@ManagedBean(name="cadastroReservas")
@SessionScoped
public class CadastroReservasBean {
    
	private String datReserva;
	private Reserva reserva;
	private Reserva reservaRemover;
	
	public CadastroReservasBean() {
		reserva = new Reserva();
		datReserva = new String();
		reservaRemover = new Reserva();
	}
	
    public Reserva getReservaRemover() {
		return reservaRemover;
	}

	public void setReservaRemover(Reserva reservaRemover) {
		this.reservaRemover = reservaRemover;
	}

	public String getDatReserva() {
		return datReserva;
	}

	public void setDatReserva(String datReserva) {
		this.datReserva = datReserva;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String cadastrarReservas() {
    	return "/pages/reservas";
	}
    
	public String pesquisarReservasHome() {
    	return "/pages/reservasPesquisar";
	}
   
	public String salvarReserva() {
		ReservaDao reservaDao = RepositoryDao.getReservaDAO();
		
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		LoginBean loginBean = (LoginBean) httpSession.getAttribute("loginBean");
		System.out.println(loginBean);

		reserva.setEstabelecimento(loginBean.getEstabelecimento());
		reservaDao.salvar(reserva);
		
		reserva = new Reserva();
		return "Reserva Efetuada com Sucesso!";
	}
	
	public List<Reserva> getListaReservas() {
		
		List<Reserva> list = new ArrayList<Reserva>();
		
		ReservaDao reservaDao = RepositoryDao.getReservaDAO();
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		LoginBean loginBean = (LoginBean) httpSession.getAttribute("loginBean");
		reserva.setEstabelecimento(loginBean.getEstabelecimento());
		
		list = reservaDao.buscarTodasReservas(reserva);
		
		return list;
	}
	
	public void pesquisarReservas() {
		getListaReservas();
	}
	
	public void cancelar() {
		ReservaDao reservaDao = RepositoryDao.getReservaDAO();
		reservaDao.remover(reserva);
		reserva = new Reserva();
	}
}