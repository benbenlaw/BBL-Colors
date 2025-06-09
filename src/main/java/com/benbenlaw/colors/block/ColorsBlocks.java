package com.benbenlaw.colors.block;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.core.block.brightable.*;
import com.benbenlaw.core.block.brightable.flammable.*;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.benbenlaw.colors.worldgen.ColorsConfiguredFeatures.GRASS_BONEMEAL_KEY;
import static com.benbenlaw.colors.worldgen.tree.ColorsTreeGrowers.TREE_GROWERS;

public class ColorsBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Colors.MOD_ID);
    public static final Map<String, DeferredBlock<Block>> STONE_BLOCKS = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> PLANKS = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> DIRT = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> GRASS_BLOCK = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> CRAFTING_TABLE = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> TALL_GRASS = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> SHORT_GRASS = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> DANDELION = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> POTTED_DANDELION = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> POPPY = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> POTTED_POPPY = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> LEAVES = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> LOGS = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> WOOD = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> BAMBOO = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> SAPLINGS = new HashMap<>();

    static {
        for (String color : ColorList.COLORS) {

            //Sapling
            SAPLINGS.put(color + "_sapling", registerBlock(color + "_sapling", () ->
                    new BrightSapling(TREE_GROWERS.get(color), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).lightLevel(litBlockEmission()))));

            //Bamboo
            BAMBOO.put(color + "_bamboo", registerBlock(color + "_bamboo", () ->
                    new BrightFlammableLog(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK).lightLevel(litBlockEmission()))));
            BAMBOO.put(color + "_stripped_bamboo", registerBlock(color + "_stripped_bamboo", () ->
                    new BrightFlammableLog(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK).lightLevel(litBlockEmission()))));

            //Logs
            LOGS.put(color + "_log", registerBlock(color + "_log", () ->
                    new BrightFlammableLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).lightLevel(litBlockEmission()))));
            LOGS.put(color + "_stripped_log", registerBlock(color + "_stripped_log", () ->
                    new BrightFlammableLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).lightLevel(litBlockEmission()))));

            //Wood
            WOOD.put(color + "_wood", registerBlock(color + "_wood", () ->
                    new BrightFlammableLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).lightLevel(litBlockEmission()))));
            WOOD.put(color + "_stripped_wood", registerBlock(color + "_stripped_wood", () ->
                    new BrightFlammableLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).lightLevel(litBlockEmission()))));

            //Leaves
            LEAVES.put(color + "_leaves", registerBlock(color + "_leaves", () ->
                    new BrightFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).lightLevel(litBlockEmission()))));

            //Tall Grass
            TALL_GRASS.put(color + "_tall_grass", registerBlock(color + "_tall_grass", () ->
                    new BrightDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).lightLevel(litBlockEmission()))));

            //Short Grass
            SHORT_GRASS.put(color + "_short_grass", registerBlock(color + "_short_grass", () ->
                    new BrightTallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).lightLevel(litBlockEmission()),
                            (BrightDoublePlantBlock) TALL_GRASS.get(color + "_tall_grass").get())));

            //Dandelion
            DANDELION.put(color + "_dandelion", registerBlock(color + "_dandelion", () ->
                    new BrightFlower(MobEffects.ABSORPTION, 0.0f, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).sound(SoundType.GRASS)
                    .lightLevel(litBlockEmission()).noOcclusion())));
            POTTED_DANDELION.put(color + "_potted_dandelion", registerBlockWithoutBlockItem(color + "_potted_dandelion", () ->
                    new BrightFlowerPot(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DANDELION.get(color + "_dandelion"), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)
                    .lightLevel(litBlockEmission()))));

            //Poppy
            POPPY.put(color + "_poppy", registerBlock(color + "_poppy", () ->
                    new BrightFlower(MobEffects.ABSORPTION, 0.0f, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).sound(SoundType.GRASS)
                    .lightLevel(litBlockEmission()).noOcclusion())));
            POTTED_POPPY.put(color + "_potted_poppy", registerBlockWithoutBlockItem(color + "_potted_poppy", () ->
                    new BrightFlowerPot(() -> (FlowerPotBlock) Blocks.FLOWER_POT, POPPY.get(color + "_poppy"), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
                    .lightLevel(litBlockEmission()))));

            //Dirt
            DIRT.put(color + "_dirt", registerBlock(color + "_dirt", () ->
                    new BrightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).lightLevel(litBlockEmission()))));

            //Grass Blocks
            GRASS_BLOCK.put(color + "_grass_block", registerBlock(color + "_grass_block", () ->
                    new BrightGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).lightLevel(litBlockEmission()),
                            GRASS_BONEMEAL_KEY.get(color),
                            DIRT.get(color + "_dirt").get(),
                            SHORT_GRASS.get(color + "_short_grass").get()
            )));

            //Crafting Table
            CRAFTING_TABLE.put(color + "_crafting_table", registerBlock(color + "_crafting_table", () ->
                    new BrightCraftingTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).lightLevel(litBlockEmission()))));

            //Planks Blocks
            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                PLANKS.put(color + "_" + type, registerBlock(color + "_" + type, () ->
                        new BrightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).lightLevel(litBlockEmission()))));
                PLANKS.put(keyPrefix + "_stairs", registerBlock(keyPrefix + "_stairs", () -> {
                    BlockState baseState = PLANKS.get(color + "_" + type).get().defaultBlockState();
                    return new BrightFlammableStairs(baseState, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).lightLevel(litBlockEmission()));
                }));
                PLANKS.put(keyPrefix + "_slab", registerBlock(keyPrefix + "_slab", () ->
                        new BrightFlammableSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).lightLevel(litBlockEmission()))));
                PLANKS.put(keyPrefix + "_fence", registerBlock(keyPrefix + "_fence", () ->
                        new BrightFlammableFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).lightLevel(litBlockEmission()))));
                PLANKS.put(keyPrefix + "_fence_gate", registerBlock(keyPrefix + "_fence_gate", () ->
                        new BrightFlammableFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).lightLevel(litBlockEmission()),
                                SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE)));
                PLANKS.put(keyPrefix + "_pressure_plate", registerBlock(keyPrefix + "_pressure_plate", () ->
                        new BrightPressurePlate(BlockSetType.PressurePlateSensitivity.EVERYTHING, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).lightLevel(litBlockEmission()), BlockSetType.OAK)));
                PLANKS.put(keyPrefix + "_button", registerBlock(keyPrefix + "_button", () ->
                        new BrightButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).lightLevel(litBlockEmission()), BlockSetType.OAK, 30, true)));
                PLANKS.put(keyPrefix + "_trapdoor", registerBlock(keyPrefix + "_trapdoor", () ->
                        new BrightTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).lightLevel(litBlockEmission()), BlockSetType.OAK)));
                PLANKS.put(keyPrefix + "_door", registerBlock(keyPrefix + "_door", () ->
                        new BrightDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).lightLevel(litBlockEmission()), BlockSetType.OAK)));

            }

            //Stone Blocks
            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                STONE_BLOCKS.put(color + "_" + type, registerBlock(color + "_" + type, () ->
                        new BrightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(litBlockEmission()))));
                STONE_BLOCKS.put(keyPrefix + "_stairs", registerBlock(keyPrefix + "_stairs", () -> {
                    BlockState baseState = STONE_BLOCKS.get(color + "_" + type).get().defaultBlockState();
                    return new BrightStairs(baseState, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).lightLevel(litBlockEmission()));
                }));
                STONE_BLOCKS.put(keyPrefix + "_slab", registerBlock(keyPrefix + "_slab", () ->
                        new BrightSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).lightLevel(litBlockEmission()))));
                STONE_BLOCKS.put(keyPrefix + "_wall", registerBlock(keyPrefix + "_wall", () ->
                        new BrightWall(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).lightLevel(litBlockEmission()))));
                STONE_BLOCKS.put(keyPrefix + "_pressure_plate", registerBlock(keyPrefix + "_pressure_plate", () ->
                        new BrightPressurePlate(BlockSetType.PressurePlateSensitivity.MOBS, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).lightLevel(litBlockEmission()), BlockSetType.STONE)));
                STONE_BLOCKS.put(keyPrefix + "_button", registerBlock(keyPrefix + "_button", () ->
                        new BrightButton(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).lightLevel(litBlockEmission()), BlockSetType.STONE, 20, false)));
            }
        }
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ColorsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    private static ToIntFunction<BlockState> litBlockEmission() {
        //return (blockState) -> blockState.getValue(BlockStateProperties.LIT) ? StartupConfig.litBlockEmission.get() : 0;
        return (blockState -> blockState.getValue(BlockStateProperties.LIT) ? 15 : 0);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
