package weescottishman.sparkalite;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SparkaliteTools implements ToolMaterial {

    public static final SparkaliteTools INSTANCE = new SparkaliteTools();

    @Override
    public int getDurability() {
        // TODO Auto-generated method stub
        return 4000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 25;
    }

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 5;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(Sparkalite.Sparkalite_Ingot);
    }
     
    
}