package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.DetallePedido;

public interface DetallePedidoRepositorio extends MongoRepository<DetallePedido, String>{

}
