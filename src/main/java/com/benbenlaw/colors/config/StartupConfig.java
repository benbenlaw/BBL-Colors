package com.benbenlaw.colors.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class StartupConfig  {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.ConfigValue<Integer> sprayCanDurability;
    public static final ModConfigSpec.ConfigValue<Integer> litBlockEmission;

    static {

        // Caveopolis Configs
        BUILDER.comment("Caveopolis Startup Config")
                .push("Caveopolis");

        sprayCanDurability = BUILDER.comment("Spray can durability, default = 2048")
                .define("Max Spray Can Durability", 2048);

        litBlockEmission = BUILDER.comment("Light block emission, default = 15")
                .define("Light Block Emission", 15);

        BUILDER.pop();



        //LAST
        SPEC = BUILDER.build();

    }

}
