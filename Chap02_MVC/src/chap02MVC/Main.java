package chap02MVC;

public class Main {
	
	public static void main(String[]args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		cafeController controller = new cafeController(model, view);
		
		
		//view.addCafename();
		view.updateMenu();
	}
}
