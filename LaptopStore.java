import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
//        создаем множество ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell XPS 13", 16, 512, "Windows 10", "Silver"));
        laptops.add(new Laptop("MacBook Air", 8, 256, "macOS", "Space Gray"));
        laptops.add(new Laptop("HP Spectre x360", 16, 1024, "Windows 11", "Black"));
        laptops.add(new Laptop("Lenovo ThinkPad x1", 32, 1024, "Widows 11", "Red"));
        laptops.add(new Laptop("Asus ROG Zephyrus", 32, 2048, "Windows 11", "Blue"));

//        запрашиваем критерии фильтрации

        Map<Integer, Object> filters = getFiltersFromUser();

//        Фильтруем ноутбуки
        Set<Laptop> filteredLaptops = filterLaptops(laptops , filters);

//        Выводим результат
        System.out.println("Filtered Laptops: ");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }

    }

    public static Map<Integer, Object> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criteria = scanner.nextInt();
        scanner.nextLine();

        switch (criteria) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ (в ГБ):");
                int minRam = scanner.nextInt();
                filters.put(1 , minRam);
                break;

            case 2:
                System.out.println("Введите минимальный объем ЖД (в ГБ):");
                int minHardDrive = scanner.nextInt();
                filters.put(2 , minHardDrive);
                break;

            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filters.put(3 , os);
                break;

            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filters.put(3 , color);
                break;

            default:
                System.out.println("Неверный критерий:");
                break;
        }

        return filters;
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean passFilter = true;

            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case 1:
                        if (laptop.getRam() < (int) value) {
                            passFilter = false;
                        }
                        break;

                    case 2:
                        if (laptop.getHardDrive() < (int) value) {
                            passFilter = false;
                        }
                        break;

                    case 3:
                        if (!laptop.getOs().equalsIgnoreCase((String) value)) {
                            passFilter = false;
                        }
                        break;

                    case 4:
                        if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                            passFilter = false;
                        }
                        break;
                }

                if (!passFilter) {
                    break;
                }
            }

            if (passFilter) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }
}
