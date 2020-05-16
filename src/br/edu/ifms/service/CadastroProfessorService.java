package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.ProfessorDAO;
import br.edu.ifms.modelo.Professor;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProfessorDAO professorDAO;
	
	@Transactional
	public void salvar(Professor professor) throws NegocioException{
		if(professor.getNome() == null || professor.getNome().trim().equals("")) {
			throw new NegocioException("O nome do professor é obrigatório");
		}
		
		this.professorDAO.salvar(professor);
	}
	

}
