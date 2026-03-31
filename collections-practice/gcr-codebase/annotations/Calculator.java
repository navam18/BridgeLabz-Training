

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import java.util.HashMap;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class CalculatorC {
    HashMap<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int square(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        int result = n * n;
        cache.put(n, result);
        return result;
    }
}

