package Ch08;

import java.io.IOException;
import java.util.Scanner;
/*請由鍵盤讀入一組分數，並檢視每個分數，如果有分數為介於1~100，則顯示
  "這不是一個合法分數"的訊息。請用自訂Exception來完成。
 */
public class Q08_03 {
 public static void main(String[] args) throws IOException {   //throws 宣告法則 來處理例外
  Scanner scanner = new Scanner(System.in);    //以Scanner類別(建構子為 輸入區輸入) 建立一個物件scanner 
   String s = null;                             //字串類別變數 s = 空值
	System.out.println("請輸入分數，輸入quit結束");           
	while (scanner.hasNextLine()) {//while迴圈設定(為了可以多次輸入 以物件scanner呼叫Scanner類別的方法:hasNextLine()為讀取輸入區此行所有的數據 以ENTER作區別(按下ENTER算此行結束) 
		s = scanner.next();  //next()為讀取輸入區記號轉為字串 並賦予變數s (型態為String) 
		if (s.trim().equalsIgnoreCase("quit"))//trim()為去除首尾空格的方法  equalsIgnoreCase()為忽略大小寫(String)的情況來做比較是否相同()參數則放要比較的依據
			break;//if區塊內 去除首尾空白 而且忽略大小寫情況下 輸入quit 則while迴圈結束(輸入區終止在輸入)
		try {                     //處理輸入區內輸入的內容
			int score = Integer.parseInt(s); //Integer.parseInt()是將字串s(就是方法內()的參數)轉為Integer整數型態後 賦予變數-score 型態為int
			if (score > 100 || score < 0) { //如果score這個變數大於100或是小於0 ||是短路運算子 或的意思
				throw new ScoreException(score);//throw關鍵字 生成一個新的例外 語法 throw new XxxxException()...
			}
			System.out.println("這是一個合法分數:" + score);
		} catch (NumberFormatException e) {    //抓出  "不是整數"的例外 
			System.out.println("格式錯誤:s=" + s);
		} catch (ScoreException se) {   //自訂新的例外類別
			System.out.println("這不是一個合法分數:" + se.score + "原因= " + se.getErrorMessage());
		}
		} // end of while
		System.out.println("程式結束");
		scanner.close();
	}
}

class ScoreException extends Exception {  //繼承Exception類別
	int score;                            //設定ScoreException類別屬性(類別變數)
	private String errorMessage;          //字串類別的變數 errorMessage 修飾為private (僅在ScoreException類別內使用)

	ScoreException(int s) {               //建構子 參數 s 型態為int  
		score = s;                        // 將 ()內的參數 賦予 score
		setErrorMessage();                //
	}

	private void setErrorMessage() {        //這是一個只限本類別使用的方法   set  可讓外界存入變數   
		if (score < 0)
			errorMessage = "分數<0";
		else if (score > 100)
			errorMessage = "分數>100";
	}

	String getErrorMessage() {              //這是一個方法 get 可讓外界取出 
		return errorMessage;                //get 可讓外界取出 
	}
}