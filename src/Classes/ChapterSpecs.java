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

    private int[] plotTwistChaptersSpecs;
    private int plotTwistChaptersPrice;
    private int[] standardChaptersSpecs;
    private int standardChaptersPrice;
    private int policyForPlotTwist;

    public ChapterSpecs(int[] plotTwistChaptersSpecs, int plotTwistChaptersPrice, int[] standardChaptersSpecs,
            int standardChaptersPrice, int policyForPlotTwist) {
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
        return this.checkChapterSpecs(chapterElements, this.getStandardChaptersSpecs());
    }

    public boolean checkPlotTwistChapterSpecs(int[] chapterElements) {
        return this.checkChapterSpecs(chapterElements, this.getPlotTwistChaptersSpecs());
    }

    private void setChapterSpecs(int studioInt) {
        boolean isNick = (studioInt == 0);

        setPlotTwistChaptersSpecs((isNick) ? new int[] { 2, 1, 4, 4, 2 } : new int[] { 1, 2, 6, 5, 1 });
        setPlotTwistChaptersPrice((isNick) ? 500000 : 650000);
        setStandardChaptersSpecs((isNick) ? new int[] { 2, 1, 4, 4, 0 } : new int[] { 1, 2, 6, 5, 0 });
        setStandardChaptersPrice((isNick) ? 450000 : 300000);
        setPolicyForPlotTwist((isNick) ? 5 : 3);
    }

    /**
     * @return the plotTwistChaptersSpecs
     */
    public int[] getPlotTwistChaptersSpecs() {
        return plotTwistChaptersSpecs;
    }

    /**
     * @param plotTwistChaptersSpecs the plotTwistChaptersSpecs to set
     */
    public void setPlotTwistChaptersSpecs(int[] plotTwistChaptersSpecs) {
        this.plotTwistChaptersSpecs = plotTwistChaptersSpecs;
    }

    /**
     * @return the plotTwistChaptersPrice
     */
    public int getPlotTwistChaptersPrice() {
        return plotTwistChaptersPrice;
    }

    /**
     * @param plotTwistChaptersPrice the plotTwistChaptersPrice to set
     */
    public void setPlotTwistChaptersPrice(int plotTwistChaptersPrice) {
        this.plotTwistChaptersPrice = plotTwistChaptersPrice;
    }

    /**
     * @return the standardChaptersSpecs
     */
    public int[] getStandardChaptersSpecs() {
        return standardChaptersSpecs;
    }

    /**
     * @param standardChaptersSpecs the standardChaptersSpecs to set
     */
    public void setStandardChaptersSpecs(int[] standardChaptersSpecs) {
        this.standardChaptersSpecs = standardChaptersSpecs;
    }

    /**
     * @return the standardChaptersPrice
     */
    public int getStandardChaptersPrice() {
        return standardChaptersPrice;
    }

    /**
     * @param standardChaptersPrice the standardChaptersPrice to set
     */
    public void setStandardChaptersPrice(int standardChaptersPrice) {
        this.standardChaptersPrice = standardChaptersPrice;
    }

    /**
     * @return the policyForPlotTwist
     */
    public int getPolicyForPlotTwist() {
        return policyForPlotTwist;
    }

    /**
     * @param policyForPlotTwist the policyForPlotTwist to set
     */
    public void setPolicyForPlotTwist(int policyForPlotTwist) {
        this.policyForPlotTwist = policyForPlotTwist;
    }

}
