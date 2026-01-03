package com.benbenlaw.colors.util;

import net.minecraft.world.item.DyeColor;

import java.util.HashMap;

public class ColorMap {

    //This Has Map coverts the DyeColor to the RGB value for the tinting of blocks and items both inworld and in inventory
    public static final HashMap<DyeColor, Integer> COLOR_MAP = new HashMap<>() {{

        put(DyeColor.WHITE, DyeColor.WHITE.getFireworkColor());
        put(DyeColor.ORANGE, DyeColor.ORANGE.getFireworkColor());
        put(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE.getFireworkColor());
        put(DyeColor.CYAN, DyeColor.CYAN.getFireworkColor());
        put(DyeColor.PINK, DyeColor.PINK.getFireworkColor());
        put(DyeColor.YELLOW, DyeColor.YELLOW.getFireworkColor());
        put(DyeColor.LIGHT_GRAY, DyeColor.LIGHT_GRAY.getFireworkColor());
        put(DyeColor.GRAY, DyeColor.GRAY.getFireworkColor());
        put(DyeColor.RED, DyeColor.RED.getFireworkColor());
        put(DyeColor.LIME, DyeColor.LIME.getFireworkColor());
        put(DyeColor.BLUE, DyeColor.BLUE.getFireworkColor());
        put(DyeColor.PURPLE, DyeColor.PURPLE.getFireworkColor());
        put(DyeColor.BROWN, DyeColor.BROWN.getFireworkColor());
        put(DyeColor.GREEN, DyeColor.GREEN.getFireworkColor());
        put(DyeColor.BLACK, DyeColor.BLACK.getFireworkColor());
        put(DyeColor.MAGENTA, DyeColor.MAGENTA.getFireworkColor());


    }};

    private static final HashMap<String, DyeColor> STRING_TO_DYE_COLOR = new HashMap<>() {{
        put("white", DyeColor.WHITE);
        put("orange", DyeColor.ORANGE);
        put("light_blue", DyeColor.LIGHT_BLUE);
        put("cyan", DyeColor.CYAN);
        put("pink", DyeColor.PINK);
        put("yellow", DyeColor.YELLOW);
        put("light_gray", DyeColor.LIGHT_GRAY);
        put("gray", DyeColor.GRAY);
        put("red", DyeColor.RED);
        put("lime", DyeColor.LIME);
        put("blue", DyeColor.BLUE);
        put("purple", DyeColor.PURPLE);
        put("brown", DyeColor.BROWN);
        put("green", DyeColor.GREEN);
        put("black", DyeColor.BLACK);
        put("magenta", DyeColor.MAGENTA);
    }};
    private static final HashMap<String, String> STRING_TO_STRING_TRANSLATION = new HashMap<>() {{
        put("white", "color.bblcore.white");
        put("orange", "color.bblcore.orange");
        put("light_blue", "color.bblcore.light_blue");
        put("cyan", "color.bblcore.cyan");
        put("pink", "color.bblcore.pink");
        put("yellow", "color.bblcore.yellow");
        put("light_gray", "color.bblcore.light_gray");
        put("gray", "color.bblcore.gray");
        put("red", "color.bblcore.red");
        put("lime", "color.bblcore.lime");
        put("blue", "color.bblcore.blue");
        put("purple", "color.bblcore.purple");
        put("brown", "color.bblcore.brown");
        put("green", "color.bblcore.green");
        put("black", "color.bblcore.black");
        put("magenta", "color.bblcore.magenta");
    }};

    public static Integer getColorValue(DyeColor dyeColor) {
        return COLOR_MAP.get(dyeColor);
    }

    public static DyeColor getDyeColor(String colorName) {
        return STRING_TO_DYE_COLOR.get(colorName.toLowerCase());
    }

    public static String getTranslationKey(String colorName) {
        return STRING_TO_STRING_TRANSLATION.get(colorName);
    }

}