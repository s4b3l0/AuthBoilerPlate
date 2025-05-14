package app.poc.secure.demo.jwtutil;

public interface WorkProcessor<T, I> {
    T process(I input);
}
