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

package net.fabricmc.fabric.test.client.event.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.client.input.ClientInputEvents;

public class ClientInputEventsTest implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("ClientInputEventsTest");

	@Override
	public void onInitialize() {
		ClientInputEvents.KEY_PRESSED.register((code, scancode, action, modKeys, key) -> {
			LOGGER.info("pressed {}", key.getTranslationKey());
		});
		ClientInputEvents.KEY_RELEASED.register((code, scancode, action, modKeys, key) -> {
			LOGGER.info("released {}", key.getTranslationKey());
		});
		ClientInputEvents.KEY_REPEATED.register((code, scancode, action, modKeys, key) -> {
			LOGGER.info("repeated {}", key.getTranslationKey());
		});
		ClientInputEvents.KEYBIND_PRESSED.register((code, scancode, action, modKeys, key, binding) -> {
			LOGGER.info("pressed {}", binding.getTranslationKey());
		});
		ClientInputEvents.KEYBIND_RELEASED.register((code, scancode, action, modKeys, key, binding) -> {
			LOGGER.info("released {}", binding.getTranslationKey());
		});
		ClientInputEvents.KEYBIND_REPEATED.register((code, scancode, action, modKeys, key, binding) -> {
			LOGGER.info("repeated {}", binding.getTranslationKey());
		});
		ClientInputEvents.CHAR_TYPED.register((codepoint, modKeys) -> {
			LOGGER.info("typed U+{}", String.format("%04x", codepoint));
		});
		ClientInputEvents.MOUSE_MOVED.register((x, y, dx, dy) -> {
			LOGGER.info("moved to {},{} (delta {},{})", x, y, dx, dy);
		});
		ClientInputEvents.MOUSE_BUTTON_PRESSED.register((button, action, modKeys, key) -> {
			LOGGER.info("pressed {}", key.getTranslationKey());
		});
		ClientInputEvents.MOUSE_BUTTON_RELEASED.register((button, action, modKeys, key) -> {
			LOGGER.info("released {}", key.getTranslationKey());
		});
		ClientInputEvents.MOUSE_WHEEL_SCROLLED.register((scrollX, scrollY) -> {
			LOGGER.info("scrolled by {},{}", scrollX, scrollY);
		});
	}
}
