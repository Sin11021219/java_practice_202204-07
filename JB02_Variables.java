package sample;

/*
 * 変数
 * 変数とは、プログラム内部で使用するデータ（値）を一時的に格納するための領域。
 * （データを入れるための箱のようなモノ）
 * 
 * 変数の宣言の構文
 * データ型 変数名（識別子）
 * （例：int num;）
 * （※）変数の宣言に関しては、適用ブロック内（変数の有効範囲）で、同じ名前の
 * 変数は宣言できない。（同じ名前の変数の宣言は多重定義となりエラーとなる）
 * 
 * 変数への値の代入の構文
 * 変数名 代入演算子 値（値を変数に格納（代入）する）
 * （例：num = 10;）（10をいう値を変数numに格納する）
 * 
 * 変数の初期化（変数の宣言と値の代入を同時に行う）の構文
 * データ型 変数名 代入演算子 値
 * （例：int num = 10;）
 * 
 * 基本データ型（プリミティブ型）
 * boolean 論理型 扱うデータはtrue（真）またはfalse（偽）
 * char 文字型 2バイト 扱うデータは1文字
 * byte 数値型（整数）1バイト
 * short 数値型（整数）2バイト
 * int 数値型（整数）4バイト
 * long 数値型（整数）8バイト
 * float 数値型（浮動小数点値）4バイト
 * double 数値型（浮動小数点値）8バイト
 * 
 * 
 * 定数
 * 一度値を設定すると変更できないもの。
 */

public class JB02_Variables {

	public static void main(String[] args) {
		
		// 変数の宣言
		boolean flg;
		int num;
		char ch;
		double dbl;
		
		// 変数にデータ（値）を代入
		flg = true;
		num = 100;
		ch = 'あ';
		dbl = 123.456;
		
		// 変数の値を表示
		System.out.println( "flg ==> " + flg );
		System.out.println( "num ==> " + num );
		System.out.println( "ch ==> " + ch );
		System.out.println( "dbl ==> " + dbl  );
		System.out.println();
		
		// 変数の初期化
		boolean bool_val = true;
		int int_val = 1000;
		char ch_val = 'a';
		double dbl_val = 256.98;
		
		// 初期化した変数の値を表示
		System.out.println( "bool_val ==> " + bool_val );
		System.out.println( "int_val ==> " + int_val );
		System.out.println( "ch_val ==> " + ch_val );
		System.out.println( "dbl_val ==> " + dbl_val  );
		System.out.println();
		
		// 変数の値の書き換え（新しい値を代入）
		bool_val = false;
		int_val = 2000;
		ch_val = 'A';
		dbl_val = 398.12;
		
		// 変数同士の値の代入（代入前）
		System.out.println( "***** 変数同士の値の代入（代入前） *****" );
		System.out.println( "bool_val ==> " + bool_val );
		System.out.println( "int_val ==> " + int_val );
		System.out.println( "ch_val ==> " + ch_val );
		System.out.println( "dbl_val ==> " + dbl_val  );
		System.out.println();
		
		// 変数同士の値の代入
		bool_val = flg;
		int_val = num;
		ch_val = ch;
		dbl_val = dbl;
		
		// 変数同士の値の代入（代入後）
		System.out.println( "***** 変数同士の値の代入（代入後） *****" );
		System.out.println( "bool_val ==> " + bool_val );
		System.out.println( "int_val ==> " + int_val );
		System.out.println( "ch_val ==> " + ch_val );
		System.out.println( "dbl_val ==> " + dbl_val  );
		System.out.println();

	}

}
