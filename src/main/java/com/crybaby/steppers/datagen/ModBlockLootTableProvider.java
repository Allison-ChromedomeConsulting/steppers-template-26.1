package com.crybaby.steppers.datagen;

import com.crybaby.steppers.block.ModBlocks;
import com.crybaby.steppers.block.custom.GoldenCarrotCropBlock;
import com.crybaby.steppers.block.custom.GoldenFarmland;
import com.crybaby.steppers.item.ModItems;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {


        add(ModBlocks.GOLDEN_FARMLAND.get(),block -> createSingleItemTable(Items.DIRT));
        add(ModBlocks.GOLDEN_FARMLAND_MOIST.get(),block -> createSingleItemTable(Items.DIRT));


        LootItemCondition.Builder isMaxAge = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOLDEN_CARROT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarrotBlock.AGE, 7));

        this.add(ModBlocks.GOLDEN_CARROT_CROP.get(), createGoldenCarrotCropDrops(ModBlocks.GOLDEN_CARROT_CROP.get(), ModItems.GOLDEN_CARROT_SEEDS.get(), isMaxAge));


    }
    protected LootTable.Builder createGoldenCarrotCropDrops(Block block, Item seedDrop, LootItemCondition.Builder isMaxAge) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().add(
                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F))).when(isMaxAge)
                        .otherwise(LootItem.lootTableItem(seedDrop)))).withPool(LootPool.lootPool().when(isMaxAge)
                .add(LootItem.lootTableItem(seedDrop)
                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(enchantments.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
