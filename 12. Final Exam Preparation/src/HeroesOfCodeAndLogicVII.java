import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heroesNumber = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroes = new LinkedHashMap<>();

        for (int i = 0; i < heroesNumber; i++) {
            String[] heroInfo = scanner.nextLine().split("\\s+");
            heroes.put(heroInfo[0], Hero.parseHero(heroInfo));
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arguments = input.split(" - ");
            String command = arguments[0];

            switch (command) {
                case "CastSpell":
                    handleCastSpell(heroes, arguments[1], Integer.parseInt(arguments[2]), arguments[3]);
                    break;
                case "TakeDamage":
                    handleTakeDamage(heroes, arguments[1], Integer.parseInt(arguments[2]), arguments[3]);
                    break;
                case "Recharge":
                    handleRecharge(heroes, arguments[1], Integer.parseInt(arguments[2]));
                    break;
                case "Heal":
                    handleHeal(heroes, arguments[1], Integer.parseInt(arguments[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        heroes.forEach((key, value) -> {
            System.out.println(key);
            System.out.printf("  HP: %d%n", value.getHitPoints());
            System.out.printf("  MP: %d%n", value.getManaPoints());
        });
    }

    private static void handleHeal(Map<String, Hero> heroes, String heroName, int amount) {
        Hero hero = heroes.get(heroName);
        int oldHitPoints = hero.getHitPoints();
        int newHitPoints = Math.min(hero.getHitPoints() + amount, 100);
        hero.setHitPoints(newHitPoints);
        int recoveredAmount = newHitPoints - oldHitPoints;
        System.out.printf("%s healed for %d HP!%n", heroName, recoveredAmount);
    }

    private static void handleRecharge(Map<String, Hero> heroes, String heroName, int amount) {
        Hero hero = heroes.get(heroName);
        int oldManaPoints = hero.getManaPoints();
        int newManaPoints = Math.min(hero.getManaPoints() + amount, 200);
        hero.setManaPoints(newManaPoints);
        int recoveredAmount = newManaPoints - oldManaPoints;
        System.out.printf("%s recharged for %d MP!%n", heroName, recoveredAmount);
    }

    private static void handleTakeDamage(Map<String, Hero> heroes, String heroName, int damage, String attacker) {
        Hero hero = heroes.get(heroName);
        hero.setHitPoints(hero.getHitPoints() - damage);
        if (hero.getHitPoints() > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, hero.getHitPoints());
        } else {
            heroes.remove(heroName);
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
        }
    }

    private static void handleCastSpell(Map<String, Hero> heroes, String heroName, int neededMana, String spellName) {
        Hero hero = heroes.get(heroName);
        if (hero.getManaPoints() >= neededMana) {
            hero.setManaPoints(hero.getManaPoints() - neededMana);
            System.out.printf("%s has successfully cast %s and now has %s MP!%n", heroName, spellName, hero.getManaPoints());
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }

    static class Hero {
        private String name;
        private int hitPoints;
        private int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public static Hero parseHero(String[] info) {
            return new Hero(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }
    }
}
