package each.usp.ach2006.adaptedfromcsc326.eler;

import java.util.Vector;

import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.AmountOfRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.DuplicatedRecipeException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InsufficientAmountOfMoneyException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InvalidValueException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.InventoryException;
import each.usp.ach2006.adaptedfromcsc326.eler.exceptions.RecipeException;

/**
 * @author Sarah Heckman
 * modified by Marcelo Eler
 *
 * Inventory for the coffee maker
 */

public class CoffeeMaker {
	/** Array of recipes in coffee maker */
	private  RecipeBook recipeBook;
	/** Inventory of the coffee maker */
    private  Inventory inventory;
	
    /**
     * Constructor for the coffee maker
     *
     */
	public CoffeeMaker() {
	    recipeBook = new RecipeBook();
		try {
			inventory = new Inventory();
		} catch (InvalidValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns true if the recipe is added to the
	 * list of recipes in the CoffeeMaker and false
	 * otherwise.
	 * @param r
	 * @return boolean
	 */
	public boolean addRecipe(Recipe r) throws AmountOfRecipeException, DuplicatedRecipeException {
		return recipeBook.addRecipe(r);
	}		
	
	
	/**
	 * Returns the name of the successfully deleted recipe
	 * or null if the recipe cannot be deleted.
	 * 
	 * @param recipeToDelete
	 * @return String (recipe name)
	 * @throws RecipeException 
	 */
	public boolean deleteRecipe(String recipeName) throws RecipeException {
		return recipeBook.deleteRecipe(recipeName);
	}
	
    /**
     * Returns true if inventory was successfully added
     * @param amtCoffee
     * @param amtMilk
     * @param amtSugar
     * @param amtChocolate
     * @return boolean
     */
	
	public synchronized void addCoffeeInventory(int amtCoffee) throws InvalidValueException {
		inventory.addCoffee(amtCoffee);
	}
	
	public synchronized void addMilkInventory(int amtMilk) throws InvalidValueException {
		inventory.addMilk(amtMilk);
	}
	
	public synchronized void addSugarInventory(int amtSugar) throws InvalidValueException {
		inventory.addChocolate(amtSugar); 
	}
	
	public synchronized void addChocolateInventory(int amtChocolate) throws InvalidValueException {
		inventory.addChocolate(amtChocolate);
	}
    
    public synchronized int checkCoffeeInventory(){
    	return inventory.getCoffee();
    }
    
    public synchronized int checkMilkInventory(){
    	return inventory.getMilk();
    }
    
    public synchronized int checkSugarInventory(){
    	return inventory.getSugar();
    }
    
    public synchronized int checkChocolateInventory(){
    	return inventory.getChocolate();
    }
    
    
    /**
     * Returns the change of a user's beverage purchase, or
     * the user's money if the beverage cannot be made
     * @param r
     * @param amtPaid
     * @return int
     */
    public synchronized int makeCoffee(String recipeName, int amtPaid) throws InsufficientAmountOfMoneyException, RecipeException, InventoryException, InvalidValueException {    	
    	if (amtPaid<0 && amtPaid>500){
    		throw new InvalidValueException("Payment must be positive or less than 500 cents");
    	}
        int change = 0;
        Recipe recipe = recipeBook.getRecipe(recipeName);
        if (recipe == null) {
        	change = amtPaid;
        	throw new RecipeException("Unknown Recipe");
        } else 
        	if (recipe.getPrice() < amtPaid) {
        		if (inventory.useIngredients(recipe)) {
        			change = recipe.getPrice();
        		} 
        		else 
        		{
        			change = amtPaid;
        			throw new InventoryException("Insuficcient amount of coffee, choco, milk or sugar");
        		}
        	} else {
        		change = amtPaid;
        		throw new InsufficientAmountOfMoneyException("Insufficient money");
        	}
        
        return change;
    }

	/**
	 * Returns the list of Recipes in the RecipeBook.
	 * @return Recipe []
	 */
	public synchronized Vector<Recipe> getRecipes() {
		return recipeBook.getRecipes();
	}
}
