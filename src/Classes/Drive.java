package Classes;

import UserInterface.MainUI;

/**
 *
 * @author David
 */
public class Drive {

    private int[] chapterElements;
    private int[] maxChapterElements; // 4
    private int standardChaptersCounter;
    private int plotTwistChaptersCounter;
    private MainUI userInterface;

    public Drive(int maxScripts, int maxScenarios, int maxAnimations, int maxVoices,
            int maxPlotTwists, MainUI userInterface) {
        this.chapterElements = new int[] { 0, 0, 0, 0, 0, 0 };
        this.maxChapterElements = new int[] { maxScripts, maxScenarios, maxAnimations, maxVoices, maxPlotTwists };
        this.standardChaptersCounter = 0;
        this.plotTwistChaptersCounter = 0;
        this.userInterface = userInterface;
    }

    public void addElement(int typeInt) {
        if (this.isNotFull(typeInt)) {
            this.increaseChapterElement(typeInt);
        }
    }

    private int getAmountByWorkerTypeIndex(int index) {
        return this.chapterElements[index];
    }

    private int getMaxByWorkerTypeIndex(int index) {
        return this.maxChapterElements[index];
    }

    private boolean isNotFull(int index) {
        return this.getAmountByWorkerTypeIndex(index) < this.getMaxByWorkerTypeIndex(index);
    }

    private void increaseChapterElement(int index) {
        this.chapterElements[index]++;
    }

}
