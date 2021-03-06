package com.esig.TaskManager.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity	
@Table(name="produtos")
public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public enum Prioridade {
		ALTA,MEDIA,BAIXA
	}

	public enum Status {
		EM_ANDAMENTO,CONCLUIDA
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String descricao;
	private Prioridade prioridade;
	private Status status;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date deadline;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario responsavel;

	
	
	public Tarefa() {
	}

	public Tarefa(Long id, String titulo , String descricao, Usuario responsavel) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.setDescricao(descricao);
		this.responsavel = responsavel;
		this.status = Status.EM_ANDAMENTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	
	
	
	
}
