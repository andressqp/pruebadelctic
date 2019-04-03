package com.example.spring.backend.apirest.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.backend.apirest.models.entity.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente,Long> {

}
