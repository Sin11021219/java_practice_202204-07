package tk_sample;

/*
 * JO10_ClassBasicおよびJO11_ClassExtで取り上げていないクラスの細かい動作のサンプル
 */

class Member {
	private int id;
	private String name;
	private String address; 
	
	public Member() {}
	public Member( int id, String name , String address ) {
		setId( id );
		setName( name );
		setAddress( address );
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	public void setName( String name ) {
		this.name = name;
	}
	public void setAddress( String address ) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
	public void show() {
		System.out.println( "IDは【" + id + "】");
		System.out.println( "名前は【" + name + "】");
		System.out.println( "住所は【" + address + "】");
	}
	
	public void add_1( int arg ) {
		// 引数で受け取った値に1を加算し、引数として返す

		System.out.println( arg );
		arg++;
		/*
		arg +arg + 1;
		arg +=1;
		*/
		System.out.println( arg );
		
	}
	
	public void add_2( int[] arg ) {
		arg[0]++;
	}
	
}


public class JO13_ClassOther {
	
	
	public static boolean func( Member m ) {
		if( m == null ) {
			return false;
		}
		else {
			return true;
		}
	}

	public static void main(String[] args) {
		
		Member mem1 = null;
		Member mem2 = null;
		Member mem3 = null;
		Member mem4 = null;
		Member mem5 = null;
		Member mem6 = null;
		
		mem1 = new Member();
		mem1.setId(10);
		mem1.setName("山田");
		mem1.setAddress("東京");
		
		mem2  = new Member( 20 , "鈴木" , "千葉" );

		System.out.println( "***** インスタンス参照変数代入前 ***** ");
		
		mem1.show();
		System.out.println("mem1の参照先===>" + mem1 );
		System.out.println();
		
		mem2.show();
		System.out.println("mem2の参照先===>" + mem2 );
		System.out.println();
		
		// クラスのインスタンス参照変数どうしの代入
		System.out.println( "***** インスタンス参照変数代入後 ***** ");
		mem3 = mem2;
		mem2 = mem1;
		
		mem1.show();
		System.out.println("mem1の参照先===>" + mem1 );
		System.out.println();
		
		mem2.show();
		System.out.println("mem2の参照先===>" + mem2 );
		System.out.println();
		
		mem3.show();
		System.out.println("mem3の参照先===>" + mem3 );
		System.out.println();
		
		// ***** 値渡しで引数を渡した場合
		System.out.println( "***** 値渡しで引数を渡した場合 *****");
		int a = 10;
		System.out.println( "a===>【" + a +"】");
		// add_1()メソッド呼び出し
		mem1.add_1( a );
		System.out.println( "a===>【" + a +"】");
		System.out.println();
		
		//***** 参照渡しで引数を渡した場合
		System.out.println( "***** 参照渡しで引数を渡した場合 *****");
		int[] ary = new int[1];
		ary[0] = a;
		System.out.println( "ary[0]==>" + ary[0] );
		mem1.add_2( ary );
		System.out.println( "ary[0]==>" + ary[0] );
		System.out.println();
		
		mem4 = mem3;
		
		if( func( mem1) == true ) {
			System.out.println( "mem1はnullではありません" );
		}
		else if( func( mem1) != true ) {
			System.out.println( "mem1はnullです" );
		}
		if( func( mem2) ) {
			System.out.println( "mem2はnullではありません" );
		}
		else  if( func(mem2) == false ){
			System.out.println( "mem2はnullです" );
		}
		if( func( mem3) ) {
			System.out.println( "mem3はnullではありません" );
		}
		else {
			System.out.println( "mem3はnullです" );
		}
		if( func( mem4) ) {
			System.out.println( "mem4はnullではありません" );
		}
		else {
			System.out.println( "mem4はnullです" );
		}
		if( func( mem5) ) {
			System.out.println( "mem5はnullではありません" );
		}
		else {
			System.out.println( "mem5はnullです" );
		}
		if( func( mem6) ) {
			System.out.println( "mem6はnullではありません" );
		}
		else {
			System.out.println( "mem6はnullです" );
		}

	}

}
