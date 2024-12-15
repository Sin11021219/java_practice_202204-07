package tk_sample;
/*
 * 継承
 * 既存クラスの要素を引き継いで別のクラスを定義すること。
 * クラス継承の構文
 * アクセス修飾子 class クラス名 extends 継承元のクラス名{…}
 * 
 * 既存クラスを継承してクラスを定義した場合、既存クラスのクラスメンバーである
 * フィールドとメソッドは新たなクラスに引き継がれる。
 * 継承元のクラス（既存クラス）をスーパークラスや親クラスなどと呼ぶ。
 * 継承したクラス（新定義クラス）をサブクラスや子クラスなどと呼ぶ。
 * 継承できるクラス（スーパークラスに指定するクラス）は1つのみ。（多重継承は不可）
 * 
 * 継承した場合、親クラスのフィールドとメソッドは引き継がれるが、コンストラクターは
 * 引き継ぐことは出来ない。（クラス名が違うので当然！！！）
 * その代わりに、子クラスのコンストラクター内部で、親クラスのコンストラクターが
 * 自動的に呼び出される仕組みを持つ。
 * （何も指定しなければスーパークラスのデフォルトコンストラクターが自動的に呼び出される）
 * 
 * メソッドのオーバーライド
 * 多態性（ポリモーフィズム）の実装形態のひとつ。
 * 継承関係があるクラス間ではメソッドのオーバーライドが可能になる。
 * メソッドのオーバーライドとは、それぞれのクラスで同一の名前のメソッドの
 * 内容をそれぞれ別々の内容に書き換えて定義することである。
 * オーバーライドの定義条件は、メソッド名や引数の数や型が全て同一であること。
 * 
 */

class RacingCar extends NormalCar {
	
	// ***** フィールドの定義 *****
	private String team;
	private String driver;
	private String exp_parts;
	
	// ***** コンストラクターの定義 *****
	public RacingCar() {
		System.out.println( "***** RacingCarの引数なしのコンストラクター *****" );
	}
	public RacingCar
	( int num , double gas , String color , String team , String driver , String exp_parts ) {
		
		// 設定パターン①
		// 親クラス（NormalCar）のフィールドは全て継承するので、以下の様に
		// thisキーワードを使って修飾することは可能。
		/*
		this.num = num;
		this.gas = gas;
		this.color = color;
		this.team = team;
		this.driver = driver;
		this.exp_parts = exp_parts;
		*/
		
		
		// 設定パターン②
		// ↑上記のような修飾も使用できるが、親クラスと子クラスのフィールドなどを
		// 明示的に区別したい場合などは親用のキーワード（super）を使い修飾する方法もある。
		/*
		super.num = num;
		super.gas = gas;
		super.color = color;
		this.team = team;
		this.driver = driver;
		this.exp_parts = exp_parts;
		*/
		
		// 設定パターン③
		// ↑上記のような方法でも良いが、上記の場合、全ての引数の値が、全ての
		// フィールドに対し、無条件で設定されてしまうので、Setterを使用する方法が良い。
		/*
		setNum( num );
		setGas( gas );
		setColor( color );
		setTeam( team );
		setDriver( driver );
		setExp_Parts( exp_parts );
		*/
		
		// 設定パターン④
		// ↑上記のようにSetterを使用しても良いが、継承したクラスの場合
		// コンストラクターの特性を生かして、以下の様な方法でも良い。
		
		super( num , gas , color );  // NormalCarの引数3個のコンストラクターを呼び出す
		setTeam( team );
		setDriver( driver );
		setExp_Parts( exp_parts );
		System.out.println( "***** RacingCarの引数6個のコンストラクター *****" );
		
	}
	
	// ***** フィールド設定用メソッド *****
	public void setTeam( String team ) {
		this.team = team;
	}
	public void setDriver( String driver ) {
		this.driver = driver;
	}
	public void setExp_Parts( String exp_parts ) {
		this.exp_parts = exp_parts;
	}
	
	// ***** フィールド取得用メソッド *****
	public String getTeam() {
		return team;
	}
	public String getDriver() {
		return driver;
	}
	public String getExp_Parts() {
		return exp_parts;
	}
	
	// ***** フィールド表示用メソッド *****
	/*
	 * NormalCarクラスに定義されているshor()メソッドをRacingCarクラスで
	 * オーバーライドする。
	 * 「@Override」のアノテーションは必ず付ける必要は無いが
	 * メソッドをオーバーライドしているという事がわかるように、付けておいた方が良い。
	 */
	@Override
	public void show() {
		System.out.println( "RacingCarのnum==> 【" + num + "】");
		System.out.println( "RacingCarのgas==> 【" + gas + "】");
		System.out.println( "RacingCarのcolor==> 【" + color + "】");
		System.out.println( "RacingCarのteam==> 【" + team + "】");
		System.out.println( "RacingCarのdriver==> 【" + driver + "】");
		System.out.println( "RacingCarのexp_parts==> 【" + exp_parts + "】");
	}
	
}	

class NormalCar {
	
	// ***** フィールドの定義 *****
	protected int num;
	protected double gas;
	protected String color;
	
