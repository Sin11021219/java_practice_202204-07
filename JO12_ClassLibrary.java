package tk_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Javaクラスライブラリとは
 * Javaクラスライブラリ（JCL）はJavaアプリケーションが実行時に呼び出せる動的ロード可能な
 * ライブラリ群のことを表す。
 * また、JREが提供しているjava.lang.名前空間他の基本的なクラスを含むライブラリを示す。
 * 
 * ------------------------------------------------------------------------------------
 * 
 * Stringクラス
 * 文字列を扱うクラス
 * 
 * Stringクラスのメソッド
 * char charAt( int index )【引数の位置にある文字を返す】
 * boolean startsWith( String suffix )【引数の文字列で始まるか否かを判定する】
 * boolean endsWith( String suffix ) 【引数の文字列で終わるか否かを判定する】
 * boolean equals( Object object )【引数の文字列と同じか否かを判定する】
 * boolean equalsIgnoreCase( String anotherString ) 【大文字/小文字の違いを無視し引数の文字列と同じか否かを判定する】
 * int indexOf( int ch )【引数の文字が文字列中から最初に出現した位置を返す】
 * int indexOf( String str )【引数の文字列が文字列中から最初に出現した位置を返す】
 * int lastIndexOf( int ch )【引数の文字が文字列中の最後に出現した位置を返す】
 * int lastIndexOf( String str )【引数の文字列が文字列中の最後に出現した位置を返す】
 * int length()【文字数を返す】
 * String substring( int beginIndex )【引数に指定した位置から最後までの文字列を抜き出す】
 * String substring( int beginIndex , int endIndex )【引数に指定した開始位置から終了位置までの文字列を抜き出す】
 * String toLowerCase()【全て小文字に変換する】
 * String toUpperCaser()【全て大文字に変換する】
 * 
 * Stringクラスの特徴
 * Stringクラスは、一度作成したオブジェクト（インスタンスおよびインスタンス内部に設定された値）
 * は変更できないという性質も持つ。
 * 
 * ------------------------------------------------------------------------------------
 * 
 * StringBufferクラス/StringBuilderクラス
 * Stringクラスは一度設定した値を変更できないという性質を持つため、文字列の値を変更/編集
 * するためのクラスとしてStringBufferやStringBuilderというクラスが用意されている。
 * 
 * StringBufferクラスのメソッド
 * StringBuffer append( char c )【引数の文字を追加する】
 * StringBuffer append( String str )【引数の文字列を追加する】
 * StringBuffer deleteCharAt( int index )【引数の位置にある文字を削除する】
 * StringBuffer insert( int offser , char c )【引数の位置に文字を追加する】
 * StringBuffer insert( int offser , String str )【引数の位置に文字列を追加する】
 * int length()【文字数を返す】
 * StringBuffer replace( int start , int end , String str )【引数の開始位置から終了位置までを指定した文字列で置換する】
 * StringBuffer reverse()【文字列を逆転させる】
 * void setCharAt( int index , char ch )【引数の位置の文字を引数の文字で置換する】
 * String toString()【Stringクラスのオブジェクトに変換する】
 * 
 * ------------------------------------------------------------------------------------
 * 
 * Mathクラス
 * Mathクラスは数学的な数値演算を行うためのクラス
 * 
 * Mathクラスのメソッド
 * static double abs( double a )【double型の引数の絶対値を返す】
 * static int abs( int a )【int型の引数の絶対値を返す】
 * static double ceil( double a )【double型の引数以上で最も小さい整数値をdouble型で返す】
 * static double floor( double a )【double型の引数以下で最も大きい整数値をdouble型で返す】
 * static double max( double a , double b )【2つのdouble型の引数のうち大きい値を返す】
 * static int max( int a , int b )【2つのint型の引数のうち大きい値を返す】
 * static double min( double a , double b )【2つのdouble型の引数のうち小さい値を返す】
 * static int min( int a , int b )【2つのint型の引数のうち小さい値を返す】
 * static double random ()【0.0以上1.0未満の乱数を返す】
 * static double pow( double a , double b )【第1引数を第2引数で累乗した値を返す】
 * static double sqrt( double a )【double型の引数の平方根を返す】
 * static double sin( double a )【double型の引数のサイン値を返す】
 * static double cos( double a )【double型の引数のコサイン値を返す】
 * static double tan( double a )【double型の引数のタンジェント値を返す】
 */

public class JO12_ClassLibrary {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader( new InputStreamReader( System.in) );
		
