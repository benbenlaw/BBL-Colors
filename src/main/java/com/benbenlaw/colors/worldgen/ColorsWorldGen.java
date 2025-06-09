package com.benbenlaw.colors.worldgen;

import com.benbenlaw.colors.Colors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ColorsWorldGen {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(BuiltInRegistries.FEATURE, Colors.MOD_ID);

    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENTS =
            DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, Colors.MOD_ID);


    // Trees Placement
    public static Supplier<PlacementModifierType<?>> TREES_PLACEMENT =
            PLACEMENTS.register("trees_placement",  () -> (PlacementModifierType<PlacementModifier>) () -> PlacementTrees.CODEC);

    //Stones Placement
    public static Supplier<PlacementModifierType<?>> STONES_PLACEMENT =
            PLACEMENTS.register("stones_placement",  () -> (PlacementModifierType<PlacementModifier>) () -> PlacementStones.CODEC);


    public static void register(IEventBus eventBus) {

        FEATURES.register(eventBus);
        PLACEMENTS.register(eventBus);
    }

}