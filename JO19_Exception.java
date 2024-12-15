package tk_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * アプリケーションで発生する可能性のあるエラー
 * 
 * ①文法エラー/構文エラー（コンパイルエラー※コンパイル言語の場合）
 * コンパイラによる文法チェック（構文チェック）時に不正を検知し、エラー扱いとする。
 * javacのようなコンパイラによる手動コンパイルまたは
 * EclipseやIntelli-J IDEA、net-beansなどのようなIDE（統合開発環境）ツール
 * の場合は、自動コンパイルが行われる。
 * コンパイルエラーが発生した場合には、エラーを解消しないとプログラム自体が
 * 動作しない為、プログラム動作中にエラーが発生することは無い。
 * 
 * ②実行時エラー（例外）
 * プログラムは動作する………しかし、コード上または言語仕樣上の問題があり
 * 例外（実行時エラー）が発生し、プログラムを正しく動作させることができない
 * または、エラー時の処理が正しく行われていない事により発生する。
 * 
 * ③ビジネスロジックエラー
 * プログラム言語としての仕樣への違反（①や②）では無く
 * アプリケーション内に定義されている業務上のルールなどをロジック化したもの
 * （ビジネスロジック）に反した場合にエラー扱いとなるもの。
 * 例：社員のIDは5桁の数字で入力（業務上のルール（規約））
 * 上記のような仕樣に対して、aaaaaや123などといった値を入力した場合はエラー扱いとするもの。
 * 
 * -----------------------------------------------------------------------------------
 * コンパイルに関して
 * 
 * 処理速度が遅い
 * ↑
 * JavaScript ⇒ 事前コンパイル無し
 * （※JavaScriptはスクリプト言語なので、インタプリタを介してプログラムの実行を
 * 　　行うため、コンパイル言語のように事前コンパイルを必要としない）
 * 
 * Java ⇒ コンパイル ⇒ クラスファイル（Javaバイトコード） 
 * 　　　⇒ JVM（JavaVirtualMachine）がインタプリタの役割をし、機械語に翻訳しながら動作する。
 * 
 * C言語 ⇒ コンパイル ⇒ 機械後に翻訳されたコード
 * ↓
 * 処理速度が速い
 * 
 * 
 * スクリプト言語
 * ⇒ OSやアプリケーションソフトの動作や機能などをプログラム形式で記述できるもの。
 * 　代表的な言語：JavaScript、VBScript、ShellScritpなど
 * 
 * インタプリタ言語
 * ⇒ プログラムを実行しながら、ソースの内容を逐次解釈し、実行形式に変換（翻訳）
 * 　 しながら処理する形式の言語。
 * 　代表的な言語：JavaScript、Ruby、Perl、Python、PHPなど
 * 
 * コンパイル言語
 * ⇒ プログラム言語で書かれたソースコードをコンピューターなどの機械が実行できる
 * 　機械語（マシン語）に翻訳し、実行する形式のプログラム言語。
 * 　代表的な言語：Java、C言語など
 * 
 * ----------------------------------------------------------------------------------
 * 
 * try～catch～finallyの構文
 * 
 * try{
 * 		例外が発生する可能性がある処理を記述する。
 * }
 * catch( 対応する例外クラス 参照変数名 ){
 * 		例外に対する処理を記述する。
 * }
 * finally(){
 * 		例外が発生した場合、最後に実行するべき処理を記述する。
 * }
 * 
 * ----------------------------------------------------------------------------------
 * 
 * PlaneクラスのsetSpeedメソッド専用の例外クラス（SetSpeedException）の定義
 * 
 * 例外クラスを作成する場合は、特別な条件がない限り、基本的には全ての例外クラスの
 * スーパークラスであるExceptionクラスを継承する。
 * 
 * オリジナルの例外処理を作成し、送出する手順
 * 手順①例外クラスを定義する。
 * 手順②例外を発生させるメソッドの中で、例外クラスのインスタンスを生成する。
 * 手順③生成した例外クラスのインスタンスを送出（throw）する。
 * 手順④例外を発生させるメソッドから例外クラスをthrowsする。
 */

@SuppressWarnings("serial")
class SetSpeedException extends Exception {			// 手順①
	/*
	 * 例外クラスを作成する場合、特にフィールドやメソッドなどが
	 * 必要無い場合は、クラス内に何も定義しなくても良い。
	 * 
	 * また、フィールドやメソッドなどを使用する場合には以下のように定義できる。
	 */
	