	// *****コンストラクターの定義 *****
	public NormalCar() {
		System.out.println( "***** NormalCarの引数なしのコンストラクター *****" );
	}
	public NormalCar( int num , double gas , String color ) {
		System.out.println( "***** NormalCarの引数3個のコンストラクター *****" );
		setNum(num );
		setGas( gas );
		setColor( color );
	}
	
	
	// ***** フィールド設定用メソッド *****
	public void setNum( int num ) {
		this.num = num;
	}
	public void setGas( double gas ) {
		if( gas >= 0 ) {
			this.gas = gas;
		}
	}
	public void setColor( String color ) {
		this.color = color;
	}
	
	// ***** フィールド取得用メソッド *****
	public int getNum() {
		return num;
	}
	public double getGas() {
		return gas;
	}
	public String getColor() {
		return color;
	}
	
	// ***** フィールド値表示用メソッド *****
	public void show() {
		System.out.println( "NormalCarのnum==>【" + num + "】" );
		System.out.println( "NormalCarのgas==>【" + gas + "】" );
		System.out.println( "NormalCarのcolor==>【" + color + "】" );
	}
}

class X{
	boolean b;
	char c;
	int i;
}


public class JO11_ClassExt {

	public static void main(String[] args) {
		
		NormalCar nc1 = new NormalCar();
		nc1.setNum( 1234 );
		nc1.setGas(2500.0);
		nc1.setColor( "WHITE" );
		nc1.show();
		System.out.println();
		
		NormalCar nc2 = new NormalCar( 5678 , 3000.0 , "BLACK" );
		nc2.show();
		System.out.println();
		
		RacingCar rc1 = new RacingCar();
		/* フィールドはカプセル化するので、以下の様な直接参照はしない！！
		rc1.num = 1111;
		rc1.gas = 5000.0;
		rc1.color = "RED";
		rc1.team = "X-RACING";
		rc1.driver = "あいう";
		rc1.exp_parts = "WING";
		rc1.show();
		System.out.println( "team=>" + rc1.team );
		System.out.println( "driver=>" + rc1.driver );
		System.out.println( "exp_parts=>" + rc1.exp_parts );
		System.out.println();
		*/
		rc1.setNum( 9999 );
		rc1.setGas( 4500.0 );
		rc1.setColor( "PINK" );
		rc1.setTeam( "MSR" );
		rc1.setDriver( "つかだ" );
		rc1.setExp_Parts( "WING" );
		rc1.show();
		System.out.println( "team=>" + rc1.getTeam() );
		System.out.println( "driver=>" + rc1.getDriver() );
		System.out.println( "exp_parts=>" + rc1.getExp_Parts() );
		System.out.println();
		
		RacingCar rc2 = new RacingCar
				( 8888 , 5000.0 , "PURPLE" , "X-RACING" , "たかはし" , "AERO" );
		rc2.show();
		System.out.println();
		
		/*
		 * 親クラスであるNormalCarクラスをインスタンス参照変数の型にして
		 * 子クラスであるRacingCarクラスのインスタンスを生成する。
		 */
		NormalCar rc3 = new RacingCar();
		rc3.setNum( 7788 );
		rc3.setGas( 6500.0 );
		rc3.setColor( "RED" );
		rc3.show();
		System.out.println();
		
		/*
		 * スーパークラス（親）の配列を用意し、スーパークラス（親）とサブクラス（子）
		 * のインスタンスを同時にまとめて処理する例
		 */
		
		System.out.println
		( "***** スーパークラスとサブクラスのインスタンスを混在させた処理の例 *****" );
		
		// NormalCarクラスを型にした配列の定義と要素数の確保
		NormalCar[] car_ary = new NormalCar[6];
		
		for( int i=0 ; i<car_ary.length ; i++ ) {
			switch( i ) {
			case 0:
				// NormalCarクラスのインスタンスを生成し配列に格納
				car_ary[i] = new NormalCar( 1001 , 2000.0 , "白" );
				car_ary[i].show();
				break;
			case 1:
				// RacingCarクラスのインスタンスを生成し配列に格納
				car_ary[i] = new RacingCar
				( 9991 , 6500.0 , "RED" , "OP-RACING" , "LUFFY" , "WING" );
				car_ary[i].show();
				break;
			case 2:
				// NormalCarクラスのインスタンスを生成し配列に格納
				car_ary[i] = new NormalCar( 1002 , 3000.0 , "黒" );
				car_ary[i].show();
				break;
			case 3:
				// RacingCarクラスのインスタンスを生成し配列に格納
				car_ary[i] = new RacingCar
				( 9992 , 7500.0 , "BLUE" , "OP-RACING" , "ZORO" , "AERO" );
				car_ary[i].show();
				break;
			case 4:
				// RacingCarクラスのインスタンスを生成し配列に格納
				car_ary[i] = new RacingCar
				( 9993 , 8500.0 , "YELLOW" , "OP-RACING" , "NAMI" , "DEFF" );
				car_ary[i].show();
				break;
			case 5:
				// NormalCarクラスのインスタンスを生成し配列に格納
				car_ary[i] = new NormalCar( 1003 , 4000.0 , "赤" );
				car_ary[i].show();
				break;
			}
			System.out.println();
		}

	}

}
