package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.ProfessorDAO;
import br.edu.ifms.jsf.FacesUtil;
import br.edu.ifms.modelo.Professor;
import br.edu.ifms.service.NegocioException;

@Named
@ViewScoped
public class PesquisaProfessorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ProfessorDAO professorDAO;
	
	private List<Professor> professores = new ArrayList<Professor>();
	
	private Professor professorSelecionado;
	
	public List<Professor> getProfessores(){
		return professores;
	}
	
	public void excluir() {
		try {
			professorDAO.excluir(professorSelecionado);
			this.professores.remove(professorSelecionado);
			FacesUtil.addSuccessMessage("Professor " + professorSelecionado.getNome() + " exclu�do com sucesso.");
			
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}
	
	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		professores = professorDAO.buscarTodos();
		System.out.println(professores);
	}
}