		System.out.println( "*******************************************" );
		System.out.println( "***** Stringクラスの各種メソッドの動作例 *****" );
		System.out.println( "*******************************************" );
		System.out.println();
		
		System.out.println( "文字列（JavaBasicClassProgramingClass）を入力してください" );
		String input = br.readLine();
		System.out.println( "入力された文字列は【" + input + "】です" );
		
		System.out.println( "入力された文字列の最初も文字は【" + input.charAt( 0 )+ "】です" );
		System.out.println( "入力された文字列の3番目の文字は【" + input.charAt( 2 )+ "】です" );
		System.out.println( "入力された文字列はXXXで始まっているか？=>【" + input.startsWith( "XXX" ) + "】" );
		System.out.println( "入力された文字列はJavaで始まっているか？=>【" + input.startsWith( "Java" ) + "】" );
		System.out.println( "入力された文字列はENDで終わっているか?=>【" + input.endsWith( "END" ) + "】" );
		System.out.println( "入力された文字列はClassで終わっているか？=>【" + input.endsWith( "Class" ) + "】" );
		System.out.println( "入力された文字列の中でaの文字が最初に見つかったのは【" + input.indexOf( 'a' ) + "】番目です" );
		System.out.println( "入力された文字列の中でPの文字が最初に見つかったのは【" + input.indexOf( 'P' ) + "】番目です" );
		System.out.println( "入力された文字列の中でClassの文字列が最初に見つかったのは【" + input.indexOf( "Class" ) +"】番目です" );
		System.out.println( "入力された文字列の中でaの文字が最後に見つかったのは【" + input.lastIndexOf( 'a' ) + "】番目です" );
		System.out.println( "入力された文字列の中でgの文字が最後に見つかったのは【" + input.lastIndexOf( 'g' ) + "】です" );
		System.out.println( "入力された文字列の中でClassの文字列が最後に見つかったのは【" + input.lastIndexOf( "Class" ) + "】番目です" );
		System.out.println( "入力された文字列の文字数は【" + input.length() +"】文字です" );
		System.out.println( "入力された文字列の14文字目から最後までを抜き出すと【" + input.substring( 14 ) + "】です" );
		System.out.println( "入力された文字列の14文字目から23文字目までを抜き出すと【" + input.substring( 14 , 24 ) + "】です" );
		System.out.println( "入力された文字列を全て小文字に変換すると【" + input.toLowerCase() + "】です" );
		System.out.println( "入力された文字列を全て大文字に変換すると【" + input.toUpperCase() + "】です" );
		System.out.println();
		
		System.out.println( "****************************" );
		System.out.println( "***** Stringクラスの動作 *****" );
		System.out.println( "****************************" );
		System.out.println();
		System.out.println( "文字列を入力してください" );
		input = br.readLine();
		System.out.println( "入力された文字列は【" + input + "】です");
		System.out.println( "入力された文字列【" + input + "】に「あいうえお」を連結します" );
		System.out.println( "--------------------------------------------------------");
		input = input + "あいうえお";
		System.out.println( "現在の文字列の状態は【" + input + "】です" );
		System.out.println( "現在の文字列から「あいうえお」を取り除きます" );
		
		String str = input;
		/*
		int end = input.lastIndexOf("あいうえお");
		input = input.substring(0, end);
		上記の２行を1行にまとめると以下になる
		↓
		*/
		input = input.substring( 0, input.lastIndexOf("あいうえお") );
		System.out.println( "現在の文字列の状態は【" + input + "】です" );
		System.out.println( "--------------------------------------------------------");
		
		System.out.println( "現在の文字列の状態は【" + str + "】です" );
		System.out.println( "現在の文字列から「あいうえお」を取り除きます" );

		str = str.substring( 0, str.length()-5 );
		
		System.out.println( "現在の文字列の状態は【" + str + "】です" );
		System.out.println( "--------------------------------------------------------");
		System.out.println();
		
		System.out.println( "*************************************************" );
		System.out.println( "***** StringBufferクラスの各種メソッドの動作例 *****" );
		System.out.println( "*************************************************" );
		System.out.println();
		
