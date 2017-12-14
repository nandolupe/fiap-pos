package br.com.fiap.reservaweb.repository;

import br.com.fiap.reservaweb.persistence.EstabelecimentoDao;
import br.com.fiap.reservaweb.persistence.ReservaDao;

public final class RepositoryDao {
    
    static EstabelecimentoDao estabelecimentoDao;
    
    static ReservaDao reservaDao;
    
    public static EstabelecimentoDao getEstabelecimentoDAO(){
        if(estabelecimentoDao == null){
            estabelecimentoDao = new EstabelecimentoDao();
        }
        return estabelecimentoDao;
    }
    
    public static ReservaDao getReservaDAO(){
        if(reservaDao == null){
        	reservaDao = new ReservaDao();
        }
        return reservaDao;
    }
}