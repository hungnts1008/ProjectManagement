package source.main;

import java.awt.Frame;
import java.io.File;

import source.view.FrameLogIn;
import source.database.FileDB;
import source.model.Staff;

public class Main {
    public static void main(String[] args) {
        FrameLogIn frameLogIn = new FrameLogIn();
        frameLogIn.setVisible(true);
    }
}
