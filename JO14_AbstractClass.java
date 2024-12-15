package tk_sample;

/*
 * 抽象クラスを使用したサンプル
 * 
 * 抽象クラス定義の構文
 * アクセス修飾子 abstract class クラス名 {
 * 		・フィールド定義
 * 		・コンストラクター定義
 * 		・メソッド定義（抽象メソッドを定義できる）
 * }
 * 
 * ・抽象メソッドを定義する場合は、abstractキーワードを付加する。
 * ・通常のフィールドやメソッドを定義可能。
 * ・コンストラクターも定義可能。
 * ・抽象メソッド（メソッド名の定義だけで処理内容が定義されていないもの）を定義可能。
 * ・クラスのインスタンスは生成できない。
 * 
 */

abstract class Food {
	
	// ***** フィールドの定義 *****
	protected String name;				// 名前
	protected String taste;				// 味
	protected String smell;				// 匂い
	protected int price;						// 価格
	protected String[] material;			// 材料
	
	// ***** コンストラクターの定義 *****
	public Food() {}
	public Food( String name , String taste , String smell , int price , String[] material ) {
		setName( name );
		setTaste( taste );
		setSmell( smell );
		setPrice( price );
		setMaterial( material );
	}
	
	// ***** 各種メソッドの定義 *****
	
	// フィールド値設定用メソッド（Setter） *****
	public void setName( String name ) {
		this.name = name;
	}
	public void setTaste( String taste ) {
		this.taste = taste;
	}
	public void setSmell( String smell ) {
		this.smell = smell;
	}
	public void setPrice( int price ) {
		this.price = price;
	}
	public void setMaterial( String[] material ) {
		this.material = material;
	}
	
	// フィールド値設定用メソッド（Getter） *****
	public String getName() {
		return name;
	}
	public String getTaste() {
		return taste;
	}
	public String getSmell() {
		return smell;
	}
	public int getPrice() {
		return price;
	}
	public String[] getMaterial() {
		return material;
	}
	
	/*
	 * 調理方法であるcook()メソッドは、各料理によって調理方法が異なるため
	 * 抽象クラス内部では処理内容を定義できない為、抽象メソッド（※）として定義する。
	 * ※：抽象メソッド⇒メソッド名だけを定義し、処理内容を一切定義しないメソッド。
	 */
	public void cook() {}
	
	public void show() {
		System.out.println( name + "の味は【" + taste + "】です" );
		System.out.println( name + "の匂いは【" + smell + "】です" );
		System.out.println( name + "の値段は【" + price + "】です" );
		System.out.print( name + "の材料は【" );
		for( int i=0 ; i<material.length ; i++ ) {
			if( i != material.length -1 ) {
				System.out.print( material[i] + "," );
			}
			else {
				System.out.println( material[i] + "】です" );
			}
		}
	}
}

// ラーメンクラス
class Ramen extends Food {
	
	// ***** コンストラクターの定義 *****
	public Ramen() {}
	public Ramen
	( String name , String taste , String smell , int price , String[] material ) {
		super( name , taste , smell , price , material );
	}
	
	@Override
	public void cook() {
		System.out.println( "-----------------------------------------------\n" +
							name + "の作り方は" + material[0] + "を茹で" + material[1] + 
							"を丼ぶりに注ぎ" + material[0] + "を入れ\n" + material[2] + "、" +
							material[3] + "、" + material[4] + "などをトッピングし完成です" );
	}
}

// カレークラス
class Curry extends Food {
	public Curry() {}
	public Curry
	( String name, String taste , String smell , int price , String[] material ) {
		super( name, taste , smell, price , material );
	}
	
	@Override
	public void cook() {
		System.out.println( "-----------------------------------------------\n" +
						name + "の作り方は" + material[0] + "を炒め、そこへ" + material[1] +
						"を入れ、更に炒め\n" + material[2] + "を入れ煮る" + 
						material[3] + "を入れて少し煮たら完成です" );
	}
}

// ハンバーグクラス
class Hamburg extends Food {
		public Hamburg() {}
		public Hamburg
		( String name , String taste , String smell , int price , String[] material ) {
			super( name , taste , smell , price , material );
		}
		
		@Override
		public void cook() {
			System.out.println( "-----------------------------------------------\n" +
						name + "の作り方は" + material[1] + "をよく炒め、そこへ" +
						material[0] + "と\n" + material[2] + "更に" + material[3] + 
						"を入れて粘りが出るまでよく混ぜ、形を形成して焼く。\n" +
						"ソースは" + material[4] + "と" + material[5] + "更に" + 
						material[6] + "火にかけ作る" );
			
		}
}

public class JO14_AbstractClass {

	public static void main(String[] args) {
		
		// 抽象クラスであるFoodを型にした配列を定義
		Food[] food = new Food[3];
		
		for( int i=0 ; i<food.length ; i++ ) {
			
			switch( i ) {
			case 0:
				String[] mate1 = { "麺" , "スープ" , "ネギ" , "メンマ" , "チャーシュー" };
				food[i] = new Ramen
						( "ラーメン" , "しょうゆ味" , "香味野菜と鶏だしの香り", 800 , mate1 );
				break;
			case 1:
				String[] mate2 = { "肉" ,  "野菜" , "ブイヨンスープ" , "カレールー" };
				food[i] = new Curry
						( "カレー" , "スパイシーな味" , "食欲をそそるスパイスの香り" , 750 , mate2 );
				break;
			case 2:
				String[] mate3 = { "合い挽き肉" , "玉ねぎ" , "パン粉" , "卵" , 
													"ケチャップ" , "ウスターソース" , "赤ワイン" };
				food[i] = new Hamburg
						( "ハンバーグ" , "肉の旨味" , "香ばしいソースの香り" , 1000 , mate3 );
				break;
			}
			food[i].show();
			food[i].cook();
			System.out.println();
		}

	}

}
