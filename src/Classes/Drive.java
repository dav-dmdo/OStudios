package Classes;

import UserInterface.MainUI;

/**
 *
 * @author David
 */
public class Drive {

    private int studioInt;
    private int[] chapterElements;
    private final int[] maxChapterElements;
    private int standardChaptersCounter;
    private int plotTwistChaptersCounter;
    private int nextPlotTwistChapter;
    private MainUI userInterface;
    private ChapterSpecs specs;

    public Drive(int studioInt, int maxScripts, int maxScenarios, int maxAnimations, int maxVoices,
            int maxPlotTwists, ChapterSpecs specs, MainUI userInterface) {
        this.studioInt = studioInt;
        this.chapterElements = new int[]{0, 0, 0, 0, 0};
        this.maxChapterElements = new int[]{maxScripts, maxScenarios, maxAnimations, maxVoices, maxPlotTwists};
        this.standardChaptersCounter = 0;
        this.plotTwistChaptersCounter = 0;
        this.userInterface = userInterface;
        this.specs = specs;
        this.nextPlotTwistChapter = this.specs.policyForPlotTwist;

        // nextPlotTwistChapter
        // iniciara siendo igual a la cantidad de la politica e ira disminuyendo hasta llegar a 0.
        // cuando llegue a cero, se debe crear capPlotTwist y resetear la cuenta.
    }

    public void addElement(int typeInt) {
        if (typeInt == 5) {
            this.addChapter();
        } else if (this.isNotFull(typeInt)) {
            this.increaseChapterElement(typeInt);
        }
        this.userInterface.changeDriveElements(getStudioInt(), typeInt, getChapterElements());

    }

    private void addChapter() {
        if (this.isTimeToPlotTwistChapter()) {
            this.addPlotTwistChapter();
        } else {
            this.addStandardChapter();
        }
    }

    private void resetNextPlotTwistChapter() {
        this.nextPlotTwistChapter = this.specs.policyForPlotTwist;
    }

    private boolean isTimeToPlotTwistChapter() {
        return this.nextPlotTwistChapter == 0;
    }
    
    private boolean isTimeToStandadrChapter(){
        return !this.isTimeToPlotTwistChapter();
    }

    private void subtractChapterElements(int[] specificChapterSpecs) {
        for (int i = 0; i < chapterElements.length; i++) {
            chapterElements[i] = chapterElements[i] - specificChapterSpecs[i];
        }
    }

    private void addStandardChapter() {
        this.subtractChapterElements(this.specs.standardChaptersSpecs);
        this.standardChaptersCounter++;
        this.nextPlotTwistChapter--;
    }

    private void addPlotTwistChapter() {
        this.subtractChapterElements(this.specs.plotTwistChaptersSpecs);
        this.plotTwistChaptersCounter++;
        this.resetNextPlotTwistChapter();
    }

    public boolean canAssembleStandardChapter(){
        return this.specs.checkStandardChapterSpecs(chapterElements);
    }
    
    public boolean canAssemblePlotTwistChapter(){
        return this.specs.checkStandardChapterSpecs(chapterElements);
    }
    
    public boolean canAssembleChapter(){
        boolean isTimeToStandardAndEnoughElements = ((this.isTimeToStandadrChapter()) && (this.canAssembleStandardChapter()));
        boolean isTimeToPlotTwistAndEnoughElements = ((this.isTimeToPlotTwistChapter()) && (this.canAssemblePlotTwistChapter()));
        return (isTimeToStandardAndEnoughElements || isTimeToPlotTwistAndEnoughElements);
    }
    
    
    private int getAmountByWorkerTypeIndex(int index) {
        return this.getChapterElements()[index];
    }

    private int getMaxByWorkerTypeIndex(int index) {
        return this.maxChapterElements[index];
    }

    private boolean isNotFull(int index) {
        return this.getAmountByWorkerTypeIndex(index) < this.getMaxByWorkerTypeIndex(index);
    }

    private void increaseChapterElement(int workerType) {
        this.getChapterElements()[workerType]++;
    }

    //Getters and Setters
    /**
     * @return the chapterElements
     */
    public int[] getChapterElements() {
        return chapterElements;
    }

    /**
     * @param chapterElements the chapterElements to set
     */
    public void setChapterElements(int[] chapterElements) {
        this.chapterElements = chapterElements;
    }

    public int getStudioInt() {
        return studioInt;
    }

    public void setStudioInt(int studioInt) {
        this.studioInt = studioInt;
    }

    /**
     * @return the specs
     */
    public ChapterSpecs getSpecs() {
        return specs;
    }

}
