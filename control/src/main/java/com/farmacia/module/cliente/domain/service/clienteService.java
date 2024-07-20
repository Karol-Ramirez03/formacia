package com.farmacia.module.cliente.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.cliente.domain.entity.cliente;

public interface clienteService {
    
    public Optional<cliente> findbyid(String id);
    public List<cliente> findAll();
    public void add(cliente cliente);
    public void delete(String id);
    public void update(cliente cliente);
}
