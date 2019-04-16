package com.ashish.microservices.limitservice.controller;

public class LimitConfiguration {
    private int min;
    private int max;

    public LimitConfiguration() {

    }

    public LimitConfiguration(int maximum, int minimum) {
        super();
        this.max = maximum;
        this.min = minimum;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
