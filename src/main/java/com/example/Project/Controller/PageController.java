package com.example.Project.Controller;
import com.example.Project.Model.Recipe;
import com.example.Project.Service.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/navigation")
public class PageController {

    private IRecipeService recipeService;
    @Autowired
    public PageController(IRecipeService recipeService){
        this.recipeService=recipeService;
    }

    @GetMapping("/home")
    public String LoadHome(Model theModel){
        List<Recipe> recipes = recipeService.findAll();
        if (recipes.size() > 3) {
            recipes = recipes.subList(0, 3); // Limit to first 3 recipes
        }
        theModel.addAttribute("recipes", recipes);
        List<Recipe> trendingRecipes = recipeService.getTrendingRecipes();
        if (trendingRecipes.size() > 3) {
            trendingRecipes = trendingRecipes.subList(0, 3); // Limit to first 3 recipes
        }
        theModel.addAttribute("trendingRecipes", trendingRecipes);
        return "home";
    }

    @GetMapping("/lunch")
    public String LoadLunch(Model theModel){
        List<Recipe> recipes = recipeService.findByCategory("Lunch");
        theModel.addAttribute("recipes", recipes);
        return "allrecipes";
    }

    @GetMapping("/breakfast")
    public String LoadBreakfast(Model theModel){
        List<Recipe> recipes = recipeService.findByCategory("breakfast");
        theModel.addAttribute("recipes", recipes);
        return "allrecipes";
    }

    @GetMapping("/snack")
    public String LoadSnake(Model theModel){
        List<Recipe> recipes = recipeService.findByCategory("snack");
        theModel.addAttribute("recipes", recipes);
        return "allrecipes";
    }

    @GetMapping("/dinner")
    public String LoadDinner(Model theModel){
        List<Recipe> recipes = recipeService.findByCategory("dinner");
        theModel.addAttribute("recipes", recipes);
        return "allrecipes";
    }

    @GetMapping("/User/loadProfile")
    public String LoadProfile(Model theModel){
        return "profile";
    }

    @GetMapping("/loadAllRecipes")
    public String loadAllRecipes(Model model){
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "allrecipes";
    }
    @GetMapping("/loadAddRecipe")
    public String loadAddRecipe(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "addRecipe";
    }
    @GetMapping("/loadEachRecipe")
    public String loadEachRecipe(@RequestParam("id") int id, Model model){
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "eachRecipe";
    }

}
