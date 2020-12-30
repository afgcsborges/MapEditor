package org.academiadecodigo.gnunas.gfxpaint;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import java.util.HashMap;

public class EditorController implements KeyboardHandler {

    private HashMap<Integer, Action> actions;
    private final Keyboard keyboard;
    private final Pointer pointer;
    private final Map map;
    private final FileEditor fileEditor;


    public EditorController(Pointer pointer, Map map, FileEditor fileEditor) {
        this.map = map;
        this.pointer = pointer;
        this.fileEditor = fileEditor;
        keyboard = new Keyboard(this);
        keyboardConfig();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        actions.get(keyboardEvent.getKey()).execute();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            pointer.setPainting(false);
        }
    }

    private void keyboardConfig () {

        for (Key key : Key.values()) {

            addListener(keyboard,key.keyCode,key.eventType);
        }
        actionConfig();
    }

    private void actionConfig() {

        actions= new HashMap<>();

        actions.put(KeyboardEvent.KEY_UP, () -> pointer.move(Pointer.Direction.UP));
        actions.put(KeyboardEvent.KEY_DOWN, () -> pointer.move(Pointer.Direction.DOWN));
        actions.put(KeyboardEvent.KEY_LEFT, () ->pointer.move(Pointer.Direction.LEFT));
        actions.put(KeyboardEvent.KEY_RIGHT, () -> pointer.move(Pointer.Direction.RIGHT));
        actions.put(KeyboardEvent.KEY_S, () -> fileEditor.save());
        actions.put(KeyboardEvent.KEY_L, () -> fileEditor.load());
        actions.put(KeyboardEvent.KEY_SPACE, () -> {pointer.paint(); pointer.setPainting(true); });
        actions.put(KeyboardEvent.KEY_C, () -> map.clear());
        actions.put(KeyboardEvent.KEY_ESC, () -> System.exit(0));
    }



    private void addListener(Keyboard keyboard, int key, KeyboardEventType type) {

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    private enum Key {

        UP(KeyboardEvent.KEY_UP),
        DOWN(KeyboardEvent.KEY_DOWN),
        RIGHT(KeyboardEvent.KEY_RIGHT),
        LEFT(KeyboardEvent.KEY_LEFT),
        S(KeyboardEvent.KEY_S),
        L(KeyboardEvent.KEY_L),
        SPACE(KeyboardEvent.KEY_SPACE),
        SPACE_R(KeyboardEvent.KEY_SPACE,KeyboardEventType.KEY_RELEASED),
        ESC(KeyboardEvent.KEY_ESC),
        C(KeyboardEvent.KEY_C);

        public final int keyCode;
        public KeyboardEventType eventType = KeyboardEventType.KEY_PRESSED;

        Key(int keyCode) {
            this.keyCode = keyCode;
        }

        Key(int keyCode, KeyboardEventType eventType){
            this.keyCode = keyCode;
            this.eventType = eventType;
        }
    }

    private interface Action {

        void execute();
    }
}
