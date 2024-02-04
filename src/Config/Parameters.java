package Config;

import Classes.ChapterSpecs;

/**
 *
 * @author Rolando
 */
public class Parameters {

    private int screenwriters;
    private int scenarioDesigners;
    private int animators;
    private int voiceActors;
    private int plotTwistWriters;
    private int assemblers;
    private ChapterSpecs chapterSpecs;

    //Constructor without parameters
    public Parameters() {
        this.screenwriters = 1;
        this.scenarioDesigners = 1;
        this.animators = 1;
        this.voiceActors = 1;
        this.plotTwistWriters = 1;
        this.assemblers = 1;
    }

    //Constructor with parameters
    public Parameters(int screenwriters, int scenarioDesigners, int animators, int voiceActors, int plotTwistWriters, int assemblers, ChapterSpecs specs) {
        this.screenwriters = screenwriters;
        this.scenarioDesigners = scenarioDesigners;
        this.animators = animators;
        this.voiceActors = voiceActors;
        this.plotTwistWriters = plotTwistWriters;
        this.assemblers = assemblers;
        this.chapterSpecs = specs;
    }

    //Getters and Setters
    public int getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(int screenwriters) {
        this.screenwriters = screenwriters;
    }

    public int getScenarioDesigners() {
        return scenarioDesigners;
    }

    public void setScenarioDesigners(int scenarioDesigners) {
        this.scenarioDesigners = scenarioDesigners;
    }

    public int getAnimators() {
        return animators;
    }

    public void setAnimators(int animators) {
        this.animators = animators;
    }

    public int getVoiceActors() {
        return voiceActors;
    }

    public void setVoiceActors(int voiceActors) {
        this.voiceActors = voiceActors;
    }

    public int getPlotTwistWriters() {
        return plotTwistWriters;
    }

    public void setPlotTwistWriters(int plotTwistWriters) {
        this.plotTwistWriters = plotTwistWriters;
    }

    public int getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(int assemblers) {
        this.assemblers = assemblers;
    }

    public ChapterSpecs getChapterSpecs() {
        return chapterSpecs;
    }

    public void setChapterSpecs(ChapterSpecs specs) {
        this.chapterSpecs = specs;
    }

}
