package com.crybaby.steppers.datagen;

import com.crybaby.steppers.Steppers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Steppers.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

    }

}
