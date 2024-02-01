/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OtherClasses;

/**
 *
 * @author david
 */
public class Drive {
    private int[] chapterElements = {0,0,0,0,0,0};
    private int[] maxChapterElements;
    private int maxScripts;     //0
    private int maxScenarios;   //1 
    private int maxAnimations;  //2
    private int maxVoices;      //3
    private int maxPlotTwists;  //4
    private int standardChaptersCounter;
    private int plotTwistChaptersCounter;

    public Drive(int[] maxChapterElements, int maxScripts, int maxScenarios, int maxAnimations, int maxVoices, int maxPlotTwists) {
        this.maxChapterElements = new int[] {maxScripts, maxScenarios, maxAnimations, maxVoices, maxPlotTwists};
        this.maxScripts = maxScripts ;
        this.maxScenarios =maxScenarios ;
        this.maxAnimations = maxAnimations;
        this.maxVoices = maxVoices;
        this.maxPlotTwists = maxPlotTwists;
        this.standardChaptersCounter = 0;
        this.plotTwistChaptersCounter = 0;
    }
    
    public void addElement(int typeInt){
        if (this.isNotFull(typeInt)){
            this.increaseChapterElement(typeInt);
        }
    }
    
    private int getAmount(int index){
        return this.chapterElements[index];
    }
    
    private int getMax(int index){
        return this.maxChapterElements[index];
    }
    
    private boolean isNotFull(int index){
        return this.getAmount(index)<this.getMax(index);
    }
    
    private void increaseChapterElement(int index){
        this.chapterElements[index]++;
    }
    
    
    
}
