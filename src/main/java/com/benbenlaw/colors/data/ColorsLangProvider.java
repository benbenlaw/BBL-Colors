package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;


public class ColorsLangProvider extends LanguageProvider {
    public ColorsLangProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Colors.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        addTranslation("creative." + Colors.MOD_ID + ".tab", "Colors");

        for (String color : ColorList.COLORS) {

            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {
                String baseKey = color + "_" + type;
                String baseName = formatName(color) + " " + formatName(type);
                addBlockTranslation(baseKey, baseName);

                String variantType = getVariantType(type);
                String variantKeyPrefix = color + "_" + variantType;
                String variantNameBase = formatName(color) + " " + formatName(variantType);

                addBlockTranslation(variantKeyPrefix + "_stairs", variantNameBase + " Stairs");
                addBlockTranslation(variantKeyPrefix + "_slab", variantNameBase + " Slab");
                addBlockTranslation(variantKeyPrefix + "_wall", variantNameBase + " Wall");
                addBlockTranslation(variantKeyPrefix + "_pressure_plate", variantNameBase + " Pressure Plate");
                addBlockTranslation(variantKeyPrefix + "_button", variantNameBase + " Button");
            }

            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                addBlockTranslation(color + "_" + type, formatName(color) + " " + formatName(type));
                addBlockTranslation(keyPrefix + "_stairs", formatName(color) + " " + formatName(singularType) + " Stairs");
                addBlockTranslation(keyPrefix + "_slab", formatName(color) + " " + formatName(singularType) + " Slab");
                addBlockTranslation(keyPrefix + "_fence", formatName(color) + " " + formatName(singularType) + " Fence");
                addBlockTranslation(keyPrefix + "_fence_gate", formatName(color) + " " + formatName(singularType) + " Fence Gate");
                addBlockTranslation(keyPrefix + "_pressure_plate", formatName(color) + " " + formatName(singularType) + " Pressure Plate");
                addBlockTranslation(keyPrefix + "_button", formatName(color) + " " + formatName(singularType) + " Button");
                addBlockTranslation(keyPrefix + "_trapdoor", formatName(color) + " " + formatName(singularType) + " Trapdoor");
                addBlockTranslation(keyPrefix + "_door", formatName(color) + " " + formatName(singularType) + " Door");
                addBlockTranslation(keyPrefix + "_sign", formatName(color) + " " + formatName(singularType) + " Sign");
                addBlockTranslation(keyPrefix + "_wall_sign", formatName(color) + " " + formatName(singularType) + " Sign");
                addBlockTranslation(keyPrefix + "_hanging_sign", formatName(color) + " " + formatName(singularType) + " Hanging Sign");
                addBlockTranslation(keyPrefix + "_wall_hanging_sign", formatName(color) + " " + formatName(singularType) + " Hanging Sign");


            }

