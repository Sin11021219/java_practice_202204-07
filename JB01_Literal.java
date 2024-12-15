package sample;

/*
 * リテラル（Literal）
 * リテラルとは、プログラムコードの中で、具体的な値を表現する方法のこと。
 * 
 * リテラルは大きく分けて以下の３種類がある。
 * ・数値を表す数値リテラル
 * ・文字（1文字）を表す文字リテラル（シングル・クォーテーションで囲む）
 * ・文字列を表す文字列リテラル（ダブル・クォーテーションで囲む）
 */

/*
 * コメント
 * ⇒プログラム内に説明や注釈などを記述しておくもの。
 * 　プログラムの動作には影響しない。
 * 
 * 	  1行コメント		　「//」 の次に文章を書く
 *   複数行コメント	   「/」＆「*」と「*」＆「/」の間に文章を書く
 */

public class JB01_Literal {

	public static void main(String[] args) {
		
		// 数値リテラル
		System.out.println( "***** 数値リテラル *****" );
		System.out.println( 100 );
		System.out.println( 500.348 );
		System.out.println( 1 );
		System.out.println();
		
		// 文字リテラル
		// （シングル・クォーテーション（一重引用符）で囲む）
		System.out.println( "***** 文字リテラル *****" );
		System.out.println( 'a' );
		System.out.println( 'あ' );
		System.out.println( '1' );
		System.out.println();
		
		// 文字列リテラル
		// （ダブル・クォーテーション（二重引用符）で囲む）
		System.out.println( "***** 文字列リテラル *****" );
		System.out.println( "1" );
		System.out.println( "100" );
		System.out.println( "500.348" );
		System.out.println( "a" );
		System.out.println( "abc" );
		System.out.println( "あ" );
		System.out.println( "あいうえお" );
		System.out.println();
		
		/*
		 * エスケープ・シーケンスとは
		 * 「\（半角\記号（\記号が表示されない場合はバックスラッシュ））と
		 * 特定のアルファベット文字を組み合わせて改行やタブ、バックスペースなど
		 * 普通の文字としては表現できない特殊文字を文字列リテラルで表現することができる
		 */
		
		// エスケープ・シーケンスを使った文字列リテラル
		System.out.println( "***** エスケープ・シーケンスを使用した文字列リテラル *****");
		
		System.out.println( "あいうえおかきくけこさしすせそ" );
		// 改行コード（\n）を表現
		System.out.println( "あいうえお\nかきくけこ\nさしすせそ");
		// タブ（TAB）キー（\t）を表現
		System.out.println( "あ\tい\tう\tえ\tお" );
		// バックスペース（\b）を表現
		System.out.println( "あいう\bえ\bお" );
		// \記号を表現
		// （javaではエスケープ・シーケンスを使用する時に\記号を使うため、\記号そのもの
		// 　が特殊な文字として扱われるので、\記号そのものを表現する時は「\\」を使用する）
		System.out.println( "\\" );
		System.out.println();
		
		// \記号を使った場合の注意点
		System.out.println( "***** \\記号を使った場合の注意点 *****" );
		System.out.println( "お小遣いで\100もらった" );
		System.out.println( "お小遣いで\\100もらった" );
		System.out.println();
		
		// エスケープ・シーケンス（\記号もしくはバックスラッシュ）と8進数または16進数の値
		// を文字列リテラルの中で組み合わせる事によって、ASCII CODE上に定義されている文字
		// を表現することができる。
		
		// エスケープ・シーケンスを使わず普通に文字を表現した場合
		System.out.println
		( "***** エスケープ・シーケンスを使わず、普通に文字を表現した場合 *****" );
		System.out.println( "Aはアルファベットの先頭の文字です" );
		System.out.println( "Bはアルファベットの2番目の文字です" );
		System.out.println();
		
		// エスケープ・シーケンスを使用し、文字を表現する方法
		// （\ + 8進数の組み合わせ）
		System.out.println( "\101はアルファベットの先頭の文字です" );
		System.out.println( "\102はアルファベットの2番目の文字です" );
		System.out.println();
		
		// （\ + u + 16進数の組み合わせ）
		System.out.println( "\u0041はアルファベットの先頭の文字です" );
		System.out.println( "\u0042はアルファベットの２番目の文字です" );
		System.out.println();
		
		System.out.println( "***** \\記号 + 8進数の組み合わせで文字列を表現 *****" );
		System.out.println( "\112\141\166\141" );
		System.out.println( "***** \\記号 + u + 16進数の組み合わせで文字列を表現 *****" );
		System.out.println( "\u004A\u0061\u0076\u0061" );
		System.out.println( "***** \\記号 + 8進数&16進数の組み合わせで文字列を表現 *****" );
		System.out.println( "\112\141\u0076\u0061" );
		System.out.println();
		
		System.out.println( "***** 数値リテラルを10進数、8進数、16進数で表現した例 *****" );
		
		System.out.println( "10進数の15を10進数で表現すると" + 15 );
		System.out.println( "10進数の15を8進数で表現すると" + 017 );
		System.out.println( "10進数の15を16進数で表現すると" + 0x0f );
		System.out.println();
		
		System.out.println( "10進数の15を表示すると" + 15 );
		System.out.println( "8進数の15を表示すると" + 015 );
		System.out.println( "16進数の15を表示すると" + 0x15 );
		System.out.println();
	}

}
