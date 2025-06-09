package com.benbenlaw.colors.util;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.core.util.ColorList;
import com.benbenlaw.core.util.CoreTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ColorsTags {

    public static class Blocks extends CoreTags.Blocks {

        public static final Map<String, TagKey<Block>> LOG_TAGS = new HashMap<>();
        static {
            for (String color : ColorList.COLORS) {
                LOG_TAGS.put(color, tag(Colors.MOD_ID, color + "_logs"));
            }
        }
    }

    public static class Items extends CoreTags.Items {
        public static final Map<String, TagKey<Item>> LOG_TAGS = new HashMap<>();
        static {
            for (String color : ColorList.COLORS) {
                LOG_TAGS.put(color, tag(Colors.MOD_ID, color + "_logs"));
            }
        }
    }
}