package com.benbenlaw.colors.worldgen.tree;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.benbenlaw.colors.worldgen.ColorsConfiguredFeatures.TREES_KEY;

public class ColorsTreeGrowers {

    public static final Map<String, TreeGrower> TREE_GROWERS = new HashMap<>();


    static {
        for (String color : ColorList.COLORS) {
            TREE_GROWERS.put(color, new TreeGrower(Colors.MOD_ID + ":" + color + "_tree",
                    Optional.empty(), Optional.of(TREES_KEY.get(color)), Optional.empty()));
        }
    }
}
