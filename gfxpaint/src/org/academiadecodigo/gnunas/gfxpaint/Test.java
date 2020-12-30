package org.academiadecodigo.gnunas.gfxpaint;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Arrays;

public class Test {

    /*private Keyboard keyboard;

    public Test(){

        Keyboard keyboard = new Keyboard(this);

        for (Key key : Key.values()) {

            addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_PRESSED);
            addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_RELEASED);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        Key key = Key.withCode(keyboardEvent.getKey());

        synchronized (inputs) {
            inputs.put(keyboardEvent.getKey(), new Input(key, Input.Type.KEY_PRESS));
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        Key key = Key.withCode(keyboardEvent.getKey());

        synchronized (inputs) {
            inputs.remove(keyboardEvent.getKey());
        }

        activeScreen.process(new Input(key, Input.Type.KEY_RELEASE));

    }

    private void addListener(Keyboard keyboard, int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public enum Key {
        W(KeyboardEvent.KEY_W),
        A(KeyboardEvent.KEY_A),
        D(KeyboardEvent.KEY_D),
        S(KeyboardEvent.KEY_S),
        T(KeyboardEvent.KEY_T),
        UP(KeyboardEvent.KEY_UP),
        LEFT(KeyboardEvent.KEY_LEFT),
        RIGHT(KeyboardEvent.KEY_RIGHT),
        DOWN(KeyboardEvent.KEY_DOWN),
        SPACE(KeyboardEvent.KEY_SPACE),
        ENTER(KeyboardEvent.KEY_ENTER),
        ESC(KeyboardEvent.KEY_ESC),
        Q(KeyboardEvent.KEY_Q),
        M(KeyboardEvent.KEY_M);

        private int keyCode;

        Key(int keyCode) {
            this.keyCode = keyCode;
        }

        public static Key withCode(int keyCode) {
            return Arrays.stream(values()).filter(key -> key.keyCode == keyCode).findFirst().get();
        }

        public int getKeyCode() {
            return keyCode;
        }
    }*/
}
