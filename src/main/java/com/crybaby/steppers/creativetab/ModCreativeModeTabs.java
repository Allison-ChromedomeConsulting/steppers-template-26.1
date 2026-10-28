package com.crybaby.steppers.creativetab;

import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Steppers.MODID);

    public static final Supplier<CreativeModeTab> SPECIAL_ITEMS_TAB = CREATIVE_MODE_TABS.register("special_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENHANCED_FEATHER.get()))
                    .title(Component.translatable("creativetab.steppers.special_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ENHANCED_FEATHER);
                        output.accept(ModItems.STEPPER_BOOTS);



                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
