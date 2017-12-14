package com.exercicios.test;

import java.util.List;

import com.exercicios.datatypes.FuncionarioTO;
import com.exercicios.persistence.FuncionarioDAOImpl;

public class FuncionarioDAOTest {

	public static void main(String[] args) {
		FuncionarioDAOImpl funcionarioDAOImpl = new FuncionarioDAOImpl();

		FuncionarioTO funcionarioTO = new FuncionarioTO();
		funcionarioTO.setNome("Luiz");

		List<FuncionarioTO> list =  funcionarioDAOImpl.pesquisarFuncionarios(funcionarioTO);
		System.out.println("Total: " + list.size());
	}

}
