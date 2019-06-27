package com.microcloud;

import com.microcloud.dao.CityDao;
import com.microcloud.entity.City;
import com.rabbitmq.client.AMQP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: wangjian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartConsulMain_8501.class)
public class TestStartConsul {

    @Resource
    private CityDao cityDao;

    @Test
    public void testQueryCityList() {
        List<City> cities = cityDao.queryCityList();
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }
}
