public class Main {
    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl();
        Light light = new Light();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        remote.setCommand(lightOnCommand);
        remote.pressButton();

        remote.setCommand(lightOffCommand);
        remote.pressButton();
    }
}