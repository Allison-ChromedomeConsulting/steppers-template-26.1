package com.crybaby.steppers.item;

import com.crybaby.steppers.Steppers;
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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
