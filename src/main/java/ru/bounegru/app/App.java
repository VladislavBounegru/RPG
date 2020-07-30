package ru.bounegru.app;

import ru.bounegru.ui.GameMainFrame;

import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            new GameMainFrame();
        });
    }
}
