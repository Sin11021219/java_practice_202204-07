package tk_sample;

/*
 * 抽象クラス
 * 構文：abstract class クラス名
 * 特徴：・フィールドとメソッドは定義可能
 * 　　　・抽象メソッドを定義可能
 * 　　　・継承して使用される（多重継承不可）
 * 　　　・インスタンスは生成できない
 * 
 * インターフェイス
 * 構文：interface インターフェイス名
 * 特徴：・フィールドは定義可能（public static finalが付加された状態）
 * 　　　・メソッドは定義可能（抽象メソッドのみ定義可能）
 * 　　　・クラス（具象/抽象）に実装することで使用される（多重実装可能）
 * 　　　・インスタンスは生成できない
 * 
 * クラスがインターフェイスを実装する時の構文
 * class クラス名 implements インターフェイス名
 * 
 * 抽象クラスとインターフェイスの使い分け例
 * 抽象クラスは他のクラスの処理の骨組み（枠組み）を定義する場合などに使用
 * インターフェイスはクラスで共通する仕樣（メソッド構成など）を定義する場合などに使用
 * 
 * 以下の様なイメージ
 * クラス共通の仕樣（インターフェイス）
 * ↓
 * クラスの全体的な構造（抽象クラス）
 * ↓
 * 個別のクラス定義（具象クラス）
 * 
 * --------------------------------------------------------------------------------
 * インターフェイスを定義する場合のイメージ
 * 
 * 音楽を聴くためのもの！
 * 
 * （ソフト）メディア　　カセットテープ　　MD（MiniDisk）　　CD（CompactDisk）　　デジタル音源ファイル
 * 
 * （ハード）機器　　　　ラジカセ　　　　　MDプレーヤー　　　CDプレーヤー　　　　　　音源ファイルプレーヤー
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　（walkman, ipod,スマホなど）
 * 
 * 上記のように、「音楽を聴く」という事を考えた場合、様々なタイプのメディア（ソフト）があり
 * また、それらを利用するための機器（ハード）があるが、「音楽を聴く」という動作には
 * 共通の機能がある。それらが以下のもの。
 * ↓
 * 再生　　　　停止　　　　一旦停止　　　　先送り　　　　逆戻し　←動作（動き/働き）
 * play()　　　stop()　　　pause()　　　　forward()　　reverse()
 * ↑
 * インターフェイスでこれらを定義（機能の名前のみを定義する）（例：インターフェイス：Music）
 * 
 * 各種メディアや各種機器によって、実際に行われている動作（具体的な処理内容）は異なるが
 * 「再生」や「停止」といった動作そのものは共通なので、その共通する「動き」の「名前」だけを
 * インターフェイスに定義する。
 * 
 * 以下はソースイメージ
 * 
 * interface Music {
 * 		public void play();
 * 		public void stop();
 * 		public void pause();
 * 		public void forward();
 * 		public void reverse();
 * }
 * 
 * abstract class MusicPlayer implements Music {
 * }
 * 
 * Music（インターフェイス）を実装したMusicPlayer（抽象クラス）を継承した
 * 各種の具象クラスでは、それぞれの機種やメディアに応じた各種メソッド（playやstopなど）を実装する。
 * 
 * class Cassette extends MusicPlayer {
 * 		public void play() {
 * 			System.out.println
 * 			( "カセットテープは磁気テープを再生ヘッドに巻き込んで記録された内容を読み取り再生する" );
 * 		}
 * 		public void stop() { カセットテープ用停止処理 }
 * 		public void pause() { カセットテープ用一旦停止処理 }
 * 		public void forward() { カセットテープ用先送り処理 }
 * 		public void reverse() { カセットテープ用逆戻し処理 }
 * }
 * 
 * class CD extends MusicPlayer {
 * 		public void play() {
 * 			System.out.println
 * 			( "再生用のレーザーを光学ディスクに照射し、ディスクに書き込まれた記録を読み取り再生する" );
 * 		}
 * 		public void stop() { CD用停止処理 }
 * 		public void pause() { CD用一旦停止処理 }
 * 		public void forward() { CD用先送り処理 }
 * 		public void reverse() { CD用逆戻し処理 }
 * }
 * 
 * 上記のような仕組みで、インターフェイスやクラスなどを定義した場合
 * 各クラスをまとめて処理する場合は、以下のようにインターフェイスや抽象クラスなどの
 * 配列やArrayListなどを使って処理することができる。
 * 
 * Music（インターフェイス）を型にした配列を使用し、
 * 配列の要素にCasseteクラスのインスタンスを格納した例
 * ↓
 * Music[] m = Music[5];
 * m[0] = new Cassette();
 * 
 * MusicPlayer（抽象クラス）を型にしたArrayListのインスタンスを用意し
 * そのArrayListの要素（箱の部分）にCasstteクラスのインスタンスを格納した例
 * ↓
 * ArrayList<MusicPlayer> array_list = new ArrayList<MusicPlayer>();
 * array_list.add( new Cassette() );
 * 
 */

