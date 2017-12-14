package com.exercicios.business;

import java.util.List;

import com.exercicios.datatypes.FuncionarioTO;
import com.exercicios.persistence.FuncionarioDAOImpl;

/**
 * @author LFP0713
 *
 */
public class FuncionarioBusinessImpl {

	/**
	 * @param funcionarioTO
	 * @return
	 */
	public List<FuncionarioTO> pesquisarFuncionarios(FuncionarioTO funcionarioTO) {

		List<FuncionarioTO> list = null;

		FuncionarioDAOImpl funcionarioDAOImpl = new FuncionarioDAOImpl();
		list = funcionarioDAOImpl.pesquisarFuncionarios(funcionarioTO);

		return list;
	}
}