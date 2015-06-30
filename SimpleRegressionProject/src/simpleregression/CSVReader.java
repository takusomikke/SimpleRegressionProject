package simpleregression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVReader{
    private List<String> idlist;
    private List<Double> para1list;
    private List<Double> para2list;
    private List<Double> codelist;

    public CSVReader(String filename){
        idlist = new ArrayList<String>();
        para1list = new ArrayList<Double>();
        para2list = new ArrayList<Double>();
        codelist = new ArrayList<Double>();

        try {
            //ファイルを読み込む
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ処理する
            String line;
            StringTokenizer token;
            while ((line = br.readLine()) != null) {
                int count = 0;

                //区切り文字","で分割する。
                token = new StringTokenizer(line, ",");

                //列ごとに別々のリストに値を入れていく。
                while (token.hasMoreTokens()) {
                    if(count == 0){
                        idlist.add(token.nextToken());
                    }else if(count ==1){
                        para1list.add(Double.parseDouble(token.nextToken()));
                    }else if(count==2){
                        para2list.add(Double.parseDouble(token.nextToken()));
                    }else if(count==3){
                        codelist.add(Double.parseDouble(token.nextToken()));
                    }

                    count++;
                }

            }

            //終了処理
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> getIdList(){
        return idlist;
    }

    public List<Double> getPara1List(){
        return para1list;
    }

    public List<Double> getPara2List(){
        return para2list;
    }

    public List<Double> getCodelist(){
        return codelist;
    }


}
