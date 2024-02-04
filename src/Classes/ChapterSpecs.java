/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author david
 */
public class ChapterSpecs {

    public int[] plotTwistChaptersSpecs;
    public int plotTwistChaptersPrice;
    public int[] standardChaptersSpecs;
    public int standardChaptersPrice;
    public int policyForPlotTwist;

    public ChapterSpecs(int[] plotTwistChaptersSpecs, int plotTwistChaptersPrice, int[] standardChaptersSpecs, int standardChaptersPrice, int policyForPlotTwist) {
        this.plotTwistChaptersSpecs = plotTwistChaptersSpecs;
        this.plotTwistChaptersPrice = plotTwistChaptersPrice;
        this.standardChaptersSpecs = standardChaptersSpecs;
        this.standardChaptersPrice = standardChaptersPrice;
        this.policyForPlotTwist = policyForPlotTwist;
    }

    public ChapterSpecs(int studioInt) {
        this.setChapterSpecs(studioInt);
    }

    private boolean checkChapterSpecs(int[] chapterElements, int[] chapterSpecs) {
        boolean flag = true;

        for (int i = 0; (i < chapterElements.length) && (flag); i++) {
            flag = (chapterElements[i] >= chapterSpecs[i]);
        }
        return flag;
    }

    public boolean checkStandardChapterSpecs(int[] chapterElements) {
        return this.checkChapterSpecs(chapterElements, this.standardChaptersSpecs);
    }

    public boolean checkPlotTwistChapterSpecs(int[] chapterElements) {
        return this.checkChapterSpecs(chapterElements, this.plotTwistChaptersSpecs);
    } 

    private void setChapterSpecs(int studioInt) {
        boolean isNick = (studioInt == 0);
        
        this.plotTwistChaptersSpecs = (isNick) ? new int[]{2, 1, 4, 4, 2} : new int[]{1, 2, 6, 5, 1};
        this.plotTwistChaptersPrice = (isNick) ? 500000 : 650000;
        this.standardChaptersSpecs = (isNick) ? new int[]{2, 1, 4, 4, 0} : new int[]{1, 2, 6, 5, 0};
        this.standardChaptersPrice = (isNick) ? 450000 : 300000;
        this.policyForPlotTwist = (isNick) ? 5 : 3;
    }
}
