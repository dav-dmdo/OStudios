package UserInterface;

import Config.Config;
import Config.ReadFile;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;

/**
 *
 * @author Rolando
 */
public class UIFunctions {

    public void setInitialSettings(Config config, JSpinner screenwritersNick, JSpinner scenarioDesignersNick, JSpinner animatorsNick, JSpinner voiceActorsNick, JSpinner plotTwistWritersNick, JSpinner assemblersNick, JSpinner screenwritersCN, JSpinner scenarioDesignersCN, JSpinner animatorsCN, JSpinner voiceActorsCN, JSpinner plotTwistWritersCN, JSpinner assemblersCN, JTextPane dayDurationInput, JTextPane deliveryDaysInput) {

        loadFile(config);
        setSpinnersValues(0, config, screenwritersNick, scenarioDesignersNick, animatorsNick, voiceActorsNick, plotTwistWritersNick, assemblersNick);
        setSpinnersValues(1, config, screenwritersCN, scenarioDesignersCN, animatorsCN, voiceActorsCN, plotTwistWritersCN, assemblersCN);
        setInputValues(dayDurationInput, deliveryDaysInput, config);
    }

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

    /**
     * Generates the portion of config String for each Studio that will be
     * printed before in the text file
     *
     */
    public String generateConfigString(String studioName, String configString, int screenwriters, int scenarioDesigners, int animators, int voiceActors, int plotTwistWriters, int assemblers) {
        configString += "\n" + studioName + "\nscreenwriters\n" + screenwriters + "\nscenario\n" + scenarioDesigners + "\nanimators\n" + animators + "\nvoice\n" + voiceActors + "\nplottwist\n" + plotTwistWriters + "\nassemblers\n" + assemblers + "\n";

        return configString;

    }

    public void setInputValues(JTextPane dayDurationInput, JTextPane deliveryDaysInput, Config config) {
        dayDurationInput.setText(Integer.toString(config.getDayDuration() / 1000));
        deliveryDaysInput.setText(Integer.toString(config.getDeliveryDays()));

    }

    public void setSpinnersValues(int studio, Config config, JSpinner screenwriters, JSpinner scenarioDesigners, JSpinner animators, JSpinner voiceActors, JSpinner plotTwistWriters, JSpinner assemblers) {

        switch (studio) {
            case 0 -> {
                screenwriters.setValue(config.getNickParameters().getScreenwriters());
                scenarioDesigners.setValue(config.getNickParameters().getScenarioDesigners());
                animators.setValue(config.getNickParameters().getAnimators());
                voiceActors.setValue(config.getNickParameters().getVoiceActors());
                plotTwistWriters.setValue(config.getNickParameters().getPlotTwistWriters());
                assemblers.setValue(config.getNickParameters().getAssemblers());

            }

            case 1 -> {
                screenwriters.setValue(config.getCNParameters().getScreenwriters());
                scenarioDesigners.setValue(config.getCNParameters().getScenarioDesigners());
                animators.setValue(config.getCNParameters().getAnimators());
                voiceActors.setValue(config.getCNParameters().getVoiceActors());
                plotTwistWriters.setValue(config.getCNParameters().getPlotTwistWriters());
                assemblers.setValue(config.getCNParameters().getAssemblers());
            }

            default -> {
            }

        }

    }
}
