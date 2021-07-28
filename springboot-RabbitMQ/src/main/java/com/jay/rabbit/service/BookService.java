package com.jay.rabbit.service;

import com.jay.rabbit.bean.Book;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @RabbitListener(queues = "jay.news")
    public void receive(Book book){
        System.out.print(book);
    }


    /*  rabbitTemplate寄送訊息時自動生成
    *       durable持久化沒有資料會刪除
    *        autoDelete自動刪除資料
    *       concurrency消費者併發
    * */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "cola.news", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "cola.direct", type = ExchangeTypes.DIRECT),
            key = "cola.news"),  concurrency = "4")
    public void autoReceive(Book book) {
        System.out.println("BOOK: " + book);
    }
}
