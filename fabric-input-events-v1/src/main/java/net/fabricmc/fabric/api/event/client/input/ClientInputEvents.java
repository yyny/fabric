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

package net.fabricmc.fabric.api.event.client.input;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

@Environment(EnvType.CLIENT)
public final class ClientInputEvents {
	public static final Event<KeyState> KEY_PRESSED
			= EventFactory.createSimpleArrayBacked(KeyEvent.class, KeyState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onKey(key));
	public static final Event<KeyState> KEY_RELEASED
			= EventFactory.createSimpleArrayBacked(KeyEvent.class, KeyState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onKey(key));
	public static final Event<KeyState> KEY_REPEATED
			= EventFactory.createSimpleArrayBacked(KeyEvent.class, KeyState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onKey(key));
	public static final Event<KeybindState> KEYBIND_PRESSED
			= EventFactory.createSimpleArrayBacked(KeybindEvent.class, KeybindState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onKeybind(key));
	public static final Event<KeybindState> KEYBIND_RELEASED
			= EventFactory.createSimpleArrayBacked(KeybindEvent.class, KeybindState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onKeybind(key));
	public static final Event<KeybindState> KEYBIND_REPEATED
			= EventFactory.createSimpleArrayBacked(KeybindEvent.class, KeybindState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onKeybind(key));
	public static final Event<CharState> CHAR_TYPED
			= EventFactory.createSimpleArrayBacked(CharEvent.class, CharState.class,
				listener -> key -> listener.accept(key),
				listener -> key -> listener.onChar(key));
	public static final Event<MouseMove> MOUSE_MOVED
			= EventFactory.createSimpleArrayBacked(MouseMoveEvent.class, MouseMove.class,
				listener -> mouse -> listener.accept(mouse),
				listener -> mouse -> listener.onMouseMoved(mouse));
	public static final Event<MouseButtonState> MOUSE_BUTTON_PRESSED
			= EventFactory.createSimpleArrayBacked(MouseButtonEvent.class, MouseButtonState.class,
				listener -> mouse -> listener.accept(mouse),
				listener -> mouse -> listener.onMouseButton(mouse));
	public static final Event<MouseButtonState> MOUSE_BUTTON_RELEASED
			= EventFactory.createSimpleArrayBacked(MouseButtonEvent.class, MouseButtonState.class,
				listener -> mouse -> listener.accept(mouse),
				listener -> mouse -> listener.onMouseButton(mouse));
	public static final Event<MouseScroll> MOUSE_WHEEL_SCROLLED
			= EventFactory.createSimpleArrayBacked(MouseScrollEvent.class, MouseScroll.class,
				listener -> mouse -> listener.accept(mouse),
				listener -> mouse -> listener.onMouseScrolled(mouse));
	public static final Event<FileDrop> FILE_DROPPED
			= EventFactory.createSimpleArrayBacked(String[].class, FileDrop.class,
				listener -> paths -> listener.accept(paths),
				listener -> paths -> listener.onFilesDropped(paths));

	@FunctionalInterface
	public interface KeyState {
		void onKey(KeyEvent key);
	}

	@FunctionalInterface
	public interface CharState {
		void onChar(CharEvent key);
	}

	@FunctionalInterface
	public interface KeybindState {
		void onKeybind(KeybindEvent key);
	}

	@FunctionalInterface
	public interface MouseMove {
		void onMouseMoved(MouseMoveEvent mouse);
	}

	@FunctionalInterface
	public interface MouseButtonState {
		void onMouseButton(MouseButtonEvent mouse);
	}

	@FunctionalInterface
	public interface MouseScroll {
		void onMouseScrolled(MouseScrollEvent mouse);
	}

	@FunctionalInterface
	public interface FileDrop {
		void onFilesDropped(String[] paths);
	}
}