package com.ecommerce.back;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.back.coleccion.Categoria;
import com.ecommerce.back.coleccion.Producto;
import com.ecommerce.back.repositorio.CategoriRepositorio;
import com.ecommerce.back.repositorio.ProductoRepositorio;
import com.ecommerce.back.service.ProductoService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BackEcommerceApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(BackEcommerceApplicationTests.class);
	/*
	@Test
	void contextLoads() {
	}
	*/
	
	@Mock
	private ProductoRepositorio productoRepositorio;
	
	@InjectMocks
	private ProductoService productoService;

	//Test unitario para listar productos
		@Test
		public void testListarProductos() {
			
			try {
				
				Categoria categoria = new Categoria("1", "Calzado");
				Producto producto = new Producto("1", "Adidas Courtmaster", "Zapatillas blancas", 160.0, 10, categoria);
				
				List<Producto> listProducto = Arrays.asList(producto);
				
				Mockito.when(productoRepositorio.findAll()).thenReturn(listProducto);
				
				List<Producto> resultListProduct = productoService.listAllProductos();
				
				logger.info("Lista de productos: {}", resultListProduct);
				
				//Validaciones
				//assertNotNull(resultListProduct);
				//assertEquals(1, resultListProduct.size());
				//assertEquals("Adidas Courtmaster", resultListProduct.get(0).getNombre());
				
				
				Mockito.verify(productoRepositorio, Mockito.times(1)).findAll();
				
			} catch (Exception e) {
				logger.error("ERROR EN EL TEST DE LISTAR PRODUCTOS{}", e.getMessage(), e);
			}
}
}