package justin.designpattern.template;

public class TemplateMethod extends TemplateMethodApplication {
    @Override
    protected void init() {
        System.out.println("Init!!!");
    }

    @Override
    protected void idle() {
        System.out.println("Just Done!!");
        setDone();
    }

    @Override
    protected void cleanup() {
        System.out.println("CleanUp!!!");
    }
}
