package com.benbenlaw.colors.particles;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.util.ColorList;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ColorsParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Colors.MOD_ID);

    public static final Map<String, DeferredHolder<ParticleType<?>, SimpleParticleType>> LEAF_PARTICLES = new HashMap<>();

    static {
        for (String color : ColorList.COLORS) {
            LEAF_PARTICLES.put(color,
                    PARTICLE_TYPES.register(color + "_leaf", () -> new SimpleParticleType(true)));
        }
    }

    public static SimpleParticleType getLeafParticle(String color) {
        DeferredHolder<ParticleType<?>, SimpleParticleType> holder = LEAF_PARTICLES.get(color);
        if (holder == null) {
            throw new IllegalArgumentException("No leaf particle registered for color: " + color);
        }
        return holder.get();
    }
}
