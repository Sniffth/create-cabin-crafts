package net.sniffth.create_cabin_crafts.block;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sniffth.create_cabin_crafts.CreateCABINCrafts;

@OnlyIn(Dist.CLIENT)
public class CABINCraftsSpriteShifts {
    public static final CTSpriteShiftEntry LEAD_CASING = omni("lead_casing");

    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, CreateCABINCrafts.rl("block/" + blockTextureName),
                CreateCABINCrafts.rl("block/" + connectedTextureName + "_connected"));
    }
}