		System.out.println( "文字列（JavaLanguage）を入力してください" );
		input = br.readLine();
		StringBuffer sb = new StringBuffer( input );
		System.out.println( "入力された文字列は【" + sb + "】です");
		System.out.println( "入力された文字列にXの文字を追加します==>【" + sb.append( 'X' ) + "】" );
		System.out.println( "最新の状態の文字列にClassの文字列を追加します==>【" + sb.append( "Class" ) + "】" );
		System.out.println( "最新の状態の文字列からXの文字を削除します==>【" + sb.deleteCharAt( 12 ) + "】" );
		System.out.println( "最新の状態の文字列にZの文字を挿入します==>【" + sb.insert( 12, 'Z' )+ "】");
		System.out.println( "最新の状態の文字列にPrograｍの文字列を挿入します==>【" + sb.insert( 4, "Program" ) + "】");
		System.out.println( "最新の状態の文字列のProgramをプログラムに変更します==>【" + sb.replace( 4 , 11 , "プログラム" ) + "】" );
		System.out.println( "最新の状態の文字列を逆転させます==>【" + sb.reverse() + "】" );
		System.out.println( "最新の状態の文字列を再度逆転させます==>【" + sb.reverse() + "】" );
		System.out.println();
		
		System.out.println( "******************************************" );
		System.out.println( "***** Mathクラスの各種メソッドの動作例 *****" );
		System.out.println( "******************************************" );
		System.out.println();
		
		System.out.println( "整数Aの値（10）を入力してください" );
		int num_a = Integer.parseInt( br.readLine() );
		System.out.println( "整数Bの値（20）を入力してください" );
		int num_b = Integer.parseInt( br.readLine() );
		System.out.println( "整数Cの値（-30）を入力してください" );
		int num_c = Integer.parseInt( br.readLine() );
		System.out.println( "浮動小数点値A（12.345）を入力してください" );
		double dbl_a = Double.parseDouble( br.readLine() );
		System.out.println( "浮動小数点値B（98.765）を入力してください" );
		double dbl_b = Double.parseDouble( br.readLine() );
		System.out.println( "浮動小数点値C（-10.123）を入力してください" );
		double dbl_c = Double.parseDouble( br.readLine() );
		System.out.println( "---------------------------------------------" );
		System.out.println( "入力された整数Aの値は【" + num_a + "】です" );
		System.out.println( "入力された整数Bの値は【" + num_b + "】です" );
		System.out.println( "入力された整数Cの値は【" + num_c + "】です" );
		System.out.println( "入力された浮動小数点値Aの値は【" + dbl_a + "】です" );
		System.out.println( "入力された浮動小数点値Bの値は【" + dbl_b + "】です" );
		System.out.println( "入力された浮動小数点値Cの値は【" + dbl_c + "】です" );
		System.out.println( "---------------------------------------------" );
		System.out.println( "整数Aの絶対値は【" + Math.abs( num_a )+ "】です" );
		System.out.println( "整数Cの絶対値は【" + Math.abs( num_c )+ "】です" );
		System.out.println( "浮動小数点値Aの絶対値は【" + Math.abs( dbl_a )+ "】です" );
		System.out.println( "浮動小数点値Cの絶対値は【" + Math.abs( dbl_c )+ "】です" );
		System.out.println( "浮動小数点値Aのceil値は【" + Math.ceil( dbl_a )+ "】です" );
		System.out.println( "浮動小数点値Cのceil値は【" + Math.ceil( dbl_c )+ "】です" );
		System.out.println( "浮動小数点値Aのfloor値は【" + Math.floor( dbl_a )+ "】です" );
		System.out.println( "浮動小数点値Cのfloor値は【" + Math.floor( dbl_c )+ "】です" );
		System.out.println( "整数Aと整数Bで大きい方の値は【" + Math.max( num_a, num_b )+ "】" );
		System.out.println( "整数Aと整数Bで小さい方の値は【" + Math.min( num_a, num_b )+ "】" );
		System.out.println( "浮動小数点値Aと浮動小数点値Bで大きい方の値は【" + Math.max( dbl_a, dbl_b )+ "】" );
		System.out.println( "浮動小数点値Aと浮動小数点値Bで小さい方の値は【" + Math.min( dbl_a, dbl_b )+ "】" );
		System.out.println( "10の2乗は【" + Math.pow( 10.0,  2.0 ) + "】" );
		System.out.println( "2の8乗は【" + Math.pow( 2.0,  8.0 ) + "】" );
		System.out.println( "100の平方根は【" + Math.sqrt( 100.0 ) + "】" );
		System.out.println( "9の平方根は【" + Math.sqrt( 9.0 ) + "】" );
		System.out.println( "0.0以上1.0未満の乱数は【" + Math.random() + "】");
		System.out.println( "浮動小数点値Aのサイン値は【" + Math.sin( dbl_a )+ "】です" );
		System.out.println( "浮動小数点値Aのコサイン値は【" + Math.cos( dbl_a )+ "】です" );
		System.out.println( "浮動小数点値Aのタンジェント値は【" + Math.tan( dbl_a )+ "】です" );

	}

}
