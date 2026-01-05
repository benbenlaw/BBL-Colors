package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.util.ColorList;
import com.benbenlaw.colors.util.ColoredChestSpecialRenderer;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Map;

import static com.benbenlaw.colors.block.ColorsBlocks.*;
import static com.benbenlaw.colors.block.ColorsBlocks.BAMBOO;
import static com.benbenlaw.colors.block.ColorsBlocks.LOGS;
import static com.benbenlaw.colors.block.ColorsBlocks.WOOD;
import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class ColorsModelProvider extends ModelProvider {

    public ColorsModelProvider(PackOutput output) {
        super(output, Colors.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        //Items
        for (String color : ColorList.COLORS) {
            itemModels.generateFlatItem(ColorsItems.SPRAY_CANS.get(color + "_spray_can").get(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SHORT_GRASS.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.TALL_GRASS.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredItem<Item>> entry : ColorsItems.APPLES.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }

        //Blocks

        for (String color : ColorList.COLORS) {
            blockModels.createPlantWithDefaultItem(SAPLINGS.get(color + "_sapling").get(), POTTED_SAPLING.get(color + "_potted_sapling").get(), PlantType.NOT_TINTED);

            blockModels.woodProvider(LOGS.get(color + "_log").get()).logWithHorizontal(LOGS.get(color + "_log").get()).wood(WOOD.get(color + "_wood").get());
            blockModels.woodProvider(LOGS.get(color + "_stripped_log").get()).logWithHorizontal(LOGS.get(color + "_stripped_log").get()).wood(WOOD.get(color + "_stripped_wood").get());

            blockModels.woodProvider(BAMBOO.get(color + "_bamboo").get()).logWithHorizontal(BAMBOO.get(color + "_bamboo").get());
            blockModels.woodProvider(BAMBOO.get(color + "_stripped_bamboo").get()).logWithHorizontal(BAMBOO.get(color + "_stripped_bamboo").get());

            blockModels.createTrivialCube(LEAVES.get(color + "_leaves").get());
            blockModels.createCrossBlock(SHORT_GRASS.get(color + "_short_grass").get(), PlantType.TINTED);

            blockModels.createDoublePlant(TALL_GRASS.get(color + "_tall_grass").get(), PlantType.TINTED);

            blockModels.createPlantWithDefaultItem(POPPY.get(color + "_poppy").get(), POTTED_POPPY.get(color + "_potted_poppy").get(), PlantType.NOT_TINTED);
            blockModels.createPlantWithDefaultItem(DANDELION.get(color + "_dandelion").get(), POTTED_DANDELION.get(color + "_potted_dandelion").get(), PlantType.NOT_TINTED);

            blockModels.createTrivialCube(DIRT.get(color + "_dirt").get());

            createColoredGrassLikeBlock(GRASS_BLOCK.get(color + "_grass_block").get(), DIRT.get(color + "_dirt").get(), blockModels);

            blockModels.createCraftingTableLike(CRAFTING_TABLE.get(color + "_crafting_table").get(), PLANKS.get(color + "_planks").get(), TextureMapping::craftingTable );

            blockModels.createChest(CHESTS.get(color + "_chest").get(), PLANKS.get(color + "_planks").get(), ColoredChestSpecialRenderer.TEXTURES.get(color), false);

            blockModels.createTrivialCube(SAND.get(color + "_sand").get());

            //Stone Blocks
            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                blockModels.family(STONE_BLOCKS.get(color + "_" + type).get())
                        .slab(STONE_BLOCKS.get(keyPrefix + "_slab").get())
                        .stairs(STONE_BLOCKS.get(keyPrefix + "_stairs").get())
                        .wall(STONE_BLOCKS.get(keyPrefix + "_wall").get())
                        .pressurePlate(STONE_BLOCKS.get(keyPrefix + "_pressure_plate").get())
                        .button(STONE_BLOCKS.get(keyPrefix + "_button").get());
            }



            //Plank Blocks
            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                BlockFamily plankFamily = new BlockFamily.Builder(PLANKS.get(color + "_" + type).get())

                        .slab(PLANKS.get(keyPrefix + "_slab").get())
                        .stairs(PLANKS.get(keyPrefix + "_stairs").get())
                        .pressurePlate(PLANKS.get(keyPrefix + "_pressure_plate").get())
                        .button(PLANKS.get(keyPrefix + "_button").get())
                        .fence(PLANKS.get(keyPrefix + "_fence").get())
                        .fenceGate(PLANKS.get(keyPrefix + "_fence_gate").get())
                        .door(PLANKS.get(keyPrefix + "_door").get())
                        .sign(PLANKS.get(keyPrefix + "_sign").get(), PLANKS.get(keyPrefix + "_wall_sign").get())
                        .trapdoor(PLANKS.get(keyPrefix + "_trapdoor").get())
                        .getFamily();

                blockModels.family(PLANKS.get(color + "_" + type).get()).generateFor(plankFamily);

                blockModels.createHangingSign(LOGS.get(color + "_stripped_log").get(), PLANKS.get(keyPrefix + "_hanging_sign").get(), PLANKS.get(keyPrefix + "_wall_hanging_sign").get());

            }
        }

    }


    public void createColoredGrassLikeBlock(Block block, Block dirtBlock, BlockModelGenerators blockModels) {

        Identifier dirt = TextureMapping.getBlockTexture(dirtBlock);

        TextureMapping base = new TextureMapping()
                .put(TextureSlot.BOTTOM, dirt)
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));

        TextureMapping snowy = base.copy()
                .put(TextureSlot.BOTTOM, dirt)
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top_snow"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side_snow"));

        MultiVariant normal = createRotatedVariants(
                plainModel(ModelTemplates.CUBE_BOTTOM_TOP.create(block, base, blockModels.modelOutput))
        );


        MultiVariant snow = createRotatedVariants(
                plainModel(ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(block, "_snow", snowy, blockModels.modelOutput))
        );


        blockModels.createGrassLikeBlock(block, normal, snow);

    }
    public static MultiVariant createRotatedVariants(Variant variant) {
        return variants(variant, variant.with(Y_ROT_90), variant.with(Y_ROT_180), variant.with(Y_ROT_270));
    }
}
