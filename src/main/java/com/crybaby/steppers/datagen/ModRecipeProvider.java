package com.crybaby.steppers.datagen;

import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }
    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModItems.STEPPER_BOOTS.get())
                .pattern("L L")
                .pattern("L L")
                .pattern("F F")
                .define('L', Items.LEATHER)
                .define('F', ModItems.ENHANCED_FEATHER.get())
                .group("enhanced feather")
                .unlockedBy(getHasName(ModItems.ENHANCED_FEATHER.get()), has(ModItems.ENHANCED_FEATHER.get()))
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.ENHANCED_FEATHER.get())
                .pattern("FF")
                .define('F', Items.FEATHER)
                .unlockedBy("has_feather", has(Items.FEATHER))
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.STEPPER_BOOTS.get())
                .pattern("L ")
                .pattern("FF")
                .define('L', Items.LEATHER_BOOTS)
                .define('F', ModItems.ENHANCED_FEATHER.get())
                .unlockedBy(getHasName(ModItems.ENHANCED_FEATHER.get()), has(Items.LEATHER_BOOTS))
                .save(output, Steppers.MODID + ":" + "stepper_boots_from_leather_boots");

        shaped(RecipeCategory.MISC, ModItems.GOLDEN_CARROT_SEEDS.get())
                .pattern("G")
                .define('G', Items.GOLDEN_CARROT)
                .unlockedBy("has_seeds", has(Items.GOLDEN_CARROT))
                .save(output);


    }
    public static class Runner extends RecipeProvider.Runner{

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "SteppersMod Recipes";
        }
    }


}
