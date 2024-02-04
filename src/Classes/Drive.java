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
    private MainUI userInterface;
    private ChapterSpecs specs;

    public Drive(int studioInt, int maxScripts, int maxScenarios, int maxAnimations, int maxVoices,
            int maxPlotTwists, ChapterSpecs specs, MainUI userInterface) {
        this.studioInt = studioInt;
        this.chapterElements = new int[] { 0, 0, 0, 0, 0 };
        this.maxChapterElements = new int[] { maxScripts, maxScenarios, maxAnimations, maxVoices, maxPlotTwists };
        this.standardChaptersCounter = 0;
        this.plotTwistChaptersCounter = 0;
        this.userInterface = userInterface;
        this.specs = specs;
    }

    public void addElement(int typeInt) {
        if (typeInt == 5) {

        } else if (this.isNotFull(typeInt)) {
            this.increaseChapterElement(typeInt);
        }
        this.userInterface.changeDriveElements(getStudioInt(), typeInt, getChapterElements());

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

}
