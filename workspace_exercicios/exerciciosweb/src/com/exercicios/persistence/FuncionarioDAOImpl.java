package com.exercicios.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exercicios.datatypes.FuncionarioTO;

public class FuncionarioDAOImpl extends BaseDAO {

	public List<FuncionarioTO> pesquisarFuncionarios(FuncionarioTO funcionarioTO) {

		List<FuncionarioTO> list = new ArrayList<FuncionarioTO>();

		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append(" COD_FUNCIONARIO ");
		query.append(",	NOME ");
		query.append("FROM ");
		query.append("	FUNCIONARIO ");
		query.append("WHERE NOME LIKE (?) ");

		Connection connection = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement(query.toString());
			ps.setString(1, "%" + funcionarioTO.getNome() + "%");

			rs = ps.executeQuery();

			FuncionarioTO funcionarioResult = null;

			while (rs.next()) {
				funcionarioResult = new FuncionarioTO();
				funcionarioResult.setCodFuncionario(rs.getInt("COD_FUNCIONARIO"));
				funcionarioResult.setNome(rs.getString("NOME"));
				list.add(funcionarioResult);
			}

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar os dados de funcionario!");
			e.printStackTrace();
		}

		return list;
	}
}
