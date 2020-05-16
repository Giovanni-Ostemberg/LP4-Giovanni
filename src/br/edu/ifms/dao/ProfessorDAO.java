package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifms.modelo.Professor;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

public class ProfessorDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject EntityManager em;
	
	public void salvar(Professor professor) {
		em.merge(professor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> buscarTodos(){
		return em.createQuery("from Professor").getResultList();
		/* TypedQuery<Professor> query = em.createQuery("SELECT * FROM professor",
			        Professor.class);
			    List<Professor> emps = query.getResultList();
			    return emps;*/
	}
	
	@Transactional
	public void excluir(Professor professor) throws NegocioException{
		Professor professorTemp = em.find(Professor.class,  professor.getCodigo());
		
		em.remove(professorTemp);
		em.flush();
	}
	
	public Professor buscarPeloCodigo(Long codigo) {
		return em.find(Professor.class, codigo);
	}
}
