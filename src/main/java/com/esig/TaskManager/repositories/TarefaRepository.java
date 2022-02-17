package com.esig.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esig.TaskManager.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
}
