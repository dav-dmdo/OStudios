package Config;

import Classes.ChapterSpecs;

/**
 *
 * @author Rolando
 */
public class Parameters {

    private WorkerParams screenwritersParams;
    private WorkerParams scenarioDesignersParams;
    private WorkerParams animatorsParams;
    private WorkerParams voiceActorsParams;
    private WorkerParams plotTwistsWritersParams;
    private WorkerParams assemblersParams;
    private ChapterSpecs chapterSpecs;

    // Constructor with parameters
    public Parameters() {
        this.screenwritersParams = new WorkerParams(1, 0);
        this.scenarioDesignersParams = new WorkerParams(1, 0);
        this.animatorsParams = new WorkerParams(1, 0);
        this.voiceActorsParams = new WorkerParams(1, 0);
        this.plotTwistsWritersParams = new WorkerParams(1, 0);
        this.assemblersParams = new WorkerParams(1, 0);
    }

    // Constructor with parameters
    public Parameters(WorkerParams screenwriters, WorkerParams scenarioDesigners, WorkerParams animators,
            WorkerParams voiceActors, WorkerParams plotTwistWriters,
            WorkerParams assemblers, ChapterSpecs specs) {
        this.screenwritersParams = screenwriters;
        this.scenarioDesignersParams = scenarioDesigners;
        this.animatorsParams = animators;
        this.voiceActorsParams = voiceActors;
        this.plotTwistsWritersParams = plotTwistWriters;
        this.assemblersParams = assemblers;
        this.chapterSpecs = specs;
    }

    // Getters and Setters
    public WorkerParams getScreenwritersParams() {
        return screenwritersParams;
    }

    public void setScreenwritersParams(WorkerParams screenwritersParams) {
        this.screenwritersParams = screenwritersParams;
    }

    public WorkerParams getScenarioDesignersParams() {
        return scenarioDesignersParams;
    }

    public void setScenarioDesignersParams(WorkerParams scenarioDesignersParams) {
        this.scenarioDesignersParams = scenarioDesignersParams;
    }

    public WorkerParams getAnimatorsParams() {
        return animatorsParams;
    }

    public void setAnimatorsParams(WorkerParams animatorsParams) {
        this.animatorsParams = animatorsParams;
    }

    public WorkerParams getVoiceActorsParams() {
        return voiceActorsParams;
    }

    public void setVoiceActorsParams(WorkerParams voiceActorsParams) {
        this.voiceActorsParams = voiceActorsParams;
    }

    public WorkerParams getPlotTwistsWritersParams() {
        return plotTwistsWritersParams;
    }

    public void setPlotTwistsWritersParams(WorkerParams plotTwistsWritersParams) {
        this.plotTwistsWritersParams = plotTwistsWritersParams;
    }

    public WorkerParams getAssemblersParams() {
        return assemblersParams;
    }

    public void setAssemblersParams(WorkerParams assemblersParams) {
        this.assemblersParams = assemblersParams;
    }

    public ChapterSpecs getChapterSpecs() {
        return chapterSpecs;
    }

    public void setChapterSpecs(ChapterSpecs specs) {
        this.chapterSpecs = specs;
    }

}
