package simpleregression;

import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class FindSimpleRegression {

    private ParameterData parameterdata;

    public FindSimpleRegression(List<Double> paralist, List<Double> codelist){
        SimpleRegression regression = new SimpleRegression();

        for(int i = 0; i < paralist.size();i++){
            regression.addData(paralist.get(i),codelist.get(i));
        }

        double intercept = regression.getIntercept();
        double slope = regression.getSlope();

        parameterdata = new ParameterData(paralist,codelist,intercept,slope);
    }

    public ParameterData getParameterData(){
        return parameterdata;
    }

}
