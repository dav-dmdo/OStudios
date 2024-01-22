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
            ReadFile nfile = new ReadFile();
            String txt = nfile.readTxt();
//            nfile.readConfig(txt, config);
            JOptionPane.showMessageDialog(null, "Config loaded succesfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
