package tk_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * I/O（Input/Output）（入力/出力）
 * Java ⇒ I/O-Stream
 * ⇒ Java言語では、入力～出力の処理の流れや構造といったものを
 * 　 I/O-Streamという考えに基づき実装している。
 * 
 * 入力/出力
 * 
 * ・標準入力/標準出力
 * 
 * ⇒ 標準入力
 * 	　（コンソール画面（コマンド・プロンプトやターミナルやIDEの内蔵コンソールなど））
 * 　 からのPCの入力装置（キーボードやマウスなど）を経由して入力されたもの。
 * Javaでの標準入力の実装：System.in
 * 
 * ⇒ ・標準出力
 * 　 PCの画面（実際にはコンソール（Windowsの場合はコマンド・プロンプト。LinuxやUnix
 * 　 などの場合は各種ターミナル・コンソール。IDEなどの場合は内蔵コンソール・ウィンドウ））
 *  　に対し出力されたもの。
 *  Javaでの標準出力の実装：System.out
 *  
 *   ファイル入力/ファイル出力
 *   ⇒ ファイル入力（テキストファイルなどからの入力（ファイルの読み込み））
 *   ⇒ ファイル出力（処理結果などをテキストファイルなどのファイルへ出力（ファイルの書き込み））
 *   
 *   画面入力/画面出力
 *   ⇒ 画面入力（GUI系アプリやWebアプリなど、画面要素を持ったプログラムで使用され
 *  	　　　　　　画面要素を構成するUIコンポーネントなどを通じて入力を行う。 ）
 *   ⇒ 画面出力（処理結果を画面（プログラムで作成された画面）に出力する。） 
 */
public class JO18_ScannerAndBFR {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner( System.in );
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		/*
		 * サンプル① 基本的なScannerの入力例
		 */
		System.out.println( "***** Scanner使用 *****" );
		System.out.println( "文字列を入力してください" );
		String str = sc.nextLine();
		System.out.println( "入力された文字列は【" + str + "】です" );
		System.out.println();
		
		System.out.println( "文字列を入力してください" );
		str = sc.next();
		System.out.println( "入力された文字列は【" + str + "】です" );
		System.out.println();
		
		System.out.println( "整数を入力してください" );
		int num = sc.nextInt();
		System.out.println( "入力された整数は【" + num + "】です" );
		System.out.println();

		System.out.println( "浮動小数点値を入力してください" );
		double dbl = sc.nextDouble();
		System.out.println( "入力された浮動小数点値は【" + dbl + "】です" );
		System.out.println();
		
		sc.nextLine();
		
		/*
		 * サンプル② 基本的なBufferedReaderの入力例
		 */
		System.out.println( "***** BufferedReader使用 *****" );
		try {
			System.out.println( "文字列を入力してください" );
			str = br.readLine();
			System.out.println( "入力された文字列は【" + str + "】です" );
			System.out.println();
			
			System.out.println( "整数を入力してください" );
			str = br.readLine();
			num = Integer.parseInt( str );
			System.out.println( "入力された整数は【" + num + "】です" );
			System.out.println();
			
			System.out.println( "浮動小数点値を入力してください" );
			str = br.readLine();
			dbl = Double.parseDouble( str );
			System.out.println( "入力された浮動小数点値は【" + dbl + "】です" );
			System.out.println();
		}
		catch( IOException e ) {}
		
		/*
		 * サンプル③ ScannerのnextLine()とnext()の挙動の違い
		 * 
		 * nextLine()
		 * ⇒ 改行コードまでを読み込む
		 * 
		 * next()
		 * ⇒ 空白文字（スペース）または改行コード、それぞれの直前までの文字列を読み込む
		 * （空白文字が含まれていない場合は、改行コードの直前までを読み込む）
		 */
		
		System.out.println( "途中に空白文字を含む文字列を入力してください（nextLine使用）" );
		str = sc.nextLine();
		System.out.println( "入力された文字列は【" + str + "】です" );
		System.out.println();
		
		System.out.println( "途中に空白文字を含む文字列を入力してください（next使用）" );
		str = sc.next();
		System.out.println( "入力された文字列は【" + str + "】です" );
		System.out.println();
		
		sc.nextLine();
		try {
			System.out.println( "途中に空白文字を含む文字列を入力してください（BufferedReader使用）" );
			str = br.readLine();
			System.out.println( "入力された文字列は【" + str + "】です" );
			System.out.println();
		}
		catch( IOException e ) {}
		
		/*
		 * サンプル④ Scannerを使用した連続したデータの処理
		 */
		// 文字列の連続データ
		List<String> list = new ArrayList<String>();
		System.out.println( "文字列を連続で複数行入力してください（空エンターで終了）");
		while( sc.hasNextLine() ) {
			str = sc.nextLine();
			if( str.isEmpty() ) break;
			list.add(str);
		}
		for( String data : list ) {
			System.out.println( "入力された文字列は【" + data + "】です" );
		}
		// 整数値の連続データ
		int[] i_ary = new int[5];
		System.out.println( "整数値を連続で5個入力してください" );
		for( int i=0 ; i<i_ary.length ; i++ ) {
			i_ary[i] = sc.nextInt();
		}
		for( int i=0 ; i<i_ary.length ; i++ ) {
			System.out.println( "入力された整数値は【" + i_ary[i] + "】です" );
		}
		System.out.println();
		
