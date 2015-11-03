package each.usp.ach2006.eler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.CoffeeMaker;
import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InsufficientAmountOfMoneyException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InventoryException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.RecipeException;

public class CoffeeMakerStructuralTest {
	/* Segundo especificacao:
	 * Na classe CoffeeMakerTest devem ser escritos os casos de teste para testar as operacoes para adicionar receita,
	 * apagar receita, adicionar ingredientes, verificar quantidade de ingredientes, fazer cafe e obter receitas.
	 */
	
	/* Metodos a serem testados:
	 * 
	 * boolean addRecipe(Recipe r) throws InvalidValueException 
	 *  
	 * void addCoffeeInventory(int amtCoffee) throws InvalidValueException
	 * 
	 * void addMilkInventory(int amtMilk) throws InvalidValueException
	 * 
	 * void addSugarInventory(int amtSugar) throws InvalidValueException
	 * 
	 * void addChocolateInventory(int amtChocolate) throws InvalidValueException
	 * 
	 * int makeCoffee(String recipeName, int amtPaid) throws RecipeException,
	 * InsufficientAmountOfMoneyException, InventoryException
	 * 
	 */
	
	private CoffeeMaker CM;
	private Recipe receitaValida1;
	private Recipe receitaValida2;
	private Recipe receitaValida3;
	private Recipe receitaValida4;
	
	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		receitaValida1 = new Recipe("Cafe",100,4,1,1,1);
		receitaValida2 = new Recipe("Chocolate Quente",75,1,3,1,3);
		receitaValida3 = new Recipe("Chocolate Frio",55,1,3,2,3);
		receitaValida4 = new Recipe("Cafe Fraco",25,1,1,1,1);
	}
	
	/* Testes para makeCoffee - INICIO */
	
	@Test (expected=InvalidValueException.class) 
	public void testaPagamentoMaiorQue500() throws InvalidValueException, DuplicatedRecipeException, AmountOfRecipeException, InventoryException, RecipeException, InsufficientAmountOfMoneyException  {
		/* Classe de equivalencia: 
		 * Valor-limite: */
		CM.addRecipe(receitaValida1);
		int troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), 501);
		assertEquals(401,troco);
	}
	
	@Test (expected=InvalidValueException.class) 
	public void testaPagamentoNegativo() throws InvalidValueException, DuplicatedRecipeException, AmountOfRecipeException, InventoryException, RecipeException, InsufficientAmountOfMoneyException  {
		/* Classe de equivalencia: 
		 * Valor-limite: */
		CM.addRecipe(receitaValida1);
		int troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), -1);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaFazerCafeDinheiroNegativo() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C33, C15, C16, C17, C18
		 * Valor-limite: amtPaid < 0 */
		
		CM.addRecipe(receitaValida1);
		int troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), -1);
	}

	@Test
	public void testaFazerCafeConsumoInventario() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C14, C15, C16, C17, C18
		 * Valor-limite: - */

	    Recipe receitaUnitaria = new Recipe("Teste Unidades", 1, 1, 1, 1, 1);
		int cafeInicial = CM.checkCoffeeInventory();
		int leiteInicial = CM.checkMilkInventory();
		int acucarInicial = CM.checkSugarInventory();
		int chocolateInicial = CM.checkChocolateInventory();
			
		CM.addRecipe(receitaUnitaria);
		CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
			
		assertEquals(cafeInicial-CM.getRecipes().get(0).getAmtCoffee(), CM.checkCoffeeInventory());
		assertEquals(leiteInicial-CM.getRecipes().get(0).getAmtMilk(), CM.checkMilkInventory());
		assertEquals(acucarInicial-CM.getRecipes().get(0).getAmtSugar(), CM.checkSugarInventory());
		assertEquals(chocolateInicial-CM.getRecipes().get(0).getAmtChocolate(), CM.checkChocolateInventory());
	}
	
	/* Testes para makeCoffee - FIM */
	
	/* Testes para addChocolateInventory - INICIO */
	
	@Test (expected=InvalidValueException.class)
	public void testaRetirarUmaUnidadeInventarioChocolate() throws InvalidValueException {
		/* Classe de equivalencia: 
		 * Valor-limite: */
		CM.addChocolateInventory(-1);
	}
	
	/* Testes para addChocolateInventory - FIM */
	
	/* Testes para addCoffeeInventory - INICIO */
	
	@Test (expected=InvalidValueException.class)
	public void testaRetirarUmaUnidadeInventarioCafe() throws InvalidValueException {
		/* Classe de equivalencia: 
		 * Valor-limite: */
		CM.addCoffeeInventory(-1);
	}
	
	/* Testes para addCoffeeInventory - FIM */
	
	/* Testes para addMilkInventory - INICIO */
	
	@Test (expected=InvalidValueException.class)
	public void testaRetirarUmaUnidadeInventarioLeite() throws InvalidValueException {
		/* Classe de equivalencia: 
		 * Valor-limite: */
		CM.addMilkInventory(-1);
	}
	
	/* Testes para addMilkInventory - FIM */
	
	/* Testes para addSugarInventory - INICIO */
	
	@Test (expected=InvalidValueException.class)
	public void testaRetirarUmaUnidadeInventarioAcucar() throws InvalidValueException {
		/* Classe de equivalencia: 
		 * Valor-limite: */
		CM.addSugarInventory(-1);
	}
	
	/* Testes para addSugarInventory - FIM */
	
	/* Testes para addRecipe - INICIO*/
	
	@Test
	public void testaInsereQuatroReceitasEVerificaNumeroReceitasInseridas () throws DuplicatedRecipeException {
		/* Classe de equivalencia: C20, C2, C3
		 * Valor-limite: v19, v3, v4 */
		try {
			CM.addRecipe(receitaValida1);
			CM.addRecipe(receitaValida2);
			CM.addRecipe(receitaValida3);
			CM.addRecipe(receitaValida4);
		}
		catch (AmountOfRecipeException a) {
			int qntd = CM.getRecipes().size();
			assertEquals(3, qntd);
		}
	}

	/* Testes para addRecipe - FIM*/
}