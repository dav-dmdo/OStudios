package Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando
 */
public class ReadFile {

    /**
     * Overwrite the text file inside the project
     *
     * @param txt (String containing the information of the read text file)
     * read)
     */
    public void printTxt(String txt) {
        try {
            File file = new File("test\\config.txt");
            PrintWriter pw = new PrintWriter(file);
            pw.print(txt);
            JOptionPane.showMessageDialog(null, "The configuration has changed!");
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has ocurred: " + e);
        }
    }

    /**
     * Adds information to the project text file
     *
     * @param txt
     */
    public void appendTxt(String txt) {
        try {
            File file = new File("test\\config.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.append(txt);
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has ocurred: " + e);
        }
    }

    /**
     * Reads a text file line by line and converts it to a string
     *
     * @return String containing the information of the text file
     */
    public String readTxt() {
        String line;
        String txt = "";
        File file = new File("test\\config.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();

            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        if (line.contains("General") || line.contains("Nickelodeon") || line.contains("CartoonNetwork")) {
                            txt += "~\n";

                        } else {
                            txt += line + "\n";
                        }
                    }

                }
                br.close();

                return txt;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred reading the file: " + e);
        }
        return null;
    }

    public void setStudioConfig(String[] studioParameters, Config config, int studio) {

        switch (studio) {
            case 0 -> {
                config.getNickParameters().setInitialScreenwriters(Integer.parseInt(studioParameters[2]));
                config.getNickParameters().setInitialScenarioDesigners(Integer.parseInt(studioParameters[4]));
                config.getNickParameters().setInitialAnimators(Integer.parseInt(studioParameters[6]));
                config.getNickParameters().setInitialVoiceActors(Integer.parseInt(studioParameters[8]));
                config.getNickParameters().setInitialPlotTwistWriters(Integer.parseInt(studioParameters[10]));
                config.getNickParameters().setInitialAssemblers(Integer.parseInt(studioParameters[12]));
            }

            case 1 -> {
                config.getCNParameters().setInitialScreenwriters(Integer.parseInt(studioParameters[2]));
                config.getCNParameters().setInitialScenarioDesigners(Integer.parseInt(studioParameters[4]));
                config.getCNParameters().setInitialAnimators(Integer.parseInt(studioParameters[6]));
                config.getCNParameters().setInitialVoiceActors(Integer.parseInt(studioParameters[8]));
                config.getCNParameters().setInitialPlotTwistWriters(Integer.parseInt(studioParameters[10]));
                config.getCNParameters().setInitialAssemblers(Integer.parseInt(studioParameters[12]));
            }

            default -> {
            }

        }

    }

    public void readConfig(String txt, Config config) {

        String[] configs = txt.split("~");
        String[] general = configs[1].split("\n");

        //General config
        config.setDayDuration(Integer.parseInt(general[2]));
        config.setDeliveryDays(Integer.parseInt(general[4]));

        //Nickelodeon config
        String[] nickParameters = configs[2].split("\n");
        setStudioConfig(nickParameters, config, 0);

        //Cartoon Network config
        String[] cnParameters = configs[3].split("\n");
        setStudioConfig(cnParameters, config, 1);

    }
}
