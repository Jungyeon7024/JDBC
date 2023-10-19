package chap02MVC;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//생성자
		public cafeController(cafeModel model, cafeView view) {
			this.model = model;
			this.view = view;
		}
	
	
}
