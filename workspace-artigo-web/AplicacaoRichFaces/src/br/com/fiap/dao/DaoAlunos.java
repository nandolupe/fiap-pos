package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Alunos;

public class DaoAlunos extends Dao{
	
	public void incluir(Alunos aluno) throws Exception{
		try {
			abrirConexao();
			String sql = "INSERT INTO ALUNOS (RM,NOME,EMAIL,DATANASC,CURSO) VALUES (?,?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, aluno.getRm());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEmail());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTime()));
			stmt.setString(5, aluno.getCurso());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	public List<Alunos> listarAlunos(String curso) throws Exception{
		List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			abrirConexao();
			
			StringBuffer query = new StringBuffer("SELECT * FROM ALUNOS");
			
			if (curso != null && !curso.equals("")) {
			    query.append(" WHERE curso = ? ");
			}
			
			stmt = cn.prepareStatement(query.toString());
			
			if (curso != null && !curso.equals("")) {
			    stmt.setString(1, curso);
			}
			
			rs = stmt.executeQuery();
			System.out.println("conexao aberta");
			while(rs.next()){
				Alunos aluno = new Alunos();
				aluno.setRm(rs.getInt("RM"));
				aluno.setNome(rs.getString("NOME"));
				aluno.setEmail(rs.getString("EMAIL"));
				aluno.setDataNascimento(rs.getDate("DATANASC"));
				aluno.setCurso(rs.getString("CURSO"));
				alunos.add(aluno);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return alunos;
	}

}
