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
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

/**
 * La clase ChartManager maneja la creación y actualización de gráficos en
 * tiempo real para visualizar las ganancias de Nickelodeon y Cartoon Network.
 * Utiliza la biblioteca JFreeChart para crear un gráfico de líneas XY que se
 * actualiza periódicamente en función de la duración del día establecida en la
 * aplicación.
 */
public class Charts {

    private Config config;
    private XYSeries seriesNickelodeon;
    private XYSeries seriesCartoonNetwork;
    private XYSeriesCollection dataset;
    private JFreeChart lineChart;
    private Timer timer;
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
                "Profit",
                "Profit",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false // URLs
        );

        int delay = config.getDayDuration();
        setTimer(new Timer(delay, e -> updateChartData()));
        getTimer().start();

    }

    /**
     * Method to customize chart appearance
     */
    private void customizeChartUI(Color color) {
        XYPlot plot = getLineChart().getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesPaint(0, color);
        plot.setRenderer(renderer);
    }

    /**
     * Actualiza las series de datos con las ganancias más recientes de
     * Nickelodeon y Cartoon Network y las agrega al gráfico.
     */
    public void updateChartData() {
        double nickelodeonProfit = getNickelodeon().getAccountant().getTotalProfit();
        double cartoonNetworkProfit = getCartoonNetwork().getAccountant().getTotalProfit();
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

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
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
