package weescottishman.sparkalite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import weescottishman.sparkalite.Tools.CustomAxeItem;
import weescottishman.sparkalite.Tools.CustomHoeItem;
import weescottishman.sparkalite.Tools.CustomPickaxeItem;
import net.minecraft.world.gen.GenerationStep;


public class Sparkalite implements ModInitializer {
	public static final SparkaliteTools SPARKALITE_TOOLS
	= new SparkaliteTools();

	public static ToolItem Sparkalite_Shovel 
	= new ShovelItem(SparkaliteTools.INSTANCE, 6.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));

	public static ToolItem Sparkalite_Sword
	= new SwordItem(SparkaliteTools.INSTANCE, 9, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));

	public static ToolItem Sparkalite_Pickaxe = new CustomPickaxeItem(SparkaliteTools.INSTANCE, 6, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
	
    public static ToolItem Sparkalite_Hoe = new CustomHoeItem(SparkaliteTools.INSTANCE, 1, 0F, new Item.Settings().group(ItemGroup.TOOLS));

	public static ToolItem Sparkalite_Axe = new CustomAxeItem(SparkaliteTools.INSTANCE, 11, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));


	public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL 
	= new CustomArmorMaterial();

    public static final Item CUSTOM_MATERIAL_HELMET 
	= new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));

    public static final Item CUSTOM_MATERIAL_CHESTPLATE 
	= new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));

    public static final Item CUSTOM_MATERIAL_LEGGINGS 
	= new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));

    public static final Item CUSTOM_MATERIAL_BOOTS 
	= new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));


	public static final Item Sparkalite_Ingot 
	= new Item(new Item.Settings().group(ItemGroup.MISC));
	

	public static final Item Sparkalite_Shard 
	= new Item(new Item.Settings().group(ItemGroup.MISC));
	

	public static final Block Sparkalite_Block 
	= new Block(FabricBlockSettings.of(Material.METAL).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES, 4).strength(5.0f, 2000.0F));


	public static final Block Sparkalite_Ore 
	= new  SparkaliteOreBlock(FabricBlockSettings.of(Material.METAL).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES, 4).strength(15.0f, 4000.0F));

	private static ConfiguredFeature<?, ?> ORE_SPARKALITE_END = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),Sparkalite_Ore.getDefaultState(),5))
	.range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(25)))).spreadHorizontally().repeat(1);
	

	@Override
	public void onInitialize() {

	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_helmet"), CUSTOM_MATERIAL_HELMET);

	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_chestplate"), CUSTOM_MATERIAL_CHESTPLATE);

	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_leggings"), CUSTOM_MATERIAL_LEGGINGS);

	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_boots"), CUSTOM_MATERIAL_BOOTS);



   
	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_shovel"), Sparkalite_Shovel);

	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_sword"), Sparkalite_Sword);
	
	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_pickaxe"), Sparkalite_Pickaxe);

    Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_hoe"), Sparkalite_Hoe);
	
	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_axe"), Sparkalite_Axe);
	



	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_ingot"), Sparkalite_Ingot);
	
	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_shard"), Sparkalite_Shard);
	
	Registry.register(Registry.BLOCK, new Identifier("sparkalite", "sparkalite_block"), Sparkalite_Block);
	
	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_block"), 
	new BlockItem(Sparkalite_Block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	
	Registry.register(Registry.BLOCK, new Identifier("sparkalite", "sparkalite_ore"), Sparkalite_Ore);
	
	Registry.register(Registry.ITEM, new Identifier("sparkalite", "sparkalite_ore"), 
	new BlockItem(Sparkalite_Ore, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));




    RegistryKey<ConfiguredFeature<?, ?>> oreSparkaliteEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,new Identifier("sparkalite", "ore_sparkalite_end"));

	Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSparkaliteEnd.getValue(), ORE_SPARKALITE_END);
    BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreSparkaliteEnd);
	}
}
