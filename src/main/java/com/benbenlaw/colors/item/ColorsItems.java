package com.benbenlaw.colors.item;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.config.StartupConfig;
import com.benbenlaw.colors.util.ColorList;
import com.benbenlaw.colors.util.ColorMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class ColorsItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Colors.MOD_ID);

    public static final Map<String, DeferredItem<Item>> APPLES = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> SPRAY_CANS = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> PLANKS = new HashMap<>();

    static {
        for (String color : ColorList.COLORS) {
            APPLES.put(color + "_apple", ITEMS.register(color + "_apple", () -> new Item(new Item.Properties().food(Foods.APPLE).setId(createID(color + "_apple")))));

            SPRAY_CANS.put(color + "_spray_can", ITEMS.register(color + "_spray_can", () -> new ColoringItem(new Item.Properties().durability(StartupConfig.sprayCanDurability.get()).setId(createID(color + "_spray_can")),
                    //.craftRemainder(new ItemStackTemplate(SPRAY_CANS.get("colors:" + color + "_spray_can"))),
                    ColorMap.getDyeColor(color))));

            PLANKS.put(color + "_plank_sign", ITEMS.register(color + "_plank_sign", () -> new SignItem(
                    ColorsBlocks.PLANKS.get(color + "_plank_sign").get(),
                    ColorsBlocks.PLANKS.get(color + "_plank_wall_sign").get(),
                    new Item.Properties().stacksTo(16).setId(createID(color + "_plank_sign")))));

            PLANKS.put(color + "_plank_hanging_sign", ITEMS.register(color + "_plank_hanging_sign", () -> new SignItem(
                    ColorsBlocks.PLANKS.get(color + "_plank_hanging_sign").get(),
                    ColorsBlocks.PLANKS.get(color + "_plank_wall_hanging_sign").get(),
                    new Item.Properties().stacksTo(16).setId(createID(color + "_plank_hanging_sign")))));

            PLANKS.put(color + "_bamboo_plank_sign", ITEMS.register(color + "_bamboo_plank_sign", () -> new SignItem(
                    ColorsBlocks.PLANKS.get(color + "_bamboo_plank_sign").get(),
                    ColorsBlocks.PLANKS.get(color + "_bamboo_plank_wall_sign").get(),
                    new Item.Properties().stacksTo(16).setId(createID(color + "_bamboo_plank_sign")))));

            PLANKS.put(color + "_bamboo_plank_hanging_sign", ITEMS.register(color + "_bamboo_plank_hanging_sign", () -> new SignItem(
                    ColorsBlocks.PLANKS.get(color + "_bamboo_plank_hanging_sign").get(),
                    ColorsBlocks.PLANKS.get(color + "_bamboo_plank_wall_hanging_sign").get(),
                    new Item.Properties().stacksTo(16).setId(createID(color + "_bamboo_plank_hanging_sign")))));

            PLANKS.put(color + "_bamboo_mosaic_sign", ITEMS.register(color + "_bamboo_mosaic_sign", () -> new SignItem(
                    ColorsBlocks.PLANKS.get(color + "_bamboo_mosaic_sign").get(),
                    ColorsBlocks.PLANKS.get(color + "_bamboo_mosaic_wall_sign").get(),
                    new Item.Properties().stacksTo(16).setId(createID(color + "_bamboo_mosaic_sign")))));

            PLANKS.put(color + "_bamboo_mosaic_hanging_sign", ITEMS.register(color + "_bamboo_mosaic_hanging_sign", () -> new SignItem(
                    ColorsBlocks.PLANKS.get(color + "_bamboo_mosaic_hanging_sign").get(),
                    ColorsBlocks.PLANKS.get(color + "_bamboo_mosaic_wall_hanging_sign").get(),
                    new Item.Properties().stacksTo(16).setId(createID(color + "_bamboo_mosaic_hanging_sign")))));





        }
    }

    public static ResourceKey<Item> createID(String name) {
        return ResourceKey.create(Registries.ITEM, Colors.identifier(name));
    }
}
