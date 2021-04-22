package sandbox;

public class TemplateMethodDemo {
    public static void main(String[] args) {
 //       AbstractLogger logger = new AbstractLogger(new CustomStrategy());
 //       logger.log();
    }

}

abstract class AbstractLogger {
 //   private StepStrategy strategy;

 //   protected AbstractLogger(StepStrategy strategy) {
 //       this.strategy = strategy;
 //   }

    public void log() {
        //....
 //       strategy.customStep();
        //....
    }

    protected abstract void customStep();
}

class CustomLogger1 extends AbstractLogger {
    CustomLogger1() {
  //      super(strategy);
    }

    @Override
    protected void customStep() {
        System.out.println("1");
    }
}

class CustomLogger2 extends AbstractLogger {
    CustomLogger2() {
    //    super(strategy);
    }

    @Override
    protected void customStep() {
        System.out.println("2");
    }
}