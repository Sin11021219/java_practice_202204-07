package tk_sample;

/*
 * 比較（等値比較）
 * 
 * int n = 10;
 * 
 * if( n == 10 )「==」等しいかどうかを判定する
 * 
 * 基本データ型
 * boolean
 * char
 * byte
 * short
 * int
 * long
 * float
 * double
 * 基本データ型の変数などに対しては「==」の等価比較演算子が使用できる。
 * 
 * 文字列（String）
 * 
 * String str = "ABC";
 * 
 * if( str == "ABC" )
 * ↓
 * 文字列（String）の値が等しいかどうかを判定する場合
 * 「==」演算子を使ってはいけない！！使っちゃダメ！！　				⇒　×
 * 文字列を比較する場合はequals()メソッドを使わなくてはならない	⇒　○
 * ↑
 * もしも、このような認識を持っている場合 ⇒ これは間違い！！！
 */

public class JO17_StringValueCompare {

	public static void main(String[] args) {
		
		System.out.println
		( "***** new 演算子を使用し、Stringクラスのインスタンスを生成した場合 *****" );
		
		String str_a = new String( "LUFFY" );
		String str_b = new String( "LUFFY" );
		
		System.out.println( "***** 変数str_aと変数str_bの値を表示 *****" );
		System.out.println( "str_a ==> " + str_a );
		System.out.println( "str_b ==> " + str_b );
		
		// 比較演算子（==）を使用して比較
		System.out.println( "***** 比較演算子（==）を使用して比較 *****" );
		if( str_a == str_b ) {
			System.out.println( "str_aとstr_bは等しいです" );
		}
		else {
			System.out.println( "str_aとstr_bは等しくありません" );
		}
		
		// equals()メソッドを使用して比較
		System.out.println( "***** equals()メソッドを使用して比較 *****" );
		if( str_a.equals( str_b ) ) {
			System.out.println( "str_aとstr_bは等しいです" );
		}
		else {
			System.out.println( "str_aとstr_bは等しくありません" );
		}
		System.out.println();
		

		System.out.println
		( "***** new 演算子を使わずにStringクラスのインスタンスを生成した場合 *****" );
		
		String str_x = "ZORO";
		String str_y = "ZORO";
		
		System.out.println( "***** 変数str_xと変数str_yの値を表示 *****" );
		System.out.println( "str_x ==> " + str_x );
		System.out.println( "str_y ==> " + str_y );
		
		// 比較演算子（==）を使用して比較
		System.out.println( "***** 比較演算子（==）を使用して比較 *****" );
		if( str_x == str_y ) {
			System.out.println( "str_xとstr_yは等しいです" );
		}
		else {
			System.out.println( "str_xとstr_yは等しくありません" );
		}
		
		// equals()メソッドを使用して比較
		System.out.println( "***** equals()メソッドを使用して比較 *****" );
		if( str_x.equals( str_y ) ) {
			System.out.println( "str_xとstr_yは等しいです" );
		}
		else {
			System.out.println( "str_xとstr_yは等しくありません" );
		}
		System.out.println();
		
		
		System.out.println
		( "***** new 演算子を使用と不使用を混在させStringクラスのインスタンスを生成した場合 *****" );
		
		String str_c = new String( "NAMI" );
		String str_d = "NAMI";
		
		System.out.println( "***** 変数str_cと変数str_dの値を表示 *****" );
		System.out.println( "str_c ==> " + str_c );
		System.out.println( "str_d ==> " + str_d );
		
		// 比較演算子（==）を使用して比較
		System.out.println( "***** 比較演算子（==）を使用して比較 *****" );
		if( str_c == str_d ) {
			System.out.println( "str_cとstr_dは等しいです" );
		}
		else {
			System.out.println( "str_cとstr_dは等しくありません" );
		}
		
		// equals()メソッドを使用して比較
		System.out.println( "***** equals()メソッドを使用して比較 *****" );
		if( str_c.equals( str_d ) ) {
			System.out.println( "str_cとstr_dは等しいです" );
		}
		else {
			System.out.println( "str_cとstr_dは等しくありません" );
		}
		

	}

}
