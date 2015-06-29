package simpleregression;

import java.util.List;

public class ParameterData {
    private List<Double> paralist;
    private List<Double> codelist;
    private double intercept;
    private double slope;

    public ParameterData(List<Double> paralist,List<Double> codelist, double intercept, double slope){
        this.paralist = paralist;
        this.codelist = codelist;
        this.intercept = intercept;
        this.slope = slope;

    }

    public List<Double> getParalist(){
        return paralist;
    }

    public List<Double> getCodelist(){
        return codelist;
    }

    public double getIntercept(){
        return intercept;
    }

    public double getSlope(){
        return slope;
    }

}
