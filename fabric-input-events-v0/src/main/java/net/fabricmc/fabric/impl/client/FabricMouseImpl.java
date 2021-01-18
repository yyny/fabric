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

package net.fabricmc.fabric.impl.client;

import java.nio.DoubleBuffer;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.FabricKeyboard;
import net.fabricmc.fabric.api.client.FabricMouse;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;

public class FabricMouseImpl implements FabricMouse {
	public static FabricMouseImpl INSTANCE = new FabricMouseImpl();

	private double x = 0.0;
	private double y = 0.0;
	private int buttons = 0;
	private int mods = 0;
	private final DoubleBuffer fabric_x = DoubleBuffer.allocate(1);
	private final DoubleBuffer fabric_y = DoubleBuffer.allocate(1);

	private FabricMouseImpl() {
	}

	@Override
	public double impl_getX() {
		return this.x;
	}
	@Override
	public double impl_getY() {
		return this.y;
	}
	@Override
	public int impl_getPressedButtons() {
		return this.buttons;
	}
	@Override
	public boolean impl_isButtonPressed(int button) {
		return (this.buttons & (1 << button)) != 0;
	}
	@Override
	public int impl_getMods() {
		return this.mods;
	}

	public void update() {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client == null)
			return;
		Window window = client.getWindow();
		long handle = window.getHandle();
		GLFW.glfwGetCursorPos(handle, fabric_x, fabric_y);
		this.buttons = 0;
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_1) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_1);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_2) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_2);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_3) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_3);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_4) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_4);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_5) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_5);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_6) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_6);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_7) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_7);
		if (GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_8) == GLFW.GLFW_PRESS)
			this.buttons |= (1 << GLFW.GLFW_MOUSE_BUTTON_8);
		this.mods = FabricKeyboard.getMods();
	}

}
