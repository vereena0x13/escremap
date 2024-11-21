package gay.vereena.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.client.util.InputUtil.GLFW_KEY_CAPS_LOCK;
import static net.minecraft.client.util.InputUtil.GLFW_KEY_ESCAPE;


@Mixin(Keyboard.class)
public class KeyboardMixin {
	@Inject(at = @At("HEAD"), method = "onKey")
	private void onKey(CallbackInfo info, @Local(ordinal = 0, argsOnly = true) LocalIntRef key) {
		switch(key.get()) {
			case GLFW_KEY_CAPS_LOCK -> key.set(GLFW_KEY_ESCAPE);
			case GLFW_KEY_ESCAPE -> key.set(GLFW_KEY_CAPS_LOCK);
		}
	}
}