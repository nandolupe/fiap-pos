package br.com.fiap.bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.fiap.dao.UsuariosDao;
import br.com.fiap.entity.Usuarios;
import br.com.fiap.repository.RepositoryDao;

@ManagedBean(name="loginUsuarios")
@SessionScoped
public class LoginUsuariosBean {
    private Usuarios usuario;
    public LoginUsuariosBean(){
        usuario = new Usuarios();
    }
    public Usuarios getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    public String validarUsuario(){
        UsuariosDao dao = RepositoryDao.getUsuariosDao();
        if(dao.validar(usuario.getNome(), usuario.getSenha())){
            return "/admin/menu";
        }
        return "/index";
    }
}