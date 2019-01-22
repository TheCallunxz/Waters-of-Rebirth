package thecallunxz.wor.init;

import java.util.Map;

import baubles.client.BaublesRenderLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import thecallunxz.wor.render.layers.LayerWings;

public class InitLayers {

	public static void registerLayers() {
		Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
		RenderPlayer render;
		render = skinMap.get("default");
		render.addLayer(new LayerWings(render));

		render = skinMap.get("slim");
		render.addLayer(new LayerWings(render));
	}
	
}
