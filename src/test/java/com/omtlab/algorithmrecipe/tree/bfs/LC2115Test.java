package com.omtlab.algorithmrecipe.tree.bfs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2115Test {

    LC2115 lc2115 = new LC2115();


    @Test
    public void findAllRecipes() {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};
        List<String> output = lc2115.findAllRecipes(recipes, ingredients, supplies);
        Assertions.assertThat(output).containsAll(Arrays.asList("bread"));
    }

    @Test
    public void findAllRecipes1() {
        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread", "meat"));
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> output = lc2115.findAllRecipes(recipes, ingredients, supplies);
        Assertions.assertThat(output).containsAll(Arrays.asList("bread", "sandwich"));
    }

    @Test
    public void findAllRecipes2() {
        String[] recipes = {"sandwich", "bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("bread", "meat"));
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> output = lc2115.findAllRecipes(recipes, ingredients, supplies);
        Assertions.assertThat(output).containsAll(Arrays.asList("bread", "sandwich"));
    }

    @Test
    public void findAllRecipes3() {
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread", "meat"));
        ingredients.add(Arrays.asList("sandwich", "meat", "bread"));
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> output = lc2115.findAllRecipes(recipes, ingredients, supplies);
        Assertions.assertThat(output).containsAll(Arrays.asList("bread", "sandwich", "burger"));
    }

    @Test
    public void findAllRecipes4() {
        String[] recipes = {"burger", "sandwich", "bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("sandwich", "meat", "bread"));
        ingredients.add(Arrays.asList("bread", "meat"));
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> output = lc2115.findAllRecipes(recipes, ingredients, supplies);
        Assertions.assertThat(output).containsAll(Arrays.asList("bread", "sandwich", "burger"));
    }
}