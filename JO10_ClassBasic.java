package tk_sample;

/*
 * オブジェクト指向とは
 * ⇒オブジェクト指向とはシステムやプログラムで作成や使用する個別のプログラムを
 * 　オブジェクト（モノ）としてとらえた考え方。
 * 
 * モノには属性と機能がある。
 * 
 * （例）
 * テレビ
 * 属性（状態や性質を表す）					⇒　フィールド
 * 
 * 色								黒
 * 型								50型
 * 価格							350,000
 * サイズ							縦×横×奥行（100×200×60）
 * メーカー						panasonic
 * 
 * 機能（動き/働きを表す）						⇒　メソッド
 * 
 * 電源ON/OFF				電源をONにすると、モニターが点灯し、チューナーが受信している
 * 									映像をモニターに映す。
 * 音量UP/DOWN			出力する音量に指定された音量レベルに合わせる。
 * チャンネル変更				チューナーの受信チャンネルを指定されたチャンネルに変更する。
 * 録画							受信しているチューナーの映像情報を内蔵HDDに記録する。
 * 
 * ----------------------------------------------------------------------------------
 * 
 * クラス
 * クラスとは…プログラムで使用する属性（データ）と機能を１つにまとめたもの。
 * 
 * クラスの定義の構文
 * アクセス修飾子	 class クラス名 {
 * 
 * 		データ型 フィールド名;
 * 
 * 		アクセス修飾子 戻り値の型 メソッド名( データ型 仮引数名 ) {
 * 			メソッド内部の処理
 * 		}
 * }
 * 
 * クラス（mainメソッドの有るクラス）
 * ⇒ mainメソッド部分がエントリーポイント（プログラムの起点）となり、mainメソッド
 * 　 そのものが自動的に動くので、自力でプログラムを動作させることができる。
 * 
 * クラス（mainメソッドの無いクラス）
 * ⇒ エントリーポイントとなる要素が無いので、自力でプログラムを動作させることができない。
 * 　 （他のプログラム（クラスなど）から利用されることで動作する。）
 * 
 * フィールドとメソッド ⇒ クラス・メンバー
 * 
 * クラスを定義した状態 ⇒ 設計図を描いた状態（紙などに設計図を描いただけの状態）
 * ↓
 * 設計図を基に実際のオブジェクト（実体・物体）を作成しないと動作しない！！
 * 
 * クラスメンバーへのアクセス方法
 * クラスのインスタンス参照変数を介し、クラスメンバーにアクセスするにはアクセス演算子「.」を使用する
 * インスタンス参照変数名.フィールド名（※）
 * （例：car.num = 1234;）
 * インスタンス参照変数名.メソッド名
 * （例：car.show();）
 * 
 * ※基本的にクラスのフィールドに対する直接参照は行わない
 * ↓
 * クラスのフィールドに対し、直接参照を許してしまうと、整合性の取れないデータなどが
 * 設定されようとした場合に、それを未然に防ぐ方法が無いため。
 * 
 * ----------------------------------------------------------------------------------
 * 
 * カプセル化
 * ⇒ 外部からのフィールドへの直接的なアクセスを遮断し、隠蔽する事。
 *  　フィールドをカプセル化し、外部からのアクセスを出来ないようにする。
 *  　アクセス修飾子を用いてカプセル化を行う。
 *  　（アクセス修飾子：アクセス（接触）を制御するための修飾子）
 *  
 * 　　アクセス修飾子
 * 　　・private：同じクラス（自クラス）からのアクセスのみ許可
 * 　　・修飾子なし：同一パッケージ内からのアクセス許可
 * 　　・protected：同一パッケージ内もしくは継承したサブクラスからのアクセス許可
 * 　　・public：アクセス制限なし（どこからでも自由にアクセス可能）
 * 
 * ----------------------------------------------------------------------------------
 * 
 * メソッドの引数
 * 呼び出す側（メソッドを使う側）で指定している引数 ⇒ 実引数
 * （例）car1.setNum( 1234 ); ←この1234という値が実引数。
 * 
 * 呼び出される側（メソッドを定義している側）で指定している引数 ⇒ 仮引数
 * （例）public void setNum( int num ) ←このint型のnumという引数が仮引数。
 * 
 * ----------------------------------------------------------------------------------
 * 
 * 多態性（ポリモーフィズム）
 * ⇒ 同じ名前で別々の働きをすること。
 * 
 * 多態性の実装形態のひとつ。
 * オーバーロード（メソッドやコンストラクターに適用）
 * （今回のサンプルではserCar()メソッドがオーバーロードしたメソッドとなる。）
 * オーバーロードの定義条件：引数の数や型が違う事！！！！
 * 
 * ----------------------------------------------------------------------------------
 * 
 * コンストラクター　
 * 【概要】
 * ・new演算子を使用し、インスタンスを生成する際に呼び出され実行される。
 * ・特に何も指定が無ければ、引数なしのコンストラクター（デフォルト・コンストラクター）
 * 　が自動的に作成され、実行される。
 * 　（デフォルト・コンストラクターは内部的に作成されるため、コード上には存在せず、
 * 　　更には、処理内容も何も無い。）
 * 【用途】
 * ・インスタンス生成時に、何か特定の処理を行いたい場合などに処理を設定する。
 * 　（一般的にはインスタンス生成時のフィールド値の初期化などに利用する）
 * 【定義】
 * ・クラスと同じレベルのアクセス修飾子を持つ。
 * ・クラス名と同じ名前を持つ。
 * ・引数指定は可能。
 * ・戻り値は持たない（戻り値の指定も出来ない）
 * 
 * コンストラクター内部から別のコンストラクターを呼び出す事が可能。
 * コンストラクターから別のコンストラクターを呼び出す場合は、コンストラクター内の
 * 先頭で一度だけ、別のコンストラクターを呼び出す事ができる。
 * コンストラクターの指定には「this」キーワードを指定する。
 * 
 * ----------------------------------------------------------------------------------
 * 
 * thisキーワード
 * ・thisキーワードの使用方法は以下の2点。
 * ①クラス内部のフィールドやメソッドなどを明示的に指定する場合（例：this.num = num ）
 * ②コンストラクターから別のコンストラクターを呼び出す場合（例：this();）
 * 
 * ----------------------------------------------------------------------------------
 * 
 * クラス・フィールド/クラス・メソッド
 * ⇒ staticキーワードを付加し定義されたフィールドやメソッド。
 *  　インスタンスの有無とは関係なく存在し、クラス内部に定義されたフィールドやメソッド
 *  　として機能する。
 *  
 * インスタンス・フィールド/インスタンス・メソッド
 * ⇒ 普通に（staticキーワード無しで）定義されたフィールドやメソッド。
 *  　インスタンスが生成されると、そのインスタンス毎に存在するフィールドやメソッド。
 *  　（インスタンスが生成されていないとフィールドやメソッドが存在しない為、
 *  　　インスタンスが無いと利用できないフィールドやメソッド。）
 * 
 * 
 */

