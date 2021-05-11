package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtração de dois n�meros")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(5, 4);		
		Assertions.assertEquals(1, subtracao);
		subtracao = calc.subtracao(5, 5);		
		Assertions.assertEquals(0, subtracao);
		subtracao = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, subtracao);
	}
	
	@DisplayName("Testa a multiplicação de dois n�meros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(5, 4);		
		Assertions.assertEquals(20, multiplicacao);
		multiplicacao = calc.multiplicacao(5, -5);		
		Assertions.assertEquals(-25, multiplicacao);
		multiplicacao = calc.multiplicacao(4, 0);		
		Assertions.assertEquals(0, multiplicacao);
	}
		
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a somatoria")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);		
		Assertions.assertEquals(15, somatoria);
		somatoria = calc.somatoria(0);		
		Assertions.assertEquals(0, somatoria);
		somatoria = calc.somatoria(-1);		
		Assertions.assertEquals(0, somatoria);
		
	}
	
	@DisplayName("Testa se um número é positivo")
	@Test
	public void testehPositivo() {
		boolean retorno = calc.ehPositivo(5);		
		Assertions.assertEquals(true, retorno);
		retorno = calc.ehPositivo(-1);
		Assertions.assertEquals(false, retorno);
	}
	
	@DisplayName("Testa a comparação entre dois números")
	@Test
	public void testCompara() {
		int comparacao = calc.compara(5, 5);		
		Assertions.assertEquals(0, comparacao);
		comparacao = calc.compara(5, 4);		
		Assertions.assertEquals(1, comparacao);
		comparacao = calc.compara(4, 5);		
		Assertions.assertEquals(-1, comparacao);
	}
}