	// エラー値格納用フィールド
	private double err_val;
	
	// Setter 
	public void setErr_Val( double err_val ) {
		this.err_val = err_val;
	}
	// Getter
	public double getErr_Val() {
		return err_val;
	}
	
}

class Plane {
	private double speed;
	private int ride_num;
	
	public Plane() {}
	public Plane( double speed , int ride_num )throws SetSpeedException {
		setSpeed( speed );
		setRide_Num( ride_num );
	}
	
	public void setSpeed( double  speed ) throws SetSpeedException {	// 手順④
		// 速度（speed）の有効設定範囲は1000以上2000以下とする
		if( speed >= 1000 && speed <= 2000 ) {
			this.speed = speed;
		}
		// 速度（speed）が有効設定範囲外（1000未満または2000より大きい）
		// の場合は例外を送出する。
		else {
			// 例外クラスのインスタンスを生成										// 手順②
			SetSpeedException e = new SetSpeedException();					
			
			e.setErr_Val(speed);
			
			// 生成した例外のインスタンスを送出する								// 手順③
			throw e;
		}
		
	}
	public void setRide_Num( int ride_num ) {
		this.ride_num = ride_num;
	}
	
	public double getSpeed() {
		return speed;
	}
	public int getRide_Num() {
		return ride_num;
	}
	
	public void show() {
		System.out.println( "飛行機の速度は【" + speed + "】です" );
		System.out.println( "飛行機の乗員数は【" + ride_num + "】です" );
	}
}

public class JO19_Exception {

	public static void main(String[] args)  {
		
		BufferedReader br = 
				new BufferedReader( new InputStreamReader( System.in ) );
		
		try {
			System.out.println( "数値を入力してください" );
			int num = Integer.parseInt( br.readLine() );
			System.out.println( "入力された数値は【" + num + "】です" );
			
			if( num > 100 ) {
				final int MAX = 6;
				int[] ary = { 10 , 20 , 30 , 40 , 50 };
				for( int i=0 ; i<MAX ; i++ ) {
					System.out.print( "i==>【" + i + "】\t");
					System.out.println( "ary[" + i + "]==>" + ary[i] );
				}
			}
			System.out.println();
			
			Plane plane = new Plane();
			if( num < 0 ) {
				plane = null;
			}
			System.out.println( "飛行機の速度を入力してください" );
			plane.setSpeed( Double.parseDouble( br.readLine() ) );
			/* ↑ 上記の処理は1行にまとめて記述しているが、分解すると以下の通り。
			 * String str = br.readLine();
			 * double speed = Double.parseDouble( str );
			 * plane.setSpeed( speed );
			 */
			System.out.println( "飛行機の乗員数を入力してください" );
			plane.setRide_Num( Integer.parseInt( br.readLine() ) );
			plane.show();
			System.out.println();
			
			// ↓以下はreadLineを使った時にIOExceptionを発生させるためのコード
			// 入力されたnumの値が0であればIOExceptionが発生する
			System.out.println( "文字列を入力してください" );
			if( num == 0 )br.close();
			String str = br.readLine();
			System.out.println("入力された文字列は【"+str+"】です");
			
		}
		catch ( NumberFormatException e ) {
			System.err.println( "数値以外の値が入力されました" );
			System.err.println( "処理を終了します" );
		}
		catch ( ArrayIndexOutOfBoundsException e ) {
			System.err.println( "配列の要素数の範囲を超えています" );
			System.err.println( "処理を終了します" );
		}
		catch( NullPointerException e ) {
			System.err.println( "未定義のオブジェクトを参照しようとしました" );
			System.err.println( "処理を終了します" );
		}
		catch( IOException e ) {
			System.err.println( "入出力に関するエラーを検知しました" );
			System.err.println( "処理を終了します" );
		}
		catch( SetSpeedException e){
			System.err.println( "許容範囲外の速度が設定されました" );
			System.err.println( "設定された値は【" + e.getErr_Val() + "】です");
			System.err.println( "処理を終了します" );
		}
		catch( Exception e ) {
			System.err.println( "プログラムの実行に問題が発生しました" );
			System.err.println( "処理を終了します" );
		}

	}

}
