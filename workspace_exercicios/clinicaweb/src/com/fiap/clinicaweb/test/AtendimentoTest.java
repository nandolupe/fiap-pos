package com.fiap.clinicaweb.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fiap.clinicaweb.datatype.AtendProcMatMed;
import com.fiap.clinicaweb.datatype.AtendProcMatMedPK;
import com.fiap.clinicaweb.datatype.Atendimento;
import com.fiap.clinicaweb.datatype.Especialista;
import com.fiap.clinicaweb.datatype.MatMed;
import com.fiap.clinicaweb.datatype.Paciente;
import com.fiap.clinicaweb.datatype.Procedimento;
import com.fiap.clinicaweb.datatype.Seguradora;
import com.fiap.clinicaweb.datatype.TipoEspecialista;
import com.fiap.clinicaweb.persistence.GenericDAO;

public class AtendimentoTest {
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaweb");
		EntityManager em = emf.createEntityManager();
		criarDados(em);
		
		listarTabelas(em, 
				new TipoEspecialista(),
				new Especialista(),
				new Seguradora(),
				new Paciente(),
				new Procedimento(),
				new MatMed(),
				new Atendimento(),
				new AtendProcMatMed()
				);
	}
	
	/**
	 * Método responsável em criar os dados do sistema para testes.
	 * 
	 * @param em
	 * @throws ParseException 
	 */
	private static void criarDados(EntityManager em) throws ParseException {
		GenericDAO genericDAO = new GenericDAO(em);
		
		TipoEspecialista tipoEspecialista = new TipoEspecialista("01", "Primeiro Auxiliar");
		genericDAO.update(tipoEspecialista);
		
		Especialista especialista = new Especialista(1L, "4545-6936"
				,	"375.789.456-98"
				, "TESTE 1"
				, "Antonio"
				, "Carlos Muñoz"
				, "36.896.789-9"
				, "M"
				, "Miranda"
				, tipoEspecialista
				);
		genericDAO.update(especialista);
		
		Seguradora seguradora = new Seguradora("006246", "01.685.053/0001-56", null, new Date(), "S", "SUL AMERICA COMPANHIA DE SEGURO SAÚDE");
		genericDAO.update(seguradora);
		
		Paciente paciente = new Paciente(
				1, "Vila do Bosque", "11987898", "04147050", "São Paulo", "456.546.879-78", new SimpleDateFormat("dd/MM/yyyy").parse("13/02/1989"), null, new Date(), 
				"Rua Patuai", "D", "S", "Luiz Fernando", "Ivene Luciano", "Francisco Maria", "37.565.897-9", "M", "Pereira", "5445-7896"
				, "SP", "test", null, seguradora
				);
		genericDAO.update(paciente);
		
		MatMed mat = new MatMed("6F0701058", "CATETER GUIA PENUMBRA", null, new Date(), "A", 1, null, "test", new BigDecimal("89.56"));
		genericDAO.update(mat);
		
		MatMed med = new MatMed("459", "ACETILCISTEINA - 15%", null, new Date(), "E", 1, null, "test", new BigDecimal("20.00"));
		genericDAO.update(med);
		
		Procedimento procedimento = new Procedimento("28140060", null, new Date(), null, "test", 45.00, "PROVAS ATIVIDADES FEBRE REUMATICA");
		genericDAO.update(procedimento);
		
		Atendimento atendimento = new Atendimento(1, new Date(), null, new Date(), null, "test", paciente);
		genericDAO.update(atendimento);
		
		AtendProcMatMed atendProcMatMed = new AtendProcMatMed(
				new AtendProcMatMedPK(procedimento.getCodProcedimento(), mat.getCodMatMed(), atendimento.getIdAtendimento())
				, "TESTE", null, new Date(), null, "test", especialista
				);
		genericDAO.update(atendProcMatMed);
	}
	
	/**
	 * Método responsável em listar todas as tabelas do sistema.
	 * 
	 * @param em
	 * @param entityList
	 */
	private static void listarTabelas(EntityManager em2, Serializable... entityList) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaweb");
		EntityManager em = null;
		GenericDAO genericDAO = null;
		
		for (Serializable entity : entityList) {
			em = emf.createEntityManager();
			genericDAO = new GenericDAO(em);

			System.out.println("Tabela: " + entity.getClass().getSimpleName());
			System.out.println("Dados: ");
			for (Serializable entityEspec : genericDAO.findAll(entity)) {
				System.out.println(entityEspec.toString());
			}
			System.out.println("---------------------------------------------------------");
		}
	}
}
