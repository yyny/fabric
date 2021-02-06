/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.api.client.input.v1;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.impl.client.input.FabricKeyboardImpl;

/**
 * Retrieve the state of the keyboard keys.
 *
 * <p>Note that, unlike {@link net.minecraft.client.Keyboard}, the state is up to date
 * even inside Screen handlers and input event listeners.
 */
@Environment(EnvType.CLIENT)
public final class FabricKeyboard {
	private FabricKeyboard() {
	}

	/**
	 * Check if the given key is currently being pressed.
	 *
	 * @param keycode  the {@link GLFW}.GLFW_KEY code, or -1 if unknown
	 * @param scancode the (system-specific) scancode, or -1 if unknown
	 */
	public static boolean isKeyPressed(int keycode, int scancode) {
		return InputUtil.isKeyPressed(keycode, scancode);
	}

	/**
	 * Check if the given key is currently being pressed.
	 *
	 * @param key the key to check
	 */
	public static boolean isKeyPressed(Key key) {
		return InputUtil.isKeyPressed(key.getCode(), -1);
	}

	/**
	 * Get the GLFW.GLFW_MOD modifier keys currently being pressed.
	 */
	public static int getModKeys() {
		return FabricKeyboardImpl.getModKeys();
	}
}
