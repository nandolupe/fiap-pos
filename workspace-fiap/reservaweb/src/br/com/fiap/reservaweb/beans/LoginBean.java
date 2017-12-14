package br.com.fiap.reservaweb.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.reservaweb.entity.Estabelecimento;
import br.com.fiap.reservaweb.persistence.EstabelecimentoDao;
import br.com.fiap.reservaweb.repository.RepositoryDao;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    private Estabelecimento estabelecimento;
    
    public LoginBean(){
    	estabelecimento = new Estabelecimento();
    }
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
    
    public String validarLogin() {
    	EstabelecimentoDao dao = RepositoryDao.getEstabelecimentoDAO();
    	
    	Estabelecimento estabelecimentoResult = dao.validar(estabelecimento.getLogin(), estabelecimento.getSenha());
    	
        if(estabelecimentoResult != null) {
        	this.estabelecimento = estabelecimentoResult;
            return "/pages/index";
        }
        return "/error";
	}
    
    public String homePage() {
    	return "/pages/index";
    }
    
    public String cadastrarEstabelecimento() {
    	return "/estabelecimento";
	}
    
    public String logout() {
    	HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		httpSession.setAttribute("loginBean", null);
    	
    	return "/login.faces";
	}
}