class Car {
	
	public static int c_sum = 0;
	public int i_sum = 0;
	
	// ***** フィールドの定義（宣言） *****
	private int num;					// クルマのナンバー
	private double gas;				// クルマのガソリン量
	private String color;			// クルマの色
	
	
	// ***** コンストラクターの定義 *****
	public Car() {
		System.out.println( "***** 引数なしのコンストラクター *****" );
	}
	/*
	 * コンストラクターはメソッド同様、オーバーロードすることが可能。
	 * （今回はあくまでも、コンストラクターのオーバーロードの例という意味で、引数１個の
	 * 　コンストラクターを複数定義しているが、コンストラクターの性質上（インスタンス生成時
	 * 　にしか起動しない）引数１個だけを指定したコンストラクターというは現実的ではない。）
	 */
	public Car( int num ) {
		System.out.println( "***** 引数1個（num）のコンストラクター *****" );
		//this.num = num;
		/*
		 * ↑上記の様に、引数の値をフィールドに直接設定しても良いが、同じ処理を行う
		 * Setterを使った方が良い！！
		 */
		setNum( num );
	}
	public Car( double gas ) {
		System.out.println( "***** 引数1個（gas）のコンストラクター *****" );
		//this.gas = gas;
		setGas( gas );
	}
	public Car( String color ) {
		System.out.println( "***** 引数1個（color）のコンストラクター *****" );
		//this.color = color;
		setColor( color );
		c_sum++;
		i_sum++;
	}
	public Car( int num , double gas, String color) {
		System.out.println( "***** 引数3個のコンストラクター *****" );
		/*
		this.num = num;
		this.gas = gas;
		this.color = color;
		*/
		setNum( num );
		setGas( gas );
		setColor( color );
	}
	public Car( int num , double gas ) {
		this();									// 引数なしのコンストラクターを呼び出す
		System.out.println( "***** 引数2個（numとgas）のコンストラクター *****" );
		setNum( num );
		setGas( gas );
	}
	
