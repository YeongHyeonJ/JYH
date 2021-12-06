package day12;

public class ExbEqualsEx1 {

	public static void main(String[] args) {

		ExbTestA a1 = new ExbTestA(1, 1);
		ExbTestA a2 = new ExbTestA(1, 1);
		if(a1.equals(a2)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
	}
}

class ExbTestA{
	public int num1;
	public int num2;
	public ExbTestA(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	@Override
	public boolean equals(Object obj) {
		//비교 대상이 없는 경우
		if(obj == null) {
			return false;
		}
		//this : 내 객체 => 내 객체의 주소, obj는 비교 대상의 주소
		//주소가 같다는건 같은 객체를 공유
		//비교 대상과 내가 같은 객체를 공유하는 경우
		if(this == obj) {
			return true;
		}
		return true;
	}
}

class ExbTestB{
	private int num1;
	private int num2;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		result = prime * result + num2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbTestB other = (ExbTestB) obj;
		if (num1 != other.num1)
			return false;
		if (num2 != other.num2)
			return false;
		return true;
	}

	
}