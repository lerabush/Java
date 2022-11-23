package sixth.third;

public class Main {
    public static void main(String[] args) {
        Table<String, String> table = new Table<>();
        table.set("1", "what");
        table.set("2", "how");
        table.set("3", "which");
        System.out.println(table.getValue("1"));
        table.setValue("2", "blblbla");
        table.deleteKey("3");
        table.list.forEach(stringEntry -> System.out.println("key = "
                + stringEntry.getKey() + ", value = " + stringEntry.getValue()));

    }
}
