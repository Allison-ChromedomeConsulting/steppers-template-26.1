package com.crybaby.steppers.datagen;

import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.item.ModItems;
import com.crybaby.steppers.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Steppers.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ItemTags.FOOT_ARMOR).add(ModItems.STEPPER_BOOTS.get());
        tag(ModTags.Items.NO_FALL_DAMAGE).add(ModItems.STEPPER_BOOTS.get());


    }
}
