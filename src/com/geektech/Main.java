package com.geektech;

import java.util.Random;

public class Main {

    public static String[] heroesNames = {"Liu Kang", "Jax", "Kung Lao", "Golem", "Lucky", "Berserk", "Thor", "Doktor"};
    public static int[] heroesHealth = {300, 280, 320, 600, 350, 360, 420, 700};
    public static int[] heroesDamace = {30, 25, 30, 10, 30, 30, 40, 0};

    public static String bossName = "Thor";
    public static int bossHealth = 1200;
    public static int bossDamace = 50;
    public static int roundNumber = 0;
    public static String bossDefence = "";


    public static void main(String[] args) {
        // write your code here

        printStatistics();
        System.out.println("_____ Mortal Kombat started_____");

        while (!isGameFinished()) {
            round();
        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!! " + "Mortal Kombat finished ");
            return true;
        }

        boolean allHeroesDead = true;
        for (int heroHealth : heroesHealth) {
            if (heroHealth > 0) {
                allHeroesDead = false;
                break;
            }

        }

        if (allHeroesDead) {
            System.out.println(bossName + "Won!!! " + "Mortol Kombat finished");
        }
        return allHeroesDead;
    }


    public static void round() {
        roundNumber++;
        System.out.println("_____Round " + roundNumber + "_____");
        bossDamace();
        heroesDamace();
        medicSkill();
        printStatistics();
    }


    public static void bossDamace() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                heroesHealth[i] = heroesHealth[i] - bossDamace;
            }
            if (bossHealth < 0) {
                bossHealth = 0;
            }
        }
    }

    public static void heroesDamace() {
        for (int i = 0; i < heroesDamace.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                bossHealth = bossHealth - heroesDamace[i];
            }
            if (heroesHealth[i] < 0) {
                heroesHealth[i] = 0;
            }
        }
        }
    

    public static void printStatistics() {
        System.out.println(bossName + " health " + bossHealth + " damace [" + bossDamace + "]");
        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + " = health " + heroesHealth[i] + " damace [" + heroesDamace[i] + "]");
        }
    }

    public static void medicSkill() {
        Random random = new Random();
        int num = random.nextInt(50);
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[7] > 0 && heroesHealth[i] > 0 && heroesHealth[i] < 100) {
                heroesHealth[i] = heroesHealth[i] + num;
                System.out.println("Medic treated " + heroesNames[i] + "+" + num + "HP");
                break;
            } else {
                System.out.println("Medic can't heal anyone");
                break;
            }
        }
    }
}
