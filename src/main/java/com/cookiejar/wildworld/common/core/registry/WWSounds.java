package com.cookiejar.wildworld.common.core.registry;

import com.cookiejar.wildworld.common.core.WildWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class WWSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, WildWorld.MODID);


    public static final Supplier<SoundEvent> SEAHORSE_AMBIENT = registerFixedRange("entity.seahorse.ambient");
    public static final Supplier<SoundEvent> SEAHORSE_PUMP = registerFixedRange("entity.seahorse.pump");
    public static final Supplier<SoundEvent> SEAHORSE_HURT = registerFixedRange("entity.seahorse.hurt");
    public static final Supplier<SoundEvent> SEAHORSE_DEATH = registerFixedRange("entity.seahorse.death");



    private static Supplier<SoundEvent> register(String name, float range) {
        return SOUNDS.register(name, () -> SoundEvent.createFixedRangeEvent(WildWorld.resLoc(name), range));
    }

    private static Supplier<SoundEvent> registerFixedRange(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(WildWorld.resLoc(name)));
    }
}
