package simpleregression;

import java.util.ArrayList;
import java.util.List;

public class DecideByMajority {
    private int judge;

    public DecideByMajority(ParameterData para1,ParameterData para2){

        List<Double> para1calccodelist = getCalcCodeList(para1);
        List<Double> para2calccodelist = getCalcCodeList(para2);

        for(int i = 0; i < para1calccodelist.size();i++){
            if(para1calccodelist.get(i) > para2calccodelist.get(i)){
                judge++;
            }else if(para1calccodelist.get(i) < para2calccodelist.get(i)){
                judge--;
            }
        }

    }

    public int getJudge(){
        return judge;
    }

    private List<Double> getCalcCodeList(ParameterData para){
        List<Double> paralist = para.getParalist();
        List<Double> calccodelist = new ArrayList<Double>();
        double intercept = para.getIntercept();
        double slope = para.getSlope();


        for(int i = 0; i < paralist.size();i++){
            calccodelist.add(slope*paralist.get(i)+intercept);
        }

        return calccodelist;
    }
}
