package com.xx.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xx.practice.producer.FateProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

  @Autowired
  private FateProducer fateProducer;

  @Test
  public void testProduce() {
    fateProducer.send();
  }
}
