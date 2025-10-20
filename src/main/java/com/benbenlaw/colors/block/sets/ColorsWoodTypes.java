package com.benbenlaw.colors.block.sets;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashMap;
import java.util.Map;

public class ColorsWoodTypes {

    public static final Map<String, WoodType> WOOD_TYPES = new HashMap<>();

    static {
        for (String color : ColorList.COLORS) {
            for (String plank : PlankLikeBlocksList.PLANKS) {
                String singularPlank = plank.endsWith("s") ? plank.substring(0, plank.length() - 1) : plank;

                // Base name for WoodType lookup (singular)
                String baseName = color + "_" + singularPlank;

                // Names for registration
                String setName = baseName + "_wood_set";
                String woodTypeName = baseName + "_sign"; // always singular

                // Register BlockSetType
                BlockSetType woodSet = BlockSetType.register(
                        new BlockSetType(ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, setName).toString())
                );

                // Register WoodType (singular)
                WoodType woodType = WoodType.register(
                        new WoodType(ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, woodTypeName).toString(), woodSet)
                );

                // Put singular name in the map
                WOOD_TYPES.put(baseName, woodType);

                System.out.println("[Colors] Added wood type: " + woodTypeName); // debug
            }
        }
    }

    // --- FIX: getWoodType now only uses singular keys ---
    public static WoodType getWoodType(String color, String plank) {
        return WOOD_TYPES.get(color + "_" + plank);
    }

    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            for (WoodType type : WOOD_TYPES.values()) {
                Sheets.addWoodType(type);
                System.out.println("[Colors] Added wood type to Sheets: " + type.name());
            }
        });
    }
}

