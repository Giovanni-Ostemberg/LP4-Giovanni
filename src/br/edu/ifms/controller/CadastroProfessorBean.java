package br.edu.ifms.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.jsf.FacesUtil;
import br.edu.ifms.modelo.Professor;
import br.edu.ifms.service.CadastroProfessorService;
import br.edu.ifms.service.NegocioException;

@Named
@ViewScoped
public class CadastroProfessorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroProfessorService cadastroProfessorService;
	private Professor professor;
	
	public void salvar() {
		try {
			this.cadastroProfessorService.salvar(professor);
			FacesUtil.addSuccessMessage("Professor Salvo com sucesso!");
			
			this.limpar();			
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.professor = new Professor();
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
