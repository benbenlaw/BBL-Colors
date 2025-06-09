package com.benbenlaw.colors.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class WorldGenConfig {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.ConfigValue<Boolean> shouldColoredStoneSpawn;
    public static final ModConfigSpec.ConfigValue<Boolean> shouldColoredTreesSpawn;

    static {

        // Colors Configs
        BUILDER.comment("Colors World Gen Config")
                .push("Colors");

        shouldColoredStoneSpawn = BUILDER.comment("If the colored stone should spawn in world, default = true")
                .define("Colored Stone Spawn", true);

        shouldColoredTreesSpawn = BUILDER.comment("If the colored trees should spawn in world, default = true")
                .define("Colored Trees Spawn", true);



        BUILDER.pop();

        //LAST
        SPEC = BUILDER.build();

    }

}
