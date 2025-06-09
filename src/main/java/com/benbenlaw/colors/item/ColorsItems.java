package com.benbenlaw.colors.item;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.config.StartupConfig;
import com.benbenlaw.core.block.colored.util.ColorMap;
import com.benbenlaw.core.item.colored.ColoringItem;
import com.benbenlaw.core.item.colored.LightingItem;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
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

    static {
        for (String color : ColorList.COLORS) {
            APPLES.put(color + "_apple", ITEMS.register(color + "_apple", () -> new Item(new Item.Properties().food(Foods.APPLE))));
            SPRAY_CANS.put(color + "_spray_can", ITEMS.register(color + "_spray_can", () -> new ColoringItem(new Item.Properties().durability(StartupConfig.sprayCanDurability.get())
                    .craftRemainder(BuiltInRegistries.ITEM.get(ResourceLocation.parse("colors:" + color + "_spray_can")))
                    , ColorMap.getDyeColor(color))));
        }
    }

    public static final DeferredItem<Item> GLOWSTONE_SPRAY_CAN = ITEMS.register("glowstone_spray_can",
            () -> new LightingItem(new Item.Properties().durability(StartupConfig.sprayCanDurability.get())
                    .craftRemainder(BuiltInRegistries.ITEM.get(ResourceLocation.parse("colors:glowstone_spray_can")))
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
