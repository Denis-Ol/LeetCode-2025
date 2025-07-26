import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GurskySupercut {
    static Set<Long> supercuts = new HashSet<>();
    static Set<Long> primes = new HashSet<>();
    static Map<Integer, Set<Long>> dimSupercuts = new HashMap<>();
    static Set<Long> endings = Set.of(1L, 3L, 7L, 9L);

    public static void main(String[] args) {
//        supercutBuild();
//        int count = 0;
//        for (long i = 2; i < Integer.MAX_VALUE / 10; i++) { // 100 -> 78
////            83 supercut = 73939133, supercuts size = 83, primes size = 4335891
//            if (isSupercut(i)) {
//                System.out.print(++count + " supercut = " + i);
//                System.out.print(", supercuts size = " + supercuts.size());
//                System.out.print(", primes size = " + primes.size() + "\n");
//            }
//        }
        long number = 300000000L;
        supercutBuild(number);
        System.out.println("Done");
        System.out.println("Supercut found: " + supercuts.size());
        for (Long supercut : supercuts) {
            System.out.println(supercut);
        }
        System.out.println("-= END =-");
    }

    private static boolean isSupercut(long number) {
        if (!isPrime(number)) return false;
        int dim = String.valueOf(number).trim().length();
        long cut = number;
        for (int i = 1; i < dim; i++) {
            cut /= 10;
            if (!isSupercut(cut)) {
                if (!isPrime(cut)) return false;
            }
        }
        supercuts.add(number);
        return true;
    }

    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (primes.contains(number)) return true;

        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        primes.add(number);
        return true;
    }

    private static Set<Long> setOfPrimesLessThanNumber(long number) {
        for (int i = 2; i <= number; i++) {
            isPrime(i);
        }
        return primes;
    }

    static void supercutBuild() {
        dimSupercuts.put(1, Set.of(2L, 3L, 5L, 7L));
        int count = 4;
        for (int i = 1; i <= 2000; i++) {
            Set<Long> currentSupercuts = new HashSet<>();
            for (long supercut : dimSupercuts.get(i)) {
                for (long end : endings) {
                    long candidate = supercut * 10 + end;
                    if (isSupercut(candidate)) {
                        System.out.print("dimension i = " + i);
                        System.out.print(", count = " + ++count);
                        System.out.print(", candidate = " + candidate + "\n");
                        currentSupercuts.add(candidate);
                    }
                }
            }
            if (currentSupercuts.isEmpty()) break;
            dimSupercuts.put(i + 1, currentSupercuts);
        }
    }

    static void supercutBuild(long number) {
        int dim = String.valueOf(number).length();

        if (dim == 1) {
            supercuts = setOfPrimesLessThanNumber(number);
            return;
        }

        Set<Long> startSet = Set.of(2L, 3L, 5L, 7L);
        supercuts.addAll(startSet);
        for (int i = 1; i <= dim + 1; i++) {
            Set<Long> currentSupercuts = new HashSet<>();
            for (long supercut : startSet) {
                for (long end : endings) {
                    long candidate = supercut * 10 + end;
                    if (candidate <= number) {
                        if (isSupercut(candidate)) {
                            currentSupercuts.add(candidate);
                            supercuts.add(candidate);
                        }
                    }
                }
            }
            if (currentSupercuts.isEmpty()) break;
            startSet = currentSupercuts;
        }
    }
}
