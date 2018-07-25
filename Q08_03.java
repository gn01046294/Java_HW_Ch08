package Ch08;

import java.io.IOException;
import java.util.Scanner;
/*�Х���LŪ�J�@�դ��ơA���˵��C�Ӥ��ơA�p�G�����Ƭ�����1~100�A�h���
  "�o���O�@�ӦX�k����"���T���C�ХΦۭqException�ӧ����C
 */
public class Q08_03 {
 public static void main(String[] args) throws IOException {   //throws �ŧi�k�h �ӳB�z�ҥ~
  Scanner scanner = new Scanner(System.in);    //�HScanner���O(�غc�l�� ��J�Ͽ�J) �إߤ@�Ӫ���scanner 
   String s = null;                             //�r�����O�ܼ� s = �ŭ�
	System.out.println("�п�J���ơA��Jquit����");           
	while (scanner.hasNextLine()) {//while�j��]�w(���F�i�H�h����J �H����scanner�I�sScanner���O����k:hasNextLine()��Ū����J�Ϧ���Ҧ����ƾ� �HENTER�@�ϧO(���UENTER�⦹�浲��) 
		s = scanner.next();  //next()��Ū����J�ϰO���ର�r�� �ýᤩ�ܼ�s (���A��String) 
		if (s.trim().equalsIgnoreCase("quit"))//trim()���h�������Ů檺��k  equalsIgnoreCase()�������j�p�g(String)�����p�Ӱ�����O�_�ۦP()�Ѽƫh��n������̾�
			break;//if�϶��� �h�������ť� �ӥB�����j�p�g���p�U ��Jquit �hwhile�j�鵲��(��J�ϲפ�b��J)
		try {                     //�B�z��J�Ϥ���J�����e
			int score = Integer.parseInt(s); //Integer.parseInt()�O�N�r��s(�N�O��k��()���Ѽ�)�ରInteger��ƫ��A�� �ᤩ�ܼ�-score ���A��int
			if (score > 100 || score < 0) { //�p�Gscore�o���ܼƤj��100�άO�p��0 ||�O�u���B��l �Ϊ��N��
				throw new ScoreException(score);//throw����r �ͦ��@�ӷs���ҥ~ �y�k throw new XxxxException()...
			}
			System.out.println("�o�O�@�ӦX�k����:" + score);
		} catch (NumberFormatException e) {    //��X  "���O���"���ҥ~ 
			System.out.println("�榡���~:s=" + s);
		} catch (ScoreException se) {   //�ۭq�s���ҥ~���O
			System.out.println("�o���O�@�ӦX�k����:" + se.score + "��]= " + se.getErrorMessage());
		}
		} // end of while
		System.out.println("�{������");
		scanner.close();
	}
}

class ScoreException extends Exception {  //�~��Exception���O
	int score;                            //�]�wScoreException���O�ݩ�(���O�ܼ�)
	private String errorMessage;          //�r�����O���ܼ� errorMessage �׹���private (�ȦbScoreException���O���ϥ�)

	ScoreException(int s) {               //�غc�l �Ѽ� s ���A��int  
		score = s;                        // �N ()�����Ѽ� �ᤩ score
		setErrorMessage();                //
	}

	private void setErrorMessage() {        //�o�O�@�ӥu�������O�ϥΪ���k   set  �i���~�ɦs�J�ܼ�   
		if (score < 0)
			errorMessage = "����<0";
		else if (score > 100)
			errorMessage = "����>100";
	}

	String getErrorMessage() {              //�o�O�@�Ӥ�k get �i���~�ɨ��X 
		return errorMessage;                //get �i���~�ɨ��X 
	}
}