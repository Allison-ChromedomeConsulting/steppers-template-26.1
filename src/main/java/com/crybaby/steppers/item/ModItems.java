package com.crybaby.steppers.item;

import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.block.ModBlocks;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Steppers.MODID);

    public static final DeferredItem<Item> ENHANCED_FEATHER = ITEMS.registerSimpleItem("enhanced_feather");
    public static final DeferredItem<Item> STEPPER_BOOTS = ITEMS.registerItem("stepper_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ENHANCED_FEATHER_MATERIAL, ArmorType.BOOTS)));


    public static final DeferredItem<Item> GOLDEN_CARROT_SEEDS = ITEMS.registerItem("golden_carrot_seeds",
            properties -> new BlockItem(ModBlocks.GOLDEN_CARROT_CROP.get(), properties.useBlockDescriptionPrefix()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
