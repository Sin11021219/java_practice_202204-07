package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 条件分岐式
 * （条件によって処理を振り分けるための制御構文）
 * 
 * IF文
 * 
 * ①
 * ifのみの構文では、if文内の条件に一致した場合のみifブロック内の処理を行う。
 * 
 * if( 条件式 ){
 * 		処理
 * }
 * 
 * ②
 * ifとelseの構文では、if文内の条件に一致した場合はifブロック内の処理を行い
 * ifの条件に一致しないものは全てelseブロック内の処理を行う。
 * 
 * if( 条件式 ) {
 * 		処理
 * }
 * else {
 * 		処理
 * }
 * 
 * ③
 * ifとelse ifとelseの構文では、if文内の条件に一致した場合はifブロック内の処理を行い
 * また、else if文内の条件に一致した場合は該当するelse ifブロック内の処理を行う。
 * ifやelse ifなどの条件に一致しないものは全てelseブロック内の処理を行う。
 * ifとelse ifを使った構文は「複数の条件を指定する」ような場合に使用する。
 * 
 * if( 条件式 ) {
 * 		処理
 * }
 * else if( 条件式 ) {
 * 		処理
 * }
 * 		・
 * 		・
 * 		・
 * else if( 条件式 ) {
 * 		処理
 * }
 * else {
 * 		処理
 * }
 * 
 */

public class JB06_If {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.println( "整数値を入力してください" );
		int num = Integer.parseInt( br.readLine() );
		
		// ① ifのみを使用した例
		if( num < 5 ) {
			System.out.println( "①入力された値は5未満です" );
		}
		System.out.println( "if①終了" );
		System.out.println();
		
		// ② if～elseを使用した例
		if( num > 10 ) {
			System.out.println( "②入力された値は10より大きいです" );
		}
		else {
			System.out.println( "②入力された値は10以下です" );
		}
		System.out.println( "if②終了" );
		System.out.println();
		
		// ③if～else if～elseを使用した例
		if( num >= 1000 ) {
			System.out.println( "③入力された値は1000以上です" );
		}
		else if( num >= 900 ) {
			System.out.println( "③入力された値は900以上です" );
		}
		else if( num >= 800 ) {
			System.out.println( "③入力された値は800以上です" );
		}
		else if( num >= 500 ) {
			System.out.println( "③入力された値は500以上です" );
		}
		else {
			System.out.println( "③それ以外" );
		}
		System.out.println( "if③終了" );
		System.out.println();
		
		// ④単独のifを連続で使用した例
		if( num >= 1000 ) {
			System.out.println( "④入力された値は1000以上です" );
		}
		if( num >= 900 ) {
			System.out.println( "④入力された値は900以上です" );
		}
		if( num >= 800 ) {
			System.out.println( "④入力された値は800以上です" );
		}
		if( num >= 500 ) {
			System.out.println( "④入力された値は500以上です" );
		}
		else {
			System.out.println( "④それ以外" );
		}
		System.out.println( "if④終了" );
		System.out.println();
		
		/*
		 * ifブロックが無い場合
		 * （ifブロックが無い場合は、ifの条件に一致した場合に処理されるのは
		 * 　if文の直後に記述されている1行のみである）
		 */
		if( num >= 10000 ) {
			System.out.println( "*** 10000以上です *** " );
			System.out.println( "*** 1万以上です *** " );
		}
		System.out.println();
		if( num >= 10000 ) 
			System.out.println( "** 10000以上です** " );
			System.out.println( "** 1万以上です** " );
		System.out.println();
		
		/*
		 * char charAt( int index )
		 * Stringクラスに定義されているメソッド。
		 * 対象となる文字列オブジェクト（String）から指定した位置（index）の
		 * 1文字を取り出し、戻り値として返す。
		 * 戻り値 char
		 */
		// ***** 論理演算子を使用した例① *****
		System.out.println( "あなたは中国人ですか？（y/n）" );
		String str = br.readLine();
		char ch = str.charAt(0);
		if( ch == 'y' || ch == 'Y' ) {
			System.out.println( "あなたは中国人ですね！" );
		}
		else if( ch == 'n' || ch == 'N' ) {
			System.out.println( "あなたは中国人ではありませんね！" );
		}
		else {
			System.out.println( "判別不能！" );
		}
		System.out.println();
		
		// ***** 論理演算子を使用した例② *****
		System.out.println( "点数（整数）を入力してください" );
		int score = Integer.parseInt( br.readLine() );
		
		if( score >= 0 && score < 20 ) {				// 0以上20未満
			System.out.println( "成績ランクE" );	
		}
		else if( score >= 20 && score < 40 ) {		// 20以上40未満
			System.out.println( "成績ランクD" );
		}
		else if( score >= 40 && score < 60 ) {		// 40以上60未満
			System.out.println( "成績ランクC" );
		}
		else if( score >= 60 && score < 80 ) {		// 60以上80未満
			System.out.println( "成績ランクB" );
		}
		else if( score >= 80 && score <= 100 ) {	// 80以上100以下
			System.out.println( "成績ランクA" );
		}
		// elseを使わずに同様の処理になるように書き換えてみてください。
		/*
		else {
			System.out.println( "範囲判定外！！" );
		}
		*/
		/*
		 * 0以上100以下 ⇒ ランク判定可能な範囲
		 * 0未満または100より大きい ⇒ 範囲判定外
		 */
		else if( score < 0 || score > 100 ) {
			System.out.println( "範囲判定外！！" );
		}
		
		// ***** if文の中に別のif文があるようなネスト（入れ子）の例 *****
		System.out.println( "あなたは中国人ですか？（y/n）" );
		ch = br.readLine().charAt(0);
		/*
		 * ↑
		 * 以下の処理を1行にまとめて書いたモノ
		 * String str = br.readLine();
		 * char ch = str.charAt(0);
		 */
		
		if( ch == 'n' || ch == 'N' ) {
			System.out.println( "あなたは韓国人ですか？（y/n）" );
			ch = br.readLine().charAt(0);
			if( ch == 'n' || ch == 'N' ) {
				System.out.println( "あなたは日本人ですか？（y/n）" );
				ch = br.readLine().charAt(0);
				if( ch == 'n' || ch == 'N' ) {
					System.out.println( "あなたはアメリカ人ですか？（y/n）" );
					ch = br.readLine().charAt(0);
					if( ch == 'n' || ch == 'N' ) {
						System.out.println( "中国、韓国、日本、アメリカ以外の方ですね" );
					}
					else if( ch == 'y' || ch == 'Y' ) {
						System.out.println( "あなたはアメリカ人ですね" );
					}
				}
				else if( ch == 'y' || ch == 'Y' ) {
					System.out.println( "あなたは日本人ですね" );
				}
			}
			else if( ch == 'y' || ch == 'Y' ) {
				System.out.println( "あなたは韓国人ですね" );
			}
		}
		else if( ch == 'y' || ch == 'Y' ) {
			System.out.println( "あなたは中国人ですね" );
		}
		
	}

}
