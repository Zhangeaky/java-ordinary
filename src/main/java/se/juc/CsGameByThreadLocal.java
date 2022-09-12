package se.juc;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @see "码出高效" 258页
 */
public class CsGameByThreadLocal {

    private static final Integer BULLET_NUMBER = 1500;

    private static final Integer KILLED_ENEMIES = 0;

    private static final Integer LIFE_VALUE = 10;

    private static final Integer TOTAL_PLAYERS = 10;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };

    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return LIFE_VALUE;
        }
    };

    private static class player extends Thread {

        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS/2);
            Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);

            String log = String.format("[%s] bullets %d, kill %d, lifeValue %d", Thread.currentThread().getName(),
                    bullets, killEnemies, lifeValue);
            System.out.println(log);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLAYERS; i ++) {
            new player().run();
        }
    }






}
