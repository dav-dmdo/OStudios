package UserInterface;

import Classes.AnimationStudio;
import Config.Config;
import Config.ReadFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando
 */
public class MainUI extends javax.swing.JFrame {

    private Config config = new Config();
    private UIFunctions functions = new UIFunctions();
    private AnimationStudio Nickelodeon;
    private AnimationStudio CartoonNetwork;

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        super("Dashboard");

        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        getFunctions().setInitialSettings(config, screenwritersNick, scenarioDesignersNick, animatorsNick,
                voiceActorsNick, plotTwistWritersNick, assemblersNick, screenwritersCN, scenarioDesignersCN,
                animatorsCN, voiceActorsCN, plotTwistWritersCN, assemblersCN, dayDurationInput, deliveryDaysInput);

        this.Nickelodeon = new AnimationStudio(0, "Nickelodeon", 20, getConfig().getNickParameters(), getConfig().getDayDuration(), this, getConfig().getDeliveryDays());
        this.CartoonNetwork = new AnimationStudio(1, "CartoonNetwork", 20, getConfig().getCNParameters(), getConfig().getDayDuration(), this, getConfig().getDeliveryDays());

        setInitialUIDaysLeft();
    }

    public void setInitialUIDaysLeft() {
        changeDaysLeftCounter(0, Integer.toString(getConfig().getDeliveryDays()));
        changeDaysLeftCounter(1, Integer.toString(getConfig().getDeliveryDays()));
    }

    public void changeDirectorStatusText(int studioInt, String directorStatus) {
        switch (studioInt) {
            case 0 ->
                directorStatusNick.setText(directorStatus);
            case 1 ->
                directorStatusCN.setText(directorStatus);
            default -> {
            }
        }
    }

    public void changeManagerFaultsQtyText(int studioInt, String faultsQty) {
        switch (studioInt) {
            case 0 ->
                faultsQtyNickelodeon.setText(faultsQty);
            case 1 ->
                faultsQtyCartoonN.setText(faultsQty);
            default -> {
            }
        }
    }
    
    public void changeChapterQuantity(int studioInt, int chapterType, int chapterQuantity){
        
        
        if(studioInt==0){
            
            switch (chapterType){
                
                case 0 ->{
                    
                    this.standarEpisodesNick.setText(Integer.toString(chapterQuantity));
                    
                }
                
                case 1 ->{
                    
                    this.plotTwistEpisodesNick.setText(Integer.toString(chapterQuantity));
                    
                }
                
            }
            
        }
        else
        {
            
            switch (chapterType){
                
                case 0 ->{
                    
                    this.standarEpisodesCN.setText(Integer.toString(chapterQuantity));
                    
                }
                
                case 1 ->{
                    
                    this.plotTwistEpisodesCN.setText(Integer.toString(chapterQuantity));
                    
                }
                
            }
            
        }
        
        
    }

    public void changeDriveElements(int studioInt, int workerType, int[] chapterElements) {

        if (studioInt == 0) {
            switch (workerType) {
                case 0 -> {
                    NickelodeonScripts.setText(Integer.toString(chapterElements[workerType]));
                }
                case 1 -> {
                    NickelodeonScenarios.setText(Integer.toString(chapterElements[workerType]));
                }
                case 2 -> {
                    NickelodeonAnimations.setText(Integer.toString(chapterElements[workerType]));
                }
                case 3 -> {
                    NickelodeonDubbings.setText(Integer.toString(chapterElements[workerType]));
                }
                case 4 -> {
                    NickelodeonPlotTwists.setText(Integer.toString(chapterElements[workerType]));
                }
                case 5 -> {
                    NickelodeonScripts.setText(Integer.toString(chapterElements[0]));
                    NickelodeonScenarios.setText(Integer.toString(chapterElements[1]));
                    NickelodeonAnimations.setText(Integer.toString(chapterElements[2]));
                    NickelodeonDubbings.setText(Integer.toString(chapterElements[3]));
                    NickelodeonPlotTwists.setText(Integer.toString(chapterElements[4]));

                }

                default -> {
                }
            }
        } else {
            switch (workerType) {
                case 0 -> {
                    CartoonScripts.setText(Integer.toString(chapterElements[workerType]));
                }
                case 1 -> {
                    CartoonNScenarios.setText(Integer.toString(chapterElements[workerType]));
                }
                case 2 -> {
                    CartoonNAnimations.setText(Integer.toString(chapterElements[workerType]));
                }
                case 3 -> {
                    CartoonNDubbings.setText(Integer.toString(chapterElements[workerType]));
                }
                case 4 -> {
                    CartoonNPlotTwists.setText(Integer.toString(chapterElements[workerType]));
                }
                case 5 -> {
                    CartoonScripts.setText(Integer.toString(chapterElements[0]));
                    CartoonNScenarios.setText(Integer.toString(chapterElements[1]));
                    CartoonNAnimations.setText(Integer.toString(chapterElements[2]));
                    CartoonNDubbings.setText(Integer.toString(chapterElements[3]));
                    CartoonNPlotTwists.setText(Integer.toString(chapterElements[4]));

                }

                default -> {
                }
            }
        }
    }

    public void changeManagerDiscountedText(int studioInt, String discountedSalary) {
        switch (studioInt) {
            case 0 ->
                managerSalaryDiscountNickelodeon.setText(discountedSalary);
            case 1 ->
                managerSalaryDiscountCN.setText(discountedSalary);
            default -> {
            }
        }
    }

    public void changeManagerTextStatus(int studioInt, String status) {
        if (studioInt == 0) {
            managerStatusNickelodeon.setText(status);
        } else {
            managerStatusCartoonN.setText(status);
        }
    }

    public void changeDaysLeftCounter(int studioInt, String daysLeft) {
        if (studioInt == 0) {
            daysLeftNick.setText(daysLeft);
        } else {
            daysLeftCartoonNetwork.setText(daysLeft);
        }
    }

    // Getters and Setters
    public final Config getConfig() {
        return config;
    }

    public final void setConfig(Config config) {
        this.config = config;
    }

    public final UIFunctions getFunctions() {
        return functions;
    }

    public void setFunctions(UIFunctions functions) {
        this.functions = functions;
    }

    public AnimationStudio getNickelodeon() {
        return Nickelodeon;
    }

    public void setNickelodeon(AnimationStudio Nickelodeon) {
        this.Nickelodeon = Nickelodeon;
    }

    public AnimationStudio getCartoonNetwork() {
        return CartoonNetwork;
    }

    public void setCartoonNetwork(AnimationStudio CartoonNetwork) {
        this.CartoonNetwork = CartoonNetwork;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        animationsN_label = new javax.swing.JLabel();
        NickelodeonAnimations = new javax.swing.JLabel();
        maxAnimationsN = new javax.swing.JLabel();
        maxScenariosN = new javax.swing.JLabel();
        scenariosN_label = new javax.swing.JLabel();
        NickelodeonScenarios = new javax.swing.JLabel();
        maxScriptsN = new javax.swing.JLabel();
        NickelodeonScripts = new javax.swing.JLabel();
        scriptsN_label = new javax.swing.JLabel();
        episodePartsNick_title = new javax.swing.JLabel();
        dubsN_label = new javax.swing.JLabel();
        NickelodeonDubbings = new javax.swing.JLabel();
        maxDubbingsN = new javax.swing.JLabel();
        plotTwistsN_label = new javax.swing.JLabel();
        NickelodeonPlotTwists = new javax.swing.JLabel();
        maxPlotTwistsN = new javax.swing.JLabel();
        directorNick_title = new javax.swing.JLabel();
        directorStatusNick_label = new javax.swing.JLabel();
        directorStatusNick = new javax.swing.JLabel();
        projectManagerNick_title = new javax.swing.JLabel();
        managerStatusNickelodeon = new javax.swing.JLabel();
        managerStatusN_label = new javax.swing.JLabel();
        managerFaultsN_label = new javax.swing.JLabel();
        faultsQtyNickelodeon = new javax.swing.JLabel();
        managerDiscounted_label = new javax.swing.JLabel();
        managerSalaryDiscountNickelodeon = new javax.swing.JLabel();
        plotTwistEpisodesN_label = new javax.swing.JLabel();
        standardEpisodesN_label = new javax.swing.JLabel();
        plotTwistEpisodesNick = new javax.swing.JLabel();
        standarEpisodesNick = new javax.swing.JLabel();
        episodesProducedNick_title = new javax.swing.JLabel();
        daysLeftNick_label = new javax.swing.JLabel();
        daysLeftNick = new javax.swing.JLabel();
        earningsNick = new javax.swing.JLabel();
        earningsNick_label = new javax.swing.JLabel();
        costsNick_label = new javax.swing.JLabel();
        costsNick = new javax.swing.JLabel();
        utilityNick = new javax.swing.JLabel();
        utilityNick_label = new javax.swing.JFormattedTextField();
        scenarioDesignersNickelodeon = new javax.swing.JLabel();
        chas13 = new javax.swing.JLabel();
        chas14 = new javax.swing.JLabel();
        voiceActorsNickelodeon = new javax.swing.JLabel();
        chas15 = new javax.swing.JLabel();
        plotTwistWritersNickelodeon = new javax.swing.JLabel();
        screenwritersNickelodeon = new javax.swing.JLabel();
        chas16 = new javax.swing.JLabel();
        assemblersNickelodeon = new javax.swing.JLabel();
        wm_label5 = new javax.swing.JLabel();
        chas17 = new javax.swing.JLabel();
        chas18 = new javax.swing.JLabel();
        animatorsNickelodeon = new javax.swing.JLabel();
        screenwritersPlusNick = new javax.swing.JButton();
        scenarioDesignersPlusNick = new javax.swing.JButton();
        animatorsPlusNick = new javax.swing.JButton();
        screenwritersMinNick = new javax.swing.JButton();
        scenarioDesignersMinNick = new javax.swing.JButton();
        animatorsMinNick = new javax.swing.JButton();
        voiceActorsPlusNick = new javax.swing.JButton();
        voiceActorsMinNick = new javax.swing.JButton();
        plotTwistWritersMinNick = new javax.swing.JButton();
        plotTwistWritersPlusNick = new javax.swing.JButton();
        assemblersMinNick = new javax.swing.JButton();
        assemblerPlusNick = new javax.swing.JButton();
        startSimulation = new javax.swing.JButton();
        CartoonNetworkTab = new javax.swing.JPanel();
        CN_label = new javax.swing.JLabel();
        episodePartsCN_title = new javax.swing.JLabel();
        scriptsCN_label = new javax.swing.JLabel();
        CartoonScripts = new javax.swing.JLabel();
        maxScriptsCN = new javax.swing.JLabel();
        scenariosCN_label = new javax.swing.JLabel();
        CartoonNScenarios = new javax.swing.JLabel();
        maxScenariosCN = new javax.swing.JLabel();
        animationsCN_label = new javax.swing.JLabel();
        CartoonNAnimations = new javax.swing.JLabel();
        maxAnimationsCN = new javax.swing.JLabel();
        dubsCN_label = new javax.swing.JLabel();
        CartoonNDubbings = new javax.swing.JLabel();
        maxDubbingsCN = new javax.swing.JLabel();
        plotTwistsCN_label = new javax.swing.JLabel();
        CartoonNPlotTwists = new javax.swing.JLabel();
        maxPlotTwistsCN = new javax.swing.JLabel();
        directorCN_title = new javax.swing.JLabel();
        directorStatusCN_label = new javax.swing.JLabel();
        directorStatusCN = new javax.swing.JLabel();
        projectManagerCN_title = new javax.swing.JLabel();
        managerStatusCartoonN = new javax.swing.JLabel();
        managerStatusCN_label = new javax.swing.JLabel();
        managerFaultsCN_label = new javax.swing.JLabel();
        faultsQtyCartoonN = new javax.swing.JLabel();
        managerDiscountedCN_label = new javax.swing.JLabel();
        managerSalaryDiscountCN = new javax.swing.JLabel();
        plotTwistEpisodesCN_label = new javax.swing.JLabel();
        standardEpisodesCN_label = new javax.swing.JLabel();
        plotTwistEpisodesCN = new javax.swing.JLabel();
        standarEpisodesCN = new javax.swing.JLabel();
        episodesProducedCN_title = new javax.swing.JLabel();
        DaysLeftCartoonNetwork = new javax.swing.JLabel();
        daysLeftCartoonNetwork = new javax.swing.JLabel();
        earningsCN = new javax.swing.JLabel();
        costsCN = new javax.swing.JLabel();
        utilityCN = new javax.swing.JLabel();
        utilityCN_label = new javax.swing.JFormattedTextField();
        qtyScenarioDesignersCartoonN = new javax.swing.JLabel();
        animatorsCN_Label = new javax.swing.JLabel();
        voiceActorsCN_Label = new javax.swing.JLabel();
        qtyVoiceActorsCN_label = new javax.swing.JLabel();
        plottwistWriters_Label = new javax.swing.JLabel();
        qtyPlotTwistWritersCN_Label = new javax.swing.JLabel();
        qtyScreenwritersCN_Label = new javax.swing.JLabel();
        assemblersCN_Label = new javax.swing.JLabel();
        qtyAssemblersCN_Label = new javax.swing.JLabel();
        wm_label6 = new javax.swing.JLabel();
        screenWritersCN_Label = new javax.swing.JLabel();
        scenarioDesignersCN_Label = new javax.swing.JLabel();
        qtyAnimatorsCN_Label = new javax.swing.JLabel();
        screenwritersPlusCN = new javax.swing.JButton();
        screenwritersMinCN = new javax.swing.JButton();
        scenarioDesignersPlusCN = new javax.swing.JButton();
        animatorsPlusCN = new javax.swing.JButton();
        scenarioDesignersMinCN = new javax.swing.JButton();
        animatorsMinCN = new javax.swing.JButton();
        voiceActorsPlusCN = new javax.swing.JButton();
        voiceActorsMinCN = new javax.swing.JButton();
        plotTwistWritersMinCN = new javax.swing.JButton();
        plotTwistWritersPlusCN = new javax.swing.JButton();
        assemblersMinCN = new javax.swing.JButton();
        assemblerPlusCN = new javax.swing.JButton();
        earningsCN_label = new javax.swing.JLabel();
        costsCN_label = new javax.swing.JLabel();
        CN_label1 = new javax.swing.JLabel();

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
        dayDurationInput.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(dayDurationInput);

        ConfigurationTab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, -1));

        deliveryDaysInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        deliveryDaysInput.setForeground(new java.awt.Color(0, 0, 0));
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

        animationsN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animationsN_label.setForeground(new java.awt.Color(255, 255, 255));
        animationsN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        animationsN_label.setText("Animations:");
        NickelodeonTab.add(animationsN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, 40));

        NickelodeonAnimations.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        NickelodeonAnimations.setForeground(new java.awt.Color(255, 255, 255));
        NickelodeonAnimations.setText("0");
        NickelodeonTab.add(NickelodeonAnimations, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 40, 40));

        maxAnimationsN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxAnimationsN.setForeground(new java.awt.Color(255, 255, 255));
        maxAnimationsN.setText("/ 55");
        NickelodeonTab.add(maxAnimationsN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 40, 40));

        maxScenariosN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxScenariosN.setForeground(new java.awt.Color(255, 255, 255));
        maxScenariosN.setText("/ 20");
        NickelodeonTab.add(maxScenariosN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 40, 40));

        scenariosN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenariosN_label.setForeground(new java.awt.Color(255, 255, 255));
        scenariosN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scenariosN_label.setText("Scenarios:");
        NickelodeonTab.add(scenariosN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 110, 40));

        NickelodeonScenarios.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        NickelodeonScenarios.setForeground(new java.awt.Color(255, 255, 255));
        NickelodeonScenarios.setText("0");
        NickelodeonTab.add(NickelodeonScenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 40, 40));

        maxScriptsN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxScriptsN.setForeground(new java.awt.Color(255, 255, 255));
        maxScriptsN.setText("/ 25");
        NickelodeonTab.add(maxScriptsN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 40, 40));

        NickelodeonScripts.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        NickelodeonScripts.setForeground(new java.awt.Color(255, 255, 255));
        NickelodeonScripts.setText("0");
        NickelodeonTab.add(NickelodeonScripts, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 40, 40));

        scriptsN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scriptsN_label.setForeground(new java.awt.Color(255, 255, 255));
        scriptsN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scriptsN_label.setText("Scripts:");
        NickelodeonTab.add(scriptsN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 70, 40));

        episodePartsNick_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        episodePartsNick_title.setForeground(new java.awt.Color(255, 255, 153));
        episodePartsNick_title.setText("EPISODE PARTS");
        NickelodeonTab.add(episodePartsNick_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, 40));

        dubsN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        dubsN_label.setForeground(new java.awt.Color(255, 255, 255));
        dubsN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dubsN_label.setText("Dubbings:");
        NickelodeonTab.add(dubsN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 40));

        NickelodeonDubbings.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        NickelodeonDubbings.setForeground(new java.awt.Color(255, 255, 255));
        NickelodeonDubbings.setText("0");
        NickelodeonTab.add(NickelodeonDubbings, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 40, 40));

        maxDubbingsN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxDubbingsN.setForeground(new java.awt.Color(255, 255, 255));
        maxDubbingsN.setText("/ 35");
        NickelodeonTab.add(maxDubbingsN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 40, 40));

        plotTwistsN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistsN_label.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistsN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plotTwistsN_label.setText("PlotTwists:");
        NickelodeonTab.add(plotTwistsN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 110, 40));

        NickelodeonPlotTwists.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        NickelodeonPlotTwists.setForeground(new java.awt.Color(255, 255, 255));
        NickelodeonPlotTwists.setText("0");
        NickelodeonTab.add(NickelodeonPlotTwists, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 40, 40));

        maxPlotTwistsN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxPlotTwistsN.setForeground(new java.awt.Color(255, 255, 255));
        maxPlotTwistsN.setText("/ 10");
        NickelodeonTab.add(maxPlotTwistsN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 40, 40));

        directorNick_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        directorNick_title.setForeground(new java.awt.Color(255, 255, 153));
        directorNick_title.setText("DIRECTOR");
        NickelodeonTab.add(directorNick_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 140, 40));

        directorStatusNick_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        directorStatusNick_label.setForeground(new java.awt.Color(255, 255, 255));
        directorStatusNick_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        directorStatusNick_label.setText("Status:");
        NickelodeonTab.add(directorStatusNick_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 100, 40));

        directorStatusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        directorStatusNick.setForeground(new java.awt.Color(255, 255, 255));
        directorStatusNick.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        directorStatusNick.setText("Working");
        NickelodeonTab.add(directorStatusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 210, 40));

        projectManagerNick_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        projectManagerNick_title.setForeground(new java.awt.Color(255, 255, 153));
        projectManagerNick_title.setText("PROJECT MANAGER");
        NickelodeonTab.add(projectManagerNick_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 260, 40));

        managerStatusNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerStatusNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        managerStatusNickelodeon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        managerStatusNickelodeon.setText("Nothing");
        NickelodeonTab.add(managerStatusNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 250, 40));

        managerStatusN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerStatusN_label.setForeground(new java.awt.Color(255, 255, 255));
        managerStatusN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        managerStatusN_label.setText("Status:");
        NickelodeonTab.add(managerStatusN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 100, 40));

        managerFaultsN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerFaultsN_label.setForeground(new java.awt.Color(255, 255, 255));
        managerFaultsN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        managerFaultsN_label.setText("Faults:");
        NickelodeonTab.add(managerFaultsN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 100, 40));

        faultsQtyNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        faultsQtyNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        faultsQtyNickelodeon.setText("0");
        NickelodeonTab.add(faultsQtyNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 40, 40));

        managerDiscounted_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerDiscounted_label.setForeground(new java.awt.Color(255, 255, 255));
        managerDiscounted_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        managerDiscounted_label.setText("Discounted:");
        NickelodeonTab.add(managerDiscounted_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 120, 40));

        managerSalaryDiscountNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerSalaryDiscountNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        managerSalaryDiscountNickelodeon.setText("0");
        NickelodeonTab.add(managerSalaryDiscountNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 120, 40));

        plotTwistEpisodesN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistEpisodesN_label.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistEpisodesN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plotTwistEpisodesN_label.setText("With PlotTwists:");
        NickelodeonTab.add(plotTwistEpisodesN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 170, 40));

        standardEpisodesN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        standardEpisodesN_label.setForeground(new java.awt.Color(255, 255, 255));
        standardEpisodesN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        standardEpisodesN_label.setText("Standard:");
        NickelodeonTab.add(standardEpisodesN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 100, 40));

        plotTwistEpisodesNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistEpisodesNick.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistEpisodesNick.setText("0");
        NickelodeonTab.add(plotTwistEpisodesNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 40, 40));

        standarEpisodesNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        standarEpisodesNick.setForeground(new java.awt.Color(255, 255, 255));
        standarEpisodesNick.setText("0");
        NickelodeonTab.add(standarEpisodesNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 40, 40));

        episodesProducedNick_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        episodesProducedNick_title.setForeground(new java.awt.Color(255, 255, 153));
        episodesProducedNick_title.setText("EPISODES PRODUCED");
        NickelodeonTab.add(episodesProducedNick_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 270, 40));

        daysLeftNick_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        daysLeftNick_label.setForeground(new java.awt.Color(255, 255, 153));
        daysLeftNick_label.setText("DAYS LEFT:");
        NickelodeonTab.add(daysLeftNick_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 150, 40));

        daysLeftNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        daysLeftNick.setForeground(new java.awt.Color(255, 255, 153));
        daysLeftNick.setText("0");
        NickelodeonTab.add(daysLeftNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 50, 40));

        earningsNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        earningsNick.setForeground(new java.awt.Color(255, 255, 153));
        earningsNick.setText("0");
        NickelodeonTab.add(earningsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 210, 40));

        earningsNick_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        earningsNick_label.setForeground(new java.awt.Color(255, 255, 153));
        earningsNick_label.setText("EARNINGS: ");
        NickelodeonTab.add(earningsNick_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 150, 40));

        costsNick_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        costsNick_label.setForeground(new java.awt.Color(255, 255, 153));
        costsNick_label.setText("COSTS:");
        NickelodeonTab.add(costsNick_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 100, 40));

        costsNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        costsNick.setForeground(new java.awt.Color(255, 255, 153));
        costsNick.setText("0");
        NickelodeonTab.add(costsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 220, 40));

        utilityNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        utilityNick.setForeground(new java.awt.Color(255, 255, 153));
        utilityNick.setText("0");
        NickelodeonTab.add(utilityNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 220, 50));

        utilityNick_label.setEditable(false);
        utilityNick_label.setBackground(new java.awt.Color(255, 255, 153));
        utilityNick_label.setForeground(new java.awt.Color(51, 51, 51));
        utilityNick_label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        utilityNick_label.setText("TOTAL PROFIT:");
        utilityNick_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        NickelodeonTab.add(utilityNick_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 210, 50));

        scenarioDesignersNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenarioDesignersNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        scenarioDesignersNickelodeon.setText("0");
        NickelodeonTab.add(scenarioDesignersNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 40, 40));

        chas13.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        chas13.setForeground(new java.awt.Color(255, 255, 255));
        chas13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chas13.setText("Animators:");
        NickelodeonTab.add(chas13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 130, 40));

        chas14.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        chas14.setForeground(new java.awt.Color(255, 255, 255));
        chas14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chas14.setText("Voice Actors:");
        NickelodeonTab.add(chas14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 130, 40));

        voiceActorsNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        voiceActorsNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        voiceActorsNickelodeon.setText("0");
        NickelodeonTab.add(voiceActorsNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, 40, 40));

        chas15.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        chas15.setForeground(new java.awt.Color(255, 255, 255));
        chas15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chas15.setText("PlotTwist Writers:");
        NickelodeonTab.add(chas15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 170, 40));

        plotTwistWritersNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistWritersNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistWritersNickelodeon.setText("0");
        NickelodeonTab.add(plotTwistWritersNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 40, 40));

        screenwritersNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        screenwritersNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        screenwritersNickelodeon.setText("0");
        NickelodeonTab.add(screenwritersNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 40, 40));

        chas16.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        chas16.setForeground(new java.awt.Color(255, 255, 255));
        chas16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chas16.setText("Assemblers:");
        NickelodeonTab.add(chas16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 120, 40));

        assemblersNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        assemblersNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        assemblersNickelodeon.setText("0");
        NickelodeonTab.add(assemblersNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 40, 40));

        wm_label5.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        wm_label5.setForeground(new java.awt.Color(255, 255, 153));
        wm_label5.setText("WORKERS");
        NickelodeonTab.add(wm_label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 140, 40));

        chas17.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        chas17.setForeground(new java.awt.Color(255, 255, 255));
        chas17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chas17.setText("Screenwriters:");
        NickelodeonTab.add(chas17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 160, 40));

        chas18.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        chas18.setForeground(new java.awt.Color(255, 255, 255));
        chas18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chas18.setText("Scenario Designers:");
        NickelodeonTab.add(chas18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 190, 40));

        animatorsNickelodeon.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animatorsNickelodeon.setForeground(new java.awt.Color(255, 255, 255));
        animatorsNickelodeon.setText("0");
        NickelodeonTab.add(animatorsNickelodeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 40, 40));

        screenwritersPlusNick.setBackground(new java.awt.Color(255, 255, 153));
        screenwritersPlusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        screenwritersPlusNick.setForeground(new java.awt.Color(51, 51, 51));
        screenwritersPlusNick.setText("+");
        screenwritersPlusNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenwritersPlusNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(screenwritersPlusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 50, 20));

        scenarioDesignersPlusNick.setBackground(new java.awt.Color(255, 255, 153));
        scenarioDesignersPlusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenarioDesignersPlusNick.setForeground(new java.awt.Color(51, 51, 51));
        scenarioDesignersPlusNick.setText("+");
        scenarioDesignersPlusNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenarioDesignersPlusNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(scenarioDesignersPlusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 50, 20));

        animatorsPlusNick.setBackground(new java.awt.Color(255, 255, 153));
        animatorsPlusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animatorsPlusNick.setForeground(new java.awt.Color(51, 51, 51));
        animatorsPlusNick.setText("+");
        animatorsPlusNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animatorsPlusNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(animatorsPlusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 50, 20));

        screenwritersMinNick.setBackground(new java.awt.Color(255, 255, 153));
        screenwritersMinNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        screenwritersMinNick.setForeground(new java.awt.Color(51, 51, 51));
        screenwritersMinNick.setText("-");
        screenwritersMinNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenwritersMinNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(screenwritersMinNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 50, 20));

        scenarioDesignersMinNick.setBackground(new java.awt.Color(255, 255, 153));
        scenarioDesignersMinNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenarioDesignersMinNick.setForeground(new java.awt.Color(51, 51, 51));
        scenarioDesignersMinNick.setText("-");
        scenarioDesignersMinNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenarioDesignersMinNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(scenarioDesignersMinNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 50, 20));

        animatorsMinNick.setBackground(new java.awt.Color(255, 255, 153));
        animatorsMinNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animatorsMinNick.setForeground(new java.awt.Color(51, 51, 51));
        animatorsMinNick.setText("-");
        animatorsMinNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animatorsMinNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(animatorsMinNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 50, 20));

        voiceActorsPlusNick.setBackground(new java.awt.Color(255, 255, 153));
        voiceActorsPlusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        voiceActorsPlusNick.setForeground(new java.awt.Color(51, 51, 51));
        voiceActorsPlusNick.setText("+");
        voiceActorsPlusNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorsPlusNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(voiceActorsPlusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, 50, 20));

        voiceActorsMinNick.setBackground(new java.awt.Color(255, 255, 153));
        voiceActorsMinNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        voiceActorsMinNick.setForeground(new java.awt.Color(51, 51, 51));
        voiceActorsMinNick.setText("-");
        voiceActorsMinNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorsMinNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(voiceActorsMinNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 50, 20));

        plotTwistWritersMinNick.setBackground(new java.awt.Color(255, 255, 153));
        plotTwistWritersMinNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistWritersMinNick.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistWritersMinNick.setText("-");
        plotTwistWritersMinNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistWritersMinNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(plotTwistWritersMinNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 50, 20));

        plotTwistWritersPlusNick.setBackground(new java.awt.Color(255, 255, 153));
        plotTwistWritersPlusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistWritersPlusNick.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistWritersPlusNick.setText("+");
        plotTwistWritersPlusNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistWritersPlusNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(plotTwistWritersPlusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 50, 20));

        assemblersMinNick.setBackground(new java.awt.Color(255, 255, 153));
        assemblersMinNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        assemblersMinNick.setForeground(new java.awt.Color(51, 51, 51));
        assemblersMinNick.setText("-");
        assemblersMinNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblersMinNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(assemblersMinNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 50, 20));

        assemblerPlusNick.setBackground(new java.awt.Color(255, 255, 153));
        assemblerPlusNick.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        assemblerPlusNick.setForeground(new java.awt.Color(51, 51, 51));
        assemblerPlusNick.setText("+");
        assemblerPlusNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblerPlusNickActionPerformed(evt);
            }
        });
        NickelodeonTab.add(assemblerPlusNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 50, 20));

        startSimulation.setBackground(new java.awt.Color(255, 255, 153));
        startSimulation.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        startSimulation.setForeground(new java.awt.Color(51, 51, 51));
        startSimulation.setText("Start");
        startSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSimulationActionPerformed(evt);
            }
        });
        NickelodeonTab.add(startSimulation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, 40));

        Tabs.addTab("Nickelodeon", NickelodeonTab);

        CartoonNetworkTab.setBackground(new java.awt.Color(51, 51, 51));
        CartoonNetworkTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        CN_label.setForeground(new java.awt.Color(255, 255, 153));
        CN_label.setText("NETWORK");
        CartoonNetworkTab.add(CN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 220, 60));

        episodePartsCN_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        episodePartsCN_title.setForeground(new java.awt.Color(255, 255, 153));
        episodePartsCN_title.setText("EPISODE PARTS");
        CartoonNetworkTab.add(episodePartsCN_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, 40));

        scriptsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scriptsCN_label.setForeground(new java.awt.Color(255, 255, 255));
        scriptsCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scriptsCN_label.setText("Scripts:");
        CartoonNetworkTab.add(scriptsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 70, 40));

        CartoonScripts.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        CartoonScripts.setForeground(new java.awt.Color(255, 255, 255));
        CartoonScripts.setText("0");
        CartoonNetworkTab.add(CartoonScripts, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 40, 40));

        maxScriptsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxScriptsCN.setForeground(new java.awt.Color(255, 255, 255));
        maxScriptsCN.setText("/ 25");
        CartoonNetworkTab.add(maxScriptsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 40, 40));

        scenariosCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenariosCN_label.setForeground(new java.awt.Color(255, 255, 255));
        scenariosCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scenariosCN_label.setText("Scenarios:");
        CartoonNetworkTab.add(scenariosCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 110, 40));

        CartoonNScenarios.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        CartoonNScenarios.setForeground(new java.awt.Color(255, 255, 255));
        CartoonNScenarios.setText("0");
        CartoonNetworkTab.add(CartoonNScenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 40, 40));

        maxScenariosCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxScenariosCN.setForeground(new java.awt.Color(255, 255, 255));
        maxScenariosCN.setText("/ 20");
        CartoonNetworkTab.add(maxScenariosCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 40, 40));

        animationsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animationsCN_label.setForeground(new java.awt.Color(255, 255, 255));
        animationsCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        animationsCN_label.setText("Animations:");
        CartoonNetworkTab.add(animationsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, 40));

        CartoonNAnimations.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        CartoonNAnimations.setForeground(new java.awt.Color(255, 255, 255));
        CartoonNAnimations.setText("0");
        CartoonNetworkTab.add(CartoonNAnimations, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 40, 40));

        maxAnimationsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxAnimationsCN.setForeground(new java.awt.Color(255, 255, 255));
        maxAnimationsCN.setText("/ 55");
        CartoonNetworkTab.add(maxAnimationsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 40, 40));

        dubsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        dubsCN_label.setForeground(new java.awt.Color(255, 255, 255));
        dubsCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dubsCN_label.setText("Dubbings:");
        CartoonNetworkTab.add(dubsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 40));

        CartoonNDubbings.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        CartoonNDubbings.setForeground(new java.awt.Color(255, 255, 255));
        CartoonNDubbings.setText("0");
        CartoonNetworkTab.add(CartoonNDubbings, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 40, 40));

        maxDubbingsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxDubbingsCN.setForeground(new java.awt.Color(255, 255, 255));
        maxDubbingsCN.setText("/ 35");
        CartoonNetworkTab.add(maxDubbingsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 40, 40));

        plotTwistsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistsCN_label.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistsCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plotTwistsCN_label.setText("PlotTwists:");
        CartoonNetworkTab.add(plotTwistsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 110, 40));

        CartoonNPlotTwists.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        CartoonNPlotTwists.setForeground(new java.awt.Color(255, 255, 255));
        CartoonNPlotTwists.setText("0");
        CartoonNetworkTab.add(CartoonNPlotTwists, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 40, 40));

        maxPlotTwistsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        maxPlotTwistsCN.setForeground(new java.awt.Color(255, 255, 255));
        maxPlotTwistsCN.setText("/ 10");
        CartoonNetworkTab.add(maxPlotTwistsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 40, 40));

        directorCN_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        directorCN_title.setForeground(new java.awt.Color(255, 255, 153));
        directorCN_title.setText("DIRECTOR");
        CartoonNetworkTab.add(directorCN_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 140, 40));

        directorStatusCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        directorStatusCN_label.setForeground(new java.awt.Color(255, 255, 255));
        directorStatusCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        directorStatusCN_label.setText("Status:");
        CartoonNetworkTab.add(directorStatusCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 100, 40));

        directorStatusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        directorStatusCN.setForeground(new java.awt.Color(255, 255, 255));
        directorStatusCN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        directorStatusCN.setText("Working");
        CartoonNetworkTab.add(directorStatusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 230, 40));

        projectManagerCN_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        projectManagerCN_title.setForeground(new java.awt.Color(255, 255, 153));
        projectManagerCN_title.setText("PROJECT MANAGER");
        CartoonNetworkTab.add(projectManagerCN_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 260, 40));

        managerStatusCartoonN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerStatusCartoonN.setForeground(new java.awt.Color(255, 255, 255));
        managerStatusCartoonN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        managerStatusCartoonN.setText("Nothing");
        CartoonNetworkTab.add(managerStatusCartoonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 250, 40));

        managerStatusCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerStatusCN_label.setForeground(new java.awt.Color(255, 255, 255));
        managerStatusCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        managerStatusCN_label.setText("Status:");
        CartoonNetworkTab.add(managerStatusCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 100, 40));

        managerFaultsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerFaultsCN_label.setForeground(new java.awt.Color(255, 255, 255));
        managerFaultsCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        managerFaultsCN_label.setText("Faults:");
        CartoonNetworkTab.add(managerFaultsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 100, 40));

        faultsQtyCartoonN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        faultsQtyCartoonN.setForeground(new java.awt.Color(255, 255, 255));
        faultsQtyCartoonN.setText("0");
        CartoonNetworkTab.add(faultsQtyCartoonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 40, 40));

        managerDiscountedCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerDiscountedCN_label.setForeground(new java.awt.Color(255, 255, 255));
        managerDiscountedCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        managerDiscountedCN_label.setText("Discounted:");
        CartoonNetworkTab.add(managerDiscountedCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 120, 40));

        managerSalaryDiscountCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        managerSalaryDiscountCN.setForeground(new java.awt.Color(255, 255, 255));
        managerSalaryDiscountCN.setText("0");
        CartoonNetworkTab.add(managerSalaryDiscountCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 120, 40));

        plotTwistEpisodesCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistEpisodesCN_label.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistEpisodesCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plotTwistEpisodesCN_label.setText("With PlotTwists:");
        CartoonNetworkTab.add(plotTwistEpisodesCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 170, 40));

        standardEpisodesCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        standardEpisodesCN_label.setForeground(new java.awt.Color(255, 255, 255));
        standardEpisodesCN_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        standardEpisodesCN_label.setText("Standard:");
        CartoonNetworkTab.add(standardEpisodesCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 100, 40));

        plotTwistEpisodesCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistEpisodesCN.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistEpisodesCN.setText("0");
        CartoonNetworkTab.add(plotTwistEpisodesCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 40, 40));

        standarEpisodesCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        standarEpisodesCN.setForeground(new java.awt.Color(255, 255, 255));
        standarEpisodesCN.setText("0");
        CartoonNetworkTab.add(standarEpisodesCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 40, 40));

        episodesProducedCN_title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        episodesProducedCN_title.setForeground(new java.awt.Color(255, 255, 153));
        episodesProducedCN_title.setText("EPISODES PRODUCED");
        CartoonNetworkTab.add(episodesProducedCN_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 270, 40));

        DaysLeftCartoonNetwork.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        DaysLeftCartoonNetwork.setForeground(new java.awt.Color(255, 255, 153));
        DaysLeftCartoonNetwork.setText("DAYS LEFT:");
        CartoonNetworkTab.add(DaysLeftCartoonNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 150, 40));

        daysLeftCartoonNetwork.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        daysLeftCartoonNetwork.setForeground(new java.awt.Color(255, 255, 153));
        daysLeftCartoonNetwork.setText("0");
        CartoonNetworkTab.add(daysLeftCartoonNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 50, 40));

        earningsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        earningsCN.setForeground(new java.awt.Color(255, 255, 153));
        earningsCN.setText("0");
        CartoonNetworkTab.add(earningsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 210, 40));

        costsCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        costsCN.setForeground(new java.awt.Color(255, 255, 153));
        costsCN.setText("0");
        CartoonNetworkTab.add(costsCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 220, 40));

        utilityCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        utilityCN.setForeground(new java.awt.Color(255, 255, 153));
        utilityCN.setText("0");
        CartoonNetworkTab.add(utilityCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 220, 50));

        utilityCN_label.setEditable(false);
        utilityCN_label.setBackground(new java.awt.Color(255, 255, 153));
        utilityCN_label.setForeground(new java.awt.Color(51, 51, 51));
        utilityCN_label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        utilityCN_label.setText("TOTAL PROFIT:");
        utilityCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        CartoonNetworkTab.add(utilityCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 210, 50));

        qtyScenarioDesignersCartoonN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        qtyScenarioDesignersCartoonN.setForeground(new java.awt.Color(255, 255, 255));
        qtyScenarioDesignersCartoonN.setText("0");
        CartoonNetworkTab.add(qtyScenarioDesignersCartoonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 40, 40));

        animatorsCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animatorsCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        animatorsCN_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        animatorsCN_Label.setText("Animators:");
        CartoonNetworkTab.add(animatorsCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 130, 40));

        voiceActorsCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        voiceActorsCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        voiceActorsCN_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        voiceActorsCN_Label.setText("Voice Actors:");
        CartoonNetworkTab.add(voiceActorsCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 130, 40));

        qtyVoiceActorsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        qtyVoiceActorsCN_label.setForeground(new java.awt.Color(255, 255, 255));
        qtyVoiceActorsCN_label.setText("0");
        CartoonNetworkTab.add(qtyVoiceActorsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, 40, 40));

        plottwistWriters_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plottwistWriters_Label.setForeground(new java.awt.Color(255, 255, 255));
        plottwistWriters_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plottwistWriters_Label.setText("PlotTwist Writers:");
        CartoonNetworkTab.add(plottwistWriters_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 170, 40));

        qtyPlotTwistWritersCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        qtyPlotTwistWritersCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        qtyPlotTwistWritersCN_Label.setText("0");
        CartoonNetworkTab.add(qtyPlotTwistWritersCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 40, 40));

        qtyScreenwritersCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        qtyScreenwritersCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        qtyScreenwritersCN_Label.setText("0");
        CartoonNetworkTab.add(qtyScreenwritersCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 40, 40));

        assemblersCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        assemblersCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        assemblersCN_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        assemblersCN_Label.setText("Assemblers:");
        CartoonNetworkTab.add(assemblersCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 120, 40));

        qtyAssemblersCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        qtyAssemblersCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        qtyAssemblersCN_Label.setText("0");
        CartoonNetworkTab.add(qtyAssemblersCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 40, 40));

        wm_label6.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        wm_label6.setForeground(new java.awt.Color(255, 255, 153));
        wm_label6.setText("WORKERS");
        CartoonNetworkTab.add(wm_label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 140, 40));

        screenWritersCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        screenWritersCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        screenWritersCN_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        screenWritersCN_Label.setText("Screenwriters:");
        CartoonNetworkTab.add(screenWritersCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 160, 40));

        scenarioDesignersCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenarioDesignersCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        scenarioDesignersCN_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scenarioDesignersCN_Label.setText("Scenario Designers:");
        CartoonNetworkTab.add(scenarioDesignersCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 190, 40));

        qtyAnimatorsCN_Label.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        qtyAnimatorsCN_Label.setForeground(new java.awt.Color(255, 255, 255));
        qtyAnimatorsCN_Label.setText("0");
        CartoonNetworkTab.add(qtyAnimatorsCN_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 40, 40));

        screenwritersPlusCN.setBackground(new java.awt.Color(255, 255, 153));
        screenwritersPlusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        screenwritersPlusCN.setForeground(new java.awt.Color(51, 51, 51));
        screenwritersPlusCN.setText("+");
        screenwritersPlusCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenwritersPlusCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(screenwritersPlusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 50, 20));

        screenwritersMinCN.setBackground(new java.awt.Color(255, 255, 153));
        screenwritersMinCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        screenwritersMinCN.setForeground(new java.awt.Color(51, 51, 51));
        screenwritersMinCN.setText("-");
        screenwritersMinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenwritersMinCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(screenwritersMinCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 50, 20));

        scenarioDesignersPlusCN.setBackground(new java.awt.Color(255, 255, 153));
        scenarioDesignersPlusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenarioDesignersPlusCN.setForeground(new java.awt.Color(51, 51, 51));
        scenarioDesignersPlusCN.setText("+");
        scenarioDesignersPlusCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenarioDesignersPlusCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(scenarioDesignersPlusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 50, 20));

        animatorsPlusCN.setBackground(new java.awt.Color(255, 255, 153));
        animatorsPlusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animatorsPlusCN.setForeground(new java.awt.Color(51, 51, 51));
        animatorsPlusCN.setText("+");
        animatorsPlusCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animatorsPlusCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(animatorsPlusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 50, 20));

        scenarioDesignersMinCN.setBackground(new java.awt.Color(255, 255, 153));
        scenarioDesignersMinCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        scenarioDesignersMinCN.setForeground(new java.awt.Color(51, 51, 51));
        scenarioDesignersMinCN.setText("-");
        scenarioDesignersMinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenarioDesignersMinCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(scenarioDesignersMinCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 50, 20));

        animatorsMinCN.setBackground(new java.awt.Color(255, 255, 153));
        animatorsMinCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        animatorsMinCN.setForeground(new java.awt.Color(51, 51, 51));
        animatorsMinCN.setText("-");
        animatorsMinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animatorsMinCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(animatorsMinCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 50, 20));

        voiceActorsPlusCN.setBackground(new java.awt.Color(255, 255, 153));
        voiceActorsPlusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        voiceActorsPlusCN.setForeground(new java.awt.Color(51, 51, 51));
        voiceActorsPlusCN.setText("+");
        voiceActorsPlusCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorsPlusCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(voiceActorsPlusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, 50, 20));

        voiceActorsMinCN.setBackground(new java.awt.Color(255, 255, 153));
        voiceActorsMinCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        voiceActorsMinCN.setForeground(new java.awt.Color(51, 51, 51));
        voiceActorsMinCN.setText("-");
        voiceActorsMinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorsMinCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(voiceActorsMinCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 50, 20));

        plotTwistWritersMinCN.setBackground(new java.awt.Color(255, 255, 153));
        plotTwistWritersMinCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistWritersMinCN.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistWritersMinCN.setText("-");
        plotTwistWritersMinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistWritersMinCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(plotTwistWritersMinCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 50, 20));

        plotTwistWritersPlusCN.setBackground(new java.awt.Color(255, 255, 153));
        plotTwistWritersPlusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        plotTwistWritersPlusCN.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistWritersPlusCN.setText("+");
        plotTwistWritersPlusCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistWritersPlusCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(plotTwistWritersPlusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 50, 20));

        assemblersMinCN.setBackground(new java.awt.Color(255, 255, 153));
        assemblersMinCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        assemblersMinCN.setForeground(new java.awt.Color(51, 51, 51));
        assemblersMinCN.setText("-");
        assemblersMinCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblersMinCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(assemblersMinCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 50, 20));

        assemblerPlusCN.setBackground(new java.awt.Color(255, 255, 153));
        assemblerPlusCN.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        assemblerPlusCN.setForeground(new java.awt.Color(51, 51, 51));
        assemblerPlusCN.setText("+");
        assemblerPlusCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblerPlusCNActionPerformed(evt);
            }
        });
        CartoonNetworkTab.add(assemblerPlusCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 50, 20));

        earningsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        earningsCN_label.setForeground(new java.awt.Color(255, 255, 153));
        earningsCN_label.setText("EARNINGS: ");
        CartoonNetworkTab.add(earningsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 150, 40));

        costsCN_label.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        costsCN_label.setForeground(new java.awt.Color(255, 255, 153));
        costsCN_label.setText("COSTS:");
        CartoonNetworkTab.add(costsCN_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 100, 40));

        CN_label1.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        CN_label1.setForeground(new java.awt.Color(255, 255, 153));
        CN_label1.setText("CARTOON ");
        CartoonNetworkTab.add(CN_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 60));

        Tabs.addTab("Cartoon Network", CartoonNetworkTab);

        getContentPane().add(Tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startSimulationActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_startSimulationActionPerformed
        getNickelodeon().start();
        getCartoonNetwork().start();
    }// GEN-LAST:event_startSimulationActionPerformed

    private void setConfigurationActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_setConfigurationActionPerformed
        String configString = "General\ndayDuration\n";

        try {
            int dayDuration = Integer.parseInt(dayDurationInput.getText()) * 1000;
            int deliveryDays = Integer.parseInt(deliveryDaysInput.getText());

            configString += Integer.toString(dayDuration) + "\ndeliveryDays\n" + Integer.toString(deliveryDays) + "\n";

            // Nickelodeon workers
            Integer screenwritersNickelodeon = (Integer) screenwritersNick.getValue();
            Integer scenarioNickelodeon = (Integer) scenarioDesignersNick.getValue();
            Integer animatorsNickelodeon = (Integer) animatorsNick.getValue();
            Integer voiceActorsNickelodeon = (Integer) voiceActorsNick.getValue();
            Integer plotTwistWritersNickelodeon = (Integer) plotTwistWritersNick.getValue();
            Integer assemblersNickelodeon = (Integer) assemblersNick.getValue();

            int totalWorkersNick = screenwritersNickelodeon + scenarioNickelodeon + animatorsNickelodeon
                    + voiceActorsNickelodeon + plotTwistWritersNickelodeon + assemblersNickelodeon;

            // Cartoon Network Workers
            Integer screenwritersCartoonNetwork = (Integer) screenwritersCN.getValue();
            Integer scenarioCartoonNetwork = (Integer) scenarioDesignersCN.getValue();
            Integer animatorsCartoonNetwork = (Integer) animatorsCN.getValue();
            Integer voiceActorsCartoonNetwork = (Integer) voiceActorsCN.getValue();
            Integer plotTwistWritersCartoonNetwork = (Integer) plotTwistWritersCN.getValue();
            Integer assemblersCartoonNetwork = (Integer) assemblersCN.getValue();

            int totalWorkersCN = screenwritersCartoonNetwork + scenarioCartoonNetwork + animatorsCartoonNetwork
                    + voiceActorsCartoonNetwork + plotTwistWritersCartoonNetwork + assemblersCartoonNetwork;

            if ((totalWorkersNick > 20) || (totalWorkersCN > 12)) {
                throw new Exception();
            }

            configString = getFunctions().generateConfigString("Nickelodeon", configString, screenwritersNickelodeon,
                    scenarioNickelodeon, animatorsNickelodeon, voiceActorsNickelodeon, plotTwistWritersNickelodeon,
                    assemblersNickelodeon);
            configString = getFunctions().generateConfigString("CartoonNetwork", configString,
                    screenwritersCartoonNetwork, scenarioCartoonNetwork, animatorsCartoonNetwork,
                    voiceActorsCartoonNetwork, plotTwistWritersCartoonNetwork, assemblersCartoonNetwork);

            ReadFile file = new ReadFile();
            file.printTxt(configString);

            String newConfig = file.readTxt();
            file.readConfig(newConfig, config);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You have to enter a number");
        }

    }// GEN-LAST:event_setConfigurationActionPerformed

    private void screenwritersPlusNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_screenwritersPlusNickActionPerformed

    }// GEN-LAST:event_screenwritersPlusNickActionPerformed

    private void scenarioDesignersPlusNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_scenarioDesignersPlusNickActionPerformed

    }// GEN-LAST:event_scenarioDesignersPlusNickActionPerformed

    private void animatorsPlusNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_animatorsPlusNickActionPerformed

    }// GEN-LAST:event_animatorsPlusNickActionPerformed

    private void screenwritersMinNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_screenwritersMinNickActionPerformed

    }// GEN-LAST:event_screenwritersMinNickActionPerformed

    private void scenarioDesignersMinNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_scenarioDesignersMinNickActionPerformed

    }// GEN-LAST:event_scenarioDesignersMinNickActionPerformed

    private void animatorsMinNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_animatorsMinNickActionPerformed

    }// GEN-LAST:event_animatorsMinNickActionPerformed

    private void voiceActorsPlusNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_voiceActorsPlusNickActionPerformed

    }// GEN-LAST:event_voiceActorsPlusNickActionPerformed

    private void voiceActorsMinNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_voiceActorsMinNickActionPerformed

    }// GEN-LAST:event_voiceActorsMinNickActionPerformed

    private void plotTwistWritersMinNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_plotTwistWritersMinNickActionPerformed

    }// GEN-LAST:event_plotTwistWritersMinNickActionPerformed

    private void plotTwistWritersPlusNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_plotTwistWritersPlusNickActionPerformed

    }// GEN-LAST:event_plotTwistWritersPlusNickActionPerformed

    private void assemblersMinNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_assemblersMinNickActionPerformed

    }// GEN-LAST:event_assemblersMinNickActionPerformed

    private void assemblerPlusNickActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_assemblerPlusNickActionPerformed

    }// GEN-LAST:event_assemblerPlusNickActionPerformed

    private void screenwritersPlusCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_screenwritersPlusCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_screenwritersPlusCNActionPerformed

    private void scenarioDesignersPlusCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_scenarioDesignersPlusCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_scenarioDesignersPlusCNActionPerformed

    private void animatorsPlusCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_animatorsPlusCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_animatorsPlusCNActionPerformed

    private void screenwritersMinCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_screenwritersMinCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_screenwritersMinCNActionPerformed

    private void scenarioDesignersMinCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_scenarioDesignersMinCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_scenarioDesignersMinCNActionPerformed

    private void animatorsMinCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_animatorsMinCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_animatorsMinCNActionPerformed

    private void voiceActorsPlusCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_voiceActorsPlusCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_voiceActorsPlusCNActionPerformed

    private void voiceActorsMinCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_voiceActorsMinCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_voiceActorsMinCNActionPerformed

    private void plotTwistWritersMinCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_plotTwistWritersMinCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_plotTwistWritersMinCNActionPerformed

    private void plotTwistWritersPlusCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_plotTwistWritersPlusCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_plotTwistWritersPlusCNActionPerformed

    private void assemblersMinCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_assemblersMinCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_assemblersMinCNActionPerformed

    private void assemblerPlusCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_assemblerPlusCNActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_assemblerPlusCNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
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
        // </editor-fold>

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
    private javax.swing.JLabel CN_label1;
    private javax.swing.JLabel CartoonNAnimations;
    private javax.swing.JLabel CartoonNDubbings;
    private javax.swing.JLabel CartoonNPlotTwists;
    private javax.swing.JLabel CartoonNScenarios;
    private javax.swing.JPanel CartoonNetworkTab;
    private javax.swing.JLabel CartoonScripts;
    private javax.swing.JLabel Config_label;
    private javax.swing.JPanel ConfigurationTab;
    private javax.swing.JLabel DaysLeftCartoonNetwork;
    private javax.swing.JLabel General_label;
    private javax.swing.JLabel NickConfig_label;
    private javax.swing.JLabel NickMaximumWorkers_label;
    private javax.swing.JLabel NickelodeonAnimations;
    private javax.swing.JLabel NickelodeonDubbings;
    private javax.swing.JLabel NickelodeonPlotTwists;
    private javax.swing.JLabel NickelodeonScenarios;
    private javax.swing.JLabel NickelodeonScripts;
    private javax.swing.JPanel NickelodeonTab;
    private javax.swing.JLabel Nickelodeon_label;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JLabel animationsCN_label;
    private javax.swing.JLabel animationsN_label;
    private javax.swing.JSpinner animatorsCN;
    private javax.swing.JLabel animatorsCN_Label;
    private javax.swing.JButton animatorsMinCN;
    private javax.swing.JButton animatorsMinNick;
    private javax.swing.JSpinner animatorsNick;
    private javax.swing.JLabel animatorsNickelodeon;
    private javax.swing.JButton animatorsPlusCN;
    private javax.swing.JButton animatorsPlusNick;
    private javax.swing.JLabel animators_label;
    private javax.swing.JLabel animators_label1;
    private javax.swing.JButton assemblerPlusCN;
    private javax.swing.JButton assemblerPlusNick;
    private javax.swing.JSpinner assemblersCN;
    private javax.swing.JLabel assemblersCN_Label;
    private javax.swing.JButton assemblersMinCN;
    private javax.swing.JButton assemblersMinNick;
    private javax.swing.JSpinner assemblersNick;
    private javax.swing.JLabel assemblersNickelodeon;
    private javax.swing.JLabel assemblers_label;
    private javax.swing.JLabel assemblers_label2;
    private javax.swing.JLabel chas13;
    private javax.swing.JLabel chas14;
    private javax.swing.JLabel chas15;
    private javax.swing.JLabel chas16;
    private javax.swing.JLabel chas17;
    private javax.swing.JLabel chas18;
    private javax.swing.JLabel costsCN;
    private javax.swing.JLabel costsCN_label;
    private javax.swing.JLabel costsNick;
    private javax.swing.JLabel costsNick_label;
    private javax.swing.JTextPane dayDurationInput;
    private javax.swing.JLabel dayDuration_label;
    private javax.swing.JLabel daysLeftCartoonNetwork;
    private javax.swing.JLabel daysLeftNick;
    private javax.swing.JLabel daysLeftNick_label;
    private javax.swing.JTextPane deliveryDaysInput;
    private javax.swing.JLabel deliveryDays_label;
    private javax.swing.JLabel directorCN_title;
    private javax.swing.JLabel directorNick_title;
    private javax.swing.JLabel directorStatusCN;
    private javax.swing.JLabel directorStatusCN_label;
    private javax.swing.JLabel directorStatusNick;
    private javax.swing.JLabel directorStatusNick_label;
    private javax.swing.JLabel dubsCN_label;
    private javax.swing.JLabel dubsN_label;
    private javax.swing.JLabel earningsCN;
    private javax.swing.JLabel earningsCN_label;
    private javax.swing.JLabel earningsNick;
    private javax.swing.JLabel earningsNick_label;
    private javax.swing.JLabel episodePartsCN_title;
    private javax.swing.JLabel episodePartsNick_title;
    private javax.swing.JLabel episodesProducedCN_title;
    private javax.swing.JLabel episodesProducedNick_title;
    private javax.swing.JLabel faultsQtyCartoonN;
    private javax.swing.JLabel faultsQtyNickelodeon;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel managerDiscountedCN_label;
    private javax.swing.JLabel managerDiscounted_label;
    private javax.swing.JLabel managerFaultsCN_label;
    private javax.swing.JLabel managerFaultsN_label;
    private javax.swing.JLabel managerSalaryDiscountCN;
    private javax.swing.JLabel managerSalaryDiscountNickelodeon;
    private javax.swing.JLabel managerStatusCN_label;
    private javax.swing.JLabel managerStatusCartoonN;
    private javax.swing.JLabel managerStatusN_label;
    private javax.swing.JLabel managerStatusNickelodeon;
    private javax.swing.JLabel maxAnimationsCN;
    private javax.swing.JLabel maxAnimationsN;
    private javax.swing.JLabel maxDubbingsCN;
    private javax.swing.JLabel maxDubbingsN;
    private javax.swing.JLabel maxPlotTwistsCN;
    private javax.swing.JLabel maxPlotTwistsN;
    private javax.swing.JLabel maxScenariosCN;
    private javax.swing.JLabel maxScenariosN;
    private javax.swing.JLabel maxScriptsCN;
    private javax.swing.JLabel maxScriptsN;
    private javax.swing.JLabel plotTwistEpisodesCN;
    private javax.swing.JLabel plotTwistEpisodesCN_label;
    private javax.swing.JLabel plotTwistEpisodesN_label;
    private javax.swing.JLabel plotTwistEpisodesNick;
    private javax.swing.JSpinner plotTwistWritersCN;
    private javax.swing.JButton plotTwistWritersMinCN;
    private javax.swing.JButton plotTwistWritersMinNick;
    private javax.swing.JSpinner plotTwistWritersNick;
    private javax.swing.JLabel plotTwistWritersNickelodeon;
    private javax.swing.JButton plotTwistWritersPlusCN;
    private javax.swing.JButton plotTwistWritersPlusNick;
    private javax.swing.JLabel plotTwistWriters_label;
    private javax.swing.JLabel plotTwistWriters_label1;
    private javax.swing.JLabel plotTwistsCN_label;
    private javax.swing.JLabel plotTwistsN_label;
    private javax.swing.JLabel plottwistWriters_Label;
    private javax.swing.JLabel projectManagerCN_title;
    private javax.swing.JLabel projectManagerNick_title;
    private javax.swing.JLabel qtyAnimatorsCN_Label;
    private javax.swing.JLabel qtyAssemblersCN_Label;
    private javax.swing.JLabel qtyPlotTwistWritersCN_Label;
    private javax.swing.JLabel qtyScenarioDesignersCartoonN;
    private javax.swing.JLabel qtyScreenwritersCN_Label;
    private javax.swing.JLabel qtyVoiceActorsCN_label;
    private javax.swing.JSpinner scenarioDesignersCN;
    private javax.swing.JLabel scenarioDesignersCN_Label;
    private javax.swing.JButton scenarioDesignersMinCN;
    private javax.swing.JButton scenarioDesignersMinNick;
    private javax.swing.JSpinner scenarioDesignersNick;
    private javax.swing.JLabel scenarioDesignersNickelodeon;
    private javax.swing.JButton scenarioDesignersPlusCN;
    private javax.swing.JButton scenarioDesignersPlusNick;
    private javax.swing.JLabel scenarioDesigners_label;
    private javax.swing.JLabel scenarioDesigners_label1;
    private javax.swing.JLabel scenariosCN_label;
    private javax.swing.JLabel scenariosN_label;
    private javax.swing.JLabel screenWritersCN_Label;
    private javax.swing.JSpinner screenwritersCN;
    private javax.swing.JButton screenwritersMinCN;
    private javax.swing.JButton screenwritersMinNick;
    private javax.swing.JSpinner screenwritersNick;
    private javax.swing.JLabel screenwritersNickelodeon;
    private javax.swing.JButton screenwritersPlusCN;
    private javax.swing.JButton screenwritersPlusNick;
    private javax.swing.JLabel screenwriters_label;
    private javax.swing.JLabel screenwriters_label1;
    private javax.swing.JLabel scriptsCN_label;
    private javax.swing.JLabel scriptsN_label;
    private javax.swing.JButton setConfiguration;
    private javax.swing.JLabel standarEpisodesCN;
    private javax.swing.JLabel standarEpisodesNick;
    private javax.swing.JLabel standardEpisodesCN_label;
    private javax.swing.JLabel standardEpisodesN_label;
    private javax.swing.JButton startSimulation;
    private javax.swing.JLabel utilityCN;
    private javax.swing.JFormattedTextField utilityCN_label;
    private javax.swing.JLabel utilityNick;
    private javax.swing.JFormattedTextField utilityNick_label;
    private javax.swing.JSpinner voiceActorsCN;
    private javax.swing.JLabel voiceActorsCN_Label;
    private javax.swing.JButton voiceActorsMinCN;
    private javax.swing.JButton voiceActorsMinNick;
    private javax.swing.JSpinner voiceActorsNick;
    private javax.swing.JLabel voiceActorsNickelodeon;
    private javax.swing.JButton voiceActorsPlusCN;
    private javax.swing.JButton voiceActorsPlusNick;
    private javax.swing.JLabel voiceActors_label;
    private javax.swing.JLabel voiceActors_label1;
    private javax.swing.JLabel wm_label5;
    private javax.swing.JLabel wm_label6;
    // End of variables declaration//GEN-END:variables
}
