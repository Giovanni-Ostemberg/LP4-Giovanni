package br.edu.ifms.controller;

import java.util.List;

import br.edu.ifms.dao.ProfessorDAO;
import br.edu.ifms.modelo.Professor;

public class teste {

	public static void main(String[] args) {
		ProfessorDAO pesquisa = new ProfessorDAO();
		/*PesquisaProfessorBean pq = new PesquisaProfessorBean();
		pq.inicializar();*/
		Professor lista =	pesquisa.buscarPeloCodigo((long) 1);
	}

}
