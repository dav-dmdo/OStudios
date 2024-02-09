/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import UserInterface.MainUI;

/**
 *
 * @author david
 */
public class Accountant {

    private int studioInt;
    private int screenwritersCosts;
    private int scenarioDesignersCosts;
    private int animatorsCosts;
    private int voiceActorsCosts;
    private int plotTwistWritersCosts;
    private int assemblersCosts;
    private int projectManagerCosts;
    private int directorCosts;

    private int standardChaptersIncome;
    private int plotTwistChaptersIncome;

    private int totalOperationalCosts;
    private int totalIncome;

    private int totalProfit;

    private MainUI userInterface;

    public Accountant(int studioInt, int screenwritersCosts, int scenarioDesignersCosts, int animatorsCosts,
            int voiceActorsCosts, int plotTwistWritersCosts, int assemblersCosts, int projectManagerCosts,
            int directorCosts, int standardChaptersIncome, int plotTwistChaptersIncome, int totalOperationalCosts,
            int totalIncome, int totalProfit) {
        this.studioInt = studioInt;
        this.screenwritersCosts = screenwritersCosts;
        this.scenarioDesignersCosts = scenarioDesignersCosts;
        this.animatorsCosts = animatorsCosts;
        this.voiceActorsCosts = voiceActorsCosts;
        this.plotTwistWritersCosts = plotTwistWritersCosts;
        this.assemblersCosts = assemblersCosts;
        this.projectManagerCosts = projectManagerCosts;
        this.directorCosts = directorCosts;
        this.standardChaptersIncome = standardChaptersIncome;
        this.plotTwistChaptersIncome = plotTwistChaptersIncome;
        this.totalOperationalCosts = totalOperationalCosts;
        this.totalIncome = totalIncome;
        this.totalProfit = totalProfit;
    }

    public Accountant(int studioInt, MainUI userInterface) {
        this.studioInt = studioInt;
        this.screenwritersCosts = 0;
        this.scenarioDesignersCosts = 0;
        this.animatorsCosts = 0;
        this.voiceActorsCosts = 0;
        this.plotTwistWritersCosts = 0;
        this.assemblersCosts = 0;
        this.projectManagerCosts = 0;
        this.directorCosts = 0;
        this.standardChaptersIncome = 0;
        this.plotTwistChaptersIncome = 0;
        this.totalOperationalCosts = 0;
        this.totalIncome = 0;
        this.totalProfit = 0;
        this.userInterface = userInterface;
    }

    public void updateScreenwritersCosts(int cost) {
        this.setScreenwritersCosts(this.getScreenwritersCosts() + cost);
    }

    public void updateScenarioDesignersCosts(int cost) {
        this.setScenarioDesignersCosts(this.getScenarioDesignersCosts() + cost);
    }

    public void updateAnimatorsCosts(int cost) {
        this.setAnimatorsCosts(this.getAnimatorsCosts() + cost);
    }

    public void updateVoiceActorsCosts(int cost) {
        this.setVoiceActorsCosts(this.getVoiceActorsCosts() + cost);
    }

    public void updateAssemblersCosts(int cost) {
        this.setAssemblersCosts(this.getAssemblersCosts() + cost);
    }

    public void updateProjectManagerCosts(int cost) {
        this.setProjectManagerCosts(this.getProjectManagerCosts() + cost);
    }

    public void updateDirectorCosts(int cost) {
        this.setDirectorCosts(this.getDirectorCosts() + cost);
    }

    public void updateStandardChaptersIncome(int income) {
        this.setStandardChaptersIncome(this.getStandardChaptersIncome() + income);
    }

    public void updatePlotTwistChaptersIncome(int income) {
        this.setPlotTwistChaptersIncome(this.getPlotTwistChaptersIncome() + income);
    }

    public void updateWorkerCosts(int typeInt, int cost) {
        switch (typeInt) {
            case -1:
                break;
            case 0:
                this.updateScreenwritersCosts(cost);
                break;
            case 1:
                this.updateScenarioDesignersCosts(cost);
                break;
            case 2:
                this.updateAnimatorsCosts(cost);
                break;
            case 3:
                this.updateVoiceActorsCosts(cost);
                break;
            case 4:
                this.updateScenarioDesignersCosts(cost);
                break;
            case 5:
                this.updateAssemblersCosts(cost);
                break;

        }
    }

    /**
     * @return
     */
    public int calculateTotalOperationalCosts() {
        this.setTotalOperationalCosts(
                this.getScreenwritersCosts()
                        + this.getScenarioDesignersCosts()
                        + this.getAnimatorsCosts()
                        + this.getVoiceActorsCosts()
                        + this.getPlotTwistWritersCosts()
                        + this.getAssemblersCosts()
                        + this.getProjectManagerCosts()
                        + this.getDirectorCosts());

        return this.getTotalOperationalCosts();

    }

    public void calculateTotalIncome() {
        this.setTotalIncome(
                this.getStandardChaptersIncome()
                        + this.getPlotTwistChaptersIncome());
    }

