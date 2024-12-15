package tk_sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * ファイル入力（ファイルの読み込み）に利用される主なクラス
 * 
 * FileReader：指定されたファイルからの入力のためのストリームを作成する。
 * 　　　　　　　指定されたファイルをオープンする。（指定されたファイルが無い場合はエラーとなる）
 * 　　　　　　　指定されたファイルから1文字づつ読み込みを行う。
 * 
 * BufferedReader：ファイルから読む込むべきデータをバッファリング（溜め込む）して処理を
 * 　　　　　　　　　行うため、効率良く読み込むを行う。
 * 
 * --------------------------------------------------------------------------------------
 * ファイル出力（ファイルの書き込み）に利用される主なクラス
 * 
 * FileWriter：指定されたファイルへの出力のためのストリームを作成する。
 * 　　　　　　指定されたファイルをオープンする。（指定されたファイルが無い場合は作成する）
 * 　　　　　　指定されたファイルへ1文字づつ書き込みを行う。
 * 
 * BufferedWriter：ファイルに書き込むべきデータをバッファリング（溜め込む）して処理を
 * 　　　　　　　　　行うため、効率良く書き込みを行う。
 * 
 * PrintWriter：書き込みや出力に特化したクラス。
 * 　　　　　　　出力用のメソッドなどを多数実装し、コンソールやファイルなど様々な出力先へ出力できる。
 * 
 * --------------------------------------------------------------------------------------
 * 
 * Files：ファイルやディレクトリの読み込み、書き込み、操作のための豊富なクラスメソッドを提供する。
 * 
 * 			List readAllLines( Path path )
 *         ⇒ 引数に指定されたパスからデータを全て読み込み、StringのListにして返す。
 * 
 */

public class JO21_FileInputOutput {

