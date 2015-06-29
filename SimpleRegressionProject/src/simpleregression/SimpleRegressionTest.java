package simpleregression;

import java.util.List;
import java.util.Scanner;

public class SimpleRegressionTest {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        //ファイル名を読み込みます。
        System.out.println("読み込むファイルの完全パスを入力してください。");

        //ファイルを読み込み、内部で列ごとのリストを生成。
        SCVReader scvreader = new SCVReader(sc.next());

        //それぞれの列のデータを格納
        List<Double> coffeelist = scvreader.getPara1List();
        List<Double> lunchlist = scvreader.getPara2List();
        List<Double> codelist = scvreader.getCodelist();

        //コーヒー列とコード列の相関関係を求める。
        //二つの列から計算される傾きと切片を格納したParameterData型が返ってくる。
        FindSimpleRegression coffeefsr= new FindSimpleRegression(coffeelist,codelist);
        ParameterData coffeedata = coffeefsr.getParameterData();

        /* ランチ列とコード列の相関関係を求める。
         * 二つの列から計算される傾きと切片を格納したParameterData型が返ってくる。
         */
        FindSimpleRegression lunchfsr= new FindSimpleRegression(lunchlist,codelist);
        ParameterData lunchdata = lunchfsr.getParameterData();

        /* それぞれのParameterDataを渡し、どちらに優位性があるかの判定が返ってくる。
         * 第一引数に優位性があれば正の値が
         * 第二引数に優位性があれば負の値が
         * どちらも同じ優位性なら0が返ってくる。
         */
        DecideByMajority dbm = new DecideByMajority(coffeedata,lunchdata);
        int judge = dbm.getJudge();

        if(judge > 0){
            System.out.println("コーヒーとの方が相関があります。");
        }else if(judge < 0){
            System.out.println("ランチとの方が相関があります。");
        }else{
            System.out.println("どちらも同等の相関があります。");
        }

    }
}
