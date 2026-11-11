package com.crybaby.steppers.datagen;

import com.crybaby.steppers.block.ModBlocks;
import com.crybaby.steppers.Steppers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Steppers.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.CROPS)
                .add(ModBlocks.GOLDEN_CARROT_CROP.get());
        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(ModBlocks.GOLDEN_CARROT_CROP.get());
        tag(BlockTags.SUPPORTS_CROPS)
                .add(ModBlocks.GOLDEN_FARMLAND.get());
        tag(BlockTags.SUPPORTS_CROPS)
                .add(ModBlocks.GOLDEN_FARMLAND_MOIST.get());




    }

}
