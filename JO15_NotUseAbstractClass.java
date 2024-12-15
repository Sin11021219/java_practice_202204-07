package tk_sample;

/*
 * JO14_AbstractClassを基に抽象クラスを使用しない形にしたサンプル
 */

class Ramen_CL {
	
	// ***** フィールドの定義 *****
	protected String name;				// 名前
	protected String taste;				// 味
	protected String smell;				// 匂い
	protected int price;						// 価格
	protected String[] material;			// 材料
	
	// ***** コンストラクターの定義 *****
	public Ramen_CL() {}
	public Ramen_CL( String name , String taste , String smell , int price , String[] material ) {
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
	
	public void cook() {
		System.out.println( "-----------------------------------------------\n" +
							name + "の作り方は" + material[0] + "を茹で" + material[1] + 
							"を丼ぶりに注ぎ" + material[0] + "を入れ\n" + material[2] + "、" +
							material[3] + "、" + material[4] + "などをトッピングし完成です" );
	}
	
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


class Curry_CL {
	
	// ***** フィールドの定義 *****
	protected String name;				// 名前
	protected String taste;				// 味
	protected String smell;				// 匂い
	protected int price;						// 価格
	protected String[] material;			// 材料
	
	// ***** コンストラクターの定義 *****
	public Curry_CL() {}
	public Curry_CL( String name , String taste , String smell , int price , String[] material ) {
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
	
	public void cook() {
		System.out.println( "-----------------------------------------------\n" +
						name + "の作り方は" + material[0] + "を炒め、そこへ" + material[1] +
						"を入れ、更に炒め\n" + material[2] + "を入れ煮る" + 
						material[3] + "を入れて少し煮たら完成です" );
	}
	
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


class Hamburg_CL {
	
	// ***** フィールドの定義 *****
	protected String name;				// 名前
	protected String taste;				// 味
	protected String smell;				// 匂い
	protected int price;						// 価格
	protected String[] material;			// 材料
	
	// ***** コンストラクターの定義 *****
	public Hamburg_CL() {}
	public Hamburg_CL( String name , String taste , String smell , int price , String[] material ) {
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
	
	public void cook() {
		System.out.println( "-----------------------------------------------\n" +
					name + "の作り方は" + material[1] + "をよく炒め、そこへ" +
					material[0] + "と\n" + material[2] + "更に" + material[3] + 
					"を入れて粘りが出るまでよく混ぜ、形を形成して焼く。\n" +
					"ソースは" + material[4] + "と" + material[5] + "更に" + 
					material[6] + "火にかけ作る" );
		
	}
	
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

public class JO15_NotUseAbstractClass {

	public static void main(String[] args) {
		
		String[] mate1 = { "麺" , "スープ" , "ネギ" , "メンマ" , "チャーシュー" };
		Ramen_CL ramen = new Ramen_CL
				( "ラーメン" , "しょうゆ味" , "香味野菜と鶏だしの香り", 800 , mate1 );
		ramen.show();
		ramen.cook();
		System.out.println();
		
		String[] mate2 = { "肉" ,  "野菜" , "ブイヨンスープ" , "カレールー" };
		Curry_CL curry = new Curry_CL
				( "カレー" , "スパイシーな味" , "食欲をそそるスパイスの香り" , 750 , mate2 );
		curry.show();
		curry.cook();
		System.out.println();
		
		String[] mate3 = { "合い挽き肉" , "玉ねぎ" , "パン粉" , "卵" , 
											"ケチャップ" , "ウスターソース" , "赤ワイン" };
		Hamburg_CL hamburg = new Hamburg_CL
				( "ハンバーグ" , "肉の旨味" , "香ばしいソースの香り" , 1000 , mate3 );
		hamburg.show();
		hamburg.cook();
		System.out.println();

	}

}
