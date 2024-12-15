package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 入力/出力（Input/Output）⇒ I/O（入出力）
 * 
 * 入力方法
 * ・標準入力（コマンド・プロンプトのようなコンソール）からの入力
 * ・ファイル入力（ファイルからデータを読み込む入力方式）
 * ・画面からの入力（Windows形式のGUIアプリケーションなど）
 * ・画面からの入力（Webアプリケーション（Webブラウザ）からの入力）
 * 
 * 出力方法
 * ・標準出力（コマンド・プロンプトのようなコンソール）への出力
 * ・ファイル出力（ファイルへの書き込み）
 * ・画面への出力（GUI系アプリケーションの画面はWebアプリケーションの画面への出力）
 * 
 * 入力から出力までの基本的なプログラムの流れ
 * 入力　⇒　プログラムでの処理　⇒　出力
 * 
 * 入力の流れ（データが入力されてくる経路（データの通り道））：入力ストリーム
 * 出力の流れ（処理したデータを出力する経路（データの通り道））：出力ストリーム
 */

public class JB03_InputOutput {

	public static void main(String[] args) throws IOException  {
		
		/*
		 * BufferedReader：入力ストリームを構成するJavaの入力用クラス
		 * InputStreamReader：入力ストリームを構成するJavaの入力用クラス
		 * 
		 * BufferedReaderクラスを使用し、標準入力からのストリーム（データの通り道）
		 * を用意する。
		 */
		BufferedReader br =
				new BufferedReader( new InputStreamReader( System.in ) );
		
		/*
		 * readLine()
		 * BufferedReaderクラスに定義されているメソッド。
		 * 入力された1行分（改行コードまで）のデータを受け取る。
		 * 戻り値はString。
		 * readLine()メソッドを使用する場合は、IOException（例外）を処理する必要がある。
		 */
		System.out.println( "名前を入力してください" );
		String name = br.readLine();
		System.out.println( "会社名を入力してください" );
		String corp = br.readLine();
		
		System.out.println( "入力された名前は【" + name + "】です" );
		System.out.println( "入力された会社名は【" + corp + "】です");
		System.out.println();
		
		
		System.out.println( "今年は西暦何年ですか？西暦年数を入力してください" );
		String year = br.readLine();
		System.out.println( "入力された西暦は【" + year + "】年です" );
		System.out.println();
		
		System.out.println( "購入するリンゴの個数を入力してください" );
		String apple = br.readLine();
		System.out.println( "購入するオレンジの個数を入力してください" );
		String orange = br.readLine();
		System.out.println
		( "購入したリンゴとオレンジの合計数は【" + ( apple + orange )+ "】個です" );
		System.out.println();
		
		System.out.println( "三角形の面積を求めます" );
		System.out.println( "三角形の底辺の長さを入力してください" );
		String base = br.readLine();
		System.out.println( "三角形の高さを入力してください" );
		String height = br.readLine();
		System.out.println( "入力された三角形の底辺の長さは【" + base + "】です" );
		System.out.println( "入力された三角形の高さは【" + height + "】です" );
		
		/*
		 * 文字列（String）のデータのままでは演算処理は出来ないので、
		 * 文字列（String）から数値（int）への変換処理を行う。
		 * 
		 * int parseInt( String args ) 
		 * Integerクラスに定義されているメソッド。
		 * parseIntは引数にて受け取った文字列（String）の値を整数（int）への変換を行う。
		 * 戻り値はint。
		 */
		int i_base = Integer.parseInt( base );
		int i_height = Integer.parseInt( height );
		int i_area = ( i_base * i_height ) / 2;
		System.out.println( "三角形の面積は【" + i_area + "】です" );
		
	}

}
