package model;

import com.horsecoder.yulinOA.sys.datainterface.CarDAO;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    CarDAO getmockcardao(){
        return Mockito.mock(CarDAO.class);
    }


}
