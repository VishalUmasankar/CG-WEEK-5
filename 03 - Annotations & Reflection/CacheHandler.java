import java.lang.reflect.Method;

public class CacheHandler {

    private Cache cache = new Cache();

    public Object invokeWithCache(Object object, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = generateCacheKey(method, args);

            if (cache.containsKey(key)) {
                return cache.getFromCache(key);
            }

            Object result = method.invoke(object, args);
            cache.putInCache(key, result);
            return result;
        } else {
            return method.invoke(object, args);
        }
    }

    private String generateCacheKey(Method method, Object[] args) {
        StringBuilder keyBuilder = new StringBuilder(method.getName());
        for (Object arg : args) {
            keyBuilder.append("-").append(arg.toString());
        }
        return keyBuilder.toString();
    }
}
