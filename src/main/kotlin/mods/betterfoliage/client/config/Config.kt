package mods.betterfoliage.client.config

import mods.betterfoliage.BetterFoliage
import mods.betterfoliage.client.integration.ShadersModIntegration
import mods.octarinecore.common.config.*
import net.minecraft.util.ResourceLocation

private fun featureEnable() = boolean(true).lang("enabled")

// Config singleton
object Config : DelegatingConfig(BetterFoliage.MOD_ID, BetterFoliage.MOD_ID) {

    val enabled by boolean(true)
    val nVidia by boolean(false)

    object shaders {
        val leavesId by long(min = 1, max = 65535, default = ShadersModIntegration.leavesDefaultBlockId)
        val grassId by long(min = 1, max = 65535, default = ShadersModIntegration.grassDefaultBlockId)
    }

    object leaves : ConfigCategory() {
        val enabled by featureEnable()
        val snowEnabled by boolean(true)
        val hOffset by double(max=0.4, default=0.2).lang("hOffset")
        val vOffset by double(max=0.4, default=0.1).lang("vOffset")
        val size by double(min=0.75, max=2.5, default=1.4).lang("size")
        val dense by boolean(false)
        val hideInternal by boolean(true)
    }

    object shortGrass : ConfigCategory(){
        val grassEnabled by boolean(true)
        val myceliumEnabled by boolean(true)
        val snowEnabled by boolean(true)
        val hOffset by double(max=0.4, default=0.2).lang("hOffset")
        val heightMin by double(min=0.1, max=2.5, default=0.6).lang("heightMin")
        val heightMax by double(min=0.1, max=2.5, default=0.8).lang("heightMax")
        val size by double(min=0.5, max=1.5, default=1.0).lang("size")
        val population by int(max=64, default=64).lang("population")
        val useGenerated by boolean(false)
        val shaderWind by boolean(true).lang("shaderWind")
        val saturationThreshold by double(default=0.1)
    }

    object connectedGrass : ConfigCategory(){
        val enabled by boolean(true)
        val snowEnabled by boolean(false)
    }

    object roundLogs : ConfigCategory(){
        val enabled by featureEnable()
        val radiusSmall by double(max=0.5, default=0.25)
        val radiusLarge by double(max=0.5, default=0.44)
        val dimming by double(default = 0.7)
        val connectSolids by boolean(false)
        val lenientConnect by boolean(true)
        val connectPerpendicular by boolean(true)
        val connectGrass by boolean(true)
        val defaultY by boolean(false)
        val zProtection by double(min = 0.9, default = 0.99)
    }

    object cactus : ConfigCategory(){
        val enabled by featureEnable()
        val size by double(min=0.5, max=1.5, default=0.8).lang("size")
        val sizeVariation by double(max=0.5, default=0.1)
        val hOffset by double(max=0.5, default=0.1).lang("hOffset")
    }

    object lilypad : ConfigCategory(){
        val enabled by featureEnable()
        val hOffset by double(max=0.25, default=0.1).lang("hOffset")
        val flowerChance by int(max=64, default=16, min=0)
    }

    object reed : ConfigCategory(){
        val enabled by featureEnable()
        val hOffset by double(max=0.4, default=0.2).lang("hOffset")
        val heightMin by double(min=1.5, max=3.5, default=1.7).lang("heightMin")
        val heightMax by double(min=1.5, max=3.5, default=2.2).lang("heightMax")
        val population by int(max=64, default=32).lang("population")
        val minBiomeTemp by double(default=0.4)
        val minBiomeRainfall by double(default=0.4)
//        val biomes by biomeList { it.filterTemp(0.4f, null) && it.filterRain(0.4f, null) }
        val shaderWind by boolean(true).lang("shaderWind")
    }

