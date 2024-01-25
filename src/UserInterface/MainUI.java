package UserInterface;

import Config.Config;
import Config.ReadFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando
 */
public class MainUI extends javax.swing.JFrame {

    private Config config;

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        super("Dashboard");

        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        UIFunctions window = new UIFunctions();

        Config newConfig = new Config();
        setConfig(newConfig);

        window.loadFile(getConfig());
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabs = new javax.swing.JTabbedPane();
        ConfigurationTab = new javax.swing.JPanel();
        Config_label = new javax.swing.JLabel();
        General_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dayDurationInput = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        deliveryDaysInput = new javax.swing.JTextPane();
        setConfiguration = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();
        dayDuration_label = new javax.swing.JLabel();
        deliveryDays_label = new javax.swing.JLabel();
        NickConfig_label = new javax.swing.JLabel();
        NickMaximumWorkers_label = new javax.swing.JLabel();
        CNConfig_label = new javax.swing.JLabel();
        CNMaximumWorkers_label = new javax.swing.JLabel();
        screenwriters_label = new javax.swing.JLabel();
        screenwritersNick = new javax.swing.JSpinner();
        scenarioDesigners_label = new javax.swing.JLabel();
        scenarioDesignersNick = new javax.swing.JSpinner();
        animators_label = new javax.swing.JLabel();
        animatorsNick = new javax.swing.JSpinner();
        voiceActors_label = new javax.swing.JLabel();
        voiceActorsNick = new javax.swing.JSpinner();
        plotTwistWriters_label = new javax.swing.JLabel();
        plotTwistWritersNick = new javax.swing.JSpinner();
        assemblers_label = new javax.swing.JLabel();
        assemblersNick = new javax.swing.JSpinner();
        screenwriters_label1 = new javax.swing.JLabel();
        scenarioDesigners_label1 = new javax.swing.JLabel();
        animators_label1 = new javax.swing.JLabel();
        voiceActors_label1 = new javax.swing.JLabel();
        plotTwistWriters_label1 = new javax.swing.JLabel();
        assemblers_label2 = new javax.swing.JLabel();
        screenwritersCN = new javax.swing.JSpinner();
        scenarioDesignersCN = new javax.swing.JSpinner();
        animatorsCN = new javax.swing.JSpinner();
        voiceActorsCN = new javax.swing.JSpinner();
        plotTwistWritersCN = new javax.swing.JSpinner();
        assemblersCN = new javax.swing.JSpinner();
        NickelodeonTab = new javax.swing.JPanel();
        Nickelodeon_label = new javax.swing.JLabel();
        CartoonNetworkTab = new javax.swing.JPanel();
        CN_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabs.setBackground(new java.awt.Color(102, 102, 102));
        Tabs.setForeground(new java.awt.Color(255, 255, 255));
        Tabs.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        ConfigurationTab.setBackground(new java.awt.Color(51, 51, 51));
        ConfigurationTab.setForeground(new java.awt.Color(255, 255, 255));
        ConfigurationTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Config_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        Config_label.setForeground(new java.awt.Color(255, 255, 153));
        Config_label.setText("CONFIGURATION");
        ConfigurationTab.add(Config_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 330, 60));

        General_label.setBackground(new java.awt.Color(102, 102, 102));
        General_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        General_label.setForeground(new java.awt.Color(255, 255, 255));
        General_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        General_label.setText("GENERAL");
        ConfigurationTab.add(General_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 140, 40));

        dayDurationInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        dayDurationInput.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(dayDurationInput);

        ConfigurationTab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, -1));

        deliveryDaysInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        deliveryDaysInput.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(deliveryDaysInput);

        ConfigurationTab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, -1));

        setConfiguration.setBackground(new java.awt.Color(255, 255, 153));
        setConfiguration.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        setConfiguration.setForeground(new java.awt.Color(51, 51, 51));
        setConfiguration.setText("SET CONFIGURATION");
        setConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setConfigurationActionPerformed(evt);
            }
        });
        ConfigurationTab.add(setConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 260, 50));

        infoLabel.setBackground(new java.awt.Color(102, 102, 102));
        infoLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 10)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 153));
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel.setText("You have to press the button to set the configuration");
        ConfigurationTab.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 280, 30));

        dayDuration_label.setBackground(new java.awt.Color(102, 102, 102));
        dayDuration_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        dayDuration_label.setForeground(new java.awt.Color(255, 255, 255));
        dayDuration_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayDuration_label.setText("Day Duration (seconds)");
        ConfigurationTab.add(dayDuration_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 170, 30));

        deliveryDays_label.setBackground(new java.awt.Color(102, 102, 102));
        deliveryDays_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        deliveryDays_label.setForeground(new java.awt.Color(255, 255, 255));
        deliveryDays_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deliveryDays_label.setText("Days to Deliver");
        ConfigurationTab.add(deliveryDays_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 110, 30));

        NickConfig_label.setBackground(new java.awt.Color(102, 102, 102));
        NickConfig_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        NickConfig_label.setForeground(new java.awt.Color(255, 255, 255));
        NickConfig_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NickConfig_label.setText("NICKELODEON");
        ConfigurationTab.add(NickConfig_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 210, 60));

        NickMaximumWorkers_label.setBackground(new java.awt.Color(102, 102, 102));
        NickMaximumWorkers_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        NickMaximumWorkers_label.setForeground(new java.awt.Color(255, 255, 153));
        NickMaximumWorkers_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NickMaximumWorkers_label.setText("MAXIMUM 20 WORKERS");
        ConfigurationTab.add(NickMaximumWorkers_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 180, 30));

        CNConfig_label.setBackground(new java.awt.Color(102, 102, 102));
        CNConfig_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        CNConfig_label.setForeground(new java.awt.Color(255, 255, 255));
        CNConfig_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CNConfig_label.setText("CARTOON NETWORK");
        ConfigurationTab.add(CNConfig_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 270, 60));

        CNMaximumWorkers_label.setBackground(new java.awt.Color(102, 102, 102));
        CNMaximumWorkers_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        CNMaximumWorkers_label.setForeground(new java.awt.Color(255, 255, 153));
        CNMaximumWorkers_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CNMaximumWorkers_label.setText("MAXIMUM 12 WORKERS");
        ConfigurationTab.add(CNMaximumWorkers_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 170, 30));

        screenwriters_label.setBackground(new java.awt.Color(102, 102, 102));
        screenwriters_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        screenwriters_label.setForeground(new java.awt.Color(255, 255, 255));
        screenwriters_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screenwriters_label.setText("Screenwriters");
        ConfigurationTab.add(screenwriters_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 90, 30));

        screenwritersNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        screenwritersNick.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        ConfigurationTab.add(screenwritersNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, 30));

        scenarioDesigners_label.setBackground(new java.awt.Color(102, 102, 102));
        scenarioDesigners_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        scenarioDesigners_label.setForeground(new java.awt.Color(255, 255, 255));
        scenarioDesigners_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scenarioDesigners_label.setText("Scenario Designers");
        ConfigurationTab.add(scenarioDesigners_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 120, 30));

        scenarioDesignersNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        scenarioDesignersNick.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        ConfigurationTab.add(scenarioDesignersNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, 30));

        animators_label.setBackground(new java.awt.Color(102, 102, 102));
        animators_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        animators_label.setForeground(new java.awt.Color(255, 255, 255));
        animators_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animators_label.setText("Character Animators");
        ConfigurationTab.add(animators_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 130, 30));

        animatorsNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        animatorsNick.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        ConfigurationTab.add(animatorsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, 30));

        voiceActors_label.setBackground(new java.awt.Color(102, 102, 102));
        voiceActors_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        voiceActors_label.setForeground(new java.awt.Color(255, 255, 255));
        voiceActors_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        voiceActors_label.setText("Voice Actors");
        ConfigurationTab.add(voiceActors_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 80, 30));

        voiceActorsNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        voiceActorsNick.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        ConfigurationTab.add(voiceActorsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, 30));

        plotTwistWriters_label.setBackground(new java.awt.Color(102, 102, 102));
        plotTwistWriters_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        plotTwistWriters_label.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistWriters_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plotTwistWriters_label.setText("PlotTwist Writers");
        ConfigurationTab.add(plotTwistWriters_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 110, 30));

        plotTwistWritersNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        plotTwistWritersNick.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        ConfigurationTab.add(plotTwistWritersNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, 30));

        assemblers_label.setBackground(new java.awt.Color(102, 102, 102));
        assemblers_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        assemblers_label.setForeground(new java.awt.Color(255, 255, 255));
        assemblers_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblers_label.setText("Assemblers");
        ConfigurationTab.add(assemblers_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 80, 30));

        assemblersNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        assemblersNick.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        ConfigurationTab.add(assemblersNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, -1, 30));

        screenwriters_label1.setBackground(new java.awt.Color(102, 102, 102));
        screenwriters_label1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        screenwriters_label1.setForeground(new java.awt.Color(255, 255, 255));
        screenwriters_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screenwriters_label1.setText("Screenwriters");
        ConfigurationTab.add(screenwriters_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 90, 30));

        scenarioDesigners_label1.setBackground(new java.awt.Color(102, 102, 102));
        scenarioDesigners_label1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        scenarioDesigners_label1.setForeground(new java.awt.Color(255, 255, 255));
        scenarioDesigners_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scenarioDesigners_label1.setText("Scenario Designers");
        ConfigurationTab.add(scenarioDesigners_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 120, 30));

        animators_label1.setBackground(new java.awt.Color(102, 102, 102));
        animators_label1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        animators_label1.setForeground(new java.awt.Color(255, 255, 255));
        animators_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        animators_label1.setText("Character Animators");
        ConfigurationTab.add(animators_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 130, 30));

        voiceActors_label1.setBackground(new java.awt.Color(102, 102, 102));
        voiceActors_label1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        voiceActors_label1.setForeground(new java.awt.Color(255, 255, 255));
        voiceActors_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        voiceActors_label1.setText("Voice Actors");
        ConfigurationTab.add(voiceActors_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 80, 30));

        plotTwistWriters_label1.setBackground(new java.awt.Color(102, 102, 102));
        plotTwistWriters_label1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        plotTwistWriters_label1.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistWriters_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plotTwistWriters_label1.setText("PlotTwist Writers");
        ConfigurationTab.add(plotTwistWriters_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 110, 30));

        assemblers_label2.setBackground(new java.awt.Color(102, 102, 102));
        assemblers_label2.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        assemblers_label2.setForeground(new java.awt.Color(255, 255, 255));
        assemblers_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assemblers_label2.setText("Assemblers");
        ConfigurationTab.add(assemblers_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 70, 30));

        screenwritersCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        screenwritersCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        ConfigurationTab.add(screenwritersCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, -1, 30));

        scenarioDesignersCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        scenarioDesignersCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        ConfigurationTab.add(scenarioDesignersCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, -1, 30));

        animatorsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        animatorsCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        ConfigurationTab.add(animatorsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, -1, 30));

        voiceActorsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        voiceActorsCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        ConfigurationTab.add(voiceActorsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, 30));

        plotTwistWritersCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        plotTwistWritersCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        ConfigurationTab.add(plotTwistWritersCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, -1, 30));

        assemblersCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        assemblersCN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        ConfigurationTab.add(assemblersCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, -1, 30));

        Tabs.addTab("Configuration", ConfigurationTab);

        NickelodeonTab.setBackground(new java.awt.Color(51, 51, 51));
        NickelodeonTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nickelodeon_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        Nickelodeon_label.setForeground(new java.awt.Color(255, 255, 153));
        Nickelodeon_label.setText("NICKELODEON");
        NickelodeonTab.add(Nickelodeon_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 290, 60));

        Tabs.addTab("Nickelodeon", NickelodeonTab);

        CartoonNetworkTab.setBackground(new java.awt.Color(51, 51, 51));
        CartoonNetworkTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        CN_label.setForeground(new java.awt.Color(255, 255, 153));
        CN_label.setText("CARTOON NETWORK");
        CartoonNetworkTab.add(CN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 410, 60));

        Tabs.addTab("Cartoon Network", CartoonNetworkTab);

        getContentPane().add(Tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setConfigurationActionPerformed
        String configString = "General\ndayDuration\n";

        try {
            int dayDuration = Integer.parseInt(dayDurationInput.getText()) * 1000;
            int deliveryDays = Integer.parseInt(deliveryDaysInput.getText());

            configString += Integer.toString(dayDuration) + "\ndeliveryDays\n" + Integer.toString(deliveryDays) + "\n";

            //Nickelodeon workers
            Integer screenwritersNickelodeon = (Integer) screenwritersNick.getValue();
            Integer scenarioNickelodeon = (Integer) scenarioDesignersNick.getValue();
            Integer animatorsNickelodeon = (Integer) animatorsNick.getValue();
            Integer voiceActorsNickelodeon = (Integer) voiceActorsNick.getValue();
            Integer plotTwistWritersNickelodeon = (Integer) plotTwistWritersNick.getValue();
            Integer assemblersNickelodeon = (Integer) assemblersNick.getValue();

            int totalWorkersNick = screenwritersNickelodeon + scenarioNickelodeon + animatorsNickelodeon + voiceActorsNickelodeon + plotTwistWritersNickelodeon + assemblersNickelodeon;

            //Cartoon Network Workers
            Integer screenwritersCartoonNetwork = (Integer) screenwritersCN.getValue();
            Integer scenarioCartoonNetwork = (Integer) scenarioDesignersCN.getValue();
            Integer animatorsCartoonNetwork = (Integer) animatorsCN.getValue();
            Integer voiceActorsCartoonNetwork = (Integer) voiceActorsCN.getValue();
            Integer plotTwistWritersCartoonNetwork = (Integer) plotTwistWritersCN.getValue();
            Integer assemblersCartoonNetwork = (Integer) assemblersCN.getValue();

            int totalWorkersCN = screenwritersCartoonNetwork + scenarioCartoonNetwork + animatorsCartoonNetwork + voiceActorsCartoonNetwork + plotTwistWritersCartoonNetwork + assemblersCartoonNetwork;

            if ((totalWorkersNick > 20) || (totalWorkersCN > 12)) {
                throw new Exception();
            }

            ReadFile file = new ReadFile();
            file.printTxt(configString);

            String newConfig = file.readTxt();
            System.out.println(newConfig);
            file.readConfig(newConfig, config);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You have to enter a number");
        }

    }//GEN-LAST:event_setConfigurationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNConfig_label;
    private javax.swing.JLabel CNMaximumWorkers_label;
    private javax.swing.JLabel CN_label;
    private javax.swing.JPanel CartoonNetworkTab;
    private javax.swing.JLabel Config_label;
    private javax.swing.JPanel ConfigurationTab;
    private javax.swing.JLabel General_label;
    private javax.swing.JLabel NickConfig_label;
    private javax.swing.JLabel NickMaximumWorkers_label;
    private javax.swing.JPanel NickelodeonTab;
    private javax.swing.JLabel Nickelodeon_label;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JSpinner animatorsCN;
    private javax.swing.JSpinner animatorsNick;
    private javax.swing.JLabel animators_label;
    private javax.swing.JLabel animators_label1;
    private javax.swing.JSpinner assemblersCN;
    private javax.swing.JSpinner assemblersNick;
    private javax.swing.JLabel assemblers_label;
    private javax.swing.JLabel assemblers_label2;
    private javax.swing.JTextPane dayDurationInput;
    private javax.swing.JLabel dayDuration_label;
    private javax.swing.JTextPane deliveryDaysInput;
    private javax.swing.JLabel deliveryDays_label;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner plotTwistWritersCN;
    private javax.swing.JSpinner plotTwistWritersNick;
    private javax.swing.JLabel plotTwistWriters_label;
    private javax.swing.JLabel plotTwistWriters_label1;
    private javax.swing.JSpinner scenarioDesignersCN;
    private javax.swing.JSpinner scenarioDesignersNick;
    private javax.swing.JLabel scenarioDesigners_label;
    private javax.swing.JLabel scenarioDesigners_label1;
    private javax.swing.JSpinner screenwritersCN;
    private javax.swing.JSpinner screenwritersNick;
    private javax.swing.JLabel screenwriters_label;
    private javax.swing.JLabel screenwriters_label1;
    private javax.swing.JButton setConfiguration;
    private javax.swing.JSpinner voiceActorsCN;
    private javax.swing.JSpinner voiceActorsNick;
    private javax.swing.JLabel voiceActors_label;
    private javax.swing.JLabel voiceActors_label1;
    // End of variables declaration//GEN-END:variables
}
