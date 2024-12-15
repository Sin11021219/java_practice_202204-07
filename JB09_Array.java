package sample;

/*
 * 配列
 * ⇒配列とは、複数の連続したデータを使用するため、連続したデータ領域をメモリ上に確保したもの。
 * 
 * 配列の宣言
 * データ型[] 変数名;
 * （例：int[] ary;）
 * 
 * 配列の要素数の確保
 * 変数名 = new データ型[ 配列の要素数 ]; 
 * （例：ary = new int[5];）
 * 
 * 配列の宣言と要素数の確保を同時に行う
 * データ型[] 変数名 = new データ型[ 配列の要素数 ];
 * （例：int[] ary = new int[5];）
 * 
 * 配列の初期化（変数の宣言と値の設定を同時に行う）
 * （初期化の場合は、値を設定した数だけ要素数が確保される）
 * データ型[] 変数名 = { 値1, 値2 , … , 値n };
 * （例：int[] ary = {10, 20, 30, 40, 50 };）
 * 
 * 配列のindex（添字）は「０」originなので
 * indexの指定は必ず0スタートとなる。
 * 要素数が5の場合、indexは0から始まるので
 * 最後のindexは「要素数-1」となる。
 * 
 */

public class JB09_Array {

	public static void main(String[] args) {
		
		// 配列変数の宣言
		int[] ary1;
		
		// 配列変数の要素数の確保
		ary1 = new int[5];
		
		// 配列変数の値の表示
		System.out.println( "*** 配列変数の定義直後：データは未設定 ***" );
		System.out.println( "ary1[0]==>" + ary1[0] );
		System.out.println( "ary1[1]==>" + ary1[1] );
		System.out.println( "ary1[2]==>" + ary1[2] );
		System.out.println( "ary1[3]==>" + ary1[3] );
		System.out.println( "ary1[4]==>" + ary1[4] );
		System.out.println();
		
		// 配列変数への値の代入
		ary1[0] = 100;
		ary1[1] = 50;
		ary1[2] = 400;
		ary1[3] = 2;
		ary1[4] = 1000;
		
		// 配列変数の値の表示
		System.out.println( "*** 配列変数へのデータ設定後 ***" );
		System.out.println( "ary1[0]==>" + ary1[0] );
		System.out.println( "ary1[1]==>" + ary1[1] );
		System.out.println( "ary1[2]==>" + ary1[2] );
		System.out.println( "ary1[3]==>" + ary1[3] );
		System.out.println( "ary1[4]==>" + ary1[4] );
		System.out.println();
		
		// 配列変数の宣言と要素の確保を同時に行う
		int[] ary2 = new int[3];
		
		// 値の代入
		ary2[0] = 10;
		ary2[1] = 20;
		ary2[2] = 30;
		
		System.out.println( "*** 配列変数の宣言と要素の確保をしたデータの表示 ***" );
		System.out.println( "ary2[0]==>" + ary2[0] );
		System.out.println( "ary2[1]==>" + ary2[1] );
		System.out.println( "ary2[2]==>" + ary2[2] );
		System.out.println();
		
		// 配列変数の初期化
		int[] ary3 = { 10000 , 20000 , 30000 , 40000 , 50000 , 60000 };
		
		System.out.println( "*** 配列変数の初期化後のデータの表示 ***" );
		System.out.println( "ary3[0]==>" + ary3[0] );
		System.out.println( "ary3[1]==>" + ary3[1] );
		System.out.println( "ary3[2]==>" + ary3[2] );
		System.out.println( "ary3[3]==>" + ary3[3] );
		System.out.println( "ary3[4]==>" + ary3[4] );
		System.out.println( "ary3[5]==>" + ary3[5] );
		System.out.println();
		
		// for文を使用した配列への値の代入
		for( int i=0 ; i<5 ; i++ ) {
			System.out.println("i==>" +i);
			ary1[i] = 1000 + i;
		}
		
		// for文を使用した配列の値の表示
		System.out.println( "*** for文を使用し配列のデータを表示 ***" );
		for( int i=0 ; i<5 ; i++ ) {
			System.out.println( "ary1[" + i + "]==>" + ary1[i] );
		}
		System.out.println();
		
		/*
		 * static double random()
		 * Mathクラスに定義されているメソッド。
		 * 0.0以上1.0未満の乱数をdoubleの値で返す。
		 * 戻り値：double
		 */
	
		// for文を使用し、発生させた乱数を代入し表示する例
		for( int i=0 ; i<5 ; i++ ) {
			ary1[i] = ( int )( Math.random()*100 );
			System.out.println( "ary1[" + i + "]==>" + ary1[i] );
		}
		System.out.println();
		
		// 配列の要素数を取得した条件の指定方法
		// （配列の要素数の取得方法は配列名.lengthで取得可能）
		System.out.println( "*** 配列名.lengthで要素数を取得しループを回す方法 ***" );
		for( int i=0 ; i<ary1.length ; i++ ) {
			System.out.println( "ary1[" + i + "]==>" + ary1[i] );
		}
		System.out.println();
		
		// 配列名.lengthを使用した要素数の取得の動作例
		System.out.println( "*** 配列名.lengthを使用し配列の要素数を取得 ***" );
		System.out.println( "ary1の要素数は==>【" + ary1.length + "】個です。" );
		System.out.println( "ary2の要素数は==>【" + ary2.length + "】個です。" );
		System.out.println( "ary3の要素数は==>【" + ary3.length + "】個です。" );
		System.out.println();
		
		// *****************************************
		// ***** 配列変数どうしの値の代入の動作例 *****
		// *****************************************
		
		// 代入前に各配列変数の値を表示
		System.out.println( "*** 変数代入前 ***" );
		for( int i=0 ; i<ary1.length ; i++ ) {
			System.out.println( "ary1[" + i + "]==>" + ary1[i] );
		}
		System.out.println();
		
		for( int i=0 ; i<ary2.length ; i++ ) {
			System.out.println( "ary2[" + i + "]==>" + ary2[i] );
		}
		System.out.println();
		
		// 代入前の各配列変数の参照先を確認
		System.out.println( "ary1の参照先は==>" + ary1 );
		System.out.println( "ary2の参照先は==>" + ary2 );
		System.out.println();

		// 配列変数どうしの値の代入
		ary2 = ary1;
		
		// 代入後に各配列変数の値を表示
		System.out.println( "*** 変数代入後 ***" );
		for( int i=0 ; i<ary1.length ; i++ ) {
			System.out.println( "ary1[" + i + "]==>" + ary1[i] );
		}
		System.out.println();
		
		for( int i=0 ; i<ary2.length ; i++ ) {
			System.out.println( "ary2[" + i + "]==>" + ary2[i] );
		}
		System.out.println();
		
		// 代入前の各配列変数の参照先を確認
		System.out.println( "ary1の参照先は==>" + ary1 );
		System.out.println( "ary2の参照先は==>" + ary2 );
		System.out.println();
		
		// 配列の並び替え（sort）の例
		int[] ary_sort = { 38 , 64 , 4 , 100 , 18 , 2 , 53 , 205 , 14 };
		
		System.out.println( "*** 並び替え前 ***" );
		for(int i=0 ; i<ary_sort.length ; i++ ) {
			System.out.println( "ary_sort[" + i + "]==>" + ary_sort[i] );
		}
		System.out.println();
		
		// 並び替え処理
		for( int x=0 ; x<ary_sort.length-1 ; x++ ) {			// 基点（x）のループ
			for( int y=x+1 ; y<ary_sort.length ; y++ ) {		// 比較点（y）のループ
				// 昇順で並び替え
				if( ary_sort[x] > ary_sort[y] ) {					// xよりyの方が小さい場合
					int temp = ary_sort[y];							// yの値を退避エリア（temp）に退避
					ary_sort[y] = ary_sort[x];						// xの値を、空いたyの場所に設定
					ary_sort[x] = temp;								// 退避しておいたtempの値をxの場所に設定
				}
			}
		}
		System.out.println( "*** 並び替え後 ***" );
		for(int i=0 ; i<ary_sort.length ; i++ ) {
			System.out.println( "ary_sort[" + i + "]==>" + ary_sort[i] );
		}
		System.out.println();
		
		// 二次元配列の定義と操作の方法
		System.out.println( "***** 二次元配列の定義と操作の方法 *****" );
		
		int[][] ary_2d = new int[3][5];
		
		// 値を設定
		ary_2d[0][0] = 1;
		ary_2d[0][1] = 2;
		ary_2d[0][2] = 3;
		ary_2d[0][3] = 4;
		ary_2d[0][4] = 5;

		ary_2d[1][0] = 11;
		ary_2d[1][1] = 12;
		ary_2d[1][2] = 13;
		ary_2d[1][3] = 14;
		ary_2d[1][4] = 15;
		
		ary_2d[2][0] = 111;
		ary_2d[2][1] = 112;
		ary_2d[2][2] = 113;
		ary_2d[2][3] = 114;
		ary_2d[2][4] = 115;
		
		System.out.println( "*** lengthを使用して二次元配列の要素数を確認 ***" );
		System.out.println( "ary_2d.length ==>" + ary_2d.length );
		System.out.println( "ary_2d[0].length ==>" + ary_2d[0].length );
		System.out.println();
		
		// 値の表示
		for( int x=0 ; x<ary_2d.length ; x++ ) {
			for( int y=0 ; y<ary_2d[x].length ; y++ ) {
				System.out.println( "ary_2d[" + x + "][" + y + "]==>" + ary_2d[x][y] );
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println( "*** 各要素を並べて表示 ***" );
		for( int x=0 ; x<ary_2d.length ; x++ ) {
			for( int y=0 ; y<ary_2d[x].length ; y++ ) {
				System.out.print( ary_2d[x][y] + "\t" );
			}
			System.out.println();
		}
		System.out.println();
		
		// 横方向（左右）の要素数（長さ）の違う二次元配列の定義と表示
		System.out.println
		( "*** 横方向（左右）の要素数（長さ）の違う二次元配列の定義と表示 ***" );
		
		String[][] s_ary =
			{
					{ "わに" , "へび" , "かめ" , "とかげ" },
					{ "いぬ" , "ねこ" , "くま" , "ライオン" , "パンダ" , "トラ" , "うま" },
					{ "カラス" , "ハト" },
					{ "マグロ" , "イカ" , "エビ" , "カツオ" , "サメ" }
			};
		
		
		System.out.println( "lengthを使用して配列の要素数を確認" );
		System.out.println( "s_ary.lengthの場合==>" + s_ary.length );
		for( int i=0 ; i<s_ary.length ; i++ ) {
			System.out.println( "s_ary[" + i + "].lengthの場合==>" + s_ary[i].length );
		}
		System.out.println();
		
		// 値を表示
		System.out.println( "各要素を個別に表示" );
		for( int x=0 ; x<s_ary.length ; x++ ) {
			for( int y=0 ; y<s_ary[x].length ; y++ ) {
				System.out.println("s_ary[" + x + "][" + y + "]==>" + s_ary[x][y] );
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println( "各要素を並べて表示" );
		for( int x=0 ; x<s_ary.length ; x++ ) {
			for( int y=0 ; y<s_ary[x].length ; y++ ) {
				System.out.print( s_ary[x][y]  + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
