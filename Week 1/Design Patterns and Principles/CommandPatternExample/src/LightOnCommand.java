public class LightOnCommand implements Command {

    Light light;
    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
