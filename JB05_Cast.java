package sample;

public class JB05_Cast {

	public static void main(String[] args) {
		
		// ***** 異なるデータ型どうしの値の代入 *****
		
		// int型 ⇒ double型
		int i = 10;
		double d;
		
		// int型の変数をdoubleの変数に代入
		d = i;
		System.out.println( "i==>" + i );
		System.out.println( "d==>" + d );
		System.out.println();
		
		// double型 ⇒ int型
		d = 56.7;
		i = 100;
		
		//i = d;
		// ↑この方法では、構文エラーとなるので、この方法は使えない！
		// doubleからintへの代入を行う場合にはキャスト演算子を使用し型変換を行う必要がある
		// キャスト演算子 ⇒ ( データ型 )
		i = ( int )d;
		System.out.println( "d==>" + d );
		System.out.println( "i==>" + i );
		System.out.println();
		
		
		// ***** 異なるデータ型どうしの演算 *****
		i = 20;
		d = 5;
		// ↓異なるデータ型どうしの演算では、サイズの大きい方の型に小さい方の型を合わせて演算を行う
		//（intとdoubleの演算では、内部的にintをdoubleに変換し、doubleどうしの演算として処理を行っている）
		System.out.println( "i==>" + i );
		System.out.println( "d==>" + d );
		System.out.println( i + "+" + d + "=" + (i+d) );
		System.out.println( i + "-" + d + "=" + (i-d) );
		System.out.println( i + "*" + d + "=" + (i*d) );
		System.out.println( i + "/" + d + "=" + (i/d) );
		System.out.println();
		
		// 同じデータ型どうしの演算
		int val1 = 5;
		int val2 = 4;
		
		int ans = val1 + val2;
		System.out.println( val1 + "と" + val2 + "の加算結果は==>【" + ans+ "】" );
		
		ans =  val1 - val2;
		System.out.println( val1 + "と" + val2 + "の減算結果は==>【" + ans + "】" );
		
		ans = val1 * val2;
		System.out.println( val1 + "と" + val2 + "の乗算結果は==>【" + ans +"】" );
		
		//ans = val1 / val2;
		double d_ans = (double)val1 / val2;
		System.out.println( val1 + "と" + val2 + "の除算結果は==>【" + d_ans + "】" );

	}

}
