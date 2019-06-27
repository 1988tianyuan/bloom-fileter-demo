import java.nio.charset.Charset;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class Main {
	
	public static void main(String[] args) {
		
		BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10000000, 0.01);
		for (int i = 0; i < 10000000; i++) {
			filter.put(String.valueOf(i));
		}
		System.out.println("9999999 存不存在？" + filter.mightContain("9999999"));
		System.out.println("3231212 存不存在？" + filter.mightContain("3231212"));
		System.out.println("323121211 存不存在？" + filter.mightContain("323121211"));
		System.out.println("1111111 存不存在？" + filter.mightContain("1111111"));
		System.out.println("11111111 存不存在？" + filter.mightContain("11111111"));
		System.out.println("33333333 存不存在？" + filter.mightContain("33333333"));
		System.out.println("43413140 存不存在？" + filter.mightContain("43413140"));
	}
}
