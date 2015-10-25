package each.usp.ach2006.eler;

import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import static org.junit.Assert.assertEquals;

public class RecipeTest {
	/* Testa a criação de uma receita */
	
	/* Segundo especificação:
	 * Na classe RecipeTest devem ser escritos os casos de teste para testar as operações da
	 * classe Recipe. Em particular, deve-se testar apenas a criação de uma receita por meio de seu construtor.
	 */
	public RecipeTest() {
		
	}
	
	/* Testes para construtor - INICIO*/
	@Test (expected = InvalidValueException.class)
	public void testeNomeVazio() throws InvalidValueException {
		/* Classe de equivalencia: C2, C3, C4, C5, C6, C7, C8
		 * Valor-limite: v8, v28*/
		Recipe receita = new Recipe("",50,4,3,1,5);
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testePrecoNulo() throws InvalidValueException {
		/* Classe de equivalencia: C1, C3, C4, C5, C6, C7, C9
		 * Valor-limite: v8, v29 */
		Recipe receita = new Recipe("Coffee",0,4,3,1,5);
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testePrecoNegativo() throws InvalidValueException {
		/* Classe de equivalencia: C1, C3, C4, C5, C6, C7, C9
		 * Valor-limite: v8 */
		Recipe receita = new Recipe("Coffee",-10,4,3,1,5);
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testeAmtCoffeeNegativo() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C4, C5, C6, C7, C10
		 * Valor-limite: v8 */
		Recipe receita = new Recipe ("Coffee",50,-4,3,1,5);
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testeAmtMilkNegativo() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C5, C6, C7, C11
		 * Valor-limite: v8, v32 */
		Recipe receita = new Recipe ("Coffee",50,4,-1,1,5);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testeAmtSugarNegativo() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C6, C7, C12
		 * Valor-limite: v6 */
		Recipe receita = new Recipe ("Coffee",50,4,1,-3,5);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testeAmtChocolateNegativo() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C7, C13
		 * Valor-limite: v6*/
		Recipe receita = new Recipe ("Coffee",50,4,1,3,-4);
	}
	
	@Test 
	public void testeSemCafe() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C7
		 * Valor-limite: v3, v6 */
		Recipe receita = new Recipe ("Coffee",50,0,1,3,5);
	}
	
	@Test 
	public void testeSemLeite() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C7
		 * Valor-limite: v5 */
		Recipe receita = new Recipe ("Coffee",50,4,0,3,5);
	}
	
	@Test 
	public void testeSemAcucar() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C7
		 * Valor-limite: v6, v7 */
		Recipe receita = new Recipe ("Coffee",50,4,1,0,5);
	}
	
	@Test 
	public void testeSemChocolate() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C7
		 * Valor-limite: v6, v9 */
		Recipe receita = new Recipe ("Coffee",50,4,1,3,0);
	}
	
	@Test
	public void testeSemDoisIngredientes() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C7
		 * Valor-limite: v5, v8, v9 */
		Recipe receita = new Recipe("Coffee",50,4,0,1,0);
	}
	
	@Test 
	public void testeSemTresIngredientes() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C7
		 * Valor-limite: v3, v5, v8, v9, v13 */
		Recipe receita = new Recipe("Coffee",50,0,0,1,0);
	}
	
	@Test (expected = InvalidValueException.class) 
	public void testeNenhumIngrediente() throws InvalidValueException {
		/* Classe de equivalencia: C1, C2, C3, C4, C5, C6, C14
		 * Valor-limite: v3, v5, v7, v9, v35 */
		Recipe receita = new Recipe("Coffee",50,0,0,0,0);
	}
	/* Testes para construtor - FIM */
}