    object algae : ConfigCategory(){
        val enabled by featureEnable()
        val hOffset by double(max=0.25, default=0.1).lang("hOffset")
        val size by double(min=0.5, max=1.5, default=1.0).lang("size")
        val heightMin by double(min=0.1, max=1.5, default=0.5).lang("heightMin")
        val heightMax by double(min=0.1, max=1.5, default=1.0).lang("heightMax")
        val population by int(max=64, default=48).lang("population")
//        val biomes by biomeList { it.filterClass("river", "ocean") }
        val shaderWind by boolean(true).lang("shaderWind")
    }

    object coral : ConfigCategory(){
        val enabled by featureEnable()
        val shallowWater by boolean(false)
        val hOffset by double(max=0.4, default=0.2).lang("hOffset")
        val vOffset by double(max=0.4, default=0.1).lang("vOffset")
        val size by double(min=0.5, max=1.5, default=0.7).lang("size")
        val crustSize by double(min=0.5, max=1.5, default=1.4)
        val chance by int(max=64, default=32)
        val population by int(max=64, default=48).lang("population")
//        val biomes by biomeList { it.filterClass("river", "ocean", "beach") }
    }

    object netherrack : ConfigCategory(){
        val enabled by featureEnable()
        val hOffset by double(max=0.4, default=0.2).lang("hOffset")
        val heightMin by double(min=0.1, max=1.5, default=0.6).lang("heightMin")
        val heightMax by double(min=0.1, max=1.5, default=0.8).lang("heightMax")
        val size by double(min=0.5, max=1.5, default=1.0).lang("size")
    }

    object fallingLeaves : ConfigCategory(){
        val enabled by featureEnable()
        val speed by double(min=0.01, max=0.15, default=0.05)
        val windStrength by double(min=0.1, max=2.0, default=0.5)
        val stormStrength by double(min=0.1, max=2.0, default=0.8)
        val size by double(min=0.25, max=1.5, default=0.75).lang("size")
        val chance by double(min=0.001, max=1.0, default=0.05)
        val perturb by double(min=0.01, max=1.0, default=0.25)
        val lifetime by double(min=1.0, max=15.0, default=5.0)
        val opacityHack by boolean(true)
    }

    object risingSoul : ConfigCategory(){
        val enabled by featureEnable()
        val chance by double(min=0.001, max=1.0, default=0.02)
        val perturb by double(min=0.01, max=0.25, default=0.05)
        val headSize by double(min=0.25, max=1.5, default=1.0)
        val trailSize by double(min=0.25, max=1.5, default=0.75)
        val opacity by double(min=0.05, max=1.0, default=0.5)
        val sizeDecay by double(min=0.5, max=1.0, default=0.97)
        val opacityDecay by double(min=0.5, max=1.0, default=0.97)
        val lifetime by double(min=1.0, max=15.0, default=4.0)
        val trailLength by int(min=2, max=128, default=48)
        val trailDensity by int(min=1, max=16, default=3)
    }
}

object BlockConfig {
    private val list = mutableListOf<Any>()

    val leafBlocks = blocks("leaves_blocks_default.cfg")
    val leafModels = models("leaves_models_default.cfg")
    val grassBlocks = blocks("grass_blocks_default.cfg")
    val grassModels = models("grass_models_default.cfg")
    val mycelium = blocks("mycelium_blocks_default.cfg")
//    val dirt = blocks("dirt_default.cfg")
    val crops = blocks("crop_default.cfg")
    val logBlocks = blocks("log_blocks_default.cfg")
    val logModels = models("log_models_default.cfg")
    val sand = blocks("sand_default.cfg")
    val lilypad = blocks("lilypad_default.cfg")
    val cactus = blocks("cactus_default.cfg")
    val netherrack = blocks("netherrack_blocks_default.cfg")

    init { BetterFoliage.modBus.register(this) }
    private fun blocks(cfgName: String) = ConfigurableBlockMatcher(BetterFoliage.logDetail, ResourceLocation(BetterFoliage.MOD_ID, cfgName)).apply { list.add(this) }
    private fun models(cfgName: String) = ModelTextureListConfiguration(BetterFoliage.logDetail, ResourceLocation(BetterFoliage.MOD_ID, cfgName)).apply { list.add(this) }
}