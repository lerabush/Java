package fourth;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.*;

public class ExtraTask {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        run();
       // Manager.staticRun();
        Manager manager = new Manager(){
            @Override
            public void runAsHeCan() {
                System.out.println("Run as manager");
            }

            @Override
            public void go(){
                System.out.println("go manager");
            }
        };
        System.out.println(Arrays.toString(manager.getClass().getAnnotations()));
    }

    static Map<Class, Object> mapClassObjects = new HashMap<>();

    public static void run() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String packageName = "fourth";
        ClassLoader classLoader = ExtraTask.class.getClassLoader();

        String packagePath = packageName.replace('.', '/');
        URL urls = classLoader.getResource(packagePath);

        File folder = new File(urls.getPath());
        File[] classes = folder.listFiles();
        List<String> result = new ArrayList<>();
        for (File aClass : classes) {
            int index = aClass.getName().indexOf(".");
            String className = aClass.getName().substring(0, index);
            String classNamePath = packageName + "." + className;

            Class<?> repoClass = Class.forName(classNamePath);

            result.addAll(processClassMethods(repoClass));
        }
        for (String resultInfo : result) {
            System.out.println(resultInfo);
        }
    }

    public static List<String> processClassMethods(Class<?> someClass) throws InstantiationException, IllegalAccessException {
        List<Method> declaredMethods = List.of(someClass.getMethods());
        List<String> results = new ArrayList<>();
        Object classObject = null;
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Run.class) {
                    if (!Modifier.isStatic(method.getModifiers())) {
                        if (Modifier.isAbstract(someClass.getModifiers()))
                            continue;
                        if (classObject == null) {
                            classObject = someClass.newInstance();
                        }
                    }

                    StringBuilder resultInvocation =
                            new StringBuilder(String.format("%s | %s |", someClass.getName(), method.getName()));
                    long startTime = System.nanoTime();
                    String resultEffect = "OK";
                    try {
                        method.invoke(classObject);
                    } catch (Exception ex) {
                       // ex.printStackTrace();
                        resultEffect = ex.getCause().getClass().getName() + ":" + ex.getCause().getMessage();
                    } finally {
                        long time = System.nanoTime() - startTime;
                        resultInvocation.append(String.format(" %s | %d", resultEffect, time));
                    }
                    results.add(String.valueOf(resultInvocation));
                }
            }
        }
        return results;
    }
}
