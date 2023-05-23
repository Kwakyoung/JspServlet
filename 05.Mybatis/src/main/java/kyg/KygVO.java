package kyg;

//@Data <= 만 쓰면 내부에 생성자, getter & setter가 있다고 자동인식되게함. (lombok)
public class KygVO {
	// VO ==> 생성자를 비어있는 생성자가 사용가능한지 여부)
	// EL문법에서 ArrayList에 있는 VO에 필드(변수) 값을 바로 출려하려면 getter & setter 메소드를 이용함.
	private String field1;
	private int field2;
	
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public int getField2() {
		return field2;
	}
	public void setField2(int field2) {
		this.field2 = field2;
	}
	
	
	
	
	// DTO : 생성자 메소드 만들고 getter & setter
}
