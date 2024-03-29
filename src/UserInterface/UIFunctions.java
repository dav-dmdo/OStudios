package UserInterface;

import Classes.AnimationStudio;
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

    public void reduceWorkersByType(AnimationStudio studio, int workerType) {
        if (studio.getStudioParams().getParamsByWorkerType(workerType).getQuantity() > 1) {
            studio.changeWorkerType(workerType, -1);
        } else {
            JOptionPane.showMessageDialog(null, "You have reached minimum capacity for " + studio.getStudioParams().getParamsByWorkerType(workerType).getTypeString() + "s");
        }
    }

    public void increaseWorkersByType(AnimationStudio studio, int workerType) {
        if (!studio.isFull()) {
            studio.changeWorkerType(-1, workerType);
        } else {
            JOptionPane.showMessageDialog(null, "You have reached maximum capacity");
        }
    }

    public void setInitialSettings(Config config, JSpinner screenwritersNick, JSpinner scenarioDesignersNick,
            JSpinner animatorsNick, JSpinner voiceActorsNick, JSpinner plotTwistWritersNick, JSpinner assemblersNick,
            JSpinner screenwritersCN, JSpinner scenarioDesignersCN, JSpinner animatorsCN, JSpinner voiceActorsCN,
            JSpinner plotTwistWritersCN, JSpinner assemblersCN, JTextPane dayDurationInput,
            JTextPane deliveryDaysInput) {

        loadFile(config);
        setSpinnersValues(0, config, screenwritersNick, scenarioDesignersNick, animatorsNick, voiceActorsNick,
                plotTwistWritersNick, assemblersNick);
        setSpinnersValues(1, config, screenwritersCN, scenarioDesignersCN, animatorsCN, voiceActorsCN,
                plotTwistWritersCN, assemblersCN);
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
    public String generateConfigString(String studioName, String configString, int screenwriters, int scenarioDesigners,
            int animators, int voiceActors, int plotTwistWriters, int assemblers) {
        configString += "\n" + studioName + "\nscreenwriters\n" + screenwriters + "\nscenario\n" + scenarioDesigners
                + "\nanimators\n" + animators + "\nvoice\n" + voiceActors + "\nplottwist\n" + plotTwistWriters
                + "\nassemblers\n" + assemblers + "\n";

        return configString;

    }

    public void setInputValues(JTextPane dayDurationInput, JTextPane deliveryDaysInput, Config config) {
        dayDurationInput.setText(Integer.toString(config.getDayDuration() / 1000));
        deliveryDaysInput.setText(Integer.toString(config.getDeliveryDays()));

    }

    public void setSpinnersValues(int studio, Config config, JSpinner screenwriters, JSpinner scenarioDesigners,
            JSpinner animators, JSpinner voiceActors, JSpinner plotTwistWriters, JSpinner assemblers) {

        switch (studio) {
            case 0 -> {
                screenwriters.setValue(config.getNickParameters().getScreenwritersParams().getQuantity());
                scenarioDesigners.setValue(config.getNickParameters().getScenarioDesignersParams().getQuantity());
                animators.setValue(config.getNickParameters().getAnimatorsParams().getQuantity());
                voiceActors.setValue(config.getNickParameters().getVoiceActorsParams().getQuantity());
                plotTwistWriters.setValue(config.getNickParameters().getPlotTwistsWritersParams().getQuantity());
                assemblers.setValue(config.getNickParameters().getAssemblersParams().getQuantity());

            }

            case 1 -> {
                screenwriters.setValue(config.getCNParameters().getScreenwritersParams().getQuantity());
                scenarioDesigners.setValue(config.getCNParameters().getScenarioDesignersParams().getQuantity());
                animators.setValue(config.getCNParameters().getAnimatorsParams().getQuantity());
                voiceActors.setValue(config.getCNParameters().getVoiceActorsParams().getQuantity());
                plotTwistWriters.setValue(config.getCNParameters().getPlotTwistsWritersParams().getQuantity());
                assemblers.setValue(config.getCNParameters().getAssemblersParams().getQuantity());
            }

            default -> {
            }

        }

    }
}
