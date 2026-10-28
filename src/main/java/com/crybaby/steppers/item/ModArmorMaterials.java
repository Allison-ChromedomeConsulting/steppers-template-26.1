package com.crybaby.steppers.item;

import com.crybaby.steppers.Steppers;
import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;

public class ModArmorMaterials {
    private static ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static ResourceKey<EquipmentAsset> ENHANCED_FEATHER_KEY = ResourceKey.create(ROOT_ID,
            Identifier.fromNamespaceAndPath(Steppers.MODID, "enhanced_feather"));

    public static final ArmorMaterial ENHANCED_FEATHER_MATERIAL = new ArmorMaterial(40, makeDefense(2, 5, 6, 2, 5 ), 1,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, ItemTags.REPAIRS_LEATHER_ARMOR, ENHANCED_FEATHER_KEY);

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}
