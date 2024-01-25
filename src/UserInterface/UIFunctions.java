package UserInterface;

import Config.Config;
import Config.ReadFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando
 */
public class UIFunctions {

    public void loadFile(Config config) {
        try {
            ReadFile fileToRead = new ReadFile();
            String txt = fileToRead.readTxt();
            fileToRead.readConfig(txt, config);
            JOptionPane.showMessageDialog(null, "Config loaded succesfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred: " + e);
        }
    }

    public void generateConfigString(String studio, String configString, int screenwriters, int scenarioDesigners, int animators, int voiceActors, int plotTwistWriters, int assemblers) {
//        configString += "\n" + studio + "\nchasis\n" + ;

    }
}
