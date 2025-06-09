package com.benbenlaw.colors.data;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.item.ColorsItems;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public class ColorsLootTableProvider extends VanillaBlockLoot {

    HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

    public ColorsLootTableProvider(HolderLookup.Provider provider) {
        super(provider);
    }


    @Override
    protected void generate() {
        //Stone Blocks
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.STONE_BLOCKS.entrySet()) {

            if (entry.getKey().endsWith("_slab")) {
                this.add(entry.getValue().get(), this::createSlabItemTable);
            } else {
                this.dropSelf(entry.getValue().get());
            }
        }

        //Planks
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.PLANKS.entrySet()) {
            if (entry.getKey().endsWith("_slab")) {
                this.add(entry.getValue().get(), this::createSlabItemTable);
            }
            else if (entry.getKey().endsWith("_door")) {
                this.add(entry.getValue().get(), this::createDoorTable);
            }
            else {
                this.dropSelf(entry.getValue().get());
            }
        }

        //Dirt
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.DIRT.entrySet()) {
            this.dropSelf(entry.getValue().get());
        }

        //Grass Block
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.GRASS_BLOCK.entrySet()) {
            String dirt = entry.getKey().replace("_grass_block", "_dirt");
            DeferredBlock<Block> block = ColorsBlocks.DIRT.get(dirt);
            this.add(entry.getValue().get(), createSingleItemTableWithSilkTouch(entry.getValue().get(), block));
        }

        //Crafting Table
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.CRAFTING_TABLE.entrySet()) {
            this.dropSelf(entry.getValue().get());
        }

        //Short Grass
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SHORT_GRASS.entrySet()) {
            this.add(entry.getValue().get(), createGrassDrops(entry.getValue().get()));
        }

        //Tall Grass
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.TALL_GRASS.entrySet()) {
            String shortGrassBlock = entry.getKey().replace("_tall_grass", "_short_grass");
            DeferredBlock<Block> block = ColorsBlocks.SHORT_GRASS.get(shortGrassBlock);
            this.add(entry.getValue().get(), createDoublePlantWithSeedDrops(entry.getValue().get(), block.get()));
        }

        //Poppy
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.POPPY.entrySet()) {
            this.dropSelf(entry.getValue().get());
            String poppyBlock = entry.getKey().replace("_poppy", "_potted_poppy");
            DeferredBlock<Block> block = ColorsBlocks.POTTED_POPPY.get(poppyBlock);
            this.add(block.get(), createPotFlowerItemTable(entry.getValue().get()));
        }

        //Dandelion
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.DANDELION.entrySet()) {
            this.dropSelf(entry.getValue().get());
            String dandelionBlock = entry.getKey().replace("_dandelion", "_potted_dandelion");
            DeferredBlock<Block> block = ColorsBlocks.POTTED_DANDELION.get(dandelionBlock);
            this.add(block.get(), createPotFlowerItemTable(entry.getValue().get()));
        }

        //Logs
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.LOGS.entrySet()) {
            this.dropSelf(entry.getValue().get());
        }

        //Wood
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.WOOD.entrySet()) {
            this.dropSelf(entry.getValue().get());
        }

        //Bamboo
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.BAMBOO.entrySet()) {
            this.dropSelf(entry.getValue().get());
        }

        //Saplings
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SAPLINGS.entrySet()) {
            this.dropSelf(entry.getValue().get());
        }

        //Leaves
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.LEAVES.entrySet()) {
            String sapling = entry.getKey().replace("_leaves", "_sapling");
            DeferredBlock<Block> saplingBlock = ColorsBlocks.SAPLINGS.get(sapling);
            String apple = entry.getKey().replace("_leaves", "_apple");
            DeferredItem<Item> appleItem = ColorsItems.APPLES.get(apple);
            this.add(entry.getValue().get(), block ->
                    createBrightLeavesDrops(block, saplingBlock.get(), appleItem.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        }


    }

    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};


    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.TOOLS_SHEAR));
    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(this.hasSilkTouch());
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }

    protected LootTable.Builder createBrightLeavesDrops(Block p_249535_, Block p_251505_, Item apple, float... p_250753_) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(p_249535_, p_251505_, p_250753_)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(p_249535_, LootItem.lootTableItem(apple)))
                                                .when(
                                                        BonusLevelTableCondition.bonusLevelFlatChance(
                                                                registrylookup.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F
                                                        )
                                                )
                                )
                );
    }

    protected LootTable.Builder createLeavesDrops(Block p_250088_, Block p_250731_, float... p_248949_) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(
                        p_250088_,
                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(p_250088_, LootItem.lootTableItem(p_250731_)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), p_248949_))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                                p_250088_, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        ))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))
                                )
                );
    }

    protected LootTable.Builder createSilkTouchOrShearsDispatchTable(Block p_250539_, LootPoolEntryContainer.Builder<?> p_251459_) {
        return createSelfDropDispatchTable(p_250539_, this.hasShearsOrSilkTouch(), p_251459_);
    }

    @Override
    protected void add(@NotNull Block block, @NotNull LootTable.Builder table) {
        super.add(block, table);
        knownBlocks.add(block);
    }

    private final Set<Block> knownBlocks = new ReferenceOpenHashSet<>();


    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
