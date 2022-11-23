package sixth;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Task25 {
    public static void main(String[] args) {
        System.out.println(getDeclarationMethod(sixth.thirteenth.Main.class, "minmax"));
    }


    public static String genericDeclaration(Method m) {
        return new StringBuilder()
                .append(getModifier(m.getModifiers()))
                .append(" ")
                .append(getGenericTypes(m.getTypeParameters()))
                .append(" ")
                .append(m.getGenericReturnType())
                .append(" ")
                .append(m.getName())
                .append(" ")
                .append(getParams(m.getGenericParameterTypes()))
                .toString();
    }

    private static String getModifier(int modifier){
        return Modifier.toString(modifier);
    }

    private static String getGenericTypes(TypeVariable<Method>[] genericTypes) {
        StringBuilder sb = new StringBuilder("<");
        if (genericTypes.length > 0) {
            sb.append(toRightSite(genericTypes, 0));
        }
        for (int i = 1; i < genericTypes.length; i++) {
            sb.append(", ").append(toRightSite(genericTypes, i));
        }
        return sb.append(">").toString();
    }
    private static String getDeclarationMethod(Class<?> cl, String methodName) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return genericDeclaration(method);
            }
        }
        return "";
    }

    private static String toRightSite(TypeVariable<Method>[] genericTypes, int x) {
        return genericTypes[x].getBounds()[0].getTypeName();
    }

    private static String getParams(Type[] genericTypes) {
        return "(" + arrayToString(genericTypes) + ")";
    }

    private static <T> String arrayToString(T[] genericTypes) {
        StringBuilder sb = new StringBuilder();
        if (genericTypes.length > 0) {
            sb.append(genericTypes[0]);
        }
        for (int i = 1; i < genericTypes.length; i++) {
            sb.append(", ").append(genericTypes[i]);
        }
        return sb.toString();
    }
}