/*
 * 行動に関する抽象メソッドを定義したインターフェイス（Action）を定義
 */
interface Action {
	// ***** 抽象メソッド定義 *****
	public void eat();				// 食事用メソッド（食べる）
	public void sleep();				// 睡眠用メソッド（寝る）
	public void move();				// 移動用メソッド（動く）
}

/*
 * インターフェイスを実装した抽象クラス（Creature）を定義する
 */
abstract class Creature implements Action {
	
	// ***** フィールド定義 *****
	protected String type;				// 種別
	protected int leg;					// 足の数
	
	// ***** コンストラクター定義 *****
	public Creature() {}
	public Creature( String type , int leg  ) {
		setType( type );
		setLeg( leg );
	}
	
	// ***** Setter *****
	public void setType( String type ) {
		this.type = type;
	}
	public void setLeg( int leg ) {
		this.leg = leg;
	}
	
	// ***** Getter *****
	public String getType() {
		return type;
	}
	public int getLeg() {
		return leg;
	}
	
	// ***** 表示用メソッド *****
	public void show() {
		System.out.println( "種別は【" + type + "】です" );
		eat();
		sleep();
		move();
	}
	
}

// 具象クラス（Human 人間）を定義
class Human extends Creature {
	
	public Human() {}
	public Human( String type , int leg ) {
		super( type , leg );
	}
	

	@Override
	public void eat() {
		System.out.println( type + "は何でも食べます" );
	}
	
	@Override
	public void sleep() {
		System.out.println( type + "はベッドや布団などで横になって寝ます" );
	}
	
	@Override
	public void move() {
		System.out.println( type + "は" + leg + "足歩行で移動します" );
	}
	
}

//具象クラス（Tiger トラ）を定義
class Tiger extends Creature {
	
	public Tiger() {}
	public Tiger( String type , int leg ) {
		super( type , leg );
	}
	
	@Override
	public void eat() {
		System.out.println( type + "肉食です" );
	}
	
	@Override
	public void sleep() {
		System.out.println( type + "は丸くなって寝ます" );
	}
	
	@Override
	public void move() {
		System.out.println( type + "は" + leg + "足歩行で移動します" );
	}
	
}

//具象クラス（Zebra シマウマ）を定義
class Zebra extends Creature {
	
	public Zebra() {}
	public Zebra( String type , int leg ) {
		super( type , leg );
	}
	
	@Override
	public void eat() {
		System.out.println( type + "は草食です" );
	}
	@Override
	public void sleep() {
		System.out.println( type + "は立ったまま寝ます" );
	}
	@Override
	public void move() {
		System.out.println( type + "は" + leg + "足歩行で移動します" );
	}
	
}
//具象クラス（Octopus タコ）を定義
class Octopus extends Creature {
	
	public Octopus() {}
	public Octopus( String type , int leg ) {
		super( type , leg );
	}
	
	@Override
	public void eat() {
		System.out.println( type + "は雑食です" );
	}
	
	@Override
	public void sleep() {
		System.out.println( type + "は体の色を変えて寝ます" );
	}
	
	@Override
	public void move() {
		System.out.println( type + "は" + leg + "足泳行で移動します" );
	}
}

public class JO16_AbstractAndInterface {

	public static void main(String[] args) {
		
		final int ARRAY_MAX = 4;
		
		Creature[] creature = new Creature[ARRAY_MAX];
		
		for( int i=0 ; i<creature.length ; i++ ) {
			switch( i ){
				case 0:
					creature[i] = new Human( "人間" , 2 );
					break;
				case 1:
					creature[i] = new Tiger( "トラ" , 4  );
					break;
				case 2:
					creature[i] = new Zebra( "シマウマ" , 4 );
					break;
				case 3:
					creature[i] = new Octopus( "タコ" , 8 );
					break;
			}
			creature[i].show();
			System.out.println();
		}

	}

}
