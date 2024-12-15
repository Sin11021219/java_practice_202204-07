package tk_sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * スレッドクラスの定義
 * スレットクラスを定義する場合は、Threadクラスを継承する。
 * 
 * スレッドクラスを定義する場合、そのスレッドのエントリポイントとなる
 * runメソッドをオーバーライドして実装する。
 */

class Walker extends Thread {
	
	private String name;		// 名前
	private int dist;				// 距離
	
	public Walker() {}
	public Walker( String name , int dist ) {
		this.name = name;
		this.dist = dist;
	}
	
	@Override
	public void run() {
		for( int i=0 ; i<=dist ; i++ ) {
			System.out.println( name + "さんは" + i + "メートルをウォーキングしました" );
		}
	}
	
}

class Runner extends Thread {
	
	private String name;		// 名前
	private int dist;				// 距離
	
	public Runner() {}
	public Runner( String name , int dist ) {
		this.name = name;
		this.dist = dist;
	}
	
	@Override
	public void run() {
		for( int i=0 ; i<=dist ; i++ ) {
			System.out.println( name + "さんは" + i + "メートルをランニングしました" );
		}
	}
	
}

class Bycycle extends Thread {
	
	private String name;		// 名前
	private int dist;				// 距離
	
	public Bycycle() {}
	public Bycycle( String name , int dist ) {
		this.name = name;
		this.dist = dist;
	}
	
	@Override
	public void run() {
		for( int i=0 ; i<=dist ; i++ ) {
			try {
				/*
				 * sleep()はThreadクラスのメソッド
				 * 引数の単位はミリ秒
				 * sleepを使用するとスレッドの動作を指定した時間分、停止させることができる
				 */
				sleep( 1000 );
				System.out.println( name + "さんは" + i + "メートルをサイクリングしました" );
			}
			catch( InterruptedException e ) {}
		}
	}
	
}

class UsualCar {
	
	protected String name;
	protected int dist;
	
	public UsualCar() {}
	public UsualCar( String name , int dist ) {
		this.name = name;
		this.dist = dist;
	}
}

class HibridCar extends UsualCar implements Runnable {
	
	public HibridCar() {}
	public HibridCar( String name , int dist ) {
		super( name, dist );
	}
	
	@Override
	public void run() {
		for( int i=0 ; i<=dist ; i++ ) {
			System.out.println( name + "さんは" + i + "メートルをドライブしました" );
		}
	}
}

// 派遣会社クラス
class Company {
	
	private int sum = 0;  // 合計額用フィールド

	// 各スレッドが稼いた分の利益を加算していくメソッド
	
	//public void add( int money ) {
	
	/*
	 * 複数の並行するスレッド（処理）が共通の項目を参照したり更新する場合などは
	 * それぞれのスレッドが同期を取りながら処理を行う必要がある。
	 * 同期を取るメソッドを定義する場合は、「synchronized」キーワードを指定する。
	 */
	public synchronized void add( int money ) {
		int temp = sum;
		System.out.println( "現在、合計額は" + temp + "円です" );
		System.out.println( money + "円稼ぎました" );
		temp += money;
		System.out.println( "合計額を" + temp + "円にします" );
		sum = temp;
	}
	
}

// 派遣社員クラス
class Employee extends Thread {
	
	private Company comp;
	private String name;
	private int money;
	
	public Employee() {}
	public Employee( Company comp , String name , int money ) {
		this.comp = comp;
		this.name = name;
		this.money = money;
	}
	
	@Override
	public void run() {
		final int WORK_DAY = 5;
		for( int i=1 ; i<=WORK_DAY ; i++ ) {
			System.out.println
			( name + "さんが" + i + "日出勤しました。" + money + "円の利益が発生しました" );
			comp.add( money );
		}
	}
}


public class JO22_Thread {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
		
