package br.com.fiap.reservaweb.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import br.com.fiap.reservaweb.entity.Estabelecimento;
import br.com.fiap.reservaweb.persistence.EstabelecimentoDao;
import br.com.fiap.reservaweb.repository.RepositoryDao;

@ManagedBean(name = "cadastroEstabelecimento")
@SessionScoped
public class CadastroEstabelecimentoBean {
	private Estabelecimento estabelecimento;

	private String confirmaSenha;
	private UIInput senhaInput;

	public UIInput getSenhaInput() {
		return senhaInput;
	}

	public void setSenhaInput(UIInput senhaInput) {
		this.senhaInput = senhaInput;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public CadastroEstabelecimentoBean() {
		estabelecimento = new Estabelecimento();
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String salvar() {
		EstabelecimentoDao dao = RepositoryDao.getEstabelecimentoDAO();
		dao.salvar(estabelecimento);
			
		return "/login";
	}

	public void verificaSenha(FacesContext context, UIComponent comp, Object values) {

		String senha = (String) this.senhaInput.getLocalValue();
		String confirmaSenha = (String) values;
		System.out.println(senha);
		System.out.println(confirmaSenha);
		if (!(senha.equals(confirmaSenha))) {
			throw new ValidatorException(new FacesMessage("As senhas devem ser iguais!"));
		}
	}
	

	public String atualizarPerfil() {
		
		try {
			EstabelecimentoDao dao = RepositoryDao.getEstabelecimentoDAO();
			dao.atualizar(estabelecimento);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/pages/index";
	}

	

	public String perfil() {
		try {
			HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			LoginBean loginBean = (LoginBean) httpSession.getAttribute("loginBean");
			estabelecimento = RepositoryDao.getEstabelecimentoDAO().buscar(loginBean.getEstabelecimento().getCnpjCpf());
			//this.confirmaSenha = estabelecimento.getSenha();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/pages/atualizaEstabelecimento";
	}

}