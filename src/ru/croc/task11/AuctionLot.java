package ru.croc.task11;

import java.time.LocalDateTime;

public class AuctionLot {
    private volatile int price;
    private volatile String owner;
    private final LocalDateTime endTime;

    AuctionLot(int startPrice, LocalDateTime endTime) {
        this.price = price;
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void getWinner() {
        if(LocalDateTime.now().isAfter(endTime)){
            System.out.println("Победитель " + owner);
        }
        else{
            System.out.println("Аукцион еще не закончен");
        }
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    /*
    * Метод “ставки”
    *
    * @param price - новая цена
    * @param owner - имя нового владельца
    *
    * обновляет текущую стоимость лота и сохраняет предложившего ее пользователя,
    * если торги по лоту еще ведутся по времени и предложенная цена выше текущей
    * */
    public void setRate(int newPrice, String owner) {
        //использую isBefore, который показывает предшествова ли эта дата указанной дате.
        //!now.equals(endTime) не подойдет, тк аукцион мог быть вчера, но условие вернет true
        LocalDateTime now = LocalDateTime.now();
        if(now.isBefore(endTime) && newPrice > this.price){
            synchronized (this) { // синхронизируем по текущему объекту
                if(now.isBefore(endTime) && newPrice > this.price){
                    this.price = newPrice;
                    this.owner = owner;
                }
            }
        }
    }
}
