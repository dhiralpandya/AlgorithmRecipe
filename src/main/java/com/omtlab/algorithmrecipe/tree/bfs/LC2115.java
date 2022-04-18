package com.omtlab.algorithmrecipe.tree.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2115. Find All Possible Recipes from Given Supplies
 * <p>
 * You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.
 * <p>
 * You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
 * <p>
 * Return a list of all the recipes that you can create. You may return the answer in any order.
 * <p>
 * Note that two recipes may contain each other in their ingredients.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
 * Output: ["bread"]
 * Explanation:
 * We can create "bread" since we have the ingredients "yeast" and "flour".
 * Example 2:
 * <p>
 * Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
 * Output: ["bread","sandwich"]
 * Explanation:
 * We can create "bread" since we have the ingredients "yeast" and "flour".
 * We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
 * Example 3:
 * <p>
 * Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
 * Output: ["bread","sandwich","burger"]
 * Explanation:
 * We can create "bread" since we have the ingredients "yeast" and "flour".
 * We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
 * We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == recipes.length == ingredients.length
 * 1 <= n <= 100
 * 1 <= ingredients[i].length, supplies.length <= 100
 * 1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
 * recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
 * All the values of recipes and supplies combined are unique.
 * Each ingredients[i] does not contain any duplicate values.
 */
public class LC2115 {

    /**
     * There are two questions we should ask before starting this problem
     * 1. Are recipes in order?
     * - I mean "sandwich" depends on "bread", So are we going to get input like ["bread","sandwich"] ?
     * - Ans is NO :D
     * <p>
     * 2. Is it possible two recipes are depends on each other?
     * - I dont think so
     */
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Ingredient> supplyNameToObj = new HashMap<>();

        // Add all the supply as true
        for (String supply : supplies) {
            Ingredient ingredient = new Ingredient();
            ingredient.isAvailable = true; // IMP Step
            ingredient.name = supply;
            supplyNameToObj.put(supply, ingredient);
        }

        // One recipe can depends on other recipe, That means those recipe is ingredient.
        List<Recipe> allRecipes = new ArrayList<>();

        for (String recipe : recipes) {
            Recipe ingredient = new Recipe();
            ingredient.isAvailable = false; // IMP Step
            ingredient.name = recipe;
            supplyNameToObj.put(recipe, ingredient);

            allRecipes.add(ingredient);
        }

        // Map recipe to ingredients
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            Recipe recipeObj = (Recipe) supplyNameToObj.get(recipe);
            for (String ingredient : ingredients.get(i)) {

                if (!supplyNameToObj.containsKey(ingredient)) {
                    // if ingredient not in supply means not available
                    Ingredient ingredientObj = new Ingredient();
                    ingredientObj.isAvailable = false; // IMP step
                    ingredientObj.name = ingredient;
                    supplyNameToObj.put(ingredient, ingredientObj);
                }

                recipeObj.ingredients.add(supplyNameToObj.get(ingredient));
            }
        }

        List<String> output = new ArrayList<>();
        bfs(allRecipes, output);
        return output;
    }

    private void bfs(List<Recipe> nodes, List<String> output) {
        for (Recipe node : nodes) {
            isAvailable(node);
        }

        for (Recipe node : nodes) {
            if (node.isAvailable) {
                output.add(node.name);
            }
        }
    }

    private boolean isAvailable(Ingredient recipe) {
        if (recipe.isAvailable) {
            return true;
        } else if (!(recipe instanceof Recipe)) { // if its not a recipe then its an ingredient which is not there in supply
            return false;
        }

        for (Ingredient ingredient : ((Recipe) recipe).ingredients) {
            if (!isAvailable(ingredient)) {
                return false;
            }
        }

        // IMP Step, Setting true for recipe
        recipe.isAvailable = true;
        return true;
    }

    private static class Recipe extends Ingredient {
        List<Ingredient> ingredients = new ArrayList<>();
    }

    private static class Ingredient {
        String name;
        boolean isAvailable = false;
    }

}
