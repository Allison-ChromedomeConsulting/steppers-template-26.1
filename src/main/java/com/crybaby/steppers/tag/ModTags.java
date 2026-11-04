package com.crybaby.steppers.tag;

import com.crybaby.steppers.Steppers;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> NO_FALL_DAMAGE = createTag("no_fall_damage");


        private static TagKey<Item> createTag(String name){
            return ItemTags.create(Identifier.fromNamespaceAndPath(Steppers.MODID, name));
        }


    }
}
