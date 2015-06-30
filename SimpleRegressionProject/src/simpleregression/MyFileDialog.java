package simpleregression;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.WindowListener;

public class MyFileDialog extends Frame implements WindowListener{
    private String filefullname;

    //コンストラクタ
    public MyFileDialog(){
        //FileDialogによるファイルの取得
        FileDialog fileDialog=new FileDialog(this);//FileDialogの作成
        fileDialog.setVisible(true);//表示する
        String dir=fileDialog.getDirectory();//ディレクトリーの取得
        String fileName=fileDialog.getFile();//File名の取得
        if (fileName==null) {
            System.exit(0);//ファイル名の設定が無ければ処理中止
        }else{
            this.filefullname=dir+fileName;
        }
    }

    public String getFileFullName(){
        return filefullname;
    }

    //アクティブになった特の処理
    @Override
    public void windowActivated(java.awt.event.WindowEvent e) {
        System.out.println("アクティブ");
    }

    //閉じられた時の処理
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        System.out.println("閉じられた！");
    }

    //閉じられている時の処理
    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
        System.out.println("閉じられる―！");
        System.exit(0);
    }

    //アクティブでなくなったときの処理
    @Override
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        System.out.println("わたしを見て！");
    }

    //アイコンから戻ったときの処理
    @Override
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        System.out.println("はーい！");
    }

    //アイコン化された時の処理
    @Override
    public void windowIconified(java.awt.event.WindowEvent e) {
        System.out.println("いやん");
    }

    // 開かれた時の処理
    @Override
    public void windowOpened(java.awt.event.WindowEvent e) {
        System.out.println("Hello,World!");
    }
}