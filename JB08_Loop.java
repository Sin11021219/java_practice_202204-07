package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 繰り返し制御構文
 * 
 * ある特定の条件に基づき、同じ処理を繰り返す構文（繰り返し文、ループ文）
 * 
 * for文
 * 構文
 * for( カウンター変数の初期化 ; 繰り返し条件 ; カウンター変数の増減 ){
 * 		繰り返し処理
 * }
 * ・for文は一般的にカウンター変数を使い、ループ制御を行うため
 * 　繰り返す回数などが、あらかじめ決まっている場合などに使用されることが多い。
 * ①カウンター変数の初期化　※最初の1回のみ
 * ②繰り返し条件の判定
 * ③繰り返し処理（繰り返し条件に一致する場合）
 * ④カウンター変数の増減
 * 以降は②～④を繰り返す。（繰り返し条件を満たさなくなった時点で終了）
 * 
 * while文
 * 構文
 * while( 繰り返し条件 ){
 * 		繰り返し処理
 * }
 * ・while文は指定された繰り返し条件を満たす場合、whileブロック内の処理を行う。
 * 　したがって、繰り返し条件を満たさない場合など、一度もループ処理を実行しない
 * 　場合もある。
 * ・while文は一般的に、繰り返し条件のみを判定するため、繰り返し回数を
 * 　意識しない繰り返し処理などに使用されることが多い。
 * 
 * do～while文
 * 構文
 * do {
 * 		繰り返し処理
 * } while( 条件式 );
 * ・do～whileはwhile同様、繰り返し条件のみを判定し、処理を行うため
 * 　繰り返す回数などは意識しない。
 * ・基本的な挙動はwhileと同じであるが、whileとの決定的な違いは、最初の1回
 * 　だけは必ずブロック内の処理を行う。
 * ・while文とdo～while文では、繰り返し処理の条件判定のタイミングが違う。
 * 	  whileの条件判定は処理前に行うのに対し、do～whileの条件判定は処理後に行う。
 * 
 * ループ制御の命令
 * continue
 * ・continueはcontinueキーワードが見つかった時点で、以降の処理を行わず
 * 　ループ制御を次のループに戻す。
 * break
 * ・breakはbreakキーワードが見つかった時点で、ループ処理を終了する。
 * 
 */

public class JB08_Loop {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =
				new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.println( "***** for loop *****" );
		
		// forを使用した例
		for( int i=0 ; i<=10 ; i++ ) {
			System.out.println( "i==>" + i );
		}
		System.out.println();
		
		for( int i=10 ; i>=0 ; i-- ) {
			System.out.println( "i==>" + i );
		}
		System.out.println();
		
		
		for( int i=0 ; i<10 ; i++ ) {
			if( i==5 ) {
				System.out.println();
			}
			System.out.print( i + "\t" );
		}
		System.out.println("\n");
		
		// 複数の変数と複数の条件を使用した例
		for( int a=0, b=0 ; a<10 && b != 8 ; a++, b++ ) {
			System.out.println( "a==>" + a + "：b==>" + b );
		}
		System.out.println();
		
		// whileを使用した例
		int x = 0;
		while( x != 0 ) {
			System.out.println( "*** whileのループ処理 ***" );
			System.out.println( "*** xは0ぢゃないでーす ***" );
		}
		System.out.println();
		
		// do～whileを使用した例
		do {
			System.out.println( "=== do～whileのループ処理 ===" );
			System.out.println( "=== xは0ぢゃないでーす ===" );
		}while( x != 0 );
		
		System.out.println( "\n" );
		
		System.out.println( "整数を入力してください（999999で終了）" );
		int num = Integer.parseInt( br.readLine() );
		while( num != 999999 ) {
			System.out.println( "入力された値は【" + num + "】です" );
			num = Integer.parseInt( br.readLine() );
		}
		System.out.println("しゅーりょー！！");
		System.out.println();
		
		System.out.println( "***** forを使用した多重ループ *****" );
		// forを使用した多重ループ
		for( int z=0 ; z<10 ; z++ ) {
			for( int y=0 ; y<10 ; y++ ) {
				System.out.println( "z==>" + z + "：y==>" + y );
			}
			System.out.println("----- 内側のyのforループ終了 -----" );
		}
		System.out.println();
		
		// continueやbreakを使用した例
		System.out.println( "***** continueやbreakの使用 *****" );
		for( int z=0 ; z<20 ; z++ ) {
			if( z==3 || z==4 || z==7 || z==15 ) {
				continue;
			}
			if( z==17) {
				break;
			}
			System.out.println( "z==>" + z );
		}
		System.out.println();
		
		// 無限ループ
		/*
		while( true ) {
			System.out.println( "無限ループ中！！（while）" );
		}
		*/
		
		/*
		for( ; ; ) {
			System.out.println( "無限ループ中！！（for）" );
		}
		*/
		
		int a = 10;
		if( a ==10 ) {
			
		}
		else if( a !=10 ) {
			
		}
		
		System.out.println( "***** booleanの値を使って図を書いた例① *****" );
		boolean flg = true;
		for( int i=0 ; i<5 ; i++ ) {
			System.out.print("i==>" + i + " ");
			for( int z=0 ; z<7 ; z++ ) {
				if( flg == true ) {  // flgがtrueの場合
					System.out.print( "●" );
					flg = false;
				}
				else {					// flgがfalseの場合
					System.out.print( "○" );
					flg = true;
				}
			}
			System.out.println();
		}
		System.out.println();

	}

}
