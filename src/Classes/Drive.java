package Classes;

import UserInterface.MainUI;

/**
 *
 * @author David
 */
public class Drive {

    private int studioInt;
    private int[] chapterElements;
    private int[] maxChapterElements;
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
        this.nextPlotTwistChapter = specs.getPolicyForPlotTwist();

        // nextPlotTwistChapter
        // iniciara siendo igual a la cantidad de la politica e ira disminuyendo hasta llegar a 0.
        // cuando llegue a cero, se debe crear capPlotTwist y resetear la cuenta.
    }



    /**
     * This is the actual addElement function.
     *
     * @param typeInt
     * @param elementQuantity
     */
    public void addElement(int typeInt, int elementQuantity) {
        if (this.isNotFull(typeInt)) {
            this.increaseChapterElement(typeInt, elementQuantity);
        }
        this.getUserInterface().changeDriveElements(getStudioInt(), typeInt, getChapterElements());

    }

    

    public void addChapterByType(int chapterType) {
        switch (chapterType) {
            case 0:
                this.setStandardChaptersCounter(this.getStandardChaptersCounter() + 1);
                this.setNextPlotTwistChapter(this.getNextPlotTwistChapter() - 1);
                this.getUserInterface().changeChapterQuantity(this.getStudioInt(), 0, this.getStandardChaptersCounter());
                break;
            case 1:
                this.setPlotTwistChaptersCounter(this.getPlotTwistChaptersCounter() + 1);
                this.resetNextPlotTwistChapter();
                this.getUserInterface().changeChapterQuantity(this.getStudioInt(), 1, this.getPlotTwistChaptersCounter());
                break;
            default:
                break;
        }
        
    }

    private boolean isTimeToPlotTwistChapter() {
        return this.getNextPlotTwistChapter() == 0;
    }

  

    private void addPlotTwistChapter() {
        this.subtractChapterElements(this.getSpecs().getPlotTwistChaptersSpecs());
        //this.plotTwistChaptersCounter++; // creo debo sumar desde worker
        this.resetNextPlotTwistChapter();
    }

    private void subtractChapterElements(int[] specificChapterSpecs) {
        for (int i = 0; i < getChapterElements().length; i++) {
            getChapterElements()[i] = getChapterElements()[i] - specificChapterSpecs[i];
        }
    }

    public void subtractChapterElements(int chapterType) {
        switch (chapterType) {
            case 0:
                this.subtractChapterElements(this.getSpecs().getStandardChaptersSpecs());
                break;
            case 1:
                this.subtractChapterElements(this.getSpecs().getPlotTwistChaptersSpecs());
                break;
            default:
                break;

        }

    }

    private void resetNextPlotTwistChapter() {
        this.setNextPlotTwistChapter(this.getSpecs().getPolicyForPlotTwist());
    }

    private boolean isTimeToStandardChapter() {
        return !this.isTimeToPlotTwistChapter();
    }

    public boolean canAssembleStandardChapter() {
        return this.getSpecs().checkStandardChapterSpecs(getChapterElements());
    }

    public boolean canAssemblePlotTwistChapter() {
        return this.getSpecs().checkStandardChapterSpecs(getChapterElements());
    }


    public int decideWhichChapterToAssemble() {
        int chapterType = -1;
        if (this.canAssembleStandardAndEnoughElements()) {
            chapterType = 0;
        } else if (this.canAssemblePlotTwistAndEnoughElements()) {
            chapterType = 1;
        }
        return chapterType;
    }

    public boolean canAssembleStandardAndEnoughElements() {
        return this.isTimeToStandardChapter() && this.canAssembleStandardChapter();
    }

    public boolean canAssemblePlotTwistAndEnoughElements() {
        return this.isTimeToPlotTwistChapter() && this.canAssemblePlotTwistChapter();
    }

    private int getAmountByWorkerTypeIndex(int index) {
        return this.getChapterElements()[index];
    }

    private int getMaxByWorkerTypeIndex(int index) {
        return this.getMaxChapterElements()[index];
    }

    private boolean isNotFull(int index) {
        return this.getAmountByWorkerTypeIndex(index) < this.getMaxByWorkerTypeIndex(index);
    }

    

    private void increaseChapterElement(int workerType, int elementQuantity) {
        int currentElementQuantity = this.getChapterElements()[workerType];
        int maxChapterElement = this.getMaxChapterElements()[workerType];
        if ((currentElementQuantity + elementQuantity) > maxChapterElement) {
            this.getChapterElements()[workerType] = maxChapterElement;
        } else {
            this.getChapterElements()[workerType] += elementQuantity;

        }
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
        this.setChapterElements( chapterElements);
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

    /**
     * @return the maxChapterElements
     */
    public int[] getMaxChapterElements() {
        return maxChapterElements;
    }

    /**
     * @param maxChapterElements the maxChapterElements to set
     */
    public void setMaxChapterElements(int[] maxChapterElements) {
        this.maxChapterElements = maxChapterElements;
    }

    /**
     * @return the standardChaptersCounter
     */
    public int getStandardChaptersCounter() {
        return standardChaptersCounter;
    }

    /**
     * @param standardChaptersCounter the standardChaptersCounter to set
     */
    public void setStandardChaptersCounter(int standardChaptersCounter) {
        this.standardChaptersCounter = standardChaptersCounter;
    }

    /**
     * @return the plotTwistChaptersCounter
     */
    public int getPlotTwistChaptersCounter() {
        return plotTwistChaptersCounter;
    }

    /**
     * @param plotTwistChaptersCounter the plotTwistChaptersCounter to set
     */
    public void setPlotTwistChaptersCounter(int plotTwistChaptersCounter) {
        this.plotTwistChaptersCounter = plotTwistChaptersCounter;
    }

    /**
     * @return the nextPlotTwistChapter
     */
    public int getNextPlotTwistChapter() {
        return nextPlotTwistChapter;
    }

    /**
     * @param nextPlotTwistChapter the nextPlotTwistChapter to set
     */
    public void setNextPlotTwistChapter(int nextPlotTwistChapter) {
        this.nextPlotTwistChapter = nextPlotTwistChapter;
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

    /**
     * @param specs the specs to set
     */
    public void setSpecs(ChapterSpecs specs) {
        this.specs = specs;
    }
    
    
        /**
     *  
     * @deprecated @param typeInt
     */
    public void addElement(int typeInt) {
        if (typeInt == 5) {
            this.addChapter();
        } else if (this.isNotFull(typeInt)) {
            this.increaseChapterElement(typeInt);
        }
        this.getUserInterface().changeDriveElements(getStudioInt(), typeInt, getChapterElements());

    }
    /**
     * @deprecated
     */
    private void addChapter() {
        if (this.isTimeToPlotTwistChapter()) {
            this.addPlotTwistChapter();
        } else {
            this.addStandardChapter();
        }
    }
    
      /**
     * @deprecated
     */
    private void addStandardChapter() {
        this.subtractChapterElements(this.getSpecs().getStandardChaptersSpecs());
        //this.standardChaptersCounter++; // creo debo sumar desde worker
        this.setNextPlotTwistChapter(this.getNextPlotTwistChapter() - 1);
    }
    
    
    /**
     * @deprecated 
     * @return 
     */
    public boolean canAssembleChapter() {
        boolean isTimeToStandardAndEnoughElements = this.isTimeToStandardChapter() && this.canAssembleStandardChapter();
        boolean isTimeToPlotTwistAndEnoughElements = this.isTimeToPlotTwistChapter() && this.canAssemblePlotTwistChapter();
        return (isTimeToStandardAndEnoughElements || isTimeToPlotTwistAndEnoughElements);
    }
    
    /**
     * @deprecated 
     * @param workerType 
     */
    private void increaseChapterElement(int workerType) {
        this.getChapterElements()[workerType]++;
    }

}
