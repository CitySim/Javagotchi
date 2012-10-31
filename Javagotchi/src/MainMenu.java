import java.util.ArrayList;

public class MainMenu implements IDrawable {
	ArrayList<Gotchi> gotchis = new ArrayList<Gotchi>();
	
	public void start() {
		
		Draw();
	}

	@Override
	public void Draw() {
		System.out.println("╔══════════════════════════════════════════════════════╗");
	}
}
