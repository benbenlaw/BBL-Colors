package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.core.block.brightable.BrightCraftingTable;
import com.benbenlaw.core.block.brightable.BrightDoublePlantBlock;
import com.benbenlaw.core.block.brightable.BrightTallGrassBlock;
import com.benbenlaw.core.block.colored.*;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;
import java.util.function.Supplier;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColorsBlockStatesProvider extends BlockStateProvider {

    public ColorsBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Colors.MOD_ID, existingFileHelper);

    }

    @Override
    protected void registerStatesAndModels() {

        for (String color : ColorList.COLORS) {

            //Sapling
            simpleBlock(SAPLINGS.get(color + "_sapling").get(), models().cross( color + "_sapling", modLoc("block/" + color + "_sapling"))
                    .texture("cross", modLoc("block/" + color + "_sapling")).renderType("cutout"));



            //Wood
            logBlock((RotatedPillarBlock) LOGS.get(color + "_log").get());
            logBlock((RotatedPillarBlock) LOGS.get(color + "_stripped_log").get());
            axisBlock((RotatedPillarBlock) WOOD.get(color + "_wood").get(), blockTexture(LOGS.get(color + "_log").get()), blockTexture(LOGS.get(color + "_log").get()));
            axisBlock((RotatedPillarBlock) WOOD.get(color + "_stripped_wood").get(), blockTexture(LOGS.get(color + "_stripped_log").get()), blockTexture(LOGS.get(color + "_stripped_log").get()));

            itemModels().withExistingParent(color + "_log", modLoc("block/" + color + "_log"));
            itemModels().withExistingParent(color + "_stripped_log", modLoc("block/" + color + "_stripped_log"));
            itemModels().withExistingParent(color + "_wood", modLoc("block/" + color + "_wood"));
            itemModels().withExistingParent(color + "_stripped_wood", modLoc("block/" + color + "_stripped_wood"));

            //Bamboo
            logBlock((RotatedPillarBlock) BAMBOO.get(color + "_bamboo").get());
            logBlock((RotatedPillarBlock) BAMBOO.get(color + "_stripped_bamboo").get());

            itemModels().withExistingParent(color + "_bamboo", modLoc("block/" + color + "_bamboo"));
            itemModels().withExistingParent(color + "_stripped_bamboo", modLoc("block/" + color + "_stripped_bamboo"));

            //Leaves
            blockWithItem(LEAVES.get(color + "_leaves"));

            //Short Grass
            simpleBlock(SHORT_GRASS.get(color + "_short_grass").get(),
                    models().cross(color + "_short_grass", modLoc("block/" + color + "_short_grass")).renderType("cutout")
            );
            itemModels().singleTexture(color + "_short_grass", mcLoc("item/generated"),
                    "layer0", modLoc("block/" + color + "_short_grass")).renderType("cutout");

            //Tall Plant
            getVariantBuilder(TALL_GRASS.get(color + "_tall_grass").get())
                    .forAllStates(state -> {
                        DoubleBlockHalf half = state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);

                        ModelFile model = models().cross(
                                color + "_tall_grass_" + (half == DoubleBlockHalf.LOWER ? "bottom" : "top"),
                                modLoc("block/" + color + "_tall_grass_" + (half == DoubleBlockHalf.LOWER ? "bottom" : "top"))
                        ).renderType("cutout");

                        return ConfiguredModel.builder()
                                .modelFile(model)
                                .build();
                    });


            itemModels().singleTexture(color + "_tall_grass", mcLoc("item/generated"),
                    "layer0", modLoc("block/" + color + "_tall_grass_top")).renderType("cutout");

            //Poppy
            simpleBlock(POPPY.get(color + "_poppy").get(), models().cross(color + "_poppy", modLoc("block/" + color + "_poppy")).renderType("cutout"));
            simpleBlock(POTTED_POPPY.get(color + "_potted_poppy").get(), models().singleTexture("potted_poppy",
                    ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "tintable_flower_pot_cross"), "plant",
                    ResourceLocation.parse("colors:block/poppy")).renderType("cutout"));
            //Dandelion
            simpleBlock(DANDELION.get(color + "_dandelion").get(), models().cross(color + "_dandelion", modLoc("block/" + color + "_dandelion")).renderType("cutout"));
            simpleBlock(POTTED_DANDELION.get(color + "_potted_dandelion").get(), models().singleTexture( "potted_dandelion",
                    ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "tintable_flower_pot_cross"), "plant",
                    ResourceLocation.parse("colors:block/dandelion")).renderType("cutout"));
            //Dirt
            blockWithItem(DIRT.get(color + "_dirt"));
            //Grass
            getVariantBuilder(GRASS_BLOCK.get(color + "_grass_block").get()).forAllStates(state -> {
                boolean snowy = state.getValue(SnowyDirtBlock.SNOWY);

                String blockName = color + "_grass_block";

                // choose side depending on snowy property
                ResourceLocation side = modLoc("block/" + blockName + "_side" + (snowy ? "_snow" : ""));
                ResourceLocation bottom = modLoc("block/" + color + "_dirt"); // or minecraft:block/dirt
                ResourceLocation top = modLoc("block/" + blockName + "_top");

                ModelFile model = models().cubeBottomTop(
                        blockName + (snowy ? "_snow" : ""),
                        side,
                        bottom,
                        top
                );

                return ConfiguredModel.builder()
                        .modelFile(model)
                        .build();
            });
            itemModels().withExistingParent(color + "_grass_block", modLoc("block/" + color + "_grass_block"));



            //Crafting Table
            simpleBlock(
                    (BrightCraftingTable) CRAFTING_TABLE.get(color + "_crafting_table").get(),
                    models().cube(
                            color + "_crafting_table",
                            modLoc("block/" + color + "_planks"),
                            modLoc("block/" + color + "_crafting_table_top"),
                            modLoc("block/" + color + "_crafting_table"),
                            modLoc("block/" + color + "_crafting_table_side"),
                            modLoc("block/" + color + "_crafting_table_side"),
                            modLoc("block/" + color + "_crafting_table")
                    )
            );

            itemModels().withExistingParent(color + "_crafting_table", modLoc("block/" + color + "_crafting_table"));

            //Stone Blocks
            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                blockWithItem(STONE_BLOCKS.get(color + "_" + type));
                slabBlock((SlabBlock) STONE_BLOCKS.get(keyPrefix + "_slab").get(), blockTexture(STONE_BLOCKS.get(color + "_" + type).get()), blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));
                stairsBlock((StairBlock) STONE_BLOCKS.get(keyPrefix + "_stairs").get(), blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));
                wallBlock((WallBlock) STONE_BLOCKS.get(keyPrefix + "_wall").get(), blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));
                pressurePlateBlock((PressurePlateBlock) STONE_BLOCKS.get(keyPrefix + "_pressure_plate").get(), blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));
                buttonBlock((ButtonBlock) STONE_BLOCKS.get(keyPrefix + "_button").get(), blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));

                itemModels().withExistingParent(keyPrefix + "_slab", modLoc("block/" + keyPrefix + "_slab"));
                itemModels().withExistingParent(keyPrefix + "_stairs", modLoc("block/" + keyPrefix + "_stairs"));
                itemModels().withExistingParent(keyPrefix + "_wall", mcLoc("block/wall_inventory"))
                        .texture("wall", blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));
                itemModels().withExistingParent(keyPrefix + "_pressure_plate", modLoc("block/" + keyPrefix + "_pressure_plate"));
                itemModels().withExistingParent(keyPrefix + "_button", mcLoc("block/button_inventory"))
                        .texture("texture", blockTexture(STONE_BLOCKS.get(color + "_" + type).get()));

            }

            //Plank Blocks
            for (String type : PlankLikeBlocksList.PLANKS) {
                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                blockWithItem(PLANKS.get(color + "_" + type));
                slabBlock((SlabBlock) PLANKS.get(keyPrefix + "_slab").get(), blockTexture(PLANKS.get(color + "_" + type).get()), blockTexture(PLANKS.get(color + "_" + type).get()));
                stairsBlock((StairBlock) PLANKS.get(keyPrefix + "_stairs").get(), blockTexture(PLANKS.get(color + "_" + type).get()));
                pressurePlateBlock((PressurePlateBlock) PLANKS.get(keyPrefix + "_pressure_plate").get(), blockTexture(PLANKS.get(color + "_" + type).get()));
                buttonBlock((ButtonBlock) PLANKS.get(keyPrefix + "_button").get(), blockTexture(PLANKS.get(color + "_" + type).get()));
                fenceBlock((FenceBlock) PLANKS.get(keyPrefix + "_fence").get(), blockTexture(PLANKS.get(color + "_" + type).get()));
                fenceGateBlock((FenceGateBlock) PLANKS.get(keyPrefix + "_fence_gate").get(), blockTexture(PLANKS.get(color + "_" + type).get()));
                doorBlockWithRenderType((DoorBlock) PLANKS.get(keyPrefix + "_door").get(), ResourceLocation.parse("colors:block/" + color + "_" + singularType + "_door_bottom"), ResourceLocation.parse("colors:block/" + color + "_" + singularType + "_door_top"), "cutout");
                trapdoorBlockWithRenderType((TrapDoorBlock) PLANKS.get(keyPrefix + "_trapdoor").get(), blockTexture(PLANKS.get(keyPrefix + "_trapdoor").get()), true, "cutout");

                signBlock((StandingSignBlock) PLANKS.get(keyPrefix + "_sign").get(),
                        (WallSignBlock) PLANKS.get(keyPrefix + "_wall_sign").get(), blockTexture(PLANKS.get(color + "_" + type).get()));
                hangingSignBlock((CeilingHangingSignBlock) PLANKS.get(keyPrefix + "_hanging_sign").get(), (WallHangingSignBlock) PLANKS.get(keyPrefix + "_wall_hanging_sign").get(), blockTexture(PLANKS.get(color + "_" + type).get()));

                itemModels().withExistingParent(keyPrefix + "_slab", modLoc("block/" + keyPrefix + "_slab"));
                itemModels().withExistingParent(keyPrefix + "_stairs", modLoc("block/" + keyPrefix + "_stairs"));
                itemModels().withExistingParent(keyPrefix + "_pressure_plate", modLoc("block/" + keyPrefix + "_pressure_plate"));
                itemModels().withExistingParent(keyPrefix + "_button", mcLoc("block/button_inventory"))
                        .texture("texture", blockTexture(PLANKS.get(color + "_" + type).get()));
                itemModels().withExistingParent(keyPrefix + "_fence", mcLoc("block/fence_inventory"))
                        .texture("texture", blockTexture(PLANKS.get(color + "_" + type).get()));
                itemModels().withExistingParent(keyPrefix + "_fence_gate", modLoc("block/" + keyPrefix + "_fence_gate"));
                itemModels().basicItem(PLANKS.get(keyPrefix + "_door").get().asItem());
                itemModels().withExistingParent(keyPrefix + "_trapdoor", modLoc("block/" + keyPrefix + "_trapdoor_bottom"));

                itemModels().basicItem(PLANKS.get(keyPrefix + "_sign").get().asItem());
                itemModels().basicItem(PLANKS.get(keyPrefix + "_hanging_sign").get().asItem());
            }
        }
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    @Override
    public String getName() {
        return Colors.MOD_ID + " Block States";
    }
}

