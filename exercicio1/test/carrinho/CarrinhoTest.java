package carrinho;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {
	
	private Carrinho full_cart, empty_cart;
	private Produto product1, product2;
	
	@BeforeEach
	public void inicializa() {
		full_cart = new Carrinho();
		product1 = new Produto("Teclado", 150.00);
		product2 = new Produto("Mouse", 100.00);
		full_cart.addItem(product1);
		full_cart.addItem(product2);
		empty_cart = new Carrinho();
	}
	
	@DisplayName("Testa o método de valor total")
	@Test
	public void testGetValorTotal() {
		double valorTotal = full_cart.getValorTotal();
		Assertions.assertEquals(250.00, valorTotal);
		valorTotal = empty_cart.getValorTotal();
		Assertions.assertEquals(0.00, valorTotal);
	}
	
	@DisplayName("Testa o método de adicionar item")
	@Test
	public void testAddItem() {
		Produto product3 = new Produto("Gabinete", 300.00); 
		full_cart.addItem(product3);
		Assertions.assertEquals(3, full_cart.getQtdeItems());
	}
	
	@DisplayName("Testa o método de remover item")
	@Test
	public void testRemoveItem() {
		try {
			full_cart.removeItem(product1);
		} catch (ProdutoNaoEncontradoException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("Testa o método de remover item quando o item não existe")
	@Test
	public void testRemoveItemNaoExistente() {
		Produto product3 = new Produto("Gabinete", 300.00);
		Assertions.assertThrows(ProdutoNaoEncontradoException.class, 
				() -> full_cart.removeItem(product3));
	}
	
	@DisplayName("Testa o método de quantidade de itens no carrinho")
	@Test
	public void testGetQtdeItems() {
		Assertions.assertEquals(2, full_cart.getQtdeItems());
	}
	
	@DisplayName("Testa o método de esvaziar itens do carrinho")
	@Test
	public void testEsvazia() {
		full_cart.esvazia();
		Assertions.assertEquals(0, full_cart.getQtdeItems());
	}
	
}
