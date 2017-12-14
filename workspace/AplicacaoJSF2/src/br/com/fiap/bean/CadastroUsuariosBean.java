package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import br.com.fiap.dao.UsuariosDao;
import br.com.fiap.entity.Usuarios;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="cadastroUsuarios")
@RequestScoped
public class CadastroUsuariosBean {
    private Usuarios usuario;
    public CadastroUsuariosBean(){
        usuario = new Usuarios();
    }
    public Usuarios getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    public List<SelectItem> getNiveis(){
        List<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(1,"Administrador"));
        itens.add(new SelectItem(2,"Cliente"));
        return itens;
    }
    public String incluirUsuario(){
        UsuariosDao dao = RepositoryDao.getUsuariosDao();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session =
                (HttpSession) fc.getExternalContext().getSession(false);
        try {
            String resultado = dao.salvar(usuario);
            session.setAttribute("session_usuario", resultado);
        } catch (Exception e) {
            session.setAttribute("session_usuario", e.getMessage());
        }
        return "";
    }
}