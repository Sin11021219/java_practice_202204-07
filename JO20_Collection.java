package tk_sample;

/*
 * このサンプルでは、ジェネリックスを使った場合と使わない場合のコードの
 * 違いを示すため、敢えてジェネリックスを使用しない箇所が数箇所あるため
 * その部分のWarningはそのままになっている。
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

abstract class Fruits {
	protected String color;
	protected String taste;
	
	public Fruits() {}
	public Fruits( String color , String taste ) {
		this.color = color;
		this.taste = taste;
	}
}

class Apple extends Fruits {
	public Apple() {}
	public Apple( String color , String taste ) {
		super( color, taste );
	}
	@Override
	public String toString() {
		return this.color + "＆" + this.taste;
	}
}

class Lemon extends Fruits {
	public Lemon() {}
	public Lemon( String color, String taste ) {
		super( color , taste );
	}
}

public class JO20_Collection {

	public static void main(String[] args) {
		
		// ***** ArrayListを使用したサンプル *****
		
		// 配列を使用した場合
		System.out.println( "***** 配列のデータ表示 *****" );
		String[] array = { "Luffy" , "Zoro" , "Nami" };
		for( int i=0 ; i<array.length ; i++ ) {
			System.out.println( "array[" + i + "]==>" + array[i] );
		}
		System.out.println();
		
		// ArrayListにStringオブジェクトを格納した例
		ArrayList al1 = new ArrayList();
		al1.add( "Luffy" );
		al1.add( "Zoro" );
		al1.add( "Nami" );
		
		System.out.println( "***** ArrayListのデータ表示① *****" );
		for( int i=0 ; i<al1.size() ; i++ ) {
			System.out.println( "al1(" + i + ")==>" + al1.get( i ) );
		}
		System.out.println();
		/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		 * 配列の場合は、要素数の取得にlengthキーワードを指定することで要素数を
		 * 取得できるが、ArraListの場合は、size()メソッドを指定することで
		 * ArrayListの要素数を取得できる。
		 * 
		 * Listの主なメソッド
		 * ・add（要素の追加）
		 * ・get（要素内の値の取得）
		 * ・size（要素数の取得）
		 */
		
		// ArrayListに型の異なるオブジェクトを格納した例
		ArrayList al2 = new ArrayList();
		al2.add( "Apple" );									// 文字列（Stringオブジェクト）
		al2.add( new Apple( "red" , "sweet" ) );	// クラスのインスタンス（Appleクラス）
		al2.add( 100 );										// 整数値（Integerオブジェクト）
		
		System.out.println( "***** ArrayListのデータ表示② *****" );
		for( int i=0 ; i<al2.size() ; i++ ) {
			Object obj = al2.get( i );
			System.out.println( "al2(" + i + ")==>" + obj );
		}
		System.out.println();
		
		/*
		 * 実体変数（基本データ型の変数）や参照変数（配列やクラス）の
		 * 変数そのものを表示した場合の表示される値の比較
		 * 
		 * 特にクラス内にtoString()メソッドが有る場合と無い場合の
		 * 表示される値の確認のためのコード
		 * 
		 * このコードの部分は今回のCollectionの内容とは全く関係ない！！！！
		 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
		int num = 10;
		int[] i_ary = { 10, 20 };
		Apple apple = new Apple( "red" , "sweet" );
		Lemon lemon = new Lemon( "yellow" , "sour" );
		System.out.println( "num ==>" + num );
		System.out.println( "i_ary ==>" + i_ary );
		System.out.println( "apple ==>" + apple );
		System.out.println( "lemon ==>" + lemon );
		System.out.println();
		
		/*
		 * Mapの主なメソッド
		 * ・put（要素（キーと値）の追加）
		 * ・keySet（キー部分の取得）
		 * ・get（引数に指定したキーに該当する値（value）の取得）
		 */
		
		// HashMapを使用した例（HashMap：put順が保証されない）
		HashMap hm1 = new HashMap();
		hm1.put( "id", "tuka" );
		hm1.put( "name", "つかだ" );
		hm1.put( "address",  "横浜市" );
		hm1.put( "b_type",  "B型" );
		System.out.println( "***** HashMapのデータ表示① *****" );
		for( Object key : hm1.keySet() ) {
			System.out.print( "キー：【" + key+ "】");
			System.out.println( "値：【" + hm1.get( key )+ "】");
		}
		System.out.println();
		/*
		 * for文の種類
		 * --------------------------------------------------------------------------
		 * Javaの場合
		 * 
		 * ・通常のfor文
		 * for( カウンター変数の初期化 ; 繰り返し条件 ; カウンター変数の増減 ){}
		 * 例：for( int i=0 ; i<5 ; i++ ){}
		 * 
		 * ・拡張for文
		 * for( データ型 データを格納する変数名 : 取得するデータが格納されているオブジェクト )
		 * 例：for( String data : arrayList ){}
		 * 
		 * 拡張forの特徴は、処理対象となるオブジェクトの要素数などがわからなくても
		 * 先頭データから最後のデータまでを自動的に取り出して処理を行う。
		 * このような、要素数に関わらず自動的に要素を取り出して処理を行うループ制御を
		 * 一般的にコンテナループともいい、Java以外の言語の場合はforeach文などがある。
		 * 
		 */
		// LinkedHashMapを使用した例（LinkedHashMap：put順が保証される）
		LinkedHashMap hm2 = new LinkedHashMap();
		hm2.put( "id", "taka" );
		hm2.put( "name", "たかはし" );
		hm2.put( "address",  "東京都" );
		hm2.put( "b_type",  "A型" );
		System.out.println( "***** LinkedHashMapのデータ表示① *****" );
		for( Object key : hm2.keySet() ) {
			System.out.print( "キー：【" + key+ "】");
			System.out.println( "値：【" + hm2.get( key )+ "】");
		}
		System.out.println();
		
		// *******************************************
		// ***** コレクション・オブジェクトの使用例 *****
		// *******************************************
		
		// ArrayListを使用した例
		
		ArrayList alist1 = new ArrayList();
		alist1.add( "ルフィー" );
		alist1.add( "エース" );
		alist1.add( "サボ" );
		alist1.add( "ロー" );
		
		// ***** ① 通常のfor文を使用した例 *****
		System.out.println( "***** 通常のfor文を使用した例 *****" );
		for( int i=0 ; i<alist1.size() ; i++ ) {
			System.out.println( "alist1(" + i + ")==>" + alist1.get( i ) );
		}
		System.out.println();
		
		// ***** ② 拡張forを使用した例 *****
		System.out.println( "***** 拡張forを使用した例 *****" );
		for( Object data : alist1 ) {
			System.out.println( "alist1==>" + data );
		}
		System.out.println();
		
		// ***** ③ Iteratorを使用した例 *****
		/*
		 * Iterator（インターフェイス）
		 * 配列やコレクション・オブジェクトなどの複数のデータ構造を持つ
		 * 要素に対する反復（繰り返し処理）を抽象化したもの。
		 * 
		 * Iteratorそのものはインターフェイスであるが
		 * Iterator()メソッドにより、Iterator型の実装クラスのインスタンスが返される。
		 * 
		 * Iteratorの主なメソッド
		 * ・hasNext() ⇒ 次の要素の有無を判定する
		 * 							次の要素がある場合 ⇒ true
		 * 							次の要素がない場合 ⇒ false
		 * ・next() ⇒ 実際のデータを取得する。
		 */
		
		System.out.println( "***** Iteratorを使用した例 *****" );
		Iterator it = alist1.iterator();
		while( it.hasNext() ) {
			System.out.println( "alist1==>" + it.next() );
		}
		System.out.println();
		
		// ***** ジェネリックスを使用した例 *****
		/*
		 * ジェネリックス（Generics）
		 * ・任意の型を受け付けるクラス・メソッドに対して特定の型を割り当てて
		 * 　型専用のクラスを生成する機能。
		 * ・ジェネリックス指定することで、メンバー要素の型をコンパイル時に
		 * 　保証できる。（クラスの安全性を保つ）
		 */
		System.out.println( "***** ジェネリックスを使用した例 ****" );
		ArrayList<String> alist_s = new ArrayList<String>();
		alist_s.add( "特上カルビ" );
		alist_s.add( "特上タン塩" );
		alist_s.add( "特上ハラミ" );
		for( String data : alist_s ) {
			System.out.println( "alist_s==>" + data );
		}
		System.out.println();
		
		// ***** インターフェイスを型にした変数を使い、実装クラスからインスタンスを取得する例
		System.out.println( "***** インターフェイスの型を変数に使用した例 *****" );
		
		// ***** Listを使用した例 ****
		System.out.println( "***** Listを使用した例 *****");
		List<Object > list = new ArrayList<Object>();
		list.add( "あいうえお" );
		list.add( new Apple( "green" , "sour" ) );
		list.add( 2500 );
		it = list.iterator();
		while( it.hasNext() ) {
			System.out.println( "list==>" + it.next() );
		}
		System.out.println();
		
		// ***** Mapを使用した例 ****
		System.out.println( "***** Mapを使用した例 *****" );
		Map<String , Object> map = new HashMap<String , Object>();
		map.put( "ID",  "MSR0001" );
		map.put( "名前", "多言語太郎" );
		map.put( "赤いりんご" , new Apple( "red" , "sweet" ) );
		map.put( "青いりんご" , new Apple( "green" , "semi-sweet" ) );
		map.put( "黄色いりんご" , new Apple( "yellow" , "sour" ) );
		map.put( "料金", 1500 );
		for( String key : map.keySet() ) {
			System.out.println( "【" + key+ "】==>【" + map.get(key) + "】") ;
		}
		System.out.println();
		
		// ***** Setを使用した例 ****
		/*
		 * Set
		 * ・追加順を保証しない（順番の概念なし）
		 * ・重複値を保持しない
		 */
		System.out.println( "***** Setを使用した例 ****" );
		Set<String> set = new HashSet<String>();
		set.add( "お" );
		set.add( "う" );
		set.add( "え" );
		set.add( "い" );
		set.add( "あ" );
		for( String data : set ) {
			System.out.print( data + "\t" );
		}
		System.out.println();
		
		System.out.println( "=====「か」を追加 " + set.add( "か" )  + "=====" );
		for( String data : set ) {
			System.out.print( data + "\t" );
		}
		System.out.println();
		
		System.out.println( "=====「あ」を追加 " + set.add( "あ" )  + "=====" );
		System.out.println
		( "↑setオブジェクトは重複値を保持できないのでaddメソッドの結果がfalseになる" );
		for( String data : set ) {
			System.out.print( data + "\t" );
		}
		System.out.println( "\n" );
		
		// ***** QueueやDequeを使用した例 *****
		
		// Queue（先入れ先出し：FIFO（First In First Out）の使用例）
		System.out.println( "***** Queueを使用した例 *****" );
		Queue<String> queue = new ArrayDeque<String>();
		queue.add( "か" );
		queue.add( "き" );
		queue.add( "く" );
		queue.add( "け" );
		queue.add( "こ" );
		
		System.out.println( "***** 取り出し前 *****" );
		System.out.println( queue );
		System.out.println( "***** 取り出し *****" );
		// 値の取り出（pollメソッド）
		System.out.println( "取り出した値は【" + queue.poll() + "】" );
		System.out.println( "***** 取り出し後 *****" );
		System.out.println( queue );
		System.out.println();
		
		System.out.println( queue );
		// 値の参照（peekメソッド）
		System.out.println( "次に取り出せる値は【" + queue.peek() +  "】");
		System.out.println( queue );
		System.out.println();
		
		// Deque（先入れ先出し：LIFO（Last In First Out）の使用例）
		System.out.println( "***** Dequeを使用した例 *****" );
		Deque<String> deque= new ArrayDeque<String>();
		deque.add( "さ" );
		deque.add( "し" );
		deque.add( "す" );
		deque.add( "せ" );
		deque.add( "そ" );
		
		System.out.println( "***** 取り出し前 *****" );
		System.out.println( deque );
		System.out.println( "***** 取り出し *****" );
		// 値の取り出（pollメソッド）
		System.out.println( "取り出した値は【" + deque.pop() + "】" );
		System.out.println( "***** 取り出し後 *****" );
		System.out.println( deque );
		System.out.println();
		
		System.out.println( deque );
		// 先頭の値の参照
		System.out.println( "先頭の値は==>【" + deque.getFirst()+ "】");
		// 最後の値の参照
		System.out.println( "最後の値は==>【" + deque.getLast()+ "】");
		System.out.println( deque );
		// 先頭の値の取得
		System.out.println( "取り出した先頭の値は【" + deque.removeFirst() +  "】");
		// 最後の値の取得
		System.out.println( "取り出した最後の値は【" + deque.removeLast() +  "】");
		System.out.println( "最新の状態==>" + deque );
		System.out.println();
		

	}

}
