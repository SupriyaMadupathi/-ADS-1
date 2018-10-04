import java.util.Scanner;
class Same {
	public String SameStar(String str) {
		if (str.length() == 1) {
			return str;
		}
		if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "*" + SameStar(str.substring(1));
		}
		return str.charAt(0) + SameStar(str.substring(1));
		}
	}

class Solution {
	private Solution() {

	} public static void main(String[] args) {
		Same p = new Same();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		p.SameStar(str);
		System.out.println(p.SameStar(str));

	}
}