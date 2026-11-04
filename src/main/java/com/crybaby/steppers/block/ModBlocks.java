package com.crybaby.steppers.block;

import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.block.custom.GoldenCarrotCropBlock;
import com.crybaby.steppers.block.custom.GoldenFarmland;
import com.crybaby.steppers.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Steppers.MODID);

    public static final DeferredBlock<Block> GOLDEN_FARMLAND = registerBlock("golden_farmland",
            properties -> new GoldenFarmland(properties.randomTicks()
                    .strength(.5f, .5f)
                    .sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> GOLDEN_FARMLAND_MOIST = registerBlock("golden_farmland_moist",
            properties -> new GoldenFarmland(properties.randomTicks()
                    .strength(.5f, .5f)
                    .sound(SoundType.WET_GRASS)));

    public static final DeferredBlock<Block> GOLDEN_CARROT_CROP = BLOCKS.registerBlock("golden_carrot_crop",
            properties -> new GoldenCarrotCropBlock(properties.mapColor(MapColor.PLANT)
                    .noCollision().randomTicks()
                    .instabreak().sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));



    private static <T extends Block> DeferredBlock <T> registerBlock (String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock <T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
