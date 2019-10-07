package be.springPressOrder.domain;

import java.util.Date;

public class Prediction {

    private Date madePrediction;
    public enum PredictionState{LOW,AVERAGE,HIGH}
    private PredictionState predictionState;
    private Fruit predictedFruit;
    private Date beginPrediction;
    private Date endPrediction;

    public Prediction(Fruit predictedFruit, Date beginPrediction, Date endPrediction, PredictionState predictionState) {
        this.madePrediction = new Date();
        this.predictedFruit = predictedFruit;
        this.beginPrediction = beginPrediction;
        this.endPrediction = endPrediction;
        this.predictionState = predictionState;
    }

    public Date getMadePrediction() {
        return madePrediction;
    }

    public Fruit getPredictedFruit() {
        return predictedFruit;
    }

    public Date getBeginPrediction() {
        return beginPrediction;
    }

    public Date getEndPrediction() {
        return endPrediction;
    }

    public PredictionState getPredictionState() { return predictionState; }

}
