package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.util.ColorList;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Map;

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

        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.PLANKS.entrySet()) {
            if (entry.getKey().endsWith("_bamboo_mosaic_door")) {
                itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
            }
            else if (entry.getKey().endsWith("_bamboo_plank_door")) {
                itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
            }
            else if (entry.getKey().endsWith("_plank_door")) {
                itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
            }
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SHORT_GRASS.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.TALL_GRASS.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.POPPY.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.DANDELION.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SAPLINGS.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }
        for (Map.Entry<String, DeferredItem<Item>> entry : ColorsItems.APPLES.entrySet()) {
            itemModels.generateFlatItem(entry.getValue().get().asItem(), ModelTemplates.FLAT_ITEM);
        }


    }
}
