package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 条件分岐式
 * 
 * switch文
 * 
 * ・switch文はif文同様、条件により処理を振り分ける条件分岐の制御構文。
 * ・基本的な動作はif文を同じ。
 * ・switch文はif文に比べると、多少の制限事項があるため、if文で出来ることが
 * 　switch文では出来ないということもある。
 * ・switch文はif文に比べ記述方法が比較的楽なので、条件数が多い場合などに利用すると
 * 　コードの可読性が高くなり効果的である。
 * 
 * swicthの構文
 * switch( 式 ){
 * 		case 式の値:
 * 			処理
 * 			break;
 * 		case 式の値:
 * 			処理
 * 			break;
 * 		・
 * 		・
 * 		・
 * 		case 式の値:
 * 			処理
 * 			break;
 * 		default:
 * 			処理
 * }
 * 
 * 条件演算子
 * 条件分岐を行うための演算子
 * ・if文やswitch文などの制御構文を使わずに演算子を使用して、条件分岐のための
 * 　処理を記述することができる。
 * ・if文やswitch文に比べ複雑な条件指定や複雑な分岐処理などはできない。
 * 
 * 構文
 * (条件式)?処理1:処理2
 * (条件式)?の部分で条件式の判定を行う。
 * 判定結果がtrue（真）の場合は処理1を行う。
 * 判定結果がfalse（偽）の場合は処理2を行う。
 * 
 */

public class JB07_Switch {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
					new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.println( "動物の名前を入力してください" );
		String animal = br.readLine();
		
		// switchを使用したサンプル
		switch( animal ) {
		case "dog":
			System.out.println( "犬です" );
			break;
		case "cat":
			System.out.println( "猫です" );
			break;
		case "rabit":
			System.out.println( "兎です" );
			break;
		case "bear":
			System.out.println( "熊です" );
			break;
		case "snake":
			System.out.println( "蛇です" );
			break;
		default:
			System.out.println( "不明！！！" );
		}
		System.out.println();
		
		// breakを使わない例
		System.out.println( "国名を入力してください" );
		String cont = br.readLine();
		
		switch( cont ) {
		case "日本":
		case "中国":
		case "韓国":
			System.out.println( "アジア" );
			break;
		case "イギリス":
		case "フランス":
		case "イタリア":
			System.out.println( "ヨーロッパ" );
			break;
		case "ギニア":
		case "ナイジェリア":
		case "コンゴ":
			System.out.println( "アフリカ" );
			break;
		default:
			System.out.println( "それ以外" );
		}
		System.out.println();
		
		// ***** 条件演算子を使用した例 *****
		System.out.println( "***** 条件演算子を使用した例 *****" );
		System.out.println( "if文を使った場合" );
		// if文を使った場合
		int num = 100;
		if( num == 100 ) {
			System.out.println( "100です！" );
		}
		else {
			System.out.println( "100ではありません！！" );
		}
		System.out.println();
		
		// 上記if文と同様の処理を条件演算子を使用した例
		System.out.println( "条件演算子を使った場合" );
		String msg =  (num == 100 )? "100です！" : "100ではありません！！";
		System.out.println( msg );
		System.out.println();
	}

}
