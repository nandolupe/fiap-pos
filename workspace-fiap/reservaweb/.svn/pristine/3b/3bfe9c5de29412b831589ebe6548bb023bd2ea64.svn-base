package br.com.fiap.reservaweb.repository;

import br.com.fiap.reservaweb.persistence.EstabelecimentoDao;

public final class RepositoryDao {
    
    static EstabelecimentoDao estabelecimentoDao;
    
    public static EstabelecimentoDao getEstabelecimentoDao(){
        if(estabelecimentoDao == null){
            estabelecimentoDao = new EstabelecimentoDao();
        }
        return estabelecimentoDao;
    }
}