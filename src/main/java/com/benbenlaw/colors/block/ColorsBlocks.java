package com.benbenlaw.colors.block;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.custom.ColoredGrassBlock;
import com.benbenlaw.colors.block.custom.ColoredTallGrassBlock;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.util.ColorList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import static com.benbenlaw.colors.block.sets.ColorsWoodTypes.getWoodType;
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
    public static final Map<String, DeferredBlock<Block>> POTTED_SAPLING = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> CHESTS = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> SAND = new HashMap<>();

    static {

        for (String color : ColorList.COLORS) {

            //Sand
            SAND.put(color + "_sand", registerBlock(color + "_sand", () ->
                    new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).setId(createID(color + "_sand")))));

            //Chest
            CHESTS.put(color + "_chest", registerBlock(color + "_chest", () ->
                    new ChestBlock(() -> BlockEntityType.CHEST,
                            SoundEvents.CHEST_OPEN,
                            SoundEvents.CHEST_CLOSE,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST).setId(createID(color + "_chest")))));

            //Sapling
            SAPLINGS.put(color + "_sapling", registerBlock(color + "_sapling", () ->
                    new SaplingBlock(TREE_GROWERS.get(color), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createID(color + "_sapling")))));
            POTTED_SAPLING.put(color + "_potted_sapling", registerBlockWithoutBlockItem(color + "_potted_sapling", () ->
                    new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAPLINGS.get(color + "_sapling"), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION).setId(createID(color + "_potted_sapling")))));

            //Bamboo
            BAMBOO.put(color + "_bamboo", registerBlock(color + "_bamboo", () ->
                    new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK).setId(createID(color + "_bamboo")))));
            BAMBOO.put(color + "_stripped_bamboo", registerBlock(color + "_stripped_bamboo", () ->
                    new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK).setId(createID(color + "_stripped_bamboo")))));

            //Logs
            LOGS.put(color + "_log", registerBlock(color + "_log", () ->
                    new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createID(color + "_log")))));
            LOGS.put(color + "_stripped_log", registerBlock(color + "_stripped_log", () ->
                    new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createID(color + "_stripped_log")))));

            //Wood
            WOOD.put(color + "_wood", registerBlock(color + "_wood", () ->
                    new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createID(color + "_wood")))));
            WOOD.put(color + "_stripped_wood", registerBlock(color + "_stripped_wood", () ->
                    new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createID(color + "_stripped_wood")))));

            //Leaves
            LEAVES.put(color + "_leaves", registerBlock(color + "_leaves", () ->
                    new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createID(color + "_leaves"))) {
                    }));

            //Tall Grass
            TALL_GRASS.put(color + "_tall_grass", registerBlock(color + "_tall_grass", () ->
                    new DoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).setId(createID(color + "_tall_grass")))));

            //Short Grass
            SHORT_GRASS.put(color + "_short_grass", registerBlock(color + "_short_grass", () ->
                    new ColoredTallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).setId(createID(color + "_short_grass")))));

            //Dandelion
            DANDELION.put(color + "_dandelion", registerBlock(color + "_dandelion", () ->
                    new FlowerBlock(MobEffects.ABSORPTION, 0.0f, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).sound(SoundType.GRASS).noOcclusion().setId(createID(color + "_dandelion")))));
            POTTED_DANDELION.put(color + "_potted_dandelion", registerBlockWithoutBlockItem(color + "_potted_dandelion", () ->
                    new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DANDELION.get(color + "_dandelion"), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION).setId(createID(color + "_potted_dandelion")))));

            //Poppy
            POPPY.put(color + "_poppy", registerBlock(color + "_poppy", () ->
                    new FlowerBlock(MobEffects.ABSORPTION, 0.0f, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).sound(SoundType.GRASS).noOcclusion().setId(createID(color + "_poppy")))));
            POTTED_POPPY.put(color + "_potted_poppy", registerBlockWithoutBlockItem(color + "_potted_poppy", () ->
                    new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, POPPY.get(color + "_poppy"), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY).setId(createID(color + "_potted_poppy")))));

            //Dirt
            DIRT.put(color + "_dirt", registerBlock(color + "_dirt", () ->
                    new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).setId(createID(color + "_dirt")))));

            //Grass Blocks
            GRASS_BLOCK.put(color + "_grass_block", registerBlock(color + "_grass_block", () ->
                    new ColoredGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).setId(createID(color + "_grass_block")),
                            GRASS_BONEMEAL_KEY.get(color), DIRT.get(color + "_dirt").get(), SHORT_GRASS.get(color + "_short_grass").get())));

            //Crafting Table
            CRAFTING_TABLE.put(color + "_crafting_table", registerBlock(color + "_crafting_table", () ->
                    new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).setId(createID(color + "_crafting_table")))));

            //Planks Blocks
            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;
                String base = color + "_" + type;

                PLANKS.put(color + "_" + type, registerBlock(color + "_" + type, () ->
                        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createID(base)))));
                PLANKS.put(keyPrefix + "_stairs", registerBlock(keyPrefix + "_stairs", () -> {
                    BlockState baseState = PLANKS.get(color + "_" + type).get().defaultBlockState();
                    return new StairBlock(baseState, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createID(keyPrefix + "_stairs")));
                }));
                PLANKS.put(keyPrefix + "_slab", registerBlock(keyPrefix + "_slab", () ->
                        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createID(keyPrefix + "_slab")))));
                PLANKS.put(keyPrefix + "_fence", registerBlock(keyPrefix + "_fence", () ->
                        new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createID(keyPrefix + "_fence")))));
                PLANKS.put(keyPrefix + "_fence_gate", registerBlock(keyPrefix + "_fence_gate", () ->
                        new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createID(keyPrefix + "_fence_gate")),
                                SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE)));
                PLANKS.put(keyPrefix + "_pressure_plate", registerBlock(keyPrefix + "_pressure_plate", () ->
                        new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createID(keyPrefix + "_pressure_plate")))));
                PLANKS.put(keyPrefix + "_button", registerBlock(keyPrefix + "_button", () ->
                        new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createID(keyPrefix + "_button")))));
                PLANKS.put(keyPrefix + "_trapdoor", registerBlock(keyPrefix + "_trapdoor", () ->
                        new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createID(keyPrefix + "_trapdoor")))));
                PLANKS.put(keyPrefix + "_door", registerBlock(keyPrefix + "_door", () ->
                        new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createID(keyPrefix + "_door")))));


                PLANKS.put(keyPrefix + "_sign", registerBlockWithoutBlockItem(keyPrefix + "_sign", () ->
                        new StandingSignBlock(getWoodType(color, singularType),
                                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createID(keyPrefix + "_sign")))));

                PLANKS.put(keyPrefix + "_wall_sign", registerBlockWithoutBlockItem(keyPrefix + "_wall_sign", () -> {
                    ResourceKey<Block> signId = createID(keyPrefix + "_sign");
                    ResourceKey<LootTable> signLootTable = ResourceKey.create(Registries.LOOT_TABLE,
                            Identifier.fromNamespaceAndPath(signId.identifier().getNamespace(), "blocks/" + signId.identifier().getPath()));

                    return new WallSignBlock(getWoodType(color, singularType),
                            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)
                                    .setId(createID(keyPrefix + "_wall_sign"))
                                    .overrideLootTable(Optional.of(signLootTable)));
                }));

                PLANKS.put(keyPrefix + "_hanging_sign", registerBlockWithoutBlockItem(keyPrefix + "_hanging_sign", () ->
                        new CeilingHangingSignBlock(getWoodType(color, singularType),
                                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createID(keyPrefix + "_hanging_sign")))));

                PLANKS.put(keyPrefix + "_wall_hanging_sign", registerBlockWithoutBlockItem(keyPrefix + "_wall_hanging_sign", () -> {
                    ResourceKey<Block> hangingSignId = createID(keyPrefix + "_hanging_sign");
                    ResourceKey<LootTable> hangingSignLootTable = ResourceKey.create(Registries.LOOT_TABLE,
                            Identifier.fromNamespaceAndPath(hangingSignId.identifier().getNamespace(), "blocks/" + hangingSignId.identifier().getPath()));

                    return new WallHangingSignBlock(getWoodType(color, singularType),
                            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)
                                    .setId(createID(keyPrefix + "_wall_hanging_sign"))
                                    .overrideLootTable(Optional.of(hangingSignLootTable)));
                }));
            }

            //Stone Blocks
            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                STONE_BLOCKS.put(color + "_" + type, registerBlock(color + "_" + type, () ->
                        new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(createID(color + "_" + type)))));
                STONE_BLOCKS.put(keyPrefix + "_stairs", registerBlock(keyPrefix + "_stairs", () -> {
                    BlockState baseState = STONE_BLOCKS.get(color + "_" + type).get().defaultBlockState();
                    return new StairBlock(baseState, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).setId(createID(keyPrefix + "_" + type)));
                }));
                STONE_BLOCKS.put(keyPrefix + "_slab", registerBlock(keyPrefix + "_slab", () ->
                        new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).setId(createID(keyPrefix + "_slab")))));
                STONE_BLOCKS.put(keyPrefix + "_wall", registerBlock(keyPrefix + "_wall", () ->
                        new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).setId(createID(keyPrefix + "_wall")))));
                STONE_BLOCKS.put(keyPrefix + "_pressure_plate", registerBlock(keyPrefix + "_pressure_plate", () ->
                        new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).setId(createID(keyPrefix + "_pressure_plate")))));
                STONE_BLOCKS.put(keyPrefix + "_button", registerBlock(keyPrefix + "_button", () ->
                        new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).setId(createID(keyPrefix + "_button")))));
            }
        }
    }

    public static void addPlanksToSigns(BlockEntityTypeAddBlocksEvent event) {

        for (String color : ColorList.COLORS) {
            event.modify(BlockEntityType.SIGN, PLANKS.get(color + "_plank_sign").get(), PLANKS.get(color +"_plank_wall_sign").get());
            event.modify(BlockEntityType.HANGING_SIGN, PLANKS.get(color + "_plank_hanging_sign").get(), PLANKS.get(color + "_plank_wall_hanging_sign").get());

            event.modify(BlockEntityType.SIGN, PLANKS.get(color + "_bamboo_plank_sign").get(), PLANKS.get(color +"_bamboo_plank_wall_sign").get());
            event.modify(BlockEntityType.HANGING_SIGN, PLANKS.get(color + "_bamboo_plank_hanging_sign").get(), PLANKS.get(color + "_bamboo_plank_wall_hanging_sign").get());

            event.modify(BlockEntityType.SIGN, PLANKS.get(color + "_bamboo_mosaic_sign").get(), PLANKS.get(color +"_bamboo_mosaic_wall_sign").get());
            event.modify(BlockEntityType.HANGING_SIGN, PLANKS.get(color + "_bamboo_mosaic_hanging_sign").get(), PLANKS.get(color + "_bamboo_mosaic_wall_hanging_sign").get());

            event.modify(BlockEntityType.CHEST, CHESTS.get(color + "_chest").get());

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
        ColorsItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static ResourceKey<Block> createID(String name) {
        return ResourceKey.create(Registries.BLOCK, Colors.identifier(name));
    }

}
