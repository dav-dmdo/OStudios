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
        this.screenwritersParams = new WorkerParams(1, 0, "", 0);
        this.scenarioDesignersParams = new WorkerParams(1, 0, "", 0);
        this.animatorsParams = new WorkerParams(1, 0, "", 0);
        this.voiceActorsParams = new WorkerParams(1, 0, "", 0);
        this.plotTwistsWritersParams = new WorkerParams(1, 0, "", 0);
        this.assemblersParams = new WorkerParams(1, 0, "", 0);
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

    public WorkerParams getWorkerParamsByType(int workerType) {
        return switch (workerType) {
            case 0 ->
                getScreenwritersParams();
            case 1 ->
                getScenarioDesignersParams();
            case 2 ->
                getAnimatorsParams();
            case 3 ->
                getVoiceActorsParams();
            case 4 ->
                getPlotTwistsWritersParams();
            case 5 ->
                getAssemblersParams();
            default ->
                null;
        };
    }

    public WorkerParams getParamsByWorkerType(int workerType) {
        switch (workerType) {

            case 0 -> {
                return getScreenwritersParams();
            }

            case 1 -> {
                return getScenarioDesignersParams();
            }

            case 2 -> {
                return getAnimatorsParams();
            }

            case 3 -> {
                return getVoiceActorsParams();
            }

            case 4 -> {
                return getPlotTwistsWritersParams();
            }

            case 5 -> {
                return getAssemblersParams();
            }

            default -> {
                WorkerParams unassignedParams = new WorkerParams(0, 0, "Unassigned", 0);
                return unassignedParams;
            }
        }
    }

    public void setParamsQuantityByWorkerType(int workerType, int newQuantity) {
        switch (workerType) {

            case 0 -> {
                getScreenwritersParams().setQuantity(newQuantity);
            }

            case 1 -> {
                getScenarioDesignersParams().setQuantity(newQuantity);
            }

            case 2 -> {
                getAnimatorsParams().setQuantity(newQuantity);
            }

            case 3 -> {
                getVoiceActorsParams().setQuantity(newQuantity);
            }

            case 4 -> {
                getPlotTwistsWritersParams().setQuantity(newQuantity);
            }

            case 5 -> {
                getAssemblersParams().setQuantity(newQuantity);
            }

            default -> {
            }
        }
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
