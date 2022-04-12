class Developer {
    State state;

    public void setState(State state) {
        this.state = state;
    }

    public void changeActivity() {
        if(state instanceof SleepingState) {
            setState(new FreshState());
        } else if(state instanceof FreshState) {
            setState(new TiredState());
        } else if(state instanceof TiredState) {
            setState(new SleepingState());
        }
    }

    public void doSomething() {
        state.doSomething();
        changeActivity();
    }
}

interface State {
    public void doSomething();
}

class SleepingState implements State {
    public void doSomething() {
        System.out.println("zZzZzZzZz...");
    }
}

class TiredState implements State {
    public void doSomething() {
        System.out.println("Low energy! Need to relax");
    }
}

class FreshState implements State {
    public void doSomething() {
        System.out.println("Feeling great! Ready to code");
    }
}

class StatePattern {
    public static void main(String[] args) {
        State freshState = new FreshState();
        Developer akzhol = new Developer();

        akzhol.setState(freshState);

        akzhol.doSomething();

        akzhol.doSomething();

        akzhol.doSomething();

        akzhol.doSomething();
    }
}