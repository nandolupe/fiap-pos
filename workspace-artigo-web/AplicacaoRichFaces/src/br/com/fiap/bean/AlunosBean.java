package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.DaoAlunos;

@ManagedBean(name="aluno")
@RequestScoped
public class AlunosBean {

	private Alunos aluno = new Alunos();
	private String mensagem;
	private String cursoPesquisa;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}
	
	public String getCursoPesquisa() {
        return this.cursoPesquisa;
    }

    public void setCursoPesquisa(String cursoPesquisa) {
        this.cursoPesquisa = cursoPesquisa;
    }

    public List<SelectItem> getCursos(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("SCJ","Arquiteturas Java-SOA"));
		lista.add(new SelectItem("AOJ","Analise Orientada a Objetos em Java"));
		lista.add(new SelectItem("MIT","Master in Information Technology"));
		return lista;
	}
	
	public List<Alunos> getListaAlunos() throws Exception{
		return new DaoAlunos().listarAlunos(cursoPesquisa);
	}
	
	public void getListaAlunosVoid() throws Exception{
	    getListaAlunos();
    }
	
	public String cadastrarAluno() {
		try {
			new DaoAlunos().incluir(aluno);
			setMensagem("RM " + aluno.getRm() + " incluído com sucesso!");
			return "/index";
		} catch (Exception e) {
			return "/erro";
		}
	}
	
	public String listarTodosAlunos(){
		return "/index";
	}
}