            addBlockTranslation(color + "_dirt", formatName(color) + " Dirt");
            addBlockTranslation(color + "_grass_block", formatName(color) + " Grass Block");
            addBlockTranslation(color + "_crafting_table", formatName(color) + " Crafting Table");
            addBlockTranslation(color + "_tall_grass", formatName(color) + " Tall Grass");
            addBlockTranslation(color + "_short_grass", formatName(color) + " Short Grass");
            addBlockTranslation(color + "_poppy", formatName(color) + " Poppy");
            addBlockTranslation(color + "_potted_poppy", formatName(color) + " Potted Poppy");
            addBlockTranslation(color + "_dandelion", formatName(color) + " Dandelion");
            addBlockTranslation(color + "_leaves", formatName(color) + " Leaves");
            addBlockTranslation(color + "_log", formatName(color) + " Log");
            addBlockTranslation(color + "_stripped_log", formatName(color) + " Stripped Log");
            addBlockTranslation(color + "_wood", formatName(color) + " Wood");
            addBlockTranslation(color + "_stripped_wood", formatName(color) + " Stripped Wood");
            addBlockTranslation(color + "_bamboo", formatName(color) + " Bamboo");
            addBlockTranslation(color + "_stripped_bamboo", formatName(color) + " Stripped Bamboo");
            addBlockTranslation(color + "_sapling", formatName(color) + " Sapling");
            addItemTranslation(color + "_spray_can", formatName(color) + " Spray Can");
            addItemTranslation(color + "_apple", formatName(color) + " Apple");


        }

        addItemTranslation("glowstone_spray_can", "Glowstone Spray Can");

    }

    private void addBlockTranslation(String name, String translation) {
        add("block." + Colors.MOD_ID + "." + name, translation);
    }

    private void addItemTranslation(String name, String translation) {
        add("item." + Colors.MOD_ID + "." + name, translation);
    }

    private void addTranslation(String name, String translation) {
        super.add(name, translation);
    }

    private String formatName(String input) {
        String[] words = input.split("_"); // Split by underscore
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            formatted.append(Character.toUpperCase(word.charAt(0))) // Capitalize first letter
                    .append(word.substring(1)) // Append rest of the word
                    .append(" ");
        }
        return formatted.toString().trim(); // Remove trailing space
    }

    private String getVariantType(String type) {
        if (type.endsWith("tiles")) {
            return type.substring(0, type.length() - "tiles".length()) + "tile";
        } else if (type.endsWith("bricks")) {
            return type.substring(0, type.length() - "bricks".length()) + "brick";
        } else {
            return type;
        }
    }

}


/*
public class ColorsLangProvider extends LanguageProvider {
    private static final Map<String, String> COLOR_CODES = Map.ofEntries(
            Map.entry("red", "§c"),
            Map.entry("blue", "§9"),
            Map.entry("green", "§2"),
            Map.entry("yellow", "§e"),
            Map.entry("purple", "§5"),
            Map.entry("cyan", "§3"),
            Map.entry("orange", "§6"),
            Map.entry("pink", "§d"),
            Map.entry("white", "§f"),
            Map.entry("black", "§0"),
            Map.entry("gray", "§7"),
            Map.entry("light_gray", "§8"),
            Map.entry("lime", "§a"),
            Map.entry("brown", "§4")
    );

    public ColorsLangProvider(PackOutput output) {
        super(output, Colors.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (String color : ColorList.COLORS) {
            String colorCode = COLOR_CODES.getOrDefault(color, "§f"); // Default to white if not found
            addBlockTranslation(color, colorCode);
        }
    }

    private void addBlockTranslation(String color, String colorCode) {
        add("block." + Colors.MOD_ID + "." + color + "_stone", colorCode + capitalize(color) + " Stone");
        add("block." + Colors.MOD_ID + "." + color + "_stone_slab", colorCode + capitalize(color) + " Stone Slab");
        add("block." + Colors.MOD_ID + "." + color + "_stone_stairs", colorCode + capitalize(color) + " Stone Stairs");
        add("block." + Colors.MOD_ID + "." + color + "_stone_wall", colorCode + capitalize(color) + " Stone Wall");
        add("block." + Colors.MOD_ID + "." + color + "_stone_pressure_plate", colorCode + capitalize(color) + " Stone Pressure Plate");
        add("block." + Colors.MOD_ID + "." + color + "_stone_button", colorCode + capitalize(color) + " Stone Button");

        add("block." + Colors.MOD_ID + "." + color + "_braid", colorCode + capitalize(color) + " Braid");
        add("block." + Colors.MOD_ID + "." + color + "_braid_slab", colorCode + capitalize(color) + " Braid Slab");
        add("block." + Colors.MOD_ID + "." + color + "_braid_stairs", colorCode + capitalize(color) + " Braid Stairs");
        add("block." + Colors.MOD_ID + "." + color + "_braid_wall", colorCode + capitalize(color) + " Braid Wall");
        add("block." + Colors.MOD_ID + "." + color + "_braid_pressure_plate", colorCode + capitalize(color) + " Braid Pressure Plate");
        add("block." + Colors.MOD_ID + "." + color + "_braid_button", colorCode + capitalize(color) + " Braid Button");
    }

    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}


 */