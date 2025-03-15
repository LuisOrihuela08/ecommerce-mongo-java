package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Pedido;

public interface PedidoRepositorio extends MongoRepository<Pedido, String>{

}
