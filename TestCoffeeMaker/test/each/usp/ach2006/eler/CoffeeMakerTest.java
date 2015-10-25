package each.usp.ach2006.eler;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.CoffeeMaker;
import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InsufficientAmountOfMoneyException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InventoryException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.RecipeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	/* Segundo especifica��o:
	 * Na classe CoffeeMakerTest devem ser escritos os casos de teste para testar as opera��es para adicionar receita,
	 * apagar receita, adicionar ingredientes, verificar quantidade de ingredientes, fazer caf� e obter receitas.
	 */
	
	/* Classes a serem testadas:
	 * 
	 * boolean addRecipe(Recipe r) throws InvalidValueException
	 * 
	 * boolean deleteRecipe(String recipeName) throws RecipeException
	 * 
	 * void addCoffeeInventory(int amtCoffee) throws InvalidValueException
	 * 
	 * void addMilkInventory(int amtMilk) throws InvalidValueException
	 * 
	 * void addSugarInventory(int amtSugar) throws InvalidValueException
	 * 
	 * void addChocolateInventory(int amtChocolate) throws InvalidValueException
	 * 
	 * int checkCoffeeInventory()
	 * 
	 * int checkMilkInventory()
	 * 
	 * int checkSugarInventory()
	 * 
	 * int checkChocolateInventory()
	 * 
	 * int makeCoffee(String recipeName, int amtPaid) throws RecipeException, 
	 * InsufficientAmountOfMoneyException, InventoryException
	 * 
	 * Vector<Recipe> getRecipes()
	 * 
	 */
	
	private CoffeeMaker CM;
	private Recipe receitaValida1;
	private Recipe receitaValida2;
	private Recipe receitaValida3;
	private Recipe receitaValida4;
	private Recipe receitaNomeRepetido1;
	private Recipe receitaIngradientesRepetidos1;
	private Recipe receitaTestaInventarioCafeLimite;
	private Recipe receitaTestaInventarioLeiteLimite;
	private Recipe receitaTestaInventarioAcucarLimite;
	private Recipe receitaTestaInventarioChocolateLimite;
	private Recipe receitaTestaInventarioCafeInsuficiente;
	private Recipe receitaTestaInventarioLeiteInsuficiente;
	private Recipe receitaTestaInventarioAcucarInsuficiente;
	private Recipe receitaTestaInventarioChocolateInsuficiente;

	private int troco;
	
	@Before
	public void setUp() throws Exception {
		CM = new CoffeeMaker();
		receitaValida1 = new Recipe("Cafe",50,4,1,1,1);
		receitaValida2 = new Recipe("Chocolate Quente",75,1,3,1,3);
		receitaValida3 = new Recipe("Chocolate Frio",55,1,3,2,3);
		receitaValida4 = new Recipe("Cafe Fraco",25,1,1,1,1);
		receitaNomeRepetido1 = new Recipe("Cafe",50,5,1,2,1);
		receitaIngradientesRepetidos1 = new Recipe("Cafe Extra",50,4,1,1,1);
	
		receitaTestaInventarioCafeLimite = new Recipe ("Testa Cafe Limite",1,20,1,1,1);
		receitaTestaInventarioLeiteLimite = new Recipe ("Testa Leite Limite",1,1,20,1,1);
		receitaTestaInventarioAcucarLimite = new Recipe ("Testa Acucar Limite",1,1,1,20,1);
		receitaTestaInventarioChocolateLimite = new Recipe ("Testa Chocolate Limite",1,1,1,1,20);
		
		receitaTestaInventarioCafeInsuficiente = new Recipe ("Testa Cafe Insuficiente",1,21,1,1,1);
		receitaTestaInventarioLeiteInsuficiente = new Recipe ("Testa Leite Insuficiente",1,1,21,1,1);
		receitaTestaInventarioAcucarInsuficiente = new Recipe ("Testa Acucar Insuficiente",1,1,1,21,1);
		receitaTestaInventarioChocolateInsuficiente = new Recipe ("Testa Chocolate Insuficiente",1,1,1,1,21);
		troco = 0;
	}
	
	
	/* Testes para addRecipe - INICIO */
		
	@Test
	public void testaInsereMenosQueLimiteReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C1, C2, C3
		 * Valor-limite: v1, v3, v4 */
		
		boolean ok = CM.addRecipe(receitaValida1);
		assertTrue(ok);
	}

	@Test
	public void testaInsereLimiteReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C1, C2, C3
		 * Valor-limite: v2, v3, v4 */
		
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaValida2);
		ok = CM.addRecipe(receitaValida3);
		assertTrue(ok);
	}
	
	@Test (expected = AmountOfRecipeException.class)
	public void testaInsereQuatroReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C20, C2, C3
		 * Valor-limite: v19, v3, v4 */
		
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaValida2);
		ok = CM.addRecipe(receitaValida3);
		ok = CM.addRecipe(receitaValida4);
		assertEquals(false, ok);
	}
	
	@Test (expected = DuplicatedRecipeException.class)
	public void testaInsereReceitaNomeDuplicado() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C1, C21, C3
		 * Valor-limite: v1, v20, v4*/
		
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaNomeRepetido1);
		assertTrue(ok);
	}
	
	@Test (expected = DuplicatedRecipeException.class)
	public void testaInsereReceitaIngredientesRepetidos() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C1, C2, C22
		 * Valor-limite: v1, v3, v21 */
		
		boolean ok = CM.addRecipe(receitaValida1);
		ok = CM.addRecipe(receitaIngradientesRepetidos1);
		assertTrue(ok);
	}
	
	/* Testes para addRecipe - FIM */
	
	
	/* Testes para deleteRecipe - INICIO */
	
	@Test
	public void testaRemoveReceitaValida() throws RecipeException, AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C4
		 * Valor-limite: - */
		
		CM.addRecipe(receitaValida1);
		boolean ok = CM.deleteRecipe(CM.getRecipes().get(0).getName());
		assertEquals(true, ok);
	}
	
	@Test (expected = RecipeException.class)
	public void testaRemoveReceitaInvalida() throws AmountOfRecipeException, DuplicatedRecipeException, RecipeException{
		/* Classe de equivalencia: C23
		 * Valor-limite: - */
		
		CM.addRecipe(receitaValida1);
		boolean ok = CM.deleteRecipe("Suco de Laranja");
		assertEquals(false, ok);
	}
	
	/* Testes para deleteRecipe - FIM */
	
	
	/* Testes para addCoffeeInventory - INICIO */
	
	@Test
	public void testaRepoeCafeValido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C5
		 * Valor-limite: v1, v5 */
		
		CM.addCoffeeInventory(100-CM.checkCoffeeInventory());
		int qtdCafe = CM.checkChocolateInventory();
		assertEquals(100, qtdCafe);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeCafeInvalido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C24
		 * Valor-limite: v22 */
		
		CM.addCoffeeInventory(101-CM.checkCoffeeInventory());
	}
	
	/* Testes para addCoffeeInventory - FIM */
	
	
	/* Testes para addMilkInventory - INICIO */
	
	@Test
	public void testaRepoeLeiteValido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C6
		 * Valor-limite: v6 */
		
		CM.addMilkInventory(100-CM.checkMilkInventory());
		int qtdLeite = CM.checkMilkInventory();
		assertEquals(100, qtdLeite);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeLeiteInvalido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C25
		 * Valor-limite: v23 */
		
		CM.addMilkInventory(101-CM.checkMilkInventory());
	}
	
	/* Testes para addMilkInventory - FIM */
	
	
	/* Testes para addSugarInventory - INICIO */
	
	@Test
	public void testaRepoeAcucarValido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C7
		 * Valor-limite: v7 */
		
		CM.addSugarInventory(100-CM.checkSugarInventory());
		int qtdAcucar = CM.checkSugarInventory();
		assertEquals(100, qtdAcucar);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeAcucarInvalido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C26
		 * Valor-limite: v24 */
		
		CM.addSugarInventory(101-CM.checkSugarInventory());
	}
	
	/* Testes para addSugarInventory - FIM */
	
	
	/* Testes para addChocolateInventory - INICIO */
	
	@Test
	public void testaRepoeChocolateValido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C8
		 * Valor-limite: v8 */
		
		CM.addChocolateInventory(100-CM.checkChocolateInventory());		
		int qtdChocolate = CM.checkChocolateInventory();
		assertEquals(100, qtdChocolate);
	}
	
	@Test (expected = InvalidValueException.class)
	public void testaRepoeChocolateInvalido() throws InvalidValueException{
		/* Classe de equivalencia: C1, C2, C3, C27
		 * Valor-limite: 0 */
		
		CM.addChocolateInventory(101-CM.checkChocolateInventory());
	}
	
	/* Testes para addChocolateInventory - FIM */
	

	/* Testes para checkCoffeeInventory - INICIO */
	
	@Test
	public void testaInventorioCafe() throws Exception{
		/* Classe de equivalencia: C9
		 * Valor-limite: v9 */
		
		int qtdCafe = CM.checkCoffeeInventory();
		assertEquals(20, qtdCafe);
	}
	
	/* Testes para checkCoffeeInventory - FIM */
	
	
	/* Testes para checkMilkInventory - INICIO */
	
	@Test
	public void testaInventorioLeite(){
		/* Classe de equivalencia: C10
		 * Valor-limite: v10 */
		
		int qtdLeite = CM.checkMilkInventory();
		assertEquals(20, qtdLeite);
	}
	
	/* Testes para checkMilkInventory - FIM */
	
	
	/* Testes para checkSugarInventory - INICIO */
	
	@Test
	public void testaInventorioAcucar() throws Exception{
		/* Classe de equivalencia: C11
		 * Valor-limite: v11 */
		
		int qtdAcucar = CM.checkSugarInventory();
		assertEquals(20, qtdAcucar);
	}
	
	/* Testes para checkSugarInventory - FIM */
	
	
	/* Testes para checkChocolateInventory - INICIO */
	
	@Test
	public void testaInventorioChocolate() throws Exception{
		/* Classe de equivalencia: C12
		 * Valor-limite: v12 */
		
		int qtdChocolate = CM.checkChocolateInventory();
		assertEquals(20, qtdChocolate);
	}
	
	/* Testes para checkChocolateInventory - FIM */
	

	/* Testes para makeCoffee - INICIO */
	
	@Test
	public void testaFazerCafeSemTroco() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C14, C15, C16, C17, C18
		 * Valor-limite: v13 */
		
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice());
		assertEquals(0, troco);
	}
	
	@Test
	public void testaFazerCafeComTroco() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C14, C15, C16, C17, C18
		 * Valor-limite: v14 */
		
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(1, troco);
	}

	@Test (expected = InsufficientAmountOfMoneyException.class)
	public void testaFazerCafeDinheiroInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C33, C14, C15, C16, C17
		 * Valor-limite: v30 */
		
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()-1);			
		assertEquals(CM.getRecipes().get(0).getPrice()-1, troco);
	}
	
	@Test (expected = RecipeException.class)
	public void testaFazerCafeReceitaInexistente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C32
		 * Valor-limite: - */
		
		CM.addRecipe(receitaValida1);
		troco = CM.makeCoffee("Suco de laranja", CM.getRecipes().get(0).getPrice()+1);
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}
	
	@Test
	public void testaFazerCafeInventorioCafeLimite() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C16, C17, C18
		 * Valor-limite: v14, v15 */
		
		CM.addRecipe(receitaTestaInventarioCafeLimite);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(1, troco);
	}
	
	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioCafeInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C34, C16, C17, C18
		 * Valor-limite: v14, v31 */
		
		CM.addRecipe(receitaTestaInventarioCafeInsuficiente);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}

	@Test
	public void testaFazerCafeInventorioLeiteLimite() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C16, C17, C18
		 * Valor-limite: v14, v16 */
		
		CM.addRecipe(receitaTestaInventarioLeiteLimite);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(1, troco);
	}
	
	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioLeiteInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C35, C17, C18
		 * Valor-limite: v14, v32 */
		
		CM.addRecipe(receitaTestaInventarioLeiteInsuficiente);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}

	@Test
	public void testaFazerCafeInventorioAcucarLimite() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C16, C17, C18
		 * Valor-limite: v14, v17 */
		
		CM.addRecipe(receitaTestaInventarioAcucarLimite);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(1, troco);
	}
	
	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioAcucarInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C16, C36, C18
		 * Valor-limite: v14, v33 */
		
		CM.addRecipe(receitaTestaInventarioAcucarInsuficiente);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}
	
	@Test
	public void testaFazerCafeInventorioChocolateLimite() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C16, C17, C18
		 * Valor-limite: v14, v18 */
		
		CM.addRecipe(receitaTestaInventarioChocolateLimite);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(1, troco);
	}
	
	@Test (expected = InventoryException.class)
	public void testaFazerCafeInventorioChocolateInsuficiente() throws AmountOfRecipeException, DuplicatedRecipeException, InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException{
		/* Classe de equivalencia: C13, C15, C16, C17, C37
		 * Valor-limite: v14, v34 */
		
		CM.addRecipe(receitaTestaInventarioChocolateInsuficiente);
		troco = CM.makeCoffee(CM.getRecipes().get(0).getName(), CM.getRecipes().get(0).getPrice()+1);
		assertEquals(CM.getRecipes().get(0).getPrice()+1, troco);
	}

	/* Testes para makeCoffee - FIM */
	
	
	/* Testes para getRecipes - INICIO */
	
	@Test
	public void testaRetornaReceitas() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C1, C2, C3, C38
		 * Valor-limite: - */
		
		CM.addRecipe(receitaValida1);
		CM.addRecipe(receitaValida2);
		CM.addRecipe(receitaValida3);
		Vector<Recipe> receitas = new Vector<>();
		receitas.addElement(receitaValida1);
		receitas.addElement(receitaValida2);
		receitas.addElement(receitaValida3);
		assertEquals(receitas, CM.getRecipes());
	}
	
	@Test
	public void testaRetornaReceitasVazia() throws AmountOfRecipeException, DuplicatedRecipeException{
		/* Classe de equivalencia: C1, C2, C3
		 * Valor-limite: - */
		
		//Vector<Recipe> receitas = null;
		Vector<Recipe> receitas = new Vector<>();
		assertEquals(receitas, CM.getRecipes());
	}
	
	/* Testes para getRecipes - FIM */

}