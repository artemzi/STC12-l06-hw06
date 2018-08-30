package com.github.artemzi.hw06;

/**
 * Напишите программу, один поток которой каждую секунду отображает на экране данные о времени,
 * прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд.
 * Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение,
 * потоком, отсчитывающим время. Отсчитывать время (использовать sleep) может только один поток
 * Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на
 *
 * экран другое сообщение каждые 7 секунд. Предполагается использование методов wait(),
 * notifyAll() по какому-то монитору, общему для всех потоков.
 *
 * Бонус: Пакет Concurrent, перевод примеров на Lock  вместо синхронизации через wait-notify
 */
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Thread timer = new Thread(new TimeThread(startTime));
        timer.start();

        new Worker(5, "Thread id=", 1);
        new Worker(7, "Thread id=", 2);
    }
}
