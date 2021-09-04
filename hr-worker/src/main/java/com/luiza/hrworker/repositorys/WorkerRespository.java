package com.luiza.hrworker.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiza.hrworker.entitys.Worker;

public interface WorkerRespository extends JpaRepository<Worker, Long> {

}
