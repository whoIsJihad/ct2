class TrafficSystem {
    public LightState state;

    public TrafficSystem(LightState state) {
        this.state = state;
    }

    public void update() {
        state.update(this);
    }
    public void display(){
        state.showLight();
    }

    public static void main(String[] args) {
        TrafficSystem trafficSystem = new TrafficSystem(new RedLight());
        trafficSystem.display();
        trafficSystem.update();
        trafficSystem.display();

        trafficSystem.update();
        trafficSystem.display();
        
        trafficSystem.update();
        trafficSystem.display();

        trafficSystem.update();
        trafficSystem.display();
    }
}

interface LightState {
    public void showLight();

    public void update(TrafficSystem system);
}

class RedLight implements LightState {
    public void showLight() {
        System.out.println("REd Light");
    }

    public void update(TrafficSystem trafficSystem) {
        trafficSystem.state = new YellowLight();
        System.out.println("Setting the light to yellow light");
    }

    public String toString() {
        return "Red Light";
    }

}

class YellowLight implements LightState {
    public void showLight() {
        System.out.println("Yellow Light");
    }

    public void update(TrafficSystem trafficSystem) {
        trafficSystem.state = new GreenLight();
        System.out.println("Setting the light to green light");
    }

    public String toString() {
        return "Yellow Light";
    }
}

class GreenLight implements LightState {
    public void showLight() {
        System.out.println("Green Light");
    }

    public void update(TrafficSystem trafficSystem) {
        trafficSystem.state = new RedLight();
        System.out.println("Setting the light to Red light");
    }

    public String toString() {
        return "Green Light";
    }
}