	// ***** メソッドの定義 *****
	
	// ***** フィールド設定用メソッド（setter） *****
	/*
	 * フィールド設定用メソッドは引数で受け取った値をフィールドへ設定する
	 * void ⇒ 戻り値なしを意味する。
	 * （戻り値なしのメソッドは処理だけを行い、結果を返さないメソッドとなる）
	 */
	public void setNum( int n ) {
		num = n;
	}
	public void setGas( double g ) {
		if( g >= 0 ) {
			gas = g;	
		}
	}
	public void setColor( String color ) {
		this.color = color;
	}

	// 多態性（オーバーロード）を利用したメソッドの定義
	public void setCar( int num ) {
		this.num = num;
	}
	public void setCar( double gas ) {
		this.gas = gas;
	}
	public void setCar( String color ) {
		this.color = color;
	}

	// ***** フィールド取得用メソッド（getter） *****
	/*
	 * フィールド取得用メソッドは、設定されているフィールドの値をメソッドの結果として
	 * 呼び元に返す。
	 * 戻り値に指定されているデータ型は結果として返すフィールドのデータとなる。
	 * return キーワードを使用し、呼び元（メソッドを呼び出した側）に値を返す。（※）
	 * ※return キーワードで返せるのは1つの値のみ。
	 */
	public int getNum() {
		return num;
	}
	public double getGas() {
		return gas;
	}
	public String getColor() {
		return color;
	}
	
	// ***** 表示用メソッド *****
	public void show() {
		System.out.println( "クルマのナンバーは【" + num + "】です");
		System.out.println( "クルマのガソリン量は【" + gas + "】です");
		System.out.println( "クルマの色は【" + color + "】です");
	}
	
	// sum変数表示用メソッド
	public void showSum() {
		System.out.println( "c_sum ==> " + c_sum );
		System.out.println( "i_sum ==> " + i_sum );
	}
	
	/*
	 * クラス・フィールド/クラス・メソッド（staticキーワード付加）
	 * インスタンスの存在は関係ない！！！
	 * どんな状況下でも使用可能！！！
	 * インスタンスが無い状況下でも使用されることがある！！
	 * （もしも、インスタンスが無い状況下で、クラスメソッド内部で
	 * インスタンス・フィールドやインスタンス・メソッドが使用できてしまうと
	 * 矛盾が発生する！！！）
	 */
	
	/*
	 * c_funcはstaic修飾子を付けて定義されたクラス・メソッドである。
	 * クラス・メソッドは、インスタンスの有無を関係なくメソッドとして機能する。
	 * 従って、インスタンスの存在が不可欠であるインスタンス・フィールドである
	 * i_sumはクラス・メソッドであるc_funcの中では使用できない。
	 */
	public static void c_func() {
		System.out.println( "***** クラス・メソッド *****" );
		System.out.println( "c_sum ==> " + c_sum );
		//System.out.println( "i_sum ==> " + i_sum );
	}
	
	/*
	 * i_funcはインスタンス・メソッドであるため、インスタンスを必要とする。
	 * c_sumフィールドは、クラス・フィールドであるため、インスタンスの有無に関係なく
	 * 使用できるし、機能する。そのため、使用する場面は選ばない（どんな状況下でも使用可能）。
	 * 従って、インスタンス・メソッドの中でも使用可能。
	 */
	public void i_func() {
		System.out.println( "***** インスタンス・メソッド *****" );
		System.out.println( "c_sum ==> " + c_sum );
		System.out.println( "i_sum ==> " + i_sum );
	}
	
}


public class JO10_ClassBasic {

