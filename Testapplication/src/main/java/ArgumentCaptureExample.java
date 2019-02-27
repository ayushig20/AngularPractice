public class ArgumentCaptureExample {
    public void foo(OtherClass other) {
        SomeData data = new SomeData("Some inner data");
        other.doSomething(data);
    }
}