		sc.nextLine();
		
		/*
		 * サンプル⑤ データ型の違う値を複数回、入力した場合
		 */
		int id = 0;
		String name = null;
		String address = null;
		
		// ****************************************
		// ***** BufferedReaderを使用した場合 *****
		// ****************************************
		try {
			System.out.println( "***** BufferedReader使用 *****" );
			System.out.println( "ID（整数）を入力してください" );
			id = Integer.parseInt( br.readLine() );
			System.out.println( "名前を入力してください" );
			name = br.readLine();
			System.out.println( "住所を入力してください" );
			address = br.readLine();
			System.out.println( "ID==>【" + id + "】");
			System.out.println( "名前==>【" + name + "】");
			System.out.println( "住所==>【" + address + "】");
			
		}
		catch( IOException e ) {}
		System.out.println();
	
		// ********************************
		// ***** Scannerを使用した場合 *****
		// ********************************
		
		// nextInt()とnextLine()を使用した場合
		System.out.println( "***** Scanner使用（nextLine使用）*****" );
		System.out.println( "ID（整数）を入力してください" );
		id = sc.nextInt();
		System.out.println( "名前を入力してください" );
		name = sc.nextLine();
		System.out.println( "住所を入力してください" );
		address = sc.nextLine();
		System.out.println( "ID==>【" + id + "】");
		System.out.println( "名前==>【" + name + "】");
		System.out.println( "住所==>【" + address + "】");
		System.out.println();
		/*
		 * ↑上記のコードの場合、名前の入力処理が読み飛ばされて、名前の入力ができない。
		 * 
		 * このような動作をする理由は以下の通り
		 * IDを入力してください。
		 * 1234▼←「▼」は改行コードを表しています。
		 * 
		 * IDの入力はnextIntのメソッドを使用しているが、nextIntは改行コードの直前までの
		 * 入力値を整数値として受け取る。
		 * 
		 * nextInt()で処理されるのは、「1234」の部分。
		 * ↓
		 * 変数idに「1234」が格納される。
		 * ↓
		 * 入力された改行コードは処理されずにそのまま残る。
		 * ↓
		 * 「▼」だけが残る。
		 * ↓
		 * nextLine()は改行コードまでを読み込む性質なため、
		 * 処理されずに残っていた改行コード「▼」だけを読み込んで処理を終了する。
		 * ↓
		 * 結果として、名前の入力が読み飛ばされて、入力できないような動作になる。
		 */
		
		// nextInt()とnext()を使用した場合
		System.out.println( "***** Scanner使用（next使用）*****" );
		System.out.println( "ID（整数）を入力してください" );
		id = sc.nextInt();
		System.out.println( "名前を入力してください" );
		name = sc.next();
		System.out.println( "住所を入力してください" );
		address = sc.next();
		System.out.println( "ID==>【" + id + "】");
		System.out.println( "名前==>【" + name + "】");
		System.out.println( "住所==>【" + address + "】");
		/*
		 * ↑上記のコードの場合
		 * next()メソッドを使用することで、nextLine()メソッドを使った場合のように
		 * 処理されずに残っていた改行コードを先読みし、本来行うべき文字列の入力処理を
		 * 読み飛ばすといった動作は回避できるが、しかし、入力された文字列の中に空白文字
		 * （スペース）が含まれている場合は、空白文字以前と以降の部分でデータの読み込み
		 * が分離してしまい、空白文字以降の部分は、別の読み込み処理として先読みされてしまう。
		 */
		
		/*
		 * nextInt()とnextLine()を使用した場合（nextLineで読み飛ばしを回避）
		 */
		System.out.println( "***** Scanner使用（nextLine使用）*****" );
		System.out.println
		( "***** nextInt()とnextLine()を使用し読み飛ばしを回避 *****" );
		
		/*
		 * Mapを使用しているが、ただ単に、入力されたデータをMapに格納しているだけで
		 * Scannerの読み飛ばし回避の対策とは、全く関係ない！！
		  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓　*/
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		System.out.println( "ID（整数）を入力してください" );
		id = sc.nextInt();
		map.put( "ID",  id );
		
		sc.nextLine(); 			// ★ポイント★ 読み飛ばし回避のためのダミーのnextLine()
		
		System.out.println( "名前を入力してください" );
		name = sc.nextLine();
		map.put( "名前", name );
		
		System.out.println( "住所を入力してください" );
		address = sc.nextLine();
		map.put( "住所", address );
		
		for( String keys : map.keySet() ) {
			System.out.println( keys + "==>【" + map.get(keys) + "】");
		}
		System.out.println();
		sc.close();
	}

}