		try {
			
			System.out.println( "プログラムの処理内容を選択してください" );
			System.out.println( "1：スレッドの基本動作　2：同期処理" );
			int mode = Integer.parseInt( br.readLine() );
			System.out.println();
			
			switch( mode ) {
			case 1:
				
				// ***** 各スレットクラスのインスタンスを生成 *****
				
				System.out.println( "歩く人の名前を入力してください" );
				String name = br.readLine();
				System.out.println( name + "さんが歩く距離を入力してください" );
				int dist = Integer.parseInt( br.readLine() );
				Walker walker = new Walker( name , dist );
				System.out.println();
				
				System.out.println( "走る人の名前を入力してください" );
				name = br.readLine();
				System.out.println( name + "さんが走る距離を入力してください" );
				dist = Integer.parseInt( br.readLine() );
				Runner runner = new Runner( name , dist );
				System.out.println();
				
				System.out.println( "自転車で走る人の名前を入力してください" );
				name = br.readLine();
				System.out.println( name + "さんが自転車で走る距離を入力してください" );
				dist = Integer.parseInt( br.readLine() );
				Bycycle bycycle = new Bycycle( name , dist );
				System.out.println();
				
				System.out.println( "ハイブリッドカーを運転する人の名前を入力してください" );
				name = br.readLine();
				System.out.println( name + "さんがハイブリッドカーを運転する距離を入力してください" );
				dist = Integer.parseInt( br.readLine() );
				HibridCar hibrid_car = new HibridCar( name , dist );
				System.out.println();
				
				/*
				 * Threadクラスを継承していないHibridCarクラスをスレッドとして起動させる方法
				 * -----------------------------------------------------------------------
				 * start()メソッドが使用できない理由
				 * 
				 * HibridCarクラスはRunnableインターフェイスを実装して
				 * 定義されているクラスではあるが、Threadクラスそのものを
				 * 継承しているわけではないので、HibridCarクラスのインスタンス
				 * からはstart()メソッドを起動することはできない。
				 * （startメソッドはThreadクラスに定義されているが
				 *   Runnableインターフェイス内には定義されていない）
				 *   
				 * -----------------------------------------------------------------------  
				 * スレッドとして起動させる方法
				 * 
				 * HibridCarクラスのようにThreadクラスを継承していないクラスを
				 * スレッドとして動かすためには、Threadクラスのインスタンスを生成し
				 * そのインスタンスにHibridCarクラスのインスタンスを乗せる（使う）必要がある。
				 * これにより、Threadクラスのインスタンスを使い、HibridCarクラスを
				 * スレッドとして動作させることが可能になる。
				 */
				Thread thread = new Thread( hibrid_car );
				
				// ***** スレッドの起動 *****
				/*
				 * スレッドはstart()メソッドで起動する。
				 * スレッドクラスのインスタンスからstart()メソッドを起動すると
				 * スレッドクラス内部に定義されたrun()メソッドが呼び出されて処理を行う。
				 */
				walker.start();
				try {
					walker.join();	// 当該スレッドが終了するまで他のスレッドは待機する
				}
				catch( InterruptedException e ) {}
				runner.start();
				bycycle.start();
				thread.start();
				
				bycycle.start();
				
				for( int i=0 ; i<=100 ; i++ ) {
					System.out.println( "mainメソッド内のfor文を実行中：" + i + "回目" );
				}
				break;
			case 2:
				
				System.out.println( "1人目の派遣社員の名前を入力してください" );
				String name1 = br.readLine();
				System.out.println( "2人目の派遣社員の名前を入力してください" );
				String name2 = br.readLine();
				System.out.println( "3人目の派遣社員の名前を入力してください" );
				String name3 = br.readLine();
				
				// 派遣会社クラスのインスタンスを生成
				Company comp = new Company();
				
				// 各派遣社員クラス（スレッドクラス）のインスタンスを生成
				Employee emp1 = new Employee( comp , name1 , 10000 );
				Employee emp2 = new Employee( comp , name2 , 10000 );
				Employee emp3 = new Employee( comp , name3 , 10000 );
				
				// 各スレッド（派遣社員）を起動
				emp1.start();
				emp2.start();
				emp3.start();
				
				break;
			}
			
		}
		catch( Exception e ) {}

	}

}