    public void calculateTotalProfit() {
        this.setTotalProfit(
                this.getTotalIncome()
                        - this.getTotalOperationalCosts());
    }

    public void showCostsInUI(int totalCosts) {
        this.getUserInterface().showCosts(studioInt, totalCosts);
    }

    public void showIncomeInUI() {

    }

    public void showProfitInUI() {

    }

    /**
     * @return the studioInt
     */
    public int getStudioInt() {
        return studioInt;
    }

    /**
     * @param studioInt the studioInt to set
     */
    public void setStudioInt(int studioInt) {
        this.studioInt = studioInt;
    }

    /**
     * @return the screenwritersCosts
     */
    public int getScreenwritersCosts() {
        return screenwritersCosts;
    }

    /**
     * @param screenwritersCosts the screenwritersCosts to set
     */
    public void setScreenwritersCosts(int screenwritersCosts) {
        this.screenwritersCosts = screenwritersCosts;
    }

    /**
     * @return the scenarioDesignersCosts
     */
    public int getScenarioDesignersCosts() {
        return scenarioDesignersCosts;
    }

    /**
     * @param scenarioDesignersCosts the scenarioDesignersCosts to set
     */
    public void setScenarioDesignersCosts(int scenarioDesignersCosts) {
        this.scenarioDesignersCosts = scenarioDesignersCosts;
    }

    /**
     * @return the animatorsCosts
     */
    public int getAnimatorsCosts() {
        return animatorsCosts;
    }

    /**
     * @param animatorsCosts the animatorsCosts to set
     */
    public void setAnimatorsCosts(int animatorsCosts) {
        this.animatorsCosts = animatorsCosts;
    }

    /**
     * @return the voiceActorsCosts
     */
    public int getVoiceActorsCosts() {
        return voiceActorsCosts;
    }

    /**
     * @param voiceActorsCosts the voiceActorsCosts to set
     */
    public void setVoiceActorsCosts(int voiceActorsCosts) {
        this.voiceActorsCosts = voiceActorsCosts;
    }

    /**
     * @return the plotTwistWritersCosts
     */
    public int getPlotTwistWritersCosts() {
        return plotTwistWritersCosts;
    }

    /**
     * @param plotTwistWritersCosts the plotTwistWritersCosts to set
     */
    public void setPlotTwistWritersCosts(int plotTwistWritersCosts) {
        this.plotTwistWritersCosts = plotTwistWritersCosts;
    }

    /**
     * @return the assemblersCosts
     */
    public int getAssemblersCosts() {
        return assemblersCosts;
    }

    /**
     * @param assemblersCosts the assemblersCosts to set
     */
    public void setAssemblersCosts(int assemblersCosts) {
        this.assemblersCosts = assemblersCosts;
    }

    /**
     * @return the projectManagerCosts
     */
    public int getProjectManagerCosts() {
        return projectManagerCosts;
    }

    /**
     * @param projectManagerCosts the projectManagerCosts to set
     */
    public void setProjectManagerCosts(int projectManagerCosts) {
        this.projectManagerCosts = projectManagerCosts;
    }

    /**
     * @return the directorCosts
     */
    public int getDirectorCosts() {
        return directorCosts;
    }

    /**
     * @param directorCosts the directorCosts to set
     */
    public void setDirectorCosts(int directorCosts) {
        this.directorCosts = directorCosts;
    }

    /**
     * @return the standardChaptersIncome
     */
    public int getStandardChaptersIncome() {
        return standardChaptersIncome;
    }

    /**
     * @param standardChaptersIncome the standardChaptersIncome to set
     */
    public void setStandardChaptersIncome(int standardChaptersIncome) {
        this.standardChaptersIncome = standardChaptersIncome;
    }

    /**
     * @return the plotTwistChaptersIncome
     */
    public int getPlotTwistChaptersIncome() {
        return plotTwistChaptersIncome;
    }

    /**
     * @param plotTwistChaptersIncome the plotTwistChaptersIncome to set
     */
    public void setPlotTwistChaptersIncome(int plotTwistChaptersIncome) {
        this.plotTwistChaptersIncome = plotTwistChaptersIncome;
    }

    /**
     * @return the totalOperationalCosts
     */
    public int getTotalOperationalCosts() {
        return totalOperationalCosts;
    }

    /**
     * @param totalOperationalCosts the totalOperationalCosts to set
     */
    public void setTotalOperationalCosts(int totalOperationalCosts) {
        this.totalOperationalCosts = totalOperationalCosts;
    }

    /**
     * @return the totalIncome
     */
    public int getTotalIncome() {
        return totalIncome;
    }

    /**
     * @param totalIncome the totalIncome to set
     */
    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * @return the totalProfit
     */
    public int getTotalProfit() {
        return totalProfit;
    }

    /**
     * @param totalProfit the totalProfit to set
     */
    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }

    /**
     * @return the userInterface
     */
    public MainUI getUserInterface() {
        return userInterface;
    }

    /**
     * @param userInterface the userInterface to set
     */
    public void setUserInterface(MainUI userInterface) {
        this.userInterface = userInterface;
    }

}
