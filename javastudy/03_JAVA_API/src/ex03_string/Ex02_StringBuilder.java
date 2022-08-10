package ex03_string;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
	
		// java.lang.StringBuilder 클래스
		// append는 추가 한다는 뜻
		
		StringBuilder sb= new StringBuilder();
		sb.append(1);
		sb.append(true);
		sb.append('T');
		sb.append(3.14);
		sb.append("hello");
		
		System.out.println(sb);
		
		
		// 첫 번째 글자 가져오기
		sb.charAt(1);
		sb.substring(0,1);
		
		// 동등 비교
		System.out.println(sb.equals("1trueT3.14hello"));
		
		// StringBuilder로 만든 문자열은 반드시 마지막에 String으로 변환해야 함
		String result = sb.toString();
		System.out.println(result);
		System.out.println(result.equals("1trueT3.14hello"));
		
		
		
		//String과 StringBuilder의 성능 테스트
		//StringBuilder가 더 빠르다
		//abcdefghijklmnopqrstuvwxyz
		
		String alphabet1="";
		long begin1=System.nanoTime();
		for(char ch ='a'; ch <='z'; ch++) {
			alphabet1 += ch;
		}
		long end1=System.nanoTime();
		System.out.println((end1-begin1)+alphabet1);
		
		
		StringBuilder sb2= new StringBuilder();
		long begin2 = System.nanoTime();
		for(char ch='a'; ch<='z'; ch++) {
			sb.append(ch);
		}
		long end2=System.nanoTime();
		String alphabet2 =sb2.toString();
		System.out.println((end2-begin2)+alphabet2);
		
		
		
		
		// 연습. 대문자 6자리로 구성된 인증코드 작성하기
		StringBuilder sbCode = new StringBuilder();
		
		for (int n=0; n<6; n++) {
			sbCode.append((char)((int)(Math.random()*26)+'A'));
			
		}
		
		String code=sbCode.toString();
		System.out.println("인증코드:"+code);
		
		
		
		
		
		
		
		// 연습. 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sbPaging=new StringBuilder();
		for(int n=1; n<=10; n++) {
			sbPaging.append(n+" ");
		}
			
		String paging =sbPaging.toString();
		System.out.println(paging);
		
		
		
			
		}
		

	}

