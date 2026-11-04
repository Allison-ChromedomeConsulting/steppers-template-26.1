package com.crybaby.steppers.datagen;

import com.crybaby.steppers.block.ModBlocks;
import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.block.custom.GoldenCarrotCropBlock;
import com.crybaby.steppers.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, Steppers.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        /* Items */
        itemModels.generateFlatItem(ModItems.ENHANCED_FEATHER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STEPPER_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        /* Blocks */
        blockModels.createTrivialCube(ModBlocks.GOLDEN_FARMLAND.get());
        blockModels.createTrivialCube(ModBlocks.GOLDEN_FARMLAND_MOIST.get());

        blockModels.createCropBlock(ModBlocks.GOLDEN_CARROT_CROP.get(), GoldenCarrotCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);






    }
}
