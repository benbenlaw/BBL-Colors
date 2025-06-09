package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.item.ColorsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Map;

public class ColorsItemModelProvider extends ItemModelProvider {

    public ColorsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Colors.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Spray Cans
        simpleItem(ColorsItems.SPRAY_CANS.get("black_spray_can"), "black_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("red_spray_can"), "red_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("green_spray_can"), "green_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("brown_spray_can"), "brown_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("blue_spray_can"), "blue_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("purple_spray_can"), "purple_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("cyan_spray_can"), "cyan_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("light_gray_spray_can"), "light_gray_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("gray_spray_can"), "gray_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("pink_spray_can"), "pink_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("lime_spray_can"), "lime_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("yellow_spray_can"), "yellow_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("light_blue_spray_can"), "light_blue_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("magenta_spray_can"), "magenta_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("orange_spray_can"), "orange_spray_can");
        simpleItem(ColorsItems.SPRAY_CANS.get("white_spray_can"), "white_spray_can");
        simpleItem(ColorsItems.GLOWSTONE_SPRAY_CAN, "glowstone_spray_can");

        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.PLANKS.entrySet()) {
            if (entry.getKey().endsWith("_bamboo_mosaic_door")) {
                doorItem(entry.getValue(), "bamboo_mosaic_door");
            }
            else if (entry.getKey().endsWith("_bamboo_plank_door")) {
                doorItem(entry.getValue(), "bamboo_plank_door");
            }
            else if (entry.getKey().endsWith("_plank_door")) {
                doorItem(entry.getValue(), "plank_door");
            }
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SHORT_GRASS.entrySet()) {
            saplingItem(entry.getValue(), "short_grass");
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.TALL_GRASS.entrySet()) {
            tallGrass(entry.getValue(), "tall_grass");
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.POPPY.entrySet()) {
            saplingItem(entry.getValue(), "poppy");
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.DANDELION.entrySet()) {
            saplingItem(entry.getValue(), "dandelion");
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SAPLINGS.entrySet()) {
            saplingItem(entry.getValue(), "sapling");
        }
        for (Map.Entry<String, DeferredItem<Item>> entry : ColorsItems.APPLES.entrySet()) {
            simpleItem(entry.getValue(), "apple");
        }
    }

    private void simpleItem(DeferredItem<Item> item, String defaultTexture) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "item/" + defaultTexture));
    }


    private void doorItem(DeferredBlock<Block> item, String defaultTexture) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "item/" + defaultTexture));
    }

    private void saplingItem(DeferredBlock<Block> item, String defaultTexture) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "block/" + defaultTexture));
    }

    private void tallGrass(DeferredBlock<Block> item, String defaultTexture) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, "block/" + defaultTexture + "_top"));
    }
}