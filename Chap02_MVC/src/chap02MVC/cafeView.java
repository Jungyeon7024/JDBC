package chap02MVC;

import java.util.Scanner;

public class cafeView {
	//CafeModel 이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	
	public void addCafename() {

		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		
		System.out.println("상호명 : ");
		String name = sc.nextLine();
		
		System.out.println("카페 주소 : ");
		String address = sc.nextLine();
		
		System.out.println("전화 번호 : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("영업 시간 : ");
		String operatingHours = sc.nextLine();
		
		//카페 모델에서 insertCafe 라는 메서드를 가지고 와야함
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다");
		
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 메뉴 설명 : ");
		String description = sc.nextLine();
		
		System.out.println("메뉴 업데이트 ");
		
		System.out.print("메뉴 ID :  ");
		int menuId = sc.nextInt();
		
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		
		
	
		//model에  있는 UpdateMeun를 가져와서 사용자가 수정한 내용 추가하기
		
		model.UpdateMeun(description, menuId, cafeId);
		System.out.println("수정 완료");
		
		
		
	}
	
}
