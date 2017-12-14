package br.com.fiap.reservaweb.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    	EstabelecimentoDao dao = RepositoryDao.getEstabelecimentoDao();
        if(dao.validar(estabelecimento.getLogin(), estabelecimento.getSenha())){
            return "/pages/index";
        }
        return "/error";
	}
    
}