	public static void main(String[] args) {
		
		// Carクラスのインスタンス（実体）を生成
		Car c1 = new Car();
		System.out.println();
		
		// Carクラスのインスタンス（c1）に対し各データを設定する
		
		// Carクラスのフィールドをカプセル化したことにより以下の様なアクセス方法は出来なくなる
		/*
		c1.num = 1234;
		c1.gas = 2000.0;
		c1.color = "WHITE";
		*/
		
		// Carクラスのインスタンス（c1）に設定した各フィールドの値を表示
		/*
		System.out.println( "c1インスタンスのnumは===>" + c1.num );
		System.out.println( "c1インスタンスのgasは===>" + c1.gas );
		System.out.println( "c1インスタンスのcolorは===>" + c1.color );
		System.out.println();
		*/
		
		Car c2 = new Car();
		System.out.println();
		
		/*
		c2.num = 5678;
		c2.gas = -2500.0;
		c2.color = "BLACK";
		*/

		/*
		System.out.println( "c2インスタンスのnumは===>" + c2.num );
		System.out.println( "c2インスタンスのgasは===>" + c2.gas );
		System.out.println( "c2インスタンスのcolorは===>" + c2.color );
		System.out.println();
		*/
		
		// Carクラスに定義したフィールド設定用メソッドを使って値をフィールドへ設定する
		c1.setNum( 1234 );
		c1.setGas( 2000.0 );
		c1.setColor( "WHITE" );
		
		// Carクラスに定義したフィールド取得用メソッドを使って戻り値を受け取る
		int num = c1.getNum();
		double gas = c1.getGas();
		String color = c1.getColor();
		
		System.out.println( "c1インスタンスのnumの値は【" + num + "】");
		System.out.println( "c1インスタンスのgasの値は【" + gas + "】");
		System.out.println( "c1インスタンスのcolorの値は【" + color + "】");
		System.out.println();
		
		// Carクラスに定義したフィールド設定用メソッドを使って値をフィールドへ設定する
		c2.setNum( 5678 );
		c2.setGas( -2500.0 );
		c2.setColor( "BLACK" );
		
		// Carクラスに定義したフィールド取得用メソッドを使って戻り値を受け取る
		num = c2.getNum();
		gas = c2.getGas();
		color = c2.getColor();
		
		System.out.println( "c2インスタンスのnumの値は【" + num + "】");
		System.out.println( "c2インスタンスのgasの値は【" + gas + "】");
		System.out.println( "c2インスタンスのcolorの値は【" + color + "】");
		System.out.println();
		
		// 引数1個（引数がint型）のコンストラクターを使用し、インスタンスを生成
		Car c3 = new Car( 9898 );
		System.out.println();
		c3.show();
		System.out.println();
		
		// 引数1個（引数がdouble型）のコンストラクターを使用し、インスタンスを生成
		Car c4 = new Car( -3000.0 );
		System.out.println();
		c4.show();
		System.out.println();
		
		// 引数1個（引数がString型）のコンストラクターを使用し、インスタンスを生成
		Car c5 = new Car( "RED" );
		System.out.println();
		c5.show();
		System.out.println();
		c5.showSum();
		
		
		// 引数3個のコンストラクターを使用し、インスタンスを生成
		Car c6 = new Car( 1122 , 3500.0 , "BLUE" );
		System.out.println();
		c6.show();
		System.out.println();
		
		// 引数2個のコンストラクターを使用し、インスタンスを生成
		Car c7 = new Car( 3344 , 3800.0 );
		System.out.println();
		c7.show();
		System.out.println();
		
		// 引数1個（引数がString型）のコンストラクターを使用し、インスタンスを生成
		Car c8 = new Car( "GREEN" );
		System.out.println();
		c8.show();
		System.out.println();
		c8.showSum();
		System.out.println();

		// 引数1個（引数がString型）のコンストラクターを使用し、インスタンスを生成
		Car c9 = new Car( "YELLOW" );
		System.out.println();
		c9.show();
		System.out.println();
		c9.showSum();
		System.out.println();

		// 引数1個（引数がString型）のコンストラクターを使用し、インスタンスを生成
		Car c10 = new Car( "PURPLE" );
		System.out.println();
		c10.show();
		System.out.println();
		c10.showSum();
		System.out.println();
		
		Car c11 = new Car( 1357 , 2300.0 , "GLAY" );
		// インスタンスメソッドの呼び出し方法 ⇒ インスタンス参照変数名.メソッド名
		c11.i_func();
		System.out.println();
		
		// クラスメソッドの呼び出し方法 ⇒ クラス名.メソッド名
		Car.c_func();
		System.out.println();
		
	}

}