	public static void main(String[] args) throws IOException {
		
		final String PATH = "d:\\2022_04_Java\\File\\";
		
		/*
		 * 当サンプルは、BufferedReaderを使用し、複数のストリームを使用します。
		 * 同じ参照変数を使い回す事も可能であるが、わかりずらくなる可能性があるため
		 * 今回は、別々の参照変数を用意します。
		 */
		BufferedReader std_in, read_br;
		PrintWriter pw;
		Path path;
		String filename = null;
		String data = null;
		
		// 標準入力用の入力ストリームを作成
		std_in = new BufferedReader( new InputStreamReader( System.in ) ); 
		
		System.out.println( "**********************************************************" );
		System.out.println( "*** ファイル入出力サンプル（動作する番号を選択してください）***" );
		System.out.println( "*** --------------------------------------------------- ***" );
		System.out.println( "* 1：ファイルの読み込み（BufferedReader）                         *");
		System.out.println( "* 2：ファイルの書き込み（PrintWriter）                                 *");
		System.out.println( "* 3：ファイルの読み込みと書き込み（）                                   *");
		System.out.println( "* 4：ファイルの読み込み（FIleクラス（BufferedReader））       *");
		System.out.println( "* 5：ファイルの読み込み（Filesクラス（readAllLines使用））     *");
		System.out.println( "* 6：ファイルの読み込み（Filesクラス（lines使用））                 *");
		System.out.println( "* 7：ファイルの読み込み（Filesクラス（BufferedReader使用））*");
		System.out.println( "* 8：ファイルの読み込み（CSVファイル）                               *");
		System.out.println( "**********************************************************" );
		
		int selector = Integer.parseInt( std_in.readLine() );
		
		switch( selector ) {
		case 1:
			
			// ********************************
			// ***** ファイルの読み込み処理 *****
			// ********************************
			
			// テキストファイルを読み込み、標準出力へ出力
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			
			// ファイル入力用のストリームを作成
			read_br = new BufferedReader( new FileReader( filename ) );
			
			System.out.println( "*** 読み込んだファイルの内容は以下の通りです ***" );
			while( ( data = read_br.readLine() ) != null ) {
				System.out.println( data );
			}
			
			read_br.close();
			break;
		
		case 2:
			
			// ********************************
			// ***** ファイルの書き込み処理 *****
			// ********************************
			
			System.out.println( "出力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			
			// ファイル出力用のストリームを作成
			pw = new PrintWriter( new BufferedWriter( new FileWriter( filename ) ) );
			
			for( int i=5 ; i>0 ; i-- ) {
				System.out.println( "何か文字列を入力してください【残り入力回数：" + i  + "回】");
				data = std_in.readLine();
				pw.println( data );
			}
			
			pw.close();
			System.out.println( "【" + filename+ "】に書き込みが完了しました" );
			break;
			
		case 3:
			
			// *****************************************
			// ***** ファイルの読み込みと書き込み処理 *****
			// *****************************************

			// 入力用ファイル名の指定
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			
			// ファイル入力用のストリームを作成
			read_br = new BufferedReader( new FileReader( filename ) );

			// 出力用ファイル名の指定
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			
			// ファイル出力用のストリームを作成
			pw = new PrintWriter( new BufferedWriter( new FileWriter( filename ) ) );
			
			while( ( data = read_br.readLine() ) != null ) {
				pw.println( data );
			}
			
			read_br.close();
			pw.close();
			System.out.println( "【" + filename+ "】に書き込みが完了しました" );
			break;
			
		case 4:
			
			// ********************************
			// ***** ファイルの読み込み処理 *****
			// ********************************
			
			// Fileクラスを使用し、case1と同じ処理した例
			
			// テキストファイルを読み込み、標準出力へ出力
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			
			// パスおよびファイル名からFileクラスのインスタンスを生成
			File file = new File( filename );
			
			// 指定されたファイルの存在チェック
			if( ! file.exists() ) {
				System.out.println( "指定されたファイルがみつかりませんでした" );
				System.out.println( "処理を終了します" );
				return;
			}
			
			// ファイル入力用のストリームを作成
			read_br = new BufferedReader( new FileReader( file) );
			
			System.out.println( "*** 読み込んだファイルの内容は以下の通りです ***" );
			while( ( data = read_br.readLine() ) != null ) {
				System.out.println( data );
			}
			
			read_br.close();
			break;

		case 5:
			
			// ********************************
			// ***** ファイルの読み込み処理 *****
			// ********************************
			
			// Filesクラスを使用し、case1と同じ処理をした例
			
			// 入力用ファイル名の指定
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			path = Paths.get( filename );
			
			// 指定されたファイルからデータを全て読み込みListで返す
			List<String> list = Files.readAllLines( path );
			
			System.out.println( "*** 読み込んだファイルの内容は以下の通りです ***" );
			for( String str : list ) {
				System.out.println( str );
			}
			
			break;
			
		case 6:
			
			// ********************************
			// ***** ファイルの読み込み処理 *****
			// ********************************
			
			// Filesクラスを使用し、case1と同じ処理をした例
			
			// 入力用ファイル名の指定
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			path = Paths.get( filename );
			
			// Filesクラスのlinesメソッドを使用し、ストリームを作成する例
			System.out.println( "*** 読み込んだファイルの内容は以下の通りです ***" );
			Files.lines(path).forEach(System.out :: println);
			
			break;
			
		case 7:
			
			// ********************************
			// ***** ファイルの読み込み処理 *****
			// ********************************
			
			// Filesクラスを使用し、case1と同じ処理をした例
			
			// 入力用ファイル名の指定
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			path = Paths.get( filename );
			
			// FilesクラスのnewBufferedReaderを使用しBufferedReaderのインスタンスを生成
			read_br = Files.newBufferedReader( path );
			
			System.out.println( "*** 読み込んだファイルの内容は以下の通りです ***" );
			while( ( data = read_br.readLine() ) != null ) {
				System.out.println( data );
			}
			
			read_br.close();
			break;

		case 8:
			
			// ************************************
			// ***** CSVファイルの読み込み処理 *****
			// ************************************
			
			// CSVファイルを読み込み、標準出力へ出力
			
			System.out.println( "入力ファイル名を入力してください" );
			filename = PATH + std_in.readLine();
			
			// ファイル入力用のストリームを作成
			read_br = new BufferedReader( new FileReader( filename ) );
			
			System.out.println( "*** 読み込んだファイルの内容は以下の通りです ***" );
			
			/*
			 * CSV（Comma Separated Value）ファイルを読み込み、タブ区切りにして
			 * 標準出力へ出力する。
			 */
			while( ( data = read_br.readLine() ) != null ) {
				
				/*
				 * String[] split( String delimitor )
				 * Stringクラスに定義されているsplit()メソッド。
				 * 対象の文字列を、引数に指定された区切り文字毎に分割し
				 * 分割した各文字列を配列に格納して返す。
				 */
				String[] ary = data.split( "," );
				for( int i=0 ; i<ary.length ; i++ ) {
					System.out.print( ary[i] + "\t" );
				}
				System.out.println();
			}
			
			read_br.close();
			break;
			
			
		}

	}

}
