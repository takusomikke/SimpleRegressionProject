package simpleregression;

import java.util.ArrayList;
import java.util.List;

public class DecideByMajority {
    private int judge;

    public DecideByMajority(ParameterData para1,ParameterData para2){

        List<Double> para1diffcodelist = getDifferenceOfCodeList(para1);
        List<Double> para2diffcodelist = getDifferenceOfCodeList(para2);

        for(int i = 0; i < para1diffcodelist.size();i++){
            if(para1diffcodelist.get(i) < para2diffcodelist.get(i)){
                judge++;
            }else if(para1diffcodelist.get(i) > para2diffcodelist.get(i)){
                judge--;
            }
        }
    }

    public int getJudge(){
        return judge;
    }

    /*
     * 線形回帰によって得られたデータで計算したコード量と
     * 実際のコード量を比較し、その差の絶対値をリストに入れて返す。
     */
    private List<Double> getDifferenceOfCodeList(ParameterData para){
        List<Double> paralist = para.getParalist();
        List<Double> differencecodelist = new ArrayList<Double>();
        double intercept = para.getIntercept();
        double slope = para.getSlope();

        for(int i = 0; i < paralist.size();i++){
            differencecodelist.add(Math.abs((slope*paralist.get(i)+intercept)-paralist.get(i)));
        }

        return differencecodelist;
    }
}
