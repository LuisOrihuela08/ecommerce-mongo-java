package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Pago;

public interface PagoRepositorio extends MongoRepository<Pago, String>{

}
