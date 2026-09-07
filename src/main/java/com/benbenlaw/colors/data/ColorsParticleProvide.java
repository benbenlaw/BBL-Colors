package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.particles.ColorsParticles;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Map;

public class ColorsParticleProvide extends ParticleDescriptionProvider {

    public ColorsParticleProvide(PackOutput output) {
        super(output);
    }

    @Override
    protected void addDescriptions() {
        for (Map.Entry<String, DeferredHolder<ParticleType<?>, SimpleParticleType>> entry : ColorsParticles.LEAF_PARTICLES.entrySet()) {
            String color = entry.getKey();
            this.spriteSet(entry.getValue().get(), Colors.identifier(color + "_leaf"));
        }
    }
}