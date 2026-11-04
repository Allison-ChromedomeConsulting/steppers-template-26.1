package com.crybaby.steppers.block.custom;

import com.crybaby.steppers.item.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GoldenCarrotCropBlock extends CarrotBlock {
    //public static final int MAX_AGE = 3;
    //public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);

    public GoldenCarrotCropBlock(Properties properties) {

        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {

        return ModItems.GOLDEN_CARROT_SEEDS.get();
    }

    /* @Override
    protected IntegerProperty getAgeProperty() {

        return AGE;
    }

    @Override
    public int getMaxAge() {

        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    } */
}
