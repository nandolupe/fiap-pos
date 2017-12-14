package br.com.fiap.repository;

import br.com.fiap.dao.LivrosDao;
import br.com.fiap.dao.UsuariosDao;

public final class RepositoryDao {
    
    static UsuariosDao usuariosDao;
    static LivrosDao livrosDao;
    
    public static UsuariosDao getUsuariosDao(){
        if(usuariosDao == null){
            usuariosDao = new UsuariosDao();
        }
        return usuariosDao;
    }
    
    public static LivrosDao getLivrosDao(){
        if(livrosDao == null){
            livrosDao = new LivrosDao();
        }
        return livrosDao;
    }
}