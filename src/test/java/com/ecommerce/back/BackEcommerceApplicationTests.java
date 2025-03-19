package com.ecommerce.back;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.back.coleccion.Categoria;
import com.ecommerce.back.coleccion.Producto;
import com.ecommerce.back.dto.ProductoDTO;
import com.ecommerce.back.repositorio.CategoriRepositorio;
import com.ecommerce.back.repositorio.ProductoRepositorio;
import com.ecommerce.back.service.ProductoService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BackEcommerceApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(BackEcommerceApplicationTests.class);

	/*
	 * @Test void contextLoads() { }
	 */

	@Mock
	private ProductoRepositorio productoRepositorio;

	@Mock
	private CategoriRepositorio categoriRepositorio;

	@InjectMocks
	private ProductoService productoService;

	// Test unitario para listar productos
	@Test
	public void testListarProductos() {

		try {

			Categoria categoria = new Categoria("1", "Calzado");
			Producto producto = new Producto("1", "Adidas Courtmaster", "Zapatillas blancas", 160.0, 10, categoria);

			List<Producto> listProducto = Arrays.asList(producto);

			Mockito.when(productoRepositorio.findAll()).thenReturn(listProducto);

			List<Producto> resultListProduct = productoService.listAllProductos();

			logger.info("Lista de productos: {}", resultListProduct);

			Mockito.verify(productoRepositorio, Mockito.times(1)).findAll();

		} catch (Exception e) {
			logger.error("ERROR EN EL TEST DE LISTAR PRODUCTOS{}", e.getMessage(), e);
		}
	}

	// Test para agregar un producto
	@Test
	public void testCreateProducto() {

		try {

			Categoria categoria = new Categoria();
			categoria.setCategoria_id("1");
			categoria.setNombre("Tecnologia");

			Mockito.when(categoriRepositorio.findById("1")).thenReturn(Optional.of(categoria));

			ProductoDTO productoDto = new ProductoDTO();
			productoDto.setNombre("Laptop");
			productoDto.setDescripcion("Laptop de 11g");
			productoDto.setPrecio(1600.0);
			productoDto.setStock(10);
			productoDto.setCategoria_id("1");

			Producto productoEsperado = new Producto();
			productoEsperado.setProducto_id("1");
			productoEsperado.setNombre(productoDto.getNombre());
			productoEsperado.setDescripcion(productoDto.getDescripcion());
			productoEsperado.setPrecio(productoDto.getPrecio());
			productoEsperado.setStock(productoDto.getStock());
			productoEsperado.setCategoria(categoria);

			Mockito.when(productoRepositorio.save(Mockito.any(Producto.class))).thenReturn(productoEsperado);

			Producto productoNuevo = productoService.saveProducto(productoDto);

			logger.info("Producto guardado con exito: {}", productoNuevo);

			assertNotNull(productoNuevo);
			assertEquals("1", productoNuevo.getProducto_id());
			assertEquals("Laptop", productoNuevo.getNombre());
			assertEquals("Laptop de 11g", productoNuevo.getDescripcion());
			assertEquals(1600.0, productoNuevo.getPrecio());
			assertEquals(10, productoNuevo.getStock());

		} catch (Exception e) {
			logger.error("ERROR AL CREAR PRODUCTO TEST: {}", e.getMessage(), e);
			fail("Se produjo un error en la prueba: " + e.getMessage());
		}
	}

	// Test para eliminar un producto
	@Test
	public void testEliminarProducto() {

		try {

			Categoria categoria = new Categoria("1", "Calzado");
			Producto producto = new Producto("1", "Adidas Courtmaster", "Zapatillas blancas", 160.0, 10, categoria);

			Mockito.doNothing().when(productoRepositorio).deleteById("1");

			productoService.deleteProducto("1");

			logger.info("TEST PRODUCTO ELIMINADO OK");

			// Verificando que el método deleteById fue llamado con el ID correcto
			Mockito.verify(productoRepositorio, Mockito.times(1)).deleteById("1");

		} catch (Exception e) {
			logger.error("ERROR EN EL TEST DE ELIMINAR EL PRODUCTO: ", e.getMessage(), e);
		}
	}
}