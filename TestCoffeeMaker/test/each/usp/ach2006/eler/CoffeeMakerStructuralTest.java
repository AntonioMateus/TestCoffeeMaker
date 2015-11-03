package each.usp.ach2006.eler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

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
	
	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		receitaValida1 = new Recipe("Cafe",100,4,1,1,1);
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
	
	
	
	
	
	
	
}
