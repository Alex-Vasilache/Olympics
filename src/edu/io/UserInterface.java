package edu.io;

import edu.kit.informatik.Terminal;
import edu.logic.Splitter;
import edu.objects.ArchiveSystem;

public class UserInterface {

    /**
     * 
     * @param args
     *            Not used throughout the program
     */
    public static void main(String[] args) {

        while (ArchiveSystem.isEnd() == false) {
            Splitter.split(Terminal.readLine());
        }
    }
}
