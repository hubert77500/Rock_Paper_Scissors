import service.GameService;

public class Run {
    public static void main(String args[]){
        GameService gs = GameService.getInstance();
        gs.doMenuLoopUntilExitSignal();
    }
}
