package each.usp.ach2006.eler;

import org.junit.Test;

import each.usp.ach2006.adaptedfromcsc326.eler.Recipe;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import static org.junit.Assert.assertEquals;

public class RecipeStructuralTest {
	/* Testa a criação de uma receita */
	
	/* Segundo especificação:
	 * Na classe RecipeTest devem ser escritos os casos de teste para testar as operações da
	 * classe Recipe. Em particular, deve-se testar apenas a criação de uma receita por meio de seu construtor.
	 */
	public RecipeStructuralTest() {
		
	}
	
	/* testes para construtor (após teste estrutural) - INICIO */
	@Test
	public void testeVerificaAmtChocolateReceita() throws InvalidValueException {
		/* Classe de equivalencia: (name != null && name.length > 0), (amtSugar >= 0 && amtSugar <= 100),
		 * (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), (amtChocolate >= 0 && amtChocolate <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1)*/
		Recipe receita = new Recipe("Cafe simples",50,4,1,1,1);
		assertEquals(1,receita.getAmtChocolate());
	}
	
	@Test (expected=InvalidValueException.class)
	public void testeCriaReceitaComMaisChocolateQueLimite() throws InvalidValueException {
		/* Classe de equivalencia: (amtChocolate > 100), (name != null && name.length > 0),
		 * (amtSugar >= 0 && amtSugar <= 100), (price > 0), (amtCoffee >= 0 && amtCoffee <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100) 
		 * Valor-limite: (amtChocolate = 101), (amtSugar = 1), (amtMilk = 1) */
		Recipe receita = new Recipe("Super chocolate",50,4,1,1,101);
	}
	
	@Test 
	public void testeVerificaAmtCoffeeReceita() throws InvalidValueException {
		/* Classe de equivalencia: (name != null && name.length > 0), (amtSugar >= 0 && amtSugar <= 100),
		 * (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), (amtChocolate >= 0 && amtChocolate <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1)*/
		Recipe receita = new Recipe("Cafe simples",50,4,1,1,1);
		assertEquals(4,receita.getAmtCoffee());
	}
	
	@Test (expected=InvalidValueException.class)
	public void testeCriaReceitaComMaisCafeQueLimite() throws InvalidValueException {
		/* Classe de equivalencia: (amtCoffee > 100), (name != null && name.length > 0), 
		 * (amtChocolate >= 0 && amtChocolate <= 100), (price > 0), (amtSugar >= 0 && amtSugar <= 100)
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtCoffee = 101), (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1) */
		Recipe receita = new Recipe("Super cafe",50,101,1,1,1);
	}
	
	@Test 
	public void testeVerificaAmtMilkReceita() throws InvalidValueException {
		/* Classe de equivalencia: (name != null && name.length > 0), (amtSugar >= 0 && amtSugar <= 100),
		 * (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), (amtChocolate >= 0 && amtChocolate <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1)*/
		Recipe receita = new Recipe("Cafe simples",50,4,1,1,1);
		assertEquals(1,receita.getAmtMilk());
	}
	
	@Test 
	public void testeVerificaAmtSugarReceita() throws InvalidValueException {
		/* Classe de equivalencia: (name != null && name.length > 0), (amtSugar >= 0 && amtSugar <= 100),
		 * (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), (amtChocolate >= 0 && amtChocolate <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1)*/
		Recipe receita = new Recipe("Cafe simples",50,4,1,1,1);
		assertEquals(1,receita.getAmtSugar());
	}
	
	@Test (expected=InvalidValueException.class)
	public void testeCriaReceitaComMaisAcucarQueLimite() throws InvalidValueException {
		/* Classe de equivalencia: (amtSugar > 100), (name != null && name.length > 0), 
		 * (amtChocolate >= 0 && amtChocolate <= 100), (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), 
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtSugar = 101), (amtMilk = 1), (amtChocolate = 1) */
		Recipe receita = new Recipe("Diabetes",50,4,1,101,1);
	}

	@Test 
	public void testeVerificaNomeReceita() throws InvalidValueException {
		/* Classe de equivalencia: (name != null && name.length > 0), (amtSugar >= 0 && amtSugar <= 100),
		 * (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), (amtChocolate >= 0 && amtChocolate <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1)*/
		Recipe receita = new Recipe("Cafe simples",50,4,1,1,1);
		assertEquals("Cafe simples",receita.getName());
	}
	
	@Test (expected = InvalidValueException.class)
	public void testeNomeNulo() throws InvalidValueException{
		/* Classe de equivalencia: (name = null), (amtSugar >= 0 && amtSugar <= 100), (amtMilk >= 0 && amtMilk <= 100)
		 * (amtChocolate >= 0 && amtChocolate <= 100), (price > 0), (amtCoffee >= 0 && amtCoffee <= 100) 
		 * Valor-limite: (name = null), (amtSugar = 1) */
		Recipe receita = new Recipe(null,50,4,3,1,5);
	}
	
	@Test 
	public void testeVerificaPrecoReceita() throws InvalidValueException {
		/* Classe de equivalencia: (name != null && name.length > 0), (amtSugar >= 0 && amtSugar <= 100),
		 * (price > 0), (amtCoffee >= 0 && amtCoffee <= 100), (amtChocolate >= 0 && amtChocolate <= 100),
		 * (amtMilk >= 0 && amtMilk <= 100)
		 * Valor-limite: (amtMilk = 1), (amtSugar = 1), (amtChocolate = 1)*/
		Recipe receita = new Recipe("Cafe simples",50,4,1,1,1);
		assertEquals(50,receita.getPrice());
	}	
	/* Testes para construtor (após teste estrutural) - FIM */
}
