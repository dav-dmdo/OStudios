/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Rolando
 */
import Config.Config;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

public class Charts {

    private Config config;
    private XYSeries seriesNickelodeon;
    private XYSeries seriesCartoonNetwork;
    private XYSeriesCollection dataset;
    private JFreeChart lineChart;
    private AnimationStudio nickelodeon;
    private AnimationStudio cartoonNetwork;

    /**
     * Constructor
     *
     * @param nickelodeon
     * @param cartoonNetwork
     */
    public Charts(AnimationStudio nickelodeon, AnimationStudio cartoonNetwork, Config config) {
        this.nickelodeon = nickelodeon;
        this.cartoonNetwork = cartoonNetwork;

        seriesNickelodeon = new XYSeries("Nickelodeon");
        seriesCartoonNetwork = new XYSeries("Cartoon Network");
        dataset = new XYSeriesCollection();

        dataset.addSeries(seriesNickelodeon);
        dataset.addSeries(seriesCartoonNetwork);

        lineChart = ChartFactory.createXYLineChart(
                "Time vs Profit",
                "Time",
                "Profit",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false // URLs
        );

    }

    /**
     * Method to customize chart appearance
     */
    public void customizeChartUI(Color color) {
        XYPlot plot = getLineChart().getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesPaint(0, color);
        plot.setRenderer(renderer);
    }

    public void updateChartData() {
        int nickelodeonProfit = getNickelodeon().getAccountant().getTotalProfitChart();
        int cartoonNetworkProfit = getCartoonNetwork().getAccountant().getTotalProfitChart();

        int newTimestamp = getSeriesNickelodeon().getItemCount() + 1;

        getSeriesNickelodeon().addOrUpdate(newTimestamp, nickelodeonProfit);
        getSeriesCartoonNetwork().addOrUpdate(newTimestamp, cartoonNetworkProfit);
    }

    public ChartPanel getChartPanel() {
        return new ChartPanel(lineChart);
    }

    public AnimationStudio getNickelodeon() {
        return nickelodeon;
    }

    public void setNickelodeon(AnimationStudio nickelodeon) {
        this.nickelodeon = nickelodeon;
    }

    public AnimationStudio getCartoonNetwork() {
        return cartoonNetwork;
    }

    public void setCartoonNetwork(AnimationStudio cartoonNetwork) {
        this.cartoonNetwork = cartoonNetwork;
    }

    public XYSeries getSeriesNickelodeon() {
        return seriesNickelodeon;
    }

    public void setSeriesNickelodeon(XYSeries seriesNickelodeon) {
        this.seriesNickelodeon = seriesNickelodeon;
    }

    public XYSeries getSeriesCartoonNetwork() {
        return seriesCartoonNetwork;
    }

    public void setSeriesCartoonNetwork(XYSeries seriesCartoonNetwork) {
        this.seriesCartoonNetwork = seriesCartoonNetwork;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public JFreeChart getLineChart() {
        return lineChart;
    }

    public void setLineChart(JFreeChart lineChart) {
        this.lineChart = lineChart;
    }

}
