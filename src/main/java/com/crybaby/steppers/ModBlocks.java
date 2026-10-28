package com.crybaby.steppers;

import com.crybaby.steppers.Steppers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Steppers.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
