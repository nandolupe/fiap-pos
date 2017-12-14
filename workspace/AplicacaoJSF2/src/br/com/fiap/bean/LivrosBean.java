package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.LivrosDao;
import br.com.fiap.entity.Livros;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="livrosBean")
@RequestScoped
public class LivrosBean {
    private Livros livro;
    public Livros getLivro() {
        return livro;
    }
    public void setLivro(Livros livro) {
        this.livro = livro;
    }
    public LivrosBean(){
        livro = new Livros();
    }
    public String incluirLivro(){
        LivrosDao dao = RepositoryDao.getLivrosDao();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) fc.getExternalContext().getSession(false);
        try {
            String resultado = dao.salvar(livro);
            session.setAttribute("session_livro", resultado);
        } catch (Exception e) {
            session.setAttribute("session_livro", e.getMessage());
        }
        return "";
    }
    public List getListaLivros(){
        return RepositoryDao.getLivrosDao().listar();
    }
}