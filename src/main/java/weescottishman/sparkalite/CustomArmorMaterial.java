package weescottishman.sparkalite;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CustomArmorMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int [] {4, 8, 9, 4};

    @Override
    public int getDurability(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        return BASE_DURABILITY[slot.getEntitySlotId()] * 75;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        // TODO Auto-generated method stub
        return SoundEvents.BLOCK_BELL_USE;
    }

    @Override
    public float getKnockbackResistance() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "sparkalite";
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(Sparkalite.Sparkalite_Ingot);
    }

    @Override
    public float getToughness() {
        // TODO Auto-generated method stub
        return 4;
